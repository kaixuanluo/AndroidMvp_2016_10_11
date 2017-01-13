package com.example.admin.androidmvp_2016_10_11.common.callBack;

import com.example.admin.androidmvp_2016_10_11.common.requestStatus.BaseLoadingRequestStatus;

import rx.Subscriber;

/**
 * 描述说明  <br/>
 * Author : luokaixuan <br/>
 * CreateDate : 2016/10/11 17:59 <br/>
 * Modified : luokaixuan <br/>
 * ModifiedDate : 2016/10/11 17:59 <br/>
 * Email : 1005949566@qq.com <br/>
 * Version 1.0
 */
public abstract class BaseCallBack<DATA> extends Subscriber<DATA>
        implements BaseLoadingRequestStatus< DATA> {

}
