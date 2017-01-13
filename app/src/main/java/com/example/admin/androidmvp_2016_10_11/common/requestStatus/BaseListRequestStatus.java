package com.example.admin.androidmvp_2016_10_11.common.requestStatus;

import com.example.admin.androidmvp_2016_10_11.common.module.BaseListModule;

/**
 * 描述说明  <br/>
 * Author : luokaixuan <br/>
 * CreateDate : 2016/10/11 16:06 <br/>
 * Modified : luokaixuan <br/>
 * ModifiedDate : 2016/10/11 16:06 <br/>
 * Email : 1005949566@qq.com <br/>
 * Version 1.0
 */
public interface BaseListRequestStatus<DATA extends BaseListModule, ITEM> extends BaseLoadingRequestStatus<DATA> {
    void noMore();
    void hasMore();
    void loadMore(ITEM lastItem);
    void refresh();
    void getListData(DATA data);
    void getListMoreData(DATA data);
    void empty();
}
