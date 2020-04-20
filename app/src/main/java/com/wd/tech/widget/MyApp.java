package com.wd.tech.widget;

import android.app.Application;
import android.content.Context;

import com.example.arclibrary.builder.AcrFaceManagerBuilder;
import com.wd.tech.hr.Constants;

/**
 * date:2020/4/18
 * author:朱金茹(Lenovo)
 * function:全局类
 */
public class MyApp extends Application {
    public static Context mContext;
    public static Context getmContext() {
        return mContext;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        mContext=this;
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
