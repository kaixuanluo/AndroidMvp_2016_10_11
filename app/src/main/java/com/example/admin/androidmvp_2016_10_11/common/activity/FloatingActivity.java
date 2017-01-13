package com.example.admin.androidmvp_2016_10_11.common.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

import com.example.admin.androidmvp_2016_10_11.R;

/**
 * 描述说明  <br/>
 * Author : luokaixuan <br/>
 * CreateDate : 2016/11/24 21:05 <br/>
 * Modified : luokaixuan <br/>
 * ModifiedDate : 2016/11/24 21:05 <br/>
 * Email : 1005949566@qq.com <br/>
 * Version 1.0
 */
public class FloatingActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.layout_change_theme);

//        EventBus.getDefault().post(new FloatActivityMsg());

    }
}
