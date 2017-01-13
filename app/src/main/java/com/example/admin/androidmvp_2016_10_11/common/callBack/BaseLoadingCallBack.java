package com.example.admin.androidmvp_2016_10_11.common.callBack;

import com.example.admin.androidmvp_2016_10_11.common.module.BaseModule;
import com.wuxiaolong.androidutils.library.LogUtil;

import retrofit2.adapter.rxjava.HttpException;

/**
 * 描述说明  <br/>
 * Author : luokaixuan <br/>
 * CreateDate : 2016/10/11 18:00 <br/>
 * Modified : luokaixuan <br/>
 * ModifiedDate : 2016/10/11 18:00 <br/>
 * Email : 1005949566@qq.com <br/>
 * Version 1.0
 */
public class BaseLoadingCallBack<DATA extends BaseModule> extends BaseCallBack< DATA>{

    final int FLAG_SUCCESS = 1;

    @Override
    public void onCompleted() {
        completed();
    }

    @Override
    public void onError(Throwable e) {

        e.printStackTrace();
        if (e instanceof HttpException) {
            HttpException httpException = (HttpException) e;
            //httpException.response().errorBody().string()
            int code = httpException.code();
            String msg = httpException.getMessage();
            LogUtil.d("code=" + code);
            if (code == 504) {
                msg = "网络不给力";
            }
            if (code == 502 || code == 404) {
                msg = "服务器异常，请稍后再试";
            }
            if (code == 401) {
                //掉线了,需要重新登录
                offLine();
            }
            failure(code, msg);
        } else {
            failure(0, e.getMessage());
        }
        completed();
    }

    @Override
    public void onNext(DATA data) {
        success(data);
    }

    @Override
    public void success(DATA data) {
        int flag = data.getFlag();
        switch (flag) {
            case FLAG_SUCCESS:
                break;
            default:
                error(data.getMsg());
                break;
        }
        completed();
    }

    @Override
    public void failure(int code, String msg) {
        completed();}

    @Override
    public void error(String msg){
            completed();
    }

    @Override
    public void loading() {

    }

    @Override
    public void startLoad() {

    }

    @Override
    public void completed() {

    }

    @Override
    public void reLoad() {

    }

    @Override
    public void offLine() {
    }
}
