package com.example.lihexiang.mydemo

import android.app.Application
import android.util.Log
import com.umeng.commonsdk.UMConfigure
import com.umeng.message.IUmengRegisterCallback
import com.umeng.message.PushAgent
import org.android.agoo.xiaomi.MiPushRegistar

class APP : Application() {

    companion object {
        private lateinit var app: APP

        fun getApp(): APP {
            return app;
        }
    }

    override fun onCreate() {
        super.onCreate()
        app = this

        UMConfigure.init(app, "5b8748c58f4a9d61e2000284",
                "channel", UMConfigure.DEVICE_TYPE_PHONE, "9ac8f5c6b5663b89b3c1776fcc2cd47e")

        MiPushRegistar.register(this, "2882303761517858476", "5361785856476");

        PushAgent.getInstance(app).register(object : IUmengRegisterCallback {
            override fun onSuccess(deviceToken: String?) {
                //注册成功会返回device token
                Log.i("push-lhx", deviceToken)
            }

            override fun onFailure(s: String?, s1: String?) {
                Log.e("push-lhx", s + "---" + s1)
            }
        })

    }
}