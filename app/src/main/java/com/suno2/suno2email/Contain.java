package com.suno2.suno2email;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import java.security.Key;

/**
 * Name: SunO2Email
 * Author: hezhihu
 * Email: 2854918124@qq.com
 * 创建时间: 2018/2/5 14:23
 * 修改时间:  2018/2/5 14:23
 * 内容描述:
 */

public class Contain {

    public static final String KEY_EMAIL = "EMAIL";

    public static final String KEY_PASSWPRD = "PASSWORD";

    public static final String KEY_RECEPTION_EMAIL = "RECEPTION_EMAIL";

    private static SharedPreferences APPSP;

    public static void init(Context context){
        APPSP = context.getSharedPreferences("app", Context.MODE_PRIVATE);
    }

    /**
     * 保存 发送邮箱
     */
    public static void saveSendEmail(String sendEmail){
        SharedPreferences.Editor edit = APPSP.edit();
        edit.putString(KEY_EMAIL,sendEmail);
        edit.apply();
    }

    /**
     * 保存 发送邮箱授权码
     */
    public static void saveAuthorizationCode(String authCode){
        SharedPreferences.Editor edit = APPSP.edit();
        edit.putString(KEY_PASSWPRD,authCode);
        edit.apply();
    }

    /**
     * 保存 发送邮箱授权码
     */
    public static void saveReceptionEmail(String receptionEmail){
        SharedPreferences.Editor edit = APPSP.edit();
        edit.putString(KEY_RECEPTION_EMAIL,receptionEmail);
        edit.apply();
    }

    public static String getString(String key){
        return APPSP.getString(key,"");
    }

    public static String  getVerCodeMessage(String title,String verCose,String message){

       if(!TextUtils.isEmpty(message)){
           char[] chars = message.toCharArray();
           String tempString = "";
           for(int i = 0;i<chars.length;i++){
               tempString = tempString + chars[i];
               if((i!=0) && (i%15 == 0)){
                    tempString = tempString+"<br\\/>";
               }
           }
           message = tempString;
       }

        return  "<div id=\"qm_con_body\">\n" +
                "\t<div id=\"mailContentContainer\" class=\"qmbox qm_con_body_content qqmail_webmail_only\" style=\"\">\n" +
                "\t\t<style>\n" +
                ".qmbox .clearfix:after {\n" +
                "\tcontent: \".\";\n" +
                "\tdisplay: block;\n" +
                "\theight: 0;\n" +
                "\tclear: both;\n" +
                "\tvisibility: hidden;\n" +
                "}\n" +
                ".qmbox .clearfix {\n" +
                "\t*display:inline-block;\n" +
                "\t*zoom:100%;\t\n" +
                "}\n" +
                ".qmbox .open_email{\n" +
                "\tbackground:url(http://imgcache.qq.com/bossweb/pay/images/mailmsg/email_bg.png) no-repeat 0 -35px;\n" +
                "\twidth:500px;\n" +
                "\tpadding:10px;\n" +
                "\tfont-family: Tahoma,\"宋体\";\n" +
                "\tmargin:0 auto;\n" +
                "\tmargin-bottom:20px;\t\n" +
                "\ttext-align:left;\n" +
                "}\n" +
                ".qmbox .open_email a:link,.qmbox .open_email a:visited {\n" +
                "    color:#295394;\n" +
                "    text-decoration:none !important;\n" +
                "}\n" +
                ".qmbox .open_email a:active,.qmbox .open_email a:hover {\n" +
                "    color:#000 ;\n" +
                "    text-decoration:underline !important;\n" +
                "}\n" +
                ".qmbox a.lv:link, .qmbox a.lv:visited {\n" +
                "\tcolor:#1969e2;\n" +
                "\ttext-decoration:underline;\n" +
                "}\n" +
                ".qmbox a.lv:active,.qmbox a.lv:hover {\n" +
                "\tcolor:#000;\n" +
                "\ttext-decoration:underline;\n" +
                "}\n" +
                ".qmbox .open_email .img_left{\n" +
                "\tfloat:left;\n" +
                "\twidth:125px;\n" +
                "\ttext-align:left;\n" +
                "}\n" +
                ".qmbox .open_email .word_right{\n" +
                "\tfloat:right;\n" +
                "\twidth:615px;\n" +
                "}\n" +
                ".qmbox .open_email h5,.qmbox .open_email h6{\n" +
                "\tfont-size:14px;\n" +
                "\tmargin:0px;\n" +
                "\tpadding-top:2px;\n" +
                "\tline-height:21px;\n" +
                "}\n" +
                ".qmbox .open_email h5{\n" +
                "\tcolor:#df0202;\n" +
                "\tpadding-bottom:10px;\n" +
                "}\n" +
                ".qmbox .open_email h6{\n" +
                "\tpadding-bottom:2px;\n" +
                "}\n" +
                ".qmbox .open_email h5 span,.qmbox .open_email p{\n" +
                "\tfont-size:12px;\n" +
                "\tcolor:#808080;\n" +
                "\tfont-weight:normal;\n" +
                "\tmargin:0;\n" +
                "\tpadding:0;\n" +
                "\tline-height:21px;\n" +
                "}\n" +
                ".qmbox .email_btn{\n" +
                "\tbackground:url(http://imgcache.qq.com/bossweb/pay/images/mailmsg/email_bg.png) no-repeat 0 0;\n" +
                "\twidth:84px;\n" +
                "\theight:29px;\n" +
                "\tline-height:29px;\n" +
                "\tborder:0;\n" +
                "\tpadding:0px;\n" +
                "\tcursor:pointer;\n" +
                "\tcolor:#023a65;\n" +
                "\tfont-size:14px;\n" +
                "\tvertical-align:middle;\n" +
                "\ttext-align:center;\n" +
                "\tmargin:10px 0 6px;\n" +
                "\tdisplay:block;\n" +
                "text-decoration:none;\n" +
                "}\n" +
                ".qmbox .email_hr{\n" +
                "\tbackground:url(http://imgcache.qq.com/bossweb/pay/images/mailmsg/email_bg.png) no-repeat -100px 0px ;\n" +
                "\theight:4px;\n" +
                "\tmargin:8px 0;\n" +
                "\t>overflow:hidden;\n" +
                "}\n" +
                "\t\t</style>\n" +
                "\t\t<style>\n" +
                ".qmbox #ft_table td,.qmbox #version_table td{border-bottom:1px solid #ebebeb;}.qmbox .open_email{background:0 0;width:100%;padding:0;font-family:Tahoma,\"宋体\";margin:0!important;margin-bottom:20px;text-align:left;}.qmbox .open_email br{display:none;}\n" +
                "\t\t</style>\n" +
                "\t\t<div align=\"center\">\n" +
                "\t\t\t<div class=\"open_email\" style=\"margin-left: 8px; margin-top: 8px; margin-bottom: 8px; margin-right: 8px;\">\n" +
                "\t\t\t\t<div>\n" +
                "\t\t\t\t\t<span class=\"genEmailNicker\">\n" +
                "\t\t\t\t\t</span>\n" +
                "\t\t\t\t\t<br>\n" +
                "\t\t\t\t\t<span class=\"genEmailContent\">\n" +
                "\t\t\t\t\t<table width=\"640\" style=\"margin:0 auto;padding:0;border-collapse:collapse;border-spacing:0;font-family:arial,sans-serif;background:#F8FAFC\">\n" +
                "\t\t\t\t\t<tbody>\n" +
                "\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t<td>\n" +
                "\t\t\t\t\t\t\t<table width=\"640\" style=\"margin:0 auto;padding:0;border-collapse:collapse;border-spacing:0;border:1px solid #e0e0e0;border-radius:2px;background:#fff\">\n" +
                "\t\t\t\t\t\t\t<tbody>\n" +
                "\t\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t\t<td style=\"border-bottom:1px solid #ebebeb;padding:26px 0\">\n" +
                "\t\t\t\t\t\t\t\t\t<span style=\"font-size:0\">Android 短信</span>\n" +
                "\t\t\t\t\t\t\t\t\t<img src=\"http://3gimg.qq.com/mig-web/2016/bugly/img/bugly_logo_201612081108.png\" width=\"106\" height=\"48\" style=\"margin:0 5px 0 30px;vertical-align:middle\" title=\"Bugly.qq.com，最专业的质量跟踪平台\">\n" +
                "\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t\t<td align=\"center\" style=\"padding:40px 60px 0\">\n" +
                "\t\t\t\t\t\t\t\t<img src=\"http://3gimg.qq.com/mig-web/2016/bugly/img/Icon_Android_201612071650.png\" width=\"20\" height=\"20\" style=\"vertical-align:middle;margin-right:5px;display:inline-block\">\n" +
                "\t\t\t\t\t\t\t\t<img src=\"http://3gimg.qq.com/mig-web/2016/bugly/img/Icon_iOS_201612071650.png\" width=\"20\" height=\"20\" style=\"vertical-align:middle;margin-right:5px;display:none\">\n" +
                "\t\t\t\t\t\t\t\t<span style=\"font-size:20px;color:#333;vertical-align:middle\">"+title+"</span>\n" +
                "\t\t\t\t\t\t\t\t\t<hr style=\"width:480px;margin:0 auto;height:1px;background:#ebebeb;border:none;margin-top:40px\">\n" +
                "\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t\t<td>\n" +
                "\t\t\t\t\t\t\t\t\t<table width=\"540\" style=\"margin:0 auto;text-align:center;font-size:14px;color:#666;padding-top:25px\">\n" +
                "\t\t\t\t\t\t\t\t\t<tbody>\n" +
                "\t\t\t\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t<td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<p style=\"font-size:14px;color:#666\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t-- 验证码 --\n" +
                "\t\t\t\t\t\t\t\t\t\t\t</p>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<p style=\"font-size:24px;color:#282828;line-height:1;margin:18px 0\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t"+verCose+"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t</p>\n" +
                "\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t<td colspan=\"4\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<hr style=\"width:480px;margin:0 auto;height:1px;background:#ebebeb;border:none;margin-top:11px\">\n" +
                "\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t</tbody>\n" +
                "\t\t\t\t\t\t\t\t\t</table>\n" +
                "\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t<tr style=\"display:none\">\n" +
                "\t\t\t\t\t\t\t\t<td>\n" +
                "\t\t\t\t\t\t\t\t\t<h3 style=\"font-size:16px;color:#282828;line-height:20px;text-align:center;margin-top:58px;margin-bottom:16px\">FT 崩溃统计</h3>\n" +
                "\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t<tr style=\"display:none\">\n" +
                "\t\t\t\t\t\t\t\t<td>\n" +
                "\t\t\t\t\t\t\t\t\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" style=\"width:100%;table-layout:fixed\">\n" +
                "\t\t\t\t\t\t\t\t\t<tbody id=\"ft_table\" align=\"right\">\n" +
                "\t\t\t\t\t\t\t\t\t<tr style=\"background:#FCFCFC;height:46px;line-height:46px\">\n" +
                "\t\t\t\t\t\t\t\t\t\t<td align=\"left\" style=\"width:178px;border-top:1px solid #EBEBEB\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<div style=\"padding-left:20px;font-size:14px;color:#666;line-height:1\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\tFT 名称\n" +
                "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t<td style=\"border-top:1px solid #EBEBEB;font-size:14px;color:#666;width:70px\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t用户崩溃率\n" +
                "\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t<td style=\"border-top:1px solid #EBEBEB;font-size:14px;color:#666;padding-right:10px;width:103px\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t波动\n" +
                "\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t<td style=\"border-top:1px solid #EBEBEB;font-size:14px;color:#666;width:107px\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t影响用户数\n" +
                "\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t<td style=\"padding-right:20px;border-top:1px solid #EBEBEB;font-size:14px;color:#666\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t崩溃次数\n" +
                "\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t<tr style=\"height:58px;line-height:58px;display:none\">\n" +
                "\t\t\t\t\t\t\t\t\t\t<td align=\"left\" title=\"none\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<div style=\"padding-left:20px;white-space:nowrap;font-size:16px;color:#333;overflow:hidden;text-overflow:ellipsis;line-height:1\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\tnone\n" +
                "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t<td style=\"font-size:16px;color:#333\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\tnone\n" +
                "\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t<td style=\"font-size:16px;color:#333\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<div style=\"position:relative;padding-right:10px\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t<span>none</span><img src=\"http://3gimg.qq.com/mig-web/2016/bugly/img/up_201612071650.png\" width=\"9\" height=\"12\" style=\"position:absolute;top:22px;right:-3px;display:none\"><img src=\"http://3gimg.qq.com/mig-web/2016/bugly/img/down_201612071650.png\" width=\"9\" height=\"12\" style=\"position:absolute;top:22px;right:-3px;display:none\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t<td style=\"font-size:16px;color:#333\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\tnone\n" +
                "\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t<td style=\"padding-right:20px;font-size:16px;color:#333\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\tnone\n" +
                "\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t<tr style=\"height:58px;line-height:58px;display:none\">\n" +
                "\t\t\t\t\t\t\t\t\t\t<td align=\"left\" title=\"none\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<div style=\"padding-left:20px;white-space:nowrap;font-size:16px;color:#333;overflow:hidden;text-overflow:ellipsis;line-height:1\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\tnone\n" +
                "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t<td style=\"font-size:16px;color:#333\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\tnone\n" +
                "\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t<td style=\"font-size:16px;color:#333\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<div style=\"position:relative;padding-right:10px\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t<span>none</span><img src=\"http://3gimg.qq.com/mig-web/2016/bugly/img/up_201612071650.png\" width=\"9\" height=\"12\" style=\"position:absolute;top:22px;right:-3px;display:none\"><img src=\"http://3gimg.qq.com/mig-web/2016/bugly/img/down_201612071650.png\" width=\"9\" height=\"12\" style=\"position:absolute;top:22px;right:-3px;display:none\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t<td style=\"font-size:16px;color:#333\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\tnone\n" +
                "\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t<td style=\"padding-right:20px;font-size:16px;color:#333\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\tnone\n" +
                "\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t<tr style=\"height:58px;line-height:58px;display:none\">\n" +
                "\t\t\t\t\t\t\t\t\t\t<td align=\"left\" title=\"none\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<div style=\"padding-left:20px;white-space:nowrap;font-size:16px;color:#333;overflow:hidden;text-overflow:ellipsis;line-height:1\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\tnone\n" +
                "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t<td style=\"font-size:16px;color:#333\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\tnone\n" +
                "\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t<td style=\"font-size:16px;color:#333\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<div style=\"position:relative;padding-right:10px\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t<span>none</span><img src=\"http://3gimg.qq.com/mig-web/2016/bugly/img/up_201612071650.png\" width=\"9\" height=\"12\" style=\"position:absolute;top:22px;right:-3px;display:none\"><img src=\"http://3gimg.qq.com/mig-web/2016/bugly/img/down_201612071650.png\" width=\"9\" height=\"12\" style=\"position:absolute;top:22px;right:-3px;display:none\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t<td style=\"font-size:16px;color:#333\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\tnone\n" +
                "\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t<td style=\"padding-right:20px;font-size:16px;color:#333\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\tnone\n" +
                "\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t<tr style=\"height:58px;line-height:58px;display:none\">\n" +
                "\t\t\t\t\t\t\t\t\t\t<td align=\"left\" title=\"none\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<div style=\"padding-left:20px;white-space:nowrap;font-size:16px;color:#333;overflow:hidden;text-overflow:ellipsis;line-height:1\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\tnone\n" +
                "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t<td style=\"font-size:16px;color:#333\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\tnone\n" +
                "\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t<td style=\"font-size:16px;color:#333\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<div style=\"position:relative;padding-right:10px\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t<span>none</span><img src=\"http://3gimg.qq.com/mig-web/2016/bugly/img/up_201612071650.png\" width=\"9\" height=\"12\" style=\"position:absolute;top:22px;right:-3px;display:none\"><img src=\"http://3gimg.qq.com/mig-web/2016/bugly/img/down_201612071650.png\" width=\"9\" height=\"12\" style=\"position:absolute;top:22px;right:-3px;display:none\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t<td style=\"font-size:16px;color:#333\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\tnone\n" +
                "\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t<td style=\"padding-right:20px;font-size:16px;color:#333\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\tnone\n" +
                "\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t<tr style=\"height:58px;line-height:58px;display:none\">\n" +
                "\t\t\t\t\t\t\t\t\t\t<td align=\"left\" title=\"none\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<div style=\"padding-left:20px;white-space:nowrap;font-size:16px;color:#333;overflow:hidden;text-overflow:ellipsis;line-height:1\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\tnone\n" +
                "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t<td style=\"font-size:16px;color:#333\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\tnone\n" +
                "\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t<td style=\"font-size:16px;color:#333\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<div style=\"position:relative;padding-right:10px\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t<span>none</span><img src=\"http://3gimg.qq.com/mig-web/2016/bugly/img/up_201612071650.png\" width=\"9\" height=\"12\" style=\"position:absolute;top:22px;right:-3px;display:none\"><img src=\"http://3gimg.qq.com/mig-web/2016/bugly/img/down_201612071650.png\" width=\"9\" height=\"12\" style=\"position:absolute;top:22px;right:-3px;display:none\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t<td style=\"font-size:16px;color:#333\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\tnone\n" +
                "\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t<td style=\"padding-right:20px;font-size:16px;color:#333\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\tnone\n" +
                "\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t</tbody>\n" +
                "\t\t\t\t\t\t\t\t\t</table>\n" +
                "\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t\t<td>\n" +
                "\t\t\t\t\t\t\t\t\t<p style=\"text-align:center;font-size:13px;color:#999;margin-top:20px;margin-bottom:20px\">\n" +
                "\t\t\t\t\t\t\t\t\t\t"+message+"\n" +
                "\t\t\t\t\t\t\t\t\t</p>\n" +
                "\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t</tbody>\n" +
                "\t\t\t\t\t\t\t</table>\n" +
                "\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t</tbody>\n" +
                "\t\t\t\t\t</table>\n" +
                "\t\t\t\t\t</span>\n" +
                "\t\t\t\t\t<br>\n" +
                "\t\t\t\t\t<span class=\"genEmailTail\">\n" +
                "\t\t\t\t\t</span>\n" +
                "\t\t\t\t</div>\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t\t<style type=\"text/css\">\n" +
                ".qmbox style, .qmbox script, .qmbox head, .qmbox link, .qmbox meta {display: none !important;}\n" +
                "\t\t</style>\n" +
                "\t</div>\n" +
                "</div>";
    }
}
