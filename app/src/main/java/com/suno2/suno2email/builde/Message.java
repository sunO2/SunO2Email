package com.suno2.suno2email.builde;

/**
 * Name: SunO2Email
 * Author: hezhihu
 * Email: 2854918124@qq.com
 * 创建时间: 2018/2/2 17:15
 * 修改时间:  2018/2/2 17:15
 * 内容描述:
 */

public class Message {

    /**
     * 消息内容
     */
    String message;

    /**
     * 手机号码
     */
    String munber;

    String title;


    /**
     * 构造方法
     * @param munber 消息内容
     * @param message 手机号码
     */
    Message(String title,String munber, String message) {
        this.message = message;
        this.munber = munber;
    }


    public String getMessage() {
        return message;
    }

    public String getMunber() {
        return munber;
    }

    public String getTitle() {
        return title;
    }

    public static class Builde{
        /**
         * 头部信息
         */
        String title;

        /**
         * 消息内容
         */
        String message;

        /**
         * 手机号码
         */
        String munber;

        public Builde setMessage(String message) {
            this.message = message;
            return this;
        }

        public Builde setMunber(String munber) {
            this.munber = munber;
            return this;
        }

        public Builde setTitle(String title) {
            this.title = title;
            return this;
        }

        public Message build(){
            return  new Message(title,munber,message);
        }
    }


}
