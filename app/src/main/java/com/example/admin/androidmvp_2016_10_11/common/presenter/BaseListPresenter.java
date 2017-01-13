package com.example.admin.androidmvp_2016_10_11.common.presenter;

import com.example.admin.androidmvp_2016_10_11.common.requestStatus.BaseListRequestStatus;

/**
 * 描述说明  <br/>
 * Author : luokaixuan <br/>
 * CreateDate : 2016/10/11 15:54 <br/>
 * Modified : luokaixuan <br/>
 * ModifiedDate : 2016/10/11 15:54 <br/>
 * Email : 1005949566@qq.com <br/>
 * Version 1.0
 */
public class BaseListPresenter<V extends BaseListRequestStatus> extends BaseLoadingPresenter<V>{

    public BaseListPresenter(V statusView) {
        super(statusView);
    }

    @Override
    void showLoading() {
    }
}
