package com.example.admin.androidmvp_2016_10_11.common.module;

import java.util.List;

/**
 * 描述说明  <br/>
 * Author : luokaixuan <br/>
 * CreateDate : 2016/10/14 20:04 <br/>
 * Modified : luokaixuan <br/>
 * ModifiedDate : 2016/10/14 20:04 <br/>
 * Email : 1005949566@qq.com <br/>
 * Version 1.0
 */
public abstract class BaseListModule3<ITEM> extends BaseListModule<ITEM> {

//    List<ITEM> data;

    public abstract List<ITEM> getList();

//    @Override
//    public List<ITEM> getList() {
//        return data;
//    }
}
