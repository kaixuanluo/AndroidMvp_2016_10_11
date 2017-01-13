package com.example.admin.androidmvp_2016_10_11.common.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.admin.androidmvp_2016_10_11.common.presenter.BasePresenter;
import com.example.admin.androidmvp_2016_10_11.common.requestStatus.BaseRequestStauts;

/**
 * 描述说明  <br/>
 * Author : luokaixuan <br/>
 * CreateDate : 2016/10/25 20:41 <br/>
 * Modified : luokaixuan <br/>
 * ModifiedDate : 2016/10/25 20:41 <br/>
 * Email : 1005949566@qq.com <br/>
 * Version 1.0
 */
public abstract class BaseMvpActivity<P extends BasePresenter<V>, V extends BaseRequestStauts> extends BaseRxActivity {

    protected abstract P createPresenter();

    P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter = createPresenter();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (presenter != null) {
            presenter.detachStatusView();
        }
    }

}
