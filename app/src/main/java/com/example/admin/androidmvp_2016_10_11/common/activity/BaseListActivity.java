package com.example.admin.androidmvp_2016_10_11.common.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.admin.androidmvp_2016_10_11.R;
import com.example.admin.androidmvp_2016_10_11.common.adapter.BaseHFAdapter;
import com.example.admin.androidmvp_2016_10_11.common.itemTouchHelper.ItemTouchHelperAdapter;
import com.example.admin.androidmvp_2016_10_11.common.itemTouchHelper.ItemTouchHelperCallback;
import com.example.admin.androidmvp_2016_10_11.common.itemTouchHelper.ItemTouchHelperViewHolder;
import com.example.admin.androidmvp_2016_10_11.common.module.BaseListModule;
import com.example.admin.androidmvp_2016_10_11.common.presenter.BaseListPresenter;
import com.example.admin.androidmvp_2016_10_11.common.recyclerviewItemClick.OnRecyclerItemClickListener;
import com.example.admin.androidmvp_2016_10_11.common.requestStatus.BaseListRequestStatus;
import com.example.admin.androidmvp_2016_10_11.view.DiffCallBack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 描述说明  <br/>
 * Author : luokaixuan <br/>
 * CreateDate : 2016/10/11 15:48 <br/>
 * Modified : luokaixuan <br/>
 * ModifiedDate : 2016/10/11 15:48 <br/>
 * Email : 1005949566@qq.com <br/>
 * Version 1.0
 */
public abstract class BaseListActivity<P extends BaseListPresenter<V>,
        V extends BaseListRequestStatus<DATA, ITEM>, DATA extends BaseListModule<ITEM>, ITEM>
        extends BaseLoadingActivity<P, V, DATA>
        implements BaseListRequestStatus<DATA, ITEM> {

    List<ITEM> mBaseList;
    TextView tvFooter;

    boolean isLoading, hasMore = true, isLoadMore;

    SwipeRefreshLayout mSrl;
    RecyclerView mRcv;
    //    BaseListAdapter baseListAdapter;
    BaseHFAdapter mBaseHFAdapter;
    BaseListAdapter2 mAdapter;
    View itemFootView;

    public RecyclerView getRcv() {
        return mRcv;
    }

    public BaseHFAdapter getBaseHFAdapter() {
        return mBaseHFAdapter;
    }

    public List<ITEM> getBaseList() {
        return mBaseList;
    }

    ItemTouchHelper mItemTouchHelper;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mSrl = (SwipeRefreshLayout) layoutInflater.inflate(R.layout.layout_swipe_refresh, null);
        mRcv = (RecyclerView) layoutInflater.inflate(R.layout.layout_recycler_view, null);
        mSrl.addView(mRcv);
        setContentView(mSrl);

        mBaseList = new ArrayList<>();

        mSrl.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh() {
                refresh();
            }
        });

        //        mRcv.setLayoutManager(new LinearLayoutManager(this));
//        mRcv.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));
//        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
//        setRecyclerViewManager(gridLayoutManager);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        setRecyclerViewManager(linearLayoutManager);
        mRcv.setHasFixedSize(true);
//        baseListAdapter = new BaseListAdapter();
//        setRecyclerViewAdapter(baseListAdapter);
        mAdapter = new BaseListAdapter2();
        mBaseHFAdapter = new BaseHFAdapter(mAdapter);//添加头部尾部的Adapter
        itemFootView = getLayoutInflater().inflate(R.layout.item_loading, null);
        tvFooter = (TextView) itemFootView.findViewById(R.id.progressTv);
        setFooterClick();
        mBaseHFAdapter.addFootView(itemFootView);
        setRecyclerViewAdapter(mBaseHFAdapter);

        //添加拖拽的监听。
        ItemTouchHelperCallback itemTouchHelperCallback = new ItemTouchHelperCallback(mAdapter);
        mItemTouchHelper = new ItemTouchHelper(itemTouchHelperCallback);
        mItemTouchHelper.attachToRecyclerView(mRcv);

        mRcv.addOnScrollListener(new OnScrollListener() {
            int lastVisibleItem;
            private int[] lastPositions;
            int totalItemCount;
            int visibleThreshold = 0;

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                LayoutManager layoutManager = mRcv.getLayoutManager();
                if (layoutManager != null) {
                    if (layoutManager instanceof LinearLayoutManager) {
                        lastVisibleItem = ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
                    } else if (layoutManager instanceof GridLayoutManager) {
                        lastVisibleItem = ((GridLayoutManager) layoutManager).findLastVisibleItemPosition();
                    } else if (layoutManager instanceof StaggeredGridLayoutManager) {
                        StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
                        if (lastPositions == null) {
                            lastPositions = new int[staggeredGridLayoutManager.getSpanCount()];
                        }
                        staggeredGridLayoutManager.findLastVisibleItemPositions(lastPositions);
                        lastVisibleItem = findMax(lastPositions);
                    } else {

                    }
                }

//                totalItemCount = layoutManager.getItemCount();
                if (mBaseList != null && mBaseList.size() > 0) {
                    totalItemCount = mBaseList.size();

                    if (!isLoading && totalItemCount <= (lastVisibleItem + visibleThreshold) && hasMore) {
                        if (mBaseList != null && mBaseList.size() > 0) {
                            loadMore(mBaseList.get(mBaseList.size() - 1));
                            isLoading = true;
                            isLoadMore = true;
                        }
                    }
                }
            }

//            @Override
//            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
//                super.onScrollStateChanged(recyclerView, newState);
//
//                int currentScrollState = newState;
//                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
//                int visibleItemCount = layoutManager.getChildCount();
//                int totalItemCount = layoutManager.getItemCount();
//
//                if (visibleItemCount > 0 && currentScrollState == RecyclerView.SCROLL_STATE_IDLE
//                        && lastVisibleItem >= totalItemCount - 1) {
//                    if (!isLoading){
////                        isLoading =true;
//                        isLoadMore = true;
//                        loadMore(mBaseList.get(mBaseList.size() - 1));
//                    }
//                }
//            }
        });

        mRcv.addOnItemTouchListener(new OnRecyclerItemClickListener(mRcv) {
            @Override
            public void onItemClick(ViewHolder vh) {
//                Toast.makeText(BaseListActivityBase.this, " item click "+ vh.getAdapterPosition(), Toast.LENGTH_SHORT).show();
                //屏蔽头部和尾部点击
                if (mBaseHFAdapter.isHeaderViewPos(vh.getAdapterPosition())) {

                } else if (mBaseHFAdapter.isFooterViewPos(vh.getAdapterPosition())) {

                } else {
                    onItemClickListener(mBaseList.get(vh.getAdapterPosition()));
                }
            }

            @Override
            public void onItemLongClick(ViewHolder vh) {
//                Toast.makeText(BaseListActivityBase.this, " item long click ", Toast.LENGTH_SHORT).show();
                //屏蔽头部和尾部点击
                if (mBaseHFAdapter.isHeaderViewPos(vh.getAdapterPosition())) {

                } else if (mBaseHFAdapter.isFooterViewPos(vh.getAdapterPosition())) {

                } else {
                    onItemLongClickListener(mBaseList.get(vh.getAdapterPosition()));
                }
            }
        });
    }

    protected void onItemClickListener(ITEM item) {

        ArrayList<ITEM> oldList = new ArrayList<>(mBaseList);
        mBaseList.remove(item);
        notifyData(mRcv.getAdapter(), oldList, mBaseList);
    }

    protected void onItemLongClickListener(ITEM item) {

    }

    protected void setRecyclerViewManager(LayoutManager layoutManager) {
        mRcv.setLayoutManager(layoutManager);
    }

    protected void setRecyclerViewAdapter(RecyclerView.Adapter adapter) {
        mRcv.setAdapter(adapter);
    }

    private int findMax(int[] lastPositions) {
        int max = lastPositions[0];
        for (int value : lastPositions) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    //    protected abstract View initItemView();
    protected abstract HolderItem createItemViewHolder(ViewGroup parent);

    protected abstract void bindItemViewHolder(ViewHolder holder, ITEM item, int position);

    protected abstract void loadData();

    protected abstract void loadMoreData(ITEM item);

    public class BaseListAdapter2 extends RecyclerView.Adapter implements ItemTouchHelperAdapter{

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return createItemViewHolder(parent);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
            ITEM item = mBaseList.get(position);
            bindItemViewHolder(holder, item, position);

            holder.itemView.setOnTouchListener(new OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    if (MotionEventCompat.getActionMasked(event) == MotionEvent.ACTION_DOWN) {
                        mItemTouchHelper.startDrag(holder);
                    }
                    return false;
                }
            });
        }

        @Override
        public int getItemCount() {
            return mBaseList == null ? 0 : mBaseList.size();
        }

        @Override
        public boolean onItemMove(int fromPosition, int toPosition) {
            //互换列表中指定位置的数据
            Collections.swap(mBaseList, fromPosition, toPosition);
//            notifyItemMoved(fromPosition, toPosition);
            mRcv.getAdapter().notifyDataSetChanged();
            mAdapter.notifyDataSetChanged();
            return true;
        }

        @Override
        public void onItemDismiss(int position) {
            mBaseList.remove(position);
//            notifyItemRemoved(position);
            mRcv.getAdapter().notifyDataSetChanged();
            mAdapter.notifyDataSetChanged();
        }
    }

//    public class BaseListAdapter extends RecyclerView.Adapter {
//
//        final int TYPE_HEAD = 0;
//        final int TYPE_ITEM = 1;
//        final int TYPE_FOOT = 2;
//
//        int type;
//
//        @Override
//        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//            switch (type) {
//                case TYPE_HEAD: {
//                    View itemView = LayoutInflater.from(BaseListActivityBase.this).inflate(R.layout.item_loading, null);
//                    return new HolderHeader(itemView);
//                }
//                case TYPE_ITEM: {
//                    return createItemViewHolder();
//                }
//                case TYPE_FOOT: {
//                    View itemView = LayoutInflater.from(BaseListActivityBase.this).inflate(R.layout.item_loading, null);
//                    return new HolderFoot(itemView);
//                }
//            }
//            return null;
//        }
//
//        @Override
//        public void onBindViewHolder(ViewHolder holder, int position) {
//            switch (type) {
//                case TYPE_HEAD:
//
//                break;
//                case TYPE_ITEM:
//                    ITEM item = mBaseList.get(position - 1);
//                bindItemViewHolder(holder, item, position);
//                break;
//                case TYPE_FOOT:
//
//                break;
//            }
//        }
//
//        @Override
//        public int getItemCount() {
//            return mBaseList == null ? 0 : mBaseList.size() + 2;
//        }
//
//        @Override
//        public int getItemViewType(int position) {
//            if (position == 0) {
//                type = TYPE_HEAD;
//            } else if (position == mBaseList.size() + 1) {
//                type = TYPE_FOOT;
//            } else {
//                type = TYPE_ITEM;
//            }
//            return type;
//        }
//    }
//
//    public class HolderHeader extends ViewHolder {
//
//        public HolderHeader(View itemView) {
//            super(itemView);
//        }
//    }
//
//    public class HolderFoot extends ViewHolder {
//
//        public HolderFoot(View itemView) {
//            super(itemView);
//
//            itemView.setOnClickListener(new OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    loadMore(mBaseList.get(mBaseList.size() - 1));
//                }
//            });
//            tvFooter = (TextView) itemView.findViewById(R.id.progressTv);
//        }
//    }

    protected void setFooterText(String text) {
        if (tvFooter != null) {
            tvFooter.setText(text);
        }
    }

    protected void setFooterClick() {
        tvFooter.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getLastItem() == null) {
                    refresh();
                } else {
                    loadMoreData(getLastItem());
                }
            }
        });
    }

    ITEM getLastItem() {
        return mBaseList != null && mBaseList.size() > 0 ? mBaseList.get(mBaseList.size() - 1) : null;
    }

    public class HolderItem extends ViewHolder implements ItemTouchHelperViewHolder{

        public HolderItem(View itemView) {
            super(itemView);
        }

        @Override
        public void onItemSelected() {
            itemView.setBackgroundColor(Color.LTGRAY);
        }

        @Override
        public void onItemClear() {
            itemView.setBackgroundColor(0);
        }
    }

    @Override
    public void refresh() {

//        ArrayList<ITEM> oldList = new ArrayList<>(mBaseList);
//        mBaseList = new ArrayList<>();
//        notifyData(mRcv.getAdapter(), oldList, mBaseList);
//        mBaseHFAdapter.notifyDataSetChanged();

        isLoadMore = false;
        if (!mSrl.isRefreshing()) {
            mSrl.setRefreshing(true);
        }
        loadData();
        hasMore();
        startLoad();
    }

    @Override
    public void startLoad() {
        super.startLoad();
    }

    @Override
    public void noMore() {
        hasMore = false;
        setFooterText("没有更多...");
    }

    @Override
    public void hasMore() {
        hasMore = true;
        setFooterText("正在加载...");
    }

    @Override
    public void error(String msg) {
        super.error(msg);
        setFooterText("加载失败...");
    }

    @Override
    public void loadMore(ITEM lastItem) {
        if (lastItem == null) {
            refresh();
        } else {
            loadMoreData(lastItem);
        }
        setFooterText("正在加载...");
    }

    @Override
    public void completed() {
        super.completed();
        isLoading = false;
        mSrl.setRefreshing(false);
        setFooterText("加载完成...");
    }

    @Override
    public void success(DATA data) {
        super.success(data);

        mSrl.setRefreshing(false);

//        List<ITEM> list = data.getList();
//        if (list != null && list.size() == 0) {
//            noMore();
//        }

        ArrayList<ITEM> oldList = new ArrayList<>(mBaseList);

        if (isLoadMore) {
            getListMoreData(data);
        } else {
            getListData(data);
        }

        mRcv.getAdapter().notifyDataSetChanged();
//        notifyData(mRcv.getAdapter(), oldList, mBaseList);

    }

    protected void notifyData(RecyclerView.Adapter mAdapter, List<ITEM> mDatas, List<ITEM> newDatas) {
        //利用DiffUtil.calculateDiff()方法，传入一个规则DiffUtil.Callback对象，和是否检测移动item的 boolean变量，得到DiffUtil.DiffResult 的对象

        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new DiffCallBack(mDatas, newDatas), true);

//利用DiffUtil.DiffResult对象的dispatchUpdatesTo（）方法，传入RecyclerView的Adapter，轻松成为文艺青年

        diffResult.dispatchUpdatesTo(mAdapter);

//别忘了将新数据给Adapter
//        mDatas = newDatas;
//        mAdapter.setDatas(mDatas);
    }

    @Override
    public void getListData(DATA data) {
        List<ITEM> list = data.getList();
        mBaseList = list;
        if (mBaseList == null || mBaseList.size() == 0) {
            empty();
        }
    }

    @Override
    public void getListMoreData(DATA data) {
        List<ITEM> list = data.getList();
        if (list == null || list.size() == 0) {
            noMore();
        } else {
            mBaseList.addAll(list);
        }
    }

    @Override
    public void reLoad() {
        super.reLoad();
        refresh();
    }

    @Override
    public void empty() {

    }
}
