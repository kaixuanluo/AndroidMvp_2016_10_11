package com.example.admin.androidmvp_2016_10_11.ui.login;

import com.example.admin.androidmvp_2016_10_11.apiServices.LoginApiStore;
import com.example.admin.androidmvp_2016_10_11.common.callBack.BaseLoadingCallBack;
import com.example.admin.androidmvp_2016_10_11.common.presenter.BaseLoadingPresenter;
import com.example.admin.androidmvp_2016_10_11.common.requestStatus.BaseLoadingRequestStatus;
import com.example.admin.androidmvp_2016_10_11.retrofit.AppClient;

/**
 * 描述说明  <br/>
 * Author : luokaixuan <br/>
 * CreateDate : 2016/10/11 19:04 <br/>
 * Modified : luokaixuan <br/>
 * ModifiedDate : 2016/10/11 19:04 <br/>
 * Email : 1005949566@qq.com <br/>
 * Version 1.0
 */
public class LoginPresenter<V extends BaseLoadingRequestStatus>
        extends BaseLoadingPresenter<V> {

    public LoginPresenter(V statusView) {
        super(statusView);
    }

    public void login(String userCode, String password, BaseLoadingCallBack callback) {
        LoginApiStore loginApiStore = AppClient.initRetrofit().create(LoginApiStore.class);
        loadData(loginApiStore.login(userCode, password), callback);
    }

}
