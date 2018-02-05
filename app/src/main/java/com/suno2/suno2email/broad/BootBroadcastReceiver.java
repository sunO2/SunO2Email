package com.suno2.suno2email.broad;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;

import com.suno2.suno2email.SendEmailTask;
import com.suno2.suno2email.bean.Phone;
import com.suno2.suno2email.builde.Message;

import java.util.HashMap;

import static android.media.tv.TvContract.Channels.COLUMN_DISPLAY_NAME;
import static android.provider.BlockedNumberContract.BlockedNumbers.COLUMN_ID;


public class BootBroadcastReceiver extends BroadcastReceiver {

    private String mPhone;

    private SendEmailTask mSendEmailTask;

    private HashMap<String,Phone> phoneHashMap = new HashMap<>();

    private PhoneListener listener;

    @Override
    public void onReceive(Context context, Intent intent) {
        if(null == listener){
            TelephonyManager tm = (TelephonyManager) context.getSystemService(Service.TELEPHONY_SERVICE);
            listener = new PhoneListener(context);
            tm.listen(listener, PhoneStateListener.LISTEN_CALL_STATE);
            Log.d("TAG","接收到来电广播");
        }

    }

    private final class PhoneListener extends PhoneStateListener {

        private Context context;

        public PhoneListener(Context context) {
            this.context = context;
        }

        @Override
        public void onCallStateChanged(int state, String incomingNumber) {
            String title = "未知状态";
            switch (state) {
                case TelephonyManager.CALL_STATE_RINGING:   //来电
                    Phone phoneStatus = getPhoneStatus(context,incomingNumber);
                    phoneStatus.setmTheTinkleOfBellsCount(incomingNumber);
                    mPhone = incomingNumber;
                    Log.d("TAG","电话 来电通知 :" +  incomingNumber);
                    break;
                case TelephonyManager.CALL_STATE_OFFHOOK:   //接通电话
                    title = "电话 接听通知";
                    if(TextUtils.isEmpty(incomingNumber)) {
                       incomingNumber = mPhone;
                    }
                    sendPhoneStatusEmail(context,title, getPhoneStatus(context, incomingNumber));
                    Log.d("TAG","电话 接听通知 :" +  incomingNumber);
                    break;
                case TelephonyManager.CALL_STATE_IDLE:  //挂掉电话
                    title = "电话 挂断通知";
                    if(TextUtils.isEmpty(incomingNumber)) {
                       incomingNumber = mPhone;
                    }
                    sendPhoneStatusEmail(context,title, getPhoneStatus(context, incomingNumber));
                    Log.d("TAG","电话 挂断通知 :" +  incomingNumber);
                    break;
            }
        }
    }

    /**
     * 手机来电状态
     */
    private Phone getPhoneStatus(Context context, String phone){
        if(phoneHashMap.containsKey(phone)){
            return phoneHashMap.get(phone);
        }else {
            String name = numberToName(context, phone);
            Phone phone1 = new Phone(name,phone);
            phoneHashMap.put(phone,phone1);
            return phone1;
        }
    }

    /**
     * 发送电话拨打状态
     * @param title
     * @param phoneStatus
     */
    private void sendPhoneStatusEmail(Context context,String title, Phone phoneStatus){
        String phoneNumber = phoneStatus.getPhoneNumber();
        Message build = new Message.Builde()
                .setTitle(title)
                .setMessage(phoneStatus.getEmailMessage())
                .setMunber(phoneNumber)
                .build();
        mSendEmailTask = new SendEmailTask(context,build);
        mSendEmailTask.execute((Void) null);
        phoneHashMap.remove(phoneNumber);
    }


    /**
     * 根据电话查找姓名
     */
    public String numberToName(Context mContext, String mNumber) {
        String displayName = null;
        Cursor cursor = null;
        try {
            ContentResolver resolver = mContext.getContentResolver();
            Uri uri = ContactsContract.PhoneLookup.CONTENT_FILTER_URI.buildUpon().appendPath(mNumber).build();
            String[] projection = new String[]{COLUMN_ID, COLUMN_DISPLAY_NAME};
            cursor = resolver.query(uri, projection, null, null, null);
            if (cursor != null && cursor.moveToFirst()) {
                int columnIndexName = cursor.getColumnIndex(COLUMN_DISPLAY_NAME);
                displayName = cursor.getString(columnIndexName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return displayName;
    }

}