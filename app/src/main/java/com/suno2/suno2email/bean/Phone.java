package com.suno2.suno2email.bean;

import android.text.TextUtils;

import com.suno2.suno2email.Contain;

/**
 * Name: SunO2Email
 * Author: hezhihu
 * Email: 2854918124@qq.com
 * 创建时间: 2018/2/5 11:13
 * 修改时间:  2018/2/5 11:13
 * 内容描述:
 */

public class Phone {

    /**
     * 姓名
     */
    private String mName = "未知";
    /**
     * 手机号码
     */
    private String mPhoneNumber;

    /**
     * 响铃次数
     */
    private int mTheTinkleOfBellsCount;

    private long startTime;

    public Phone(String name, String phone) {
        setPhoneNumber(phone);
        setmName(name);
        startTime = System.currentTimeMillis();
    }


    public String getPhoneNumber() {
        return mPhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        mPhoneNumber = phoneNumber;
    }

    public int getmTheTinkleOfBellsCount() {
        long time = System.currentTimeMillis() - startTime;
        float times = (time / 1000) + 0.5f;
        mTheTinkleOfBellsCount = (int) times;
        return mTheTinkleOfBellsCount;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public void setmTheTinkleOfBellsCount(String phone) {
        if(phone.equals(mPhoneNumber)){
            mTheTinkleOfBellsCount = mTheTinkleOfBellsCount+1;
        }
    }

    public String getEmailMessage() {
        return Contain.getVerCodeMessage("未接电话",mPhoneNumber,mName+"(" + mPhoneNumber + ")    响铃 ：" + getmTheTinkleOfBellsCount() + " 秒" );
    }
}
