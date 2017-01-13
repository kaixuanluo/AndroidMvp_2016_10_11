package com.example.admin.androidmvp_2016_10_11.ui.flow;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.example.admin.androidmvp_2016_10_11.R;
import com.example.admin.androidmvp_2016_10_11.common.activity.BaseStickListActivity;
import com.example.admin.androidmvp_2016_10_11.common.requestStatus.BaseListRequestStatus;
import com.example.admin.androidmvp_2016_10_11.module.response.FlowProgressResult;
import com.example.admin.androidmvp_2016_10_11.module.response.FlowProgressResult.FlowProgress;
import com.example.admin.androidmvp_2016_10_11.module.response.FlowProgressResult.FlowProgress.HandleUsers;
import com.example.admin.androidmvp_2016_10_11.retrofit.AppClient;
import com.example.admin.androidmvp_2016_10_11.utils.SharedPreferenceUtil;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.admin.androidmvp_2016_10_11.ui.flow.FlowListActivity.FLOW_ID;

/**
 * 描述说明  <br/>
 * Author : luokaixuan <br/>
 * CreateDate : 2016/10/14 20:07 <br/>
 * Modified : luokaixuan <br/>
 * ModifiedDate : 2016/10/14 20:07 <br/>
 * Email : 1005949566@qq.com <br/>
 * Version 1.0
 */
public class FlowProgressActivityBaseStickListActivity extends BaseStickListActivity<FlowProgressPresenter<FlowProgressResult,
        FlowProgress>,
        BaseListRequestStatus<FlowProgressResult, FlowProgress>, FlowProgressResult, FlowProgress> {

    String flowId;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        flowId = getIntent().getIntExtra(FLOW_ID, 0) + "";
        refresh();
    }

    @Override
    protected long initStickHeaderId(int position, FlowProgress flowProgress) {
        if (flowProgress != null) {
            int status = flowProgress.getTrackType();
            return status;
        } else {
            return 0;
        }
    }

    @Override
    protected void bindStickHeardViewHolder(TextView tvHeard, FlowProgress flowProgress, int position) {
        tvHeard.setText(flowProgress.getTrackHandleTime());
    }

    @Override
    protected HolderItem createItemViewHolder(ViewGroup parent) {
        return new EmailViewHolder(LayoutInflater.from(this).inflate(R.layout.item_emial, parent, false));
    }

    @Override
    protected void bindItemViewHolder(ViewHolder holder, FlowProgress flowProgress, int position) {
        Log.e(" dedao "," dedao " + flowProgress.toString());
        ((EmailViewHolder) holder).mItemEmailTime.setText(flowProgress.getTrackName());
        ((EmailViewHolder) holder).mItemEmailTitle.setText(flowProgress.getTrackHandleTime());

                Glide.with(this).load(AppClient.API_SERVER_URL + flowProgress.getImageUrl()).asBitmap().diskCacheStrategy(DiskCacheStrategy.ALL)
//                .into(new SimpleTarget<Bitmap>(App.SCREEN_WIDTH / 2, App.SCREEN_WIDTH / 2) {
//                    @Override
//                    public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
//
//                    }
//                }
        .into(((EmailViewHolder)holder).mItemEmailHeard
                );

        final List<HandleUsers> handleUsers = flowProgress.getHandleUsers();

        ((EmailViewHolder)holder).mItemEmailLl.removeAllViews();

        for (int i = 0 ; i < handleUsers.size() ; i ++) {
                            View view = LayoutInflater.from(FlowProgressActivityBaseStickListActivity.this).inflate(R.layout.item_user, null);
                ImageView ivPhoto = (ImageView) view.findViewById(R.id.item_user_photo);
                TextView tvName = (TextView) view.findViewById(R.id.item_user_name);

                HandleUsers handleUser = handleUsers.get(i);
                GlideDrawableImageViewTarget imageViewTarget = new GlideDrawableImageViewTarget(ivPhoto);
                Glide.with(FlowProgressActivityBaseStickListActivity.this).load(AppClient.API_SERVER_URL + handleUser.getUserPhoto()).into(imageViewTarget);

//                Glide.with(FlowProgressActivityBase.this).load(AppClient.API_SERVER_URL + handleUser.getUserPhoto()).asBitmap().diskCacheStrategy(DiskCacheStrategy.ALL)
//                        .into(ivPhoto);

                tvName.setText(handleUser.getUserName());
            ((EmailViewHolder)holder).mItemEmailLl.addView(view);
        }

//        ((EmailViewHolder)holder).mItemEmailLv.setAdapter(new BaseAdapter() {
//            @Override
//            public int getCount() {
//                return handleUsers.size();
//            }
//
//            @Override
//            public Object getItem(int position) {
//                return handleUsers.get(position);
//            }
//
//            @Override
//            public long getItemId(int position) {
//                return position;
//            }
//
//            @Override
//            public View getView(int position, View convertView, ViewGroup parent) {
//                View view = LayoutInflater.from(FlowProgressActivityBase.this).inflate(R.layout.item_user, null);
//                ImageView ivPhoto = (ImageView) view.findViewById(R.id.item_user_photo);
//                TextView tvName = (TextView) view.findViewById(R.id.item_user_name);
//
//                HandleUsers handleUser = handleUsers.get(position);
//                GlideDrawableImageViewTarget imageViewTarget = new GlideDrawableImageViewTarget(ivPhoto);
//                Glide.with(FlowProgressActivityBase.this).load(AppClient.API_SERVER_URL + handleUser.getUserPhoto()).into(imageViewTarget);
//
////                Glide.with(FlowProgressActivityBase.this).load(AppClient.API_SERVER_URL + handleUser.getUserPhoto()).asBitmap().diskCacheStrategy(DiskCacheStrategy.ALL)
////                        .into(ivPhoto);
//
//                tvName.setText(handleUser.getUserName());
//
//                return view;
//            }
//        });
    }

    @Override
    protected void loadData() {
        createPresenter().flowProgressData(flowId, new LoadingCallback());
    }

    @Override
    protected void loadMoreData(FlowProgress flowProgress) {

    }

    @Override
    protected FlowProgressPresenter createPresenter() {
        return new FlowProgressPresenter<>(this);
    }

    class EmailViewHolder extends HolderItem{
        @BindView(R.id.item_email_title)
        TextView mItemEmailTitle;
        @BindView(R.id.item_email_time)
        TextView mItemEmailTime;
        @BindView(R.id.item_email_user_heard)
        ImageView mItemEmailHeard;
        @BindView(R.id.item_email_user_ll)
        LinearLayout mItemEmailLl;

        public EmailViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.theme_change, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.theme_1:
            setBaseTheme(SharedPreferenceUtil.GREEN);
                EventBus.getDefault().post(new MessageEventMainActivity("green"));
                break;
            case R.id.theme_2:
            setBaseTheme(SharedPreferenceUtil.RED);
                EventBus.getDefault().post(new MessageEventMainActivity("green"));
                break;
            case R.id.theme_3:
            setBaseTheme(SharedPreferenceUtil.BLUE);
                EventBus.getDefault().post(new MessageEventMainActivity("green"));
                break;
            case R.id.theme_4:
            setBaseTheme(SharedPreferenceUtil.PURPLE);
                EventBus.getDefault().post(new MessageEventMainActivity("green"));
                break;
            case R.id.theme_5:
            setBaseTheme(SharedPreferenceUtil.GREY);
                EventBus.getDefault().post(new MessageEventMainActivity("green"));
            break;
            case R.id.theme_6:
                setBaseTheme(SharedPreferenceUtil.DEFAULT);
                EventBus.getDefault().post(new MessageEventMainActivity("green"));
                break;
            case R.id.theme_7:
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                EventBus.getDefault().post(new MessageEventMainActivity("green"));
                break;
            case R.id.theme_8:
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                EventBus.getDefault().post(new MessageEventMainActivity("green"));
                break;
        }
//        recreateActivityCompat(this);
        return super.onOptionsItemSelected(item);
    }
}
