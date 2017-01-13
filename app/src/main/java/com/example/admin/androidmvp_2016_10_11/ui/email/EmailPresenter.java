package com.example.admin.androidmvp_2016_10_11.ui.email;

import com.example.admin.androidmvp_2016_10_11.apiServices.EmailApiStore;
import com.example.admin.androidmvp_2016_10_11.common.callBack.BaseLoadingCallBack;
import com.example.admin.androidmvp_2016_10_11.common.module.BaseListModule;
import com.example.admin.androidmvp_2016_10_11.common.presenter.BaseListPresenter;
import com.example.admin.androidmvp_2016_10_11.common.requestStatus.BaseListRequestStatus;
import com.example.admin.androidmvp_2016_10_11.module.response.MailResult;
import com.example.admin.androidmvp_2016_10_11.retrofit.AppClient;

import rx.Observable;

/**
 * 描述说明  <br/>
 * Author : luokaixuan <br/>
 * CreateDate : 2016/10/12 18:47 <br/>
 * Modified : luokaixuan <br/>
 * ModifiedDate : 2016/10/12 18:47 <br/>
 * Email : 1005949566@qq.com <br/>
 * Version 1.0
 */
public class EmailPresenter<DATA extends BaseListModule, ITEM, CALLBACK extends BaseLoadingCallBack>
        extends BaseListPresenter<BaseListRequestStatus<DATA, ITEM>> {
    public EmailPresenter(BaseListRequestStatus statusView) {
        super(statusView);
    }

    void loadEmailData(String minid, CALLBACK callback) {
        EmailApiStore emailApiStore = AppClient.initRetrofit().create(EmailApiStore.class);
        Observable<MailResult> observable = emailApiStore.mailList(minid, 5);
        loadData(observable, callback);

//        FlowApiStore flowApiStore = AppClient.initRetrofit().create(FlowApiStore.class);
//        Observable<FlowProgressResult> observable = flowApiStore.progress("4289");
//        loadData(observable, callback);
    }
}
