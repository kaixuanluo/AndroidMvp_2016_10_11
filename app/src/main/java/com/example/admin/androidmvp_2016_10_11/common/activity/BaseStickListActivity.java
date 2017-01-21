package com.example.admin.androidmvp_2016_10_11.common.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.androidmvp_2016_10_11.R;
import com.example.admin.androidmvp_2016_10_11.common.adapter.BaseHFAdapter;
import com.example.admin.androidmvp_2016_10_11.common.module.BaseListModule;
import com.example.admin.androidmvp_2016_10_11.common.presenter.BaseListPresenter;
import com.example.admin.androidmvp_2016_10_11.common.requestStatus.BaseListRequestStatus;
import com.timehop.stickyheadersrecyclerview.StickyRecyclerHeadersAdapter;
import com.timehop.stickyheadersrecyclerview.StickyRecyclerHeadersDecoration;
import com.timehop.stickyheadersrecyclerview.StickyRecyclerHeadersTouchListener;

/**
 * 描述说明  <br/>
 * Author : luokaixuan <br/>
 * CreateDate : 2016/10/14 18:22 <br/>
 * Modified : luokaixuan <br/>
 * ModifiedDate : 2016/10/14 18:22 <br/>
 * Email : 1005949566@qq.com <br/>
 * Version 1.0
 */
public abstract class BaseStickListActivity<P extends BaseListPresenter<V>,
        V extends BaseListRequestStatus<DATA, ITEM>, DATA extends BaseListModule<ITEM>, ITEM> extends BaseListActivity<P, V, DATA, ITEM> {

    StickAdapter mStickAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        mStickAdapter = new StickAdapter(new BaseListAdapter2());

        super.onCreate(savedInstanceState);

        final StickyRecyclerHeadersDecoration decor = new StickyRecyclerHeadersDecoration(mStickAdapter);
        mRcv.addItemDecoration(decor);

        //添加头部点击监听
        StickyRecyclerHeadersTouchListener touchListener =
                new StickyRecyclerHeadersTouchListener(mRcv, decor);
        touchListener.setOnHeaderClickListener(
                new StickyRecyclerHeadersTouchListener.OnHeaderClickListener() {
                    @Override
                    public void onHeaderClick(View header, int position, long headerId) {
                        Toast.makeText(BaseStickListActivity.this, "Header position: " + position + ", id: " + headerId,
                                Toast.LENGTH_SHORT).show();
                    }
                });
        mRcv.addOnItemTouchListener(touchListener);

        //添加头部刷新
        mStickAdapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override public void onChanged() {
                decor.invalidateHeaders();
            }
        });
    }

    protected abstract long initStickHeaderId(int position, ITEM item);
    protected abstract void bindStickHeardViewHolder(TextView tvHeard, ITEM item, int position);

    public class StickAdapter extends BaseHFAdapter implements StickyRecyclerHeadersAdapter<HolderItem> {

        public StickAdapter(Adapter adapter) {
            super(adapter);
        }

        @Override
        public long getHeaderId(int position) {
            ITEM item = null;
            if (mBaseList != null && mBaseList.size() > 0) {
                item = mBaseList.get(position);
            } else {
                Log.e(" getHeaderId ", " getHeaderId " + position);
            }
            return initStickHeaderId(position, item);
        }

        @Override
        public HolderItem onCreateHeaderViewHolder(ViewGroup parent) {
            return new HeardHolderItem(LayoutInflater.from(BaseStickListActivity.this).inflate(R.layout.item_flow_progress_heard, null));
        }

        @Override
        public void onBindHeaderViewHolder(HolderItem holder, int position) {
            if (mBaseList != null && mBaseList.size() > 0) {
                bindStickHeardViewHolder(((HeardHolderItem) holder).tvProgress, mBaseList.get(position), position);
            } else {
                Log.e("  HeaderViewHolder ", " onBindHeaderViewHolder " + position);
            }
        }

//        @Override
//        public int getItemViewType(int position) {
//            return TYPE_ITEM;
//        }
    }

    class HeardHolderItem extends HolderItem {
        TextView tvProgress;
        public HeardHolderItem(View itemView) {
            super(itemView);

            tvProgress = (TextView) itemView.findViewById(R.id.flow_prg_heard);
        }
    }

    @Override
    protected void setRecyclerViewAdapter(Adapter adapter) {
        super.setRecyclerViewAdapter(mStickAdapter);
    }

}
