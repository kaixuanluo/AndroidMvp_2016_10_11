package com.example.admin.androidmvp_2016_10_11.common.module;

import java.util.List;

/**
 * 描述说明  <br/>
 * Author : luokaixuan <br/>
 * CreateDate : 2016/10/20 11:51 <br/>
 * Modified : luokaixuan <br/>
 * ModifiedDate : 2016/10/20 11:51 <br/>
 * Email : 1005949566@qq.com <br/>
 * Version 1.0
 */
public abstract class BaseListModule2<ITEM> extends BaseListModule<ITEM> {

    private Data<ITEM> data;

    public Data<ITEM> getData() {
        return data;
    }

    public class Data<ITEM> {

//        public List<ITEM> getRows() {
//            return rows;
//        }

        public List<ITEM> getRows() {
            return getRows2();
        }

    }

    public abstract List getRows2 ();

//    public Data<ITEM> getData() {
//        return data;
//    }

    @Override
    public List<ITEM> getList() {
        return getData().getRows();
    }

}