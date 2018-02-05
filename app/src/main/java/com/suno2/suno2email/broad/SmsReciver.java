package com.suno2.suno2email.broad;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.telephony.SmsMessage;
import android.text.TextUtils;
import android.util.Log;

import com.suno2.suno2email.SendEmailTask;
import com.suno2.suno2email.bean.Messages;
import com.suno2.suno2email.builde.Message;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static android.media.tv.TvContract.Channels.COLUMN_DISPLAY_NAME;
import static android.provider.BlockedNumberContract.BlockedNumbers.COLUMN_ID;

public class SmsReciver extends BroadcastReceiver {

    private SendEmailTask mSendEmailTask;

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        if (null != bundle) {  
            Object[] smsObj = (Object[]) bundle.get("pdus");
            if(null != smsObj) {
                Messages messages = new Messages();
                for (Object object : smsObj) {
                    SmsMessage msg = SmsMessage.createFromPdu((byte[]) object);
                    String phoneNumber = msg.getOriginatingAddress();
                    String name = numberToName(context, phoneNumber);
                    messages.setmName(name);
                    messages.setmPhoneNumber(phoneNumber);
                    messages.setMessage(msg.getDisplayMessageBody());
                    Log.d("TAG", "手机号码：" + phoneNumber + "\n 联系人 ：" + name);
                }
                String getyzm = getyzm(messages.getMessage(), 6);
                String title = "收到 短信";
                if(!TextUtils.isEmpty(getyzm)){
                    title = title + "验证码：" + getyzm;
                    messages.setVerfCode(getyzm);
                }
                sendMessageStatusEmail(context,title,messages);
            }
        }
    }

    /**
     * 发送电话拨打状态
     * @param title
     * @param phoneStatus
     */
    private void sendMessageStatusEmail(Context context,String title, Messages phoneStatus){
        String phoneNumber = phoneStatus.getmPhoneNumber();
        Message build = new Message.Builde()
                .setTitle(title)
                .setMessage(phoneStatus.getEmailMessage())
                .setMunber(phoneNumber)
                .build();
        mSendEmailTask = new SendEmailTask(context,build);
        mSendEmailTask.execute((Void) null);
    }

    /**
     * 从短信字符窜提取验证码
     * @param body 短信内容
     * @param YZMLENGTH  验证码的长度 一般6位或者4位
     * @return 接取出来的验证码
     */
    public static String getyzm(String body, int YZMLENGTH) {
        // 首先([a-zA-Z0-9]{YZMLENGTH})是得到一个连续的六位数字字母组合
        // (?<![a-zA-Z0-9])负向断言([0-9]{YZMLENGTH})前面不能有数字
        // (?![a-zA-Z0-9])断言([0-9]{YZMLENGTH})后面不能有数字出现
        Pattern p = Pattern
                .compile("(?<![a-zA-Z0-9])([a-zA-Z0-9]{" + YZMLENGTH + "})(?![a-zA-Z0-9])");
        Matcher m = p.matcher(body);
        if (m.find()) {
            System.out.println(m.group());
            return m.group(0);
        }
        return null;
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