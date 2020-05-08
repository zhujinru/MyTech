package com.wd.tech.widget;

import android.app.Application;
import android.content.Context;

import com.example.arclibrary.builder.AcrFaceManagerBuilder;
import com.wd.tech.hr.Constants;

import cn.jpush.im.android.api.JMessageClient;

import static cn.jpush.im.android.api.JMessageClient.FLAG_NOTIFY_SILENCE;

/**
 * date:2020/4/18
 * author:朱金茹(Lenovo)
 * function:全局类
 */
public class MyApp extends Application {
    public static Context mContext;
    //用于极光
    public static String s1="d4cf77f0d3b85e9edc540dee";
    public static String s2="a12345";
    public static Context getmContext() {
        return mContext;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        mContext=this;
        //初始化极光
        JMessageClient.init(this, true);
        JMessageClient.setDebugMode(true);
        //通知管理,通知栏开启，其他关闭
        JMessageClient.setNotificationFlag(FLAG_NOTIFY_SILENCE);
    }
    private void initArcFace() {
        new AcrFaceManagerBuilder().setContext(this)
                .setFreeSdkAppId(Constants.FREESDKAPPID)
                .setFdSdkKey(Constants.FDSDKKEY)
                .setFtSdkKey(Constants.FTSDKKEY)
                .setFrSdkKey(Constants.FRSDKKEY)
                .setLivenessAppId(Constants.LIVENESSAPPID)
                .setLivenessSdkKey(Constants.LIVENESSSDKKEY)
                .create();
    }

}
