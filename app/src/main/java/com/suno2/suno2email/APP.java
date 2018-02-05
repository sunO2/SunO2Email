package com.suno2.suno2email;

import android.app.Application;

/**
 * Name: SunO2Email
 * Author: hezhihu
 * Email: 2854918124@qq.com
 * 创建时间: 2018/2/5 15:54
 * 修改时间:  2018/2/5 15:54
 * 内容描述:
 */

public class APP extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Contain.init(this.getApplicationContext());
    }
}
