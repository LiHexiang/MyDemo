package com.example.lihexiang.mydemo;

import android.app.Application;
import android.util.Log;

import com.umeng.commonsdk.UMConfigure;
import com.umeng.message.IUmengRegisterCallback;
import com.umeng.message.PushAgent;

import org.android.agoo.xiaomi.MiPushRegistar;

public class APP extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化推送
        UMConfigure.init(this, "5b8748c58f4a9d61e2000284",
                "channel", UMConfigure.DEVICE_TYPE_PHONE, "9ac8f5c6b5663b89b3c1776fcc2cd47e");


        MiPushRegistar.register(this, "2882303761517858476", "5361785856476");

        //注册推送服务
        PushAgent mPushAgent = PushAgent.getInstance(this);
        //注册推送服务，每次调用register方法都会回调该接口
        mPushAgent.register(new IUmengRegisterCallback() {
            @Override
            public void onSuccess(String deviceToken) {
                //注册成功会返回device token
                Log.i("push-lhx", deviceToken);
            }

            @Override
            public void onFailure(String s, String s1) {
                Log.e("push-lhx", s + "---" + s1);
            }
        });



    }
}
