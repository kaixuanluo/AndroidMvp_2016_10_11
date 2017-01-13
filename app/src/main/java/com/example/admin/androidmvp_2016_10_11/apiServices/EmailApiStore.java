package com.example.admin.androidmvp_2016_10_11.apiServices;

import com.example.admin.androidmvp_2016_10_11.module.response.MailResult;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * 描述说明  <br/>
 * Author : luokaixuan <br/>
 * CreateDate : 2016/10/12 19:37 <br/>
 * Modified : luokaixuan <br/>
 * ModifiedDate : 2016/10/12 19:37 <br/>
 * Email : 1005949566@qq.com <br/>
 * Version 1.0
 */
public interface EmailApiStore {

    //邮件列表
    @GET("api/MailSendList")
    Observable<MailResult> mailList(@Query("MinId") String minid,
                                    @Query("PageSize") int pageSize);
}
