package com.example.admin.androidmvp_2016_10_11.common.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.example.admin.androidmvp_2016_10_11.R;
import com.example.admin.androidmvp_2016_10_11.common.callBack.BaseLoadingCallBack;
import com.example.admin.androidmvp_2016_10_11.common.module.BaseModule;
import com.example.admin.androidmvp_2016_10_11.common.presenter.BaseLoadingPresenter;
import com.example.admin.androidmvp_2016_10_11.common.requestStatus.BaseLoadingRequestStatus;
import com.example.admin.androidmvp_2016_10_11.ui.login.LoginPresenter;
import com.example.admin.androidmvp_2016_10_11.view.FixedFlipper;
import com.example.admin.androidmvp_2016_10_11.view.LoadingLayout;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 描述说明  <br/>
 * Author : luokaixuan <br/>
 * CreateDate : 2016/10/11 15:47 <br/>
 * Modified : luokaixuan <br/>
 * ModifiedDate : 2016/10/11 15:47 <br/>
 * Email : 1005949566@qq.com <br/>
 * Version 1.0
 */
public abstract class BaseLoadingActivity<P extends BaseLoadingPresenter<V>,
        V extends BaseLoadingRequestStatus<DATA>, DATA extends BaseModule>
        extends BaseMvpActivity<P, V> implements BaseLoadingRequestStatus<DATA> {

    ProgressDialog pd;
    LoadingLayout mLoadingLayout;
    @BindView(R.id.load_transparent_ll)
    FrameLayout mLoadTransparentLl;
    @BindView(R.id.load_error_ll)
    LinearLayout mLoadErrorLl;
    @BindView(R.id.load_empty_ll)
    LinearLayout mLoadEmptyLl;
    @BindView(R.id.loading)
    LinearLayout mLoading;
    @BindView(R.id.flp)
    FixedFlipper mFlp;

    P presenter;

    @OnClick({R.id.load_error_ll, R.id.load_empty_ll})
    void onViewClick(View view) {
        switch (view.getId()) {
            case R.id.load_error_ll:
                reLoad();
            break;

            case R.id.load_empty_ll:
                reLoad();
            break;
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pd = new ProgressDialog(this);
        presenter = createPresenter();
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(addLoadingView(view));
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(addLoadingView(LayoutInflater.from(this).inflate(layoutResID, null)));
    }

    protected LoadingLayout addLoadingView(View view) {
        mLoadingLayout = (LoadingLayout) LayoutInflater.from(this).inflate(R.layout.layout_loading, null);
        mLoadingLayout.addView(view, 0);
        return mLoadingLayout;
    }

    @Override
    public void failure(int code, String msg) {
        hideLoadingDialog();
        mLoadingLayout.failure(code, msg);
    }

    @Override
    public void error(String msg) {
        hideLoadingDialog();
        mLoadingLayout.error(msg);
    }

    @Override
    public void success(DATA data) {
        hideLoadingDialog();
        mLoadingLayout.success(data);
    }

    @Override
    public void loading() {
        showLoadingDialog();
        mLoadingLayout.loading();
    }

    @Override
    public void startLoad() {
        showLoadingDialog();
        mLoadingLayout.loading();
    }

    @Override
    public void reLoad() {
        startLoad();
    }

    @Override
    public void completed() {
        hideLoadingDialog();
    }

    void showLoadingDialog() {
        if (pd != null && !pd.isShowing()) {
            pd.show();
        }
    }

    void hideLoadingDialog() {
        if (pd != null && pd.isShowing()) {
            pd.hide();
        }
    }

    @Override
    public void offLine() {
//        new LoginPresenter(this).login("admin", "21232f297a57a5a743894a0e4a801fc3", new LoadingCallback());
        new LoginPresenter(this).login("10082",
                "e10adc3949ba59abbe56e057f20f883e", new LoadingCallback());
    }

    //    protected void addLoadingSubscription (Observable observable) {
//        loadData(observable, new LoadingCallback());
//    }

    public class LoadingCallback extends BaseLoadingCallBack<DATA> {
        @Override
        public void success(DATA data) {
            BaseLoadingActivity.this.success(data);
            reLoad();
        }

        @Override
        public void failure(int code, String msg) {
            BaseLoadingActivity.this.failure(code, msg);
        }

        @Override
        public void error(String msg) {
            BaseLoadingActivity.this.error(msg);
        }

        @Override
        public void loading() {
            BaseLoadingActivity.this.loading();
        }

        @Override
        public void startLoad() {
            BaseLoadingActivity.this.startLoad();
        }

        @Override
        public void completed() {
            BaseLoadingActivity.this.completed();
        }

        @Override
        public void offLine() {
            BaseLoadingActivity.this.offLine();
        }
    }
}
