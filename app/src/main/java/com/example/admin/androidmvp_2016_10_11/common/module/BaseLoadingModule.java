package com.example.admin.androidmvp_2016_10_11.common.module;

/**
 * 描述说明  <br/>
 * Author : luokaixuan <br/>
 * CreateDate : 2016/10/11 17:08 <br/>
 * Modified : luokaixuan <br/>
 * ModifiedDate : 2016/10/11 17:08 <br/>
 * Email : 1005949566@qq.com <br/>
 * Version 1.0
 */
public class BaseLoadingModule<DATA> extends BaseModule {
    DATA data;

    public DATA getData() {
        return data;
    }
}
