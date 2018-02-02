package com.suno2.suno2email;

import android.os.AsyncTask;
import android.util.Log;

import com.suno2.suno2email.builde.Message;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Name: SunO2Email
 * Author: hezhihu
 * Email: 2854918124@qq.com
 * 创建时间: 2018/2/2 17:19
 * 修改时间:  2018/2/2 17:19
 * 内容描述:
 */

public class SendEmailTask extends AsyncTask<Void, Void, Boolean> {

    private Message mMessage;

    public SendEmailTask(Message message) {
        this.mMessage = message;
    }

    /**
     * Override this method to perform a computation on a background thread. The
     * specified parameters are the parameters passed to {@link #execute}
     * by the caller of this task.
     * <p>
     * This method can call {@link #publishProgress} to publish updates
     * on the UI thread.
     *
     * @param voids The parameters of the task.
     * @return A result, defined by the subclass of this task.
     * @see #onPreExecute()
     * @see #onPostExecute
     * @see #publishProgress
     */
    @Override
    protected Boolean doInBackground(Void... voids) {
        try {
            // 创建Properties 类用于记录邮箱的一些属性
            final Properties props = new Properties();
            // 表示SMTP发送邮件，必须进行身份验证
            props.put("mail.smtp.auth", "true");
            //此处填写SMTP服务器
            props.put("mail.smtp.host", "smtp.qq.com");
            //端口号，QQ邮箱给出了两个端口，但是另一个我一直使用不了，所以就给出这一个587
            props.put("mail.smtp.port", "587");
            // 此处填写你的账号
            props.put("mail.user", "2854918124@qq.com");
            // 此处的密码就是前面说的16位STMP口令
            props.put("mail.password", "vsuquuhaoxyadghj");

            // 构建授权信息，用于进行SMTP进行身份验证
            Authenticator authenticator = new Authenticator() {

                protected PasswordAuthentication getPasswordAuthentication() {
                    // 用户名、密码
                    String userName = props.getProperty("mail.user");
                    String password = props.getProperty("mail.password");
                    return new PasswordAuthentication(userName, password);
                }
            };
            // 使用环境属性和授权信息，创建邮件会话
            Session mailSession = Session.getInstance(props, authenticator);
            // 创建邮件消息
            MimeMessage message = new MimeMessage(mailSession);
            // 设置发件人
            InternetAddress form = new InternetAddress(
                    props.getProperty("mail.user"));
            message.setFrom(form);

            // 设置收件人的邮箱
            InternetAddress to = new InternetAddress("354137379@qq.com");
            message.setRecipient(javax.mail.Message.RecipientType.TO, to);

            // 设置邮件标题
            message.setSubject(mMessage.getTitle());

            // 设置邮件的内容体
            message.setContent(mMessage.getMessage(), "text/html;charset=UTF-8");

            // 最后当然就是发送邮件啦
            Transport.send(message);

            Log.d("TAG","邮件发送成功");
            return true;
        }catch (Exception e){
            e.printStackTrace();
            Log.d("TAG","邮件发送失败");
            return false;
        }
    }
}
