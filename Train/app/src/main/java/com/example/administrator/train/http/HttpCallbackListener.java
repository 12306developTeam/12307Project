package com.example.administrator.train.http;

/**
 * Created by Administrator on 2017/5/5.
 */
public interface HttpCallbackListener {
    void onFinish(String response);
    void onError(Exception e);
}
