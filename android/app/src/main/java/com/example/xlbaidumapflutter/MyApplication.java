package com.example.xlbaidumapflutter;

import android.app.Application;
import android.content.Context;

import com.baidu.mapapi.SDKInitializer;

import io.flutter.app.FlutterApplication;

/**
 * Created by Administrator on 2018/1/26.
 */

public class MyApplication extends FlutterApplication {
    public static Context mContext;
    @Override
    public void onCreate() {
        super.onCreate();
        mContext=getApplicationContext();
        SDKInitializer.initialize(getApplicationContext());
    }
}
