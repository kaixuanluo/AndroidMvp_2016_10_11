package com.example.admin.androidmvp_2016_10_11.apiServices;

import com.example.admin.androidmvp_2016_10_11.module.response.UploadResult;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * 描述说明  <br/>
 * Author : luokaixuan <br/>
 * CreateDate : 2016/11/24 15:05 <br/>
 * Modified : luokaixuan <br/>
 * ModifiedDate : 2016/11/24 15:05 <br/>
 * Email : 1005949566@qq.com <br/>
 * Version 1.0
 */
public interface DownUpStore {

    @GET("/api/FileDownloadNew/{id}")
    Observable<ResponseBody>
    download(@Path("id") String id);

    @Multipart
    @POST("/api/FileUploadNew")
    Observable<UploadResult> uploadFile(@Part MultipartBody.Part file, @Query("directoryId") String directoryId);


}
