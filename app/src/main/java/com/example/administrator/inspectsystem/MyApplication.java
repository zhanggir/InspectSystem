package com.example.administrator.inspectsystem;

import android.app.Application;

import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.mapapi.SDKInitializer;
import com.example.administrator.inspectsystem.model.login.map.MyLocationListener;

import java.util.Map;

/**
 * Created time : 2017/4/26 14:18.
 *
 * @author
 */

public class MyApplication extends Application {
    // 用于存放倒计时时间
    public static Map<String, Long> map;
    public LocationClient mLocationClient = null;
    public BDLocationListener myListener = new MyLocationListener();

    @Override
    public void onCreate() {
        super.onCreate();
        mLocationClient = new LocationClient(getApplicationContext());
        //声明LocationClient类
        mLocationClient.registerLocationListener( myListener );
        //注册监听函数
        SDKInitializer.initialize(getApplicationContext());
    }
}
