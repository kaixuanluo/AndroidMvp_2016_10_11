package com.example.admin.androidmvp_2016_10_11.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.design.widget.NavigationView.OnNavigationItemSelectedListener;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatDelegate;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.androidmvp_2016_10_11.R;
import com.example.admin.androidmvp_2016_10_11.apiServices.DownUpStore;
import com.example.admin.androidmvp_2016_10_11.common.activity.BaseLoadingActivity;
import com.example.admin.androidmvp_2016_10_11.common.requestStatus.BaseLoadingRequestStatus;
import com.example.admin.androidmvp_2016_10_11.module.response.LoginResult;
import com.example.admin.androidmvp_2016_10_11.module.response.UploadResult;
import com.example.admin.androidmvp_2016_10_11.retrofit.AppClient;
import com.example.admin.androidmvp_2016_10_11.ui.download.DownInfo;
import com.example.admin.androidmvp_2016_10_11.ui.download.HttpProgressOnNextListener;
import com.example.admin.androidmvp_2016_10_11.ui.email.EmailListActivity;
import com.example.admin.androidmvp_2016_10_11.ui.flow.FlowListActivity;
import com.example.admin.androidmvp_2016_10_11.ui.flow.FlowProgressActivityBaseStickListActivity;
import com.example.admin.androidmvp_2016_10_11.ui.upload.ProgressRequestBody;
import com.example.admin.androidmvp_2016_10_11.ui.upload.UploadProgressListener;
import com.example.admin.androidmvp_2016_10_11.utils.DirUtil;
import com.example.admin.androidmvp_2016_10_11.utils.FloatingViewUtil.BeerFloating;
import com.example.admin.androidmvp_2016_10_11.utils.FloatingViewUtil.OnEnd;
import com.example.admin.androidmvp_2016_10_11.utils.FloatingViewUtil.PlaneFloating;
import com.example.admin.androidmvp_2016_10_11.utils.FloatingViewUtil.StarFloating;
import com.example.admin.androidmvp_2016_10_11.utils.SharedPreferenceUtil;
import com.ufreedom.floatingview.Floating;
import com.ufreedom.floatingview.FloatingBuilder;
import com.ufreedom.floatingview.FloatingElement;
import com.ufreedom.floatingview.effect.ScaleFloatingTransition;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

import static com.example.admin.androidmvp_2016_10_11.R.id.main_upload_bt;
import static com.example.admin.androidmvp_2016_10_11.utils.ViewUtil.recreateActivityCompat;

/**
 * 描述说明  <br/>
 * Author : luokaixuan <br/>
 * CreateDate : 2016/10/11 16:34 <br/>
 * Modified : luokaixuan <br/>
 * ModifiedDate : 2016/10/11 16:34 <br/>
 * Email : 1005949566@qq.com <br/>
 * Version 1.0
 */
public class LoginActivity extends BaseLoadingActivity<LoginPresenter<BaseLoadingRequestStatus<LoginResult>>,
        BaseLoadingRequestStatus<LoginResult>, LoginResult> implements OnNavigationItemSelectedListener {

    @BindView(R.id.login_bt)
    Button mLoginBt;
    @BindView(R.id.login_mail)
    Button mLoginMail;
    @BindView(R.id.login_progress)
    Button mLoginProgress;
    @BindView(R.id.login_flow_list)
    Button mLoginFlowList;

    private static String SKIN_BROWN_NAME = "skin_brown.skin";
    private static String SKIN_BLACK_NAME = "skin_black.skin";
    @BindView(R.id.drawer_content_fl)
    FrameLayout mDrawerContentFl;
    @BindView(R.id.nav_view)
    NavigationView mNavView;
    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;
    @BindView(R.id.login_fly)
    Button mLoginFly;
    @BindView(R.id.login_ll)
    LinearLayout mLoginLl;
    @BindView(R.id.login_fly2)
    Button mLoginFly2;
    @BindView(R.id.login_fly3)
    Button mLoginFly3;
    @BindView(R.id.login_fly5)
    Button mLoginFly5;
    @BindView(R.id.main_download_bt)
    Button btDownMsg;
    @BindView(main_upload_bt)
    Button btUpMsg;
    @BindView(R.id.tv_down_msg)
    TextView tvDownMsg;
    @BindView(R.id.tv_up_msg)
    TextView tvUpMsg;
    @BindView(R.id.pb_down_msg)
    com.daimajia.numberprogressbar.NumberProgressBar pbDownMsg;
    @BindView(R.id.pb_up_msg)
    com.daimajia.numberprogressbar.NumberProgressBar pbUpMsg;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View viewDrawer = getLayoutInflater().inflate(R.layout.layout_drawer, null);
//        DrawerLayout drawerLayout = (DrawerLayout) viewDrawer.findViewById(R.id.drawer_layout);
//        View viewNav = getLayoutInflater().inflate(R.layout.layout_nav, null);
        FrameLayout flContent = (FrameLayout) viewDrawer.findViewById(R.id.drawer_content_fl);
        View login = getLayoutInflater().inflate(R.layout.activity_login, null);
////        flContent.addView(login);

        flContent.addView(addTitleBar(addLoadingView(login)));
//        drawerLayout.addView(viewNav);
        setOrgContentView(viewDrawer);

//        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);

        setNavigationIcon(null);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, getToolbar(), R.string.open, R.string.close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        mLoginFly.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                mLoginFly.setVisibility(View.INVISIBLE);

                ImageView imageView = new ImageView(LoginActivity.this);
                imageView.setLayoutParams(new LayoutParams(mLoginFly.getMeasuredWidth(), mLoginFly.getMeasuredHeight()));
                imageView.setImageResource(R.drawable.ic_1);

                BeerFloating floatingTransition = new BeerFloating(new OnEnd() {
                    @Override
                    public void end() {
                        mLoginFly.setVisibility(View.VISIBLE);
                    }
                });
                final FloatingElement builder = new FloatingBuilder()
                        .anchorView(v)
                        .targetView(imageView)
//                        .offsetX(600)
//                        .offsetY(600)
                        .floatingTransition(floatingTransition)
                        .build();

                Floating floating = new Floating(LoginActivity.this);
                floating.startFloating(builder);
            }
        });

        mLoginFly2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                ImageView imageView = new ImageView(LoginActivity.this);
                imageView.setLayoutParams(new LayoutParams(mLoginFly.getMeasuredWidth(), mLoginFly.getMeasuredHeight()));
                imageView.setImageResource(R.drawable.ic_1);

                final FloatingElement builder = new FloatingBuilder()
                        .anchorView(v)
                        .targetView(imageView)
//                        .offsetX(600)
//                        .offsetY(600)
                        .floatingTransition(new StarFloating())
                        .build();

                Floating floating = new Floating(LoginActivity.this);
                floating.startFloating(builder);
            }
        });

        mLoginFly3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                ImageView imageView = new ImageView(LoginActivity.this);
                imageView.setLayoutParams(new LayoutParams(mLoginFly.getMeasuredWidth(), mLoginFly.getMeasuredHeight()));
                imageView.setImageResource(R.drawable.ic_1);

                PlaneFloating floatingTransition = new PlaneFloating(LoginActivity.this);
                final FloatingElement builder = new FloatingBuilder()
                        .anchorView(v)
                        .targetView(imageView)
//                        .offsetX(600)
//                        .offsetY(600)
                        .floatingTransition(floatingTransition)
                        .build();

                Floating floating = new Floating(LoginActivity.this);
                floating.startFloating(builder);
            }
        });

        mLoginFly5.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                ImageView imageView = new ImageView(LoginActivity.this);
                imageView.setLayoutParams(new LayoutParams(mLoginFly.getMeasuredWidth(), mLoginFly.getMeasuredHeight()));
                imageView.setImageResource(R.drawable.ic_1);

                final FloatingElement builder = new FloatingBuilder()
                        .anchorView(v)
                        .targetView(imageView)
//                        .offsetX(600)
//                        .offsetY(-v.getMeasuredHeight())
                        .floatingTransition(new ScaleFloatingTransition())
                        .build();

                Floating floating = new Floating(LoginActivity.this);
                floating.startFloating(builder);
            }
        });
    }

    @Override
    protected LoginPresenter<BaseLoadingRequestStatus<LoginResult>> createPresenter() {
        LoginPresenter loginPresenter = new LoginPresenter(this);
        return loginPresenter;
    }


    @OnClick({R.id.login_bt, R.id.login_mail, R.id.login_progress, R.id.login_flow_list,
    R.id.main_download_bt, main_upload_bt})
    void click(View view) {
        switch (view.getId()) {
            case R.id.login_bt: {
                startLoad();
                break;
            }
            case R.id.login_mail: {
                Intent intent = new Intent(this, EmailListActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.login_progress: {
                Intent intent = new Intent(this, FlowProgressActivityBaseStickListActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.login_flow_list: {
                Intent intent = new Intent(this, FlowListActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.main_download_bt:

                /*下载回调*/
                HttpProgressOnNextListener httpProgressOnNextListener = new HttpProgressOnNextListener<DownInfo>() {

                    @Override
                    public void onNext(DownInfo baseDownEntity) {
                        tvDownMsg.setText("提示：下载完成");
                        Log.e("提示：下载完成", "提示：下载完成");
                        Toast.makeText(LoginActivity.this, baseDownEntity.getSavePath().getAbsolutePath() + "", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onStart() {
                        tvDownMsg.setText("提示:开始下载");
                        Log.e("提示:开始下载", "提示:开始下载");
                    }

                    @Override
                    public void onComplete() {
                        tvDownMsg.setText("提示：下载结束");
                        Log.e("提示：下载结束", "提示：下载结束");
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        tvDownMsg.setText("失败:" + e.toString());
                        Log.e("失败:" + e.toString(), "失败:" + e.toString());
                    }


                    @Override
                    public void onPuase() {
                        super.onPuase();
                        tvDownMsg.setText("提示:暂停");
                        Log.e("提示:暂停", "提示:暂停");
                    }

                    @Override
                    public void onStop() {
                        super.onStop();
                    }

                    @Override
                    public void updateProgress(long readLength, long countLength) {
                        tvDownMsg.setText("提示:下载中" + readLength);
                        pbDownMsg.setMax((int) countLength);
                        pbDownMsg.setProgress((int) readLength);
                        Log.e("提示:下载中", "提示:下载中" + readLength);
                    }

                };

                final DownInfo downInfo = new DownInfo();
                downInfo.setId("20101383110101201611232024163461");
                downInfo.setCountLength(1148449);
                downInfo.setName("download_2016_11_23.gif");
                downInfo.setSavePath(DirUtil.getSDCardAppDownloadDir());
                downInfo.setListener(httpProgressOnNextListener);

                DownUpStore downStore = AppClient.initDownUploadRetrofit(downInfo).create(DownUpStore.class);
                downStore.download(downInfo.getId())
                        .subscribeOn(Schedulers.io())
                        .unsubscribeOn(Schedulers.io())

                        .map(new Func1<ResponseBody, DownInfo>() {
                                 @Override
                                 public DownInfo call(ResponseBody responseBody) {
                                     long contentLength = responseBody.contentLength();
                                     final File downloadFile = new File(downInfo.getSavePath(), downInfo.getName());
                                     if (downloadFile.exists() && downloadFile.length() != contentLength)
                                         downloadFile.delete();
                                     try {
                                         FileUtils.copyInputStreamToFile(responseBody.byteStream(), downloadFile);
                                     } catch (IOException e) {
                                         e.printStackTrace();
                                     }
                                     return downInfo;
                                 }
                             }

                        ).observeOn(AndroidSchedulers.mainThread())
                        .subscribe(AppClient.subscriber);
//                        .subscribe(new ProgressDownSubscriber<DownInfo>(downInfo));
                break;

            case R.id.main_upload_bt:
                DownUpStore upStore = AppClient.initRetrofit().create(DownUpStore.class);
                File file = DirUtil.getUploadFile();
                RequestBody requestBody=RequestBody.create(MediaType.parse("image/jpeg"),file);
                MultipartBody.Part part= MultipartBody.Part.createFormData("file_name", file.getName(), new ProgressRequestBody(requestBody,
                        new UploadProgressListener() {
                            @Override
                            public void onProgress(long currentBytesCount, long totalBytesCount) {
                                tvUpMsg.setText("提示:上传中");
                                Log.e("提示:上传中", "提示:上传中" + currentBytesCount);
                                pbUpMsg.setMax((int) totalBytesCount);
                                pbUpMsg.setProgress((int) currentBytesCount);
                            }
                        }));

                upStore.uploadFile(part, "104102")
                        .subscribeOn(Schedulers.io())
                        .unsubscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Subscriber<UploadResult>() {
                            @Override
                            public void onCompleted() {
                                Log.e(" onCompleted ", " onCompleted ");
                            }

                            @Override
                            public void onError(Throwable e) {
                                Log.e(" onError ", " onError "+ e);
                            }

                            @Override
                            public void onNext(UploadResult uploadResult) {

                                Log.e(" ok2 ", " ok2 " + uploadResult.getData());
                                tvUpMsg.setText("提示:上传完成");
                                Log.e("提示:上传完成", "提示:上传完成" );
//                                pbUpMsg.setMax((int) totalBytesCount);
//                                pbUpMsg.setProgress((int) currentBytesCount);
                            }
                        });
            break;
        }
    }

    @Override
    public void startLoad() {
        super.startLoad();

//        createPresenter().login("admin", "21232f297a57a5a743894a0e4a801fc3", new LoadingCallback());
        createPresenter().login("10082", "e10adc3949ba59abbe56e057f20f883e", new LoadingCallback());
    }

    @Override
    public void success(LoginResult login) {
        super.success(login);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
            setBaseTheme(SharedPreferenceUtil.GREEN);

        } else if (id == R.id.nav_gallery) {
            setBaseTheme(SharedPreferenceUtil.RED);
        } else if (id == R.id.nav_slideshow) {
            setBaseTheme(SharedPreferenceUtil.BLUE);
        } else if (id == R.id.nav_manage) {
            setBaseTheme(SharedPreferenceUtil.GREY);
        } else if (id == R.id.nav_share) {
            setBaseTheme(SharedPreferenceUtil.PURPLE);
        } else if (id == R.id.nav_send) {
            setBaseTheme(SharedPreferenceUtil.DEFAULT);
        } else if (id == R.id.nav_day) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        } else if (id == R.id.nav_night) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
//        recreate();
        recreateActivityCompat(this);
        return true;
    }

//    public static final String THEM = "them";
//    public static final String THEM_TYPE = "themType";
//    public static final String RED = "red";
//    public static final String BLUE = "blue";
//    public static final String GREY = "grey";
//    public static final String PURPLE = "populer";
//    public static final String GREEN = "green";
//    public static final String DEFAULT = "default";
}
