package com.example.admin.androidmvp_2016_10_11.common.presenter;

import com.example.admin.androidmvp_2016_10_11.common.requestStatus.BaseRequestStauts;

import rx.subscriptions.CompositeSubscription;

/**
 * 描述说明  <br/>
 * Author : luokaixuan <br/>
 * CreateDate : 2016/10/11 15:53 <br/>
 * Modified : luokaixuan <br/>
 * ModifiedDate : 2016/10/11 15:53 <br/>
 * Email : 1005949566@qq.com <br/>
 * Version 1.0
 */
public class BasePresenter<V extends BaseRequestStauts> {
    public V statusView;
    public CompositeSubscription mSubscription;

    public BasePresenter(V statusView) {
        this.statusView = statusView;
    }

    public void detachStatusView() {
        this.statusView = null;
        if (mSubscription != null && mSubscription.hasSubscriptions()) {
            mSubscription.unsubscribe();
        }
    }
}
