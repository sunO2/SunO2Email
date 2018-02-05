package com.suno2.suno2email.bean;

import android.text.TextUtils;

import com.suno2.suno2email.Contain;

/**
 * Name: SunO2Email
 * Author: hezhihu
 * Email: 2854918124@qq.com
 * 创建时间: 2018/2/5 13:44
 * 修改时间:  2018/2/5 13:44
 * 内容描述:
 */

public class Messages {


    /**
     * 姓名
     */
    private String mName;
    /**
     * 手机号码
     */
    private String mPhoneNumber;

    /**
     * 消息内容
     */
    private String message = "";

    /**
     * 验证码
     */
    private String verfCode;

    public String getmName() {
        if(TextUtils.isEmpty(mName)){
            return "未知联系人";
        }
        return mName;
    }

    public void setmName(String mName) {
        if(TextUtils.isEmpty(this.mName)) {
            this.mName = mName;
        }
    }

    public String getVerfCode() {
        return verfCode;
    }

    public void setVerfCode(String verfCode) {
        this.verfCode = verfCode;
    }

    public String getmPhoneNumber() {
        return mPhoneNumber;
    }

    public void setmPhoneNumber(String mPhoneNumber) {
        if(TextUtils.isEmpty(this.mPhoneNumber)) {
            this.mPhoneNumber = mPhoneNumber;
        }
    }

    public String getMessage() {
        return message;
    }

    /**
     * 设置消息
     * @param message 消息内容
     */
    public void setMessage(String message) {
        this.message = this.message + message;
    }


    public String getEmailMessage() {
        String emailMessage;
        if(!TextUtils.isEmpty(verfCode)){
            emailMessage = Contain.getVerCodeMessage("验证码短信",verfCode,message);
        }else{
            emailMessage =  Contain.getVerCodeMessage("短信息","--",message);
        }
        return emailMessage;
    }
}
