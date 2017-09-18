package com.example.administrator.umengtest;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.umeng.message.IUmengRegisterCallback;
import com.umeng.message.PushAgent;
import com.umeng.message.UmengNotificationClickHandler;
import com.umeng.message.entity.UMessage;

/**
 * Created by Alex on 2017/9/12.
 */

public class MyApplication  extends Application{
    private static final String TAG = "MyApplication";
    @Override
    public void onCreate() {

        super.onCreate();
        PushAgent pushAgent = PushAgent.getInstance(this);


        pushAgent.register(new IUmengRegisterCallback() {
            @Override
            public void onSuccess(String s) {
                Log.d(TAG, "onSuccess: "+s);
                
            }

            @Override
            public void onFailure(String s, String s1) {
                Log.d(TAG, "onFailure: "+s+s1);

            }
        });

        pushAgent.setNotificationClickHandler(clickHandler);



    }

    UmengNotificationClickHandler clickHandler = new UmengNotificationClickHandler(){


        @Override
        public void dealWithCustomAction(Context context, UMessage uMessage) {
            super.dealWithCustomAction(context, uMessage);
           // Toast.makeText(context, uMessage.extra.get("custom"), Toast.LENGTH_LONG).show();

        }
    };



}
