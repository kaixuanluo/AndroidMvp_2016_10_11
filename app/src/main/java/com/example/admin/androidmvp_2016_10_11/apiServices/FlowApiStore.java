package com.example.admin.androidmvp_2016_10_11.apiServices;

import com.example.admin.androidmvp_2016_10_11.module.response.FlowProgressResult;
import com.example.admin.androidmvp_2016_10_11.module.response.FlowSendResult;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * 描述说明  <br/>
 * Author : luokaixuan <br/>
 * CreateDate : 2016/10/14 20:26 <br/>
 * Modified : luokaixuan <br/>
 * ModifiedDate : 2016/10/14 20:26 <br/>
 * Email : 1005949566@qq.com <br/>
 * Version 1.0
 */
public interface FlowApiStore {

    @GET("api/WorkFlowNew/Track")
    Observable<FlowProgressResult> progress (@Query("FlowApplyId") String minid);

    @GET("api/WorkFlowNew/Send")
    Observable<FlowSendResult> send(@Query("minId") String minid, @Query("pageSize") int pageSize);

}
