package com.example.admin.androidmvp_2016_10_11.common.requestStatus;

import com.example.admin.androidmvp_2016_10_11.common.module.BaseModule;

import java.util.List;

/**
 * 描述说明  <br/>
 * Author : luokaixuan <br/>
 * CreateDate : 2016/10/11 16:06 <br/>
 * Modified : luokaixuan <br/>
 * ModifiedDate : 2016/10/11 16:06 <br/>
 * Email : 1005949566@qq.com <br/>
 * Version 1.0
 */
public interface BaseListRequestStatus2<DATA extends BaseModule, ITEM> extends BaseLoadingRequestStatus<DATA> {
    void noMore();
    void hasMore();
    void loadMore(ITEM lastItem);
    void refresh();
    void getListData(List<ITEM> itemList);
    void getListMoreData(List<ITEM> itemList);
}
