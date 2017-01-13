package com.example.admin.androidmvp_2016_10_11.view;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.example.admin.androidmvp_2016_10_11.R;
import com.example.admin.androidmvp_2016_10_11.common.requestStatus.BaseLoadingRequestStatus;

/**
 * 描述说明  <br/>
 * Author : luokaixuan <br/>
 * CreateDate : 2016/10/12 15:12 <br/>
 * Modified : luokaixuan <br/>
 * ModifiedDate : 2016/10/12 15:12 <br/>
 * Email : 1005949566@qq.com <br/>
 * Version 1.0
 */
public class LoadingLayout extends FrameLayout implements BaseLoadingRequestStatus{

    FixedFlipper flp;
    int CONTENT = 0 ;
    int ERROR = 1;
    int EMPTY = 2;
    int LOADING = 3;
    public LoadingLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        flp = (FixedFlipper) findViewById(R.id.flp);
        ImageView ivLoading = (ImageView) findViewById(R.id.load_ing_iv);
        AnimationDrawable loadingDrawable = (AnimationDrawable) ivLoading.getDrawable();
        loadingDrawable.start();
    }

    void showError() {
        flp.setDisplayedChild(ERROR);
    }

    void showContent() {
        flp.setDisplayedChild(CONTENT);
    }

    void showEmpty() {
        flp.setDisplayedChild(EMPTY);
    }

    void showLoading() {
        flp.setDisplayedChild(LOADING);

    }

    @Override
    public void success( Object o2) {
        showContent();
    }

    @Override
    public void failure(int code, String msg) {
        showError();
    }

    @Override
    public void error(String msg) {
        showError();
    }

    @Override
    public void loading() {
        showLoading();
    }

    @Override
    public void startLoad() {
        showLoading();
    }

    @Override
    public void completed() {

    }

    @Override
    public void reLoad() {
        startLoad();
    }

    @Override
    public void offLine() {

    }
}
