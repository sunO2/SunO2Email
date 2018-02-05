package com.suno2.suno2email.bean;

import android.text.TextUtils;

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

    public Phone(String name, String phone) {
        setPhoneNumber(phone);
        setmName(name);
    }


    public String getPhoneNumber() {
        return mPhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        mPhoneNumber = phoneNumber;
    }

    public int getmTheTinkleOfBellsCount() {
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
}
