package com.example.admin.androidmvp_2016_10_11.common.requestStatus;

/**
 * 描述说明  <br/>
 * Author : luokaixuan <br/>
 * CreateDate : 2016/10/11 16:06 <br/>
 * Modified : luokaixuan <br/>
 * ModifiedDate : 2016/10/11 16:06 <br/>
 * Email : 1005949566@qq.com <br/>
 * Version 1.0
 */
public interface BaseLoadingRequestStatus<DATA> extends BaseRequestStauts{
    void success(DATA data);
    void failure(int code, String msg);
    void error(String msg);
    void loading();
    void startLoad();
    void completed();
    void reLoad();
    void offLine();
}
