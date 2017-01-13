package com.example.admin.androidmvp_2016_10_11.ui.download;

import com.example.admin.androidmvp_2016_10_11.common.activity.BaseMvpActivity;
import com.example.admin.androidmvp_2016_10_11.common.requestStatus.BaseDownLoadRequestStatus;

/**
 * 描述说明  <br/>
 * Author : luokaixuan <br/>
 * CreateDate : 2016/10/27 11:52 <br/>
 * Modified : luokaixuan <br/>
 * ModifiedDate : 2016/10/27 11:52 <br/>
 * Email : 1005949566@qq.com <br/>
 * Version 1.0
 */
public class DownLoadActivity extends BaseMvpActivity<DownLoadPresenter, BaseDownLoadRequestStatus>
    implements BaseDownLoadRequestStatus{

    @Override
    protected DownLoadPresenter createPresenter() {
        return new DownLoadPresenter(this);
    }

    @Override
    public void onDownLoadStart() {

    }

    @Override
    public void onDownLoadPause() {

    }

    @Override
    public void onDownLoadStop() {

    }

    @Override
    public void onDownLoadFailure() {

    }

    @Override
    public void onDownLoadSuccess() {

    }

    @Override
    public void onDownLoadError() {

    }

    @Override
    public void offLine() {

    }
}
