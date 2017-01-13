package com.example.admin.androidmvp_2016_10_11.common.presenter;

import com.example.admin.androidmvp_2016_10_11.common.requestStatus.BaseLoadingRequestStatus;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * 描述说明  <br/>
 * Author : luokaixuan <br/>
 * CreateDate : 2016/10/11 15:54 <br/>
 * Modified : luokaixuan <br/>
 * ModifiedDate : 2016/10/11 15:54 <br/>
 * Email : 1005949566@qq.com <br/>
 * Version 1.0
 */
public class BaseLoadingPresenter<V extends BaseLoadingRequestStatus> extends BasePresenter<V> {

    public BaseLoadingPresenter(V statusView) {
        super(statusView);
    }

    public void loadData(Observable observable, Subscriber subscriber) {

        showLoading();

        if (mSubscription == null) {
            mSubscription = new CompositeSubscription();
        }

        mSubscription.add(observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber));

    }

    void showLoading() {
        statusView.loading();
    }
}
