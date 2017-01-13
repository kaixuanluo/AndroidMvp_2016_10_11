package com.example.admin.androidmvp_2016_10_11.ui.flow;

import com.example.admin.androidmvp_2016_10_11.apiServices.FlowApiStore;
import com.example.admin.androidmvp_2016_10_11.common.callBack.BaseLoadingCallBack;
import com.example.admin.androidmvp_2016_10_11.common.module.BaseListModule;
import com.example.admin.androidmvp_2016_10_11.common.presenter.BaseListPresenter;
import com.example.admin.androidmvp_2016_10_11.common.requestStatus.BaseListRequestStatus;
import com.example.admin.androidmvp_2016_10_11.module.response.FlowProgressResult;
import com.example.admin.androidmvp_2016_10_11.module.response.FlowSendResult;
import com.example.admin.androidmvp_2016_10_11.retrofit.AppClient;

import rx.Observable;

/**
 * 描述说明  <br/>
 * Author : luokaixuan <br/>
 * CreateDate : 2016/10/14 20:09 <br/>
 * Modified : luokaixuan <br/>
 * ModifiedDate : 2016/10/14 20:09 <br/>
 * Email : 1005949566@qq.com <br/>
 * Version 1.0
 */
public class FlowProgressPresenter <DATA extends BaseListModule, ITEM>
        extends BaseListPresenter<BaseListRequestStatus<DATA, ITEM>> {
    public FlowProgressPresenter(BaseListRequestStatus statusView) {
        super(statusView);
    }

    void flowProgressData(String flowId, BaseLoadingCallBack callback) {
        FlowApiStore flowApiStore = AppClient.initRetrofit().create(FlowApiStore.class);
        Observable<FlowProgressResult> observable = flowApiStore.progress(flowId);/*"4289"*/
        loadData(observable, callback);
    }

    void flowList(String minId, BaseLoadingCallBack callback) {
        FlowApiStore flowApiStore = AppClient.initRetrofit().create(FlowApiStore.class);
        Observable<FlowSendResult> send = flowApiStore.send(minId, 5);
        loadData(send, callback);
    }
}