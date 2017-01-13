package com.example.admin.androidmvp_2016_10_11.ui.flow;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.admin.androidmvp_2016_10_11.R;
import com.example.admin.androidmvp_2016_10_11.common.activity.BaseListActivity;
import com.example.admin.androidmvp_2016_10_11.common.requestStatus.BaseListRequestStatus;
import com.example.admin.androidmvp_2016_10_11.module.response.FlowSendResult;
import com.example.admin.androidmvp_2016_10_11.module.response.FlowSendResult.Data.Rows.FlowSend;
import com.example.admin.androidmvp_2016_10_11.utils.SharedPreferenceUtil;

import org.greenrobot.eventbus.EventBus;

/**
 * 描述说明  <br/>
 * Author : luokaixuan <br/>
 * CreateDate : 2016/10/20 16:21 <br/>
 * Modified : luokaixuan <br/>
 * ModifiedDate : 2016/10/20 16:21 <br/>
 * Email : 1005949566@qq.com <br/>
 * Version 1.0
 */
public class FlowListActivity extends BaseListActivity<FlowProgressPresenter<FlowSendResult, FlowSend>,
        BaseListRequestStatus<FlowSendResult, FlowSend>, FlowSendResult, FlowSend> {

    public static final String FLOW_ID = "flowId";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        refresh();

        getBaseHFAdapter().addHeaderView(getLayoutInflater().inflate(R.layout.layout_flow_progress_heard, null));
        getBaseHFAdapter().notifyDataSetChanged();
    }

    @Override
    protected HolderItem createItemViewHolder(ViewGroup parent) {
        View view = getLayoutInflater().inflate(R.layout.item_flow, parent, false);
        return new FlowItem(view);
    }

    class FlowItem extends HolderItem {
        TextView tvTime, tvTitle, tvUser;
        public FlowItem(View itemView) {
            super(itemView);
            tvTime = (TextView) itemView.findViewById(R.id.item_flow_time);
            tvTitle = (TextView) itemView.findViewById(R.id.item_flow_title);
            tvUser = (TextView) itemView.findViewById(R.id.item_flow_user);
        }
    }

    @Override
    protected void bindItemViewHolder(ViewHolder holder, FlowSend flowSend, int position) {

        ((FlowItem)holder).tvTime.setText(flowSend.getStartTime());
        ((FlowItem)holder).tvTitle.setText(flowSend.getName());
        ((FlowItem)holder).tvUser.setText(flowSend.getUserName());

    }

    @Override
    protected void loadData() {
        createPresenter().flowList(0+"", new LoadingCallback());
    }

    @Override
    protected void loadMoreData(FlowSend flowSend) {
        createPresenter().flowList(flowSend.getId()+"", new LoadingCallback());
    }

    @Override
    protected FlowProgressPresenter<FlowSendResult, FlowSend> createPresenter() {
        return new FlowProgressPresenter<>(this);
    }

    @Override
    protected void onItemClickListener(FlowSend flowSend) {
        super.onItemClickListener(flowSend);
        Intent intent = new Intent(FlowListActivity.this, FlowProgressActivityBaseStickListActivity.class);
        int id = flowSend.getId();
        intent.putExtra(FLOW_ID, id);
         startActivity(intent);
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
