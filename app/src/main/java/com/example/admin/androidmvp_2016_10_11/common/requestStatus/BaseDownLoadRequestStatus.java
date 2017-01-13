package com.example.admin.androidmvp_2016_10_11.common.requestStatus;

/**
 * 描述说明  <br/>
 * Author : luokaixuan <br/>
 * CreateDate : 2016/10/27 13:37 <br/>
 * Modified : luokaixuan <br/>
 * ModifiedDate : 2016/10/27 13:37 <br/>
 * Email : 1005949566@qq.com <br/>
 * Version 1.0
 */
public interface BaseDownLoadRequestStatus extends BaseRequestStauts {

    void onDownLoadStart ();
    void onDownLoadPause();
    void onDownLoadStop();
    void onDownLoadFailure();
    void onDownLoadSuccess();
    void onDownLoadError();
    void offLine();

}
