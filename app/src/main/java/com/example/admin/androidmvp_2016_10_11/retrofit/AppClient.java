package com.example.admin.androidmvp_2016_10_11.retrofit;

import com.example.admin.androidmvp_2016_10_11.BuildConfig;
import com.example.admin.androidmvp_2016_10_11.ui.download.DownInfo;
import com.example.admin.androidmvp_2016_10_11.ui.download.DownloadInterceptor;
import com.example.admin.androidmvp_2016_10_11.ui.download.ProgressDownSubscriber;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by WuXiaolong
 * on 2016/3/24.
 * github:https://github.com/WuXiaolong/
 * weibo:http://weibo.com/u/2175011601
 * 微信公众号：吴小龙同学
 * 个人博客：http://wuxiaolong.me/
 */
public class AppClient {
    public static Retrofit mRetrofit;
//    public static final String API_SERVER_URL = "http://192.168.1.31:85";
    public static final String API_SERVER_URL = "http://192.168.1.10";
//    public static final String API_SERVER_URL = "http://192.168.1.34:5555";

    public static ProgressDownSubscriber subscriber;

    static OkHttpClient.Builder builder;

    private static final HashMap<String, List<Cookie>> cookieStore = new HashMap<>();

    public static Retrofit initRetrofit() {
        return initBaseRetrofit();
    }

    public static Retrofit initDownUploadRetrofit(DownInfo info) {
        subscriber = new ProgressDownSubscriber(info);
        DownloadInterceptor interceptor2 = new DownloadInterceptor(subscriber);
        return initBaseRetrofit(interceptor2);
    }

    public static Retrofit initBaseRetrofit(){
        return initBaseRetrofit(null);
    }

    public static Retrofit initBaseRetrofit(Interceptor interceptorDownload) {

            Interceptor interceptor = new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request newRequest = chain.request().newBuilder().addHeader("User-Agent", "Retrofit-Sample-App").build();
                    return chain.proceed(newRequest);
                }
            };

        if (builder == null) {
            builder = new OkHttpClient.Builder().cookieJar(new CookieJar() {
                //MD,終於把Cookie帶過去了，這裡key必須是String啊！！！！！！！！！！！！

                @Override
                public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
                    cookieStore.put(url.host(), cookies);
                }

                @Override
                public List<Cookie> loadForRequest(HttpUrl url) {
                    List<Cookie> cookies = cookieStore.get(url.host());
                    return cookies != null ? cookies : new ArrayList<Cookie>();
                }
            });

            if (BuildConfig.DEBUG) {
                // Log信息拦截器
                HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
                loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                //设置 Debug Log 模式
                builder.addInterceptor(loggingInterceptor);
            }

        }

//            if (interceptorDownload != null) {
//                builder.addInterceptor(interceptorDownload);
//            }

            OkHttpClient okHttpClient = builder.build();

            Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();

            mRetrofit = new Retrofit.Builder()
                    .baseUrl(API_SERVER_URL)
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(okHttpClient)
                    .build();

        return mRetrofit;
    }

    OkHttpClient mHttpClient = new OkHttpClient.Builder().cookieJar(new CookieJar() {
        //MD,終於把Cookie帶過去了，這裡key必須是String啊！！！！！！！！！！！！
        private final HashMap<String, List<Cookie>> cookieStore = new HashMap<>();

        @Override
        public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
            cookieStore.put(url.host(), cookies);
        }
        @Override
        public List<Cookie> loadForRequest(HttpUrl url) {
            List<Cookie> cookies = cookieStore.get(url.host());
            return cookies != null ? cookies : new ArrayList<Cookie>();
        }
    }).build();

}
