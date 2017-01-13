package com.example.admin.androidmvp_2016_10_11.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ViewFlipper;

/**
 * 描述说明  <br/>
 * Author : luokaixuan <br/>
 * CreateDate : 2016/10/12 15:15 <br/>
 * Modified : luokaixuan <br/>
 * ModifiedDate : 2016/10/12 15:15 <br/>
 * Email : 1005949566@qq.com <br/>
 * Version 1.0
 */
public class FixedFlipper extends ViewFlipper{
    public FixedFlipper(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDetachedFromWindow(){
        try{
            super.onDetachedFromWindow();
        }catch(Exception e){
            super.stopFlipping();
        }
    }
}
