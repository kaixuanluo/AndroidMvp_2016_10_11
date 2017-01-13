package com.example.admin.androidmvp_2016_10_11.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;

/**
 * 描述说明  <br/>
 * Author : luokaixuan <br/>
 * CreateDate : 2016/10/22 20:04 <br/>
 * Modified : luokaixuan <br/>
 * ModifiedDate : 2016/10/22 20:04 <br/>
 * Email : 1005949566@qq.com <br/>
 * Version 1.0
 */
public class ViewUtil {

    /**
     * 清空当前界面Edittext的内容
     * @param viewGroup
     */
    public static void clearAllEtContent(ViewGroup viewGroup) {

        int count = viewGroup.getChildCount();
        for (int i = 0; i < count; i++) {
            View view = viewGroup.getChildAt(i);
            if (view instanceof ViewGroup)
                clearAllEtContent((ViewGroup) view);
            else if (view instanceof EditText) {
                EditText edittext = (EditText) view;
                edittext.setText("");
            }
        }
    }

    /**
     Current Activity instance will go through its lifecycle to onDestroy() and a new instance then created after it.
     */
    @SuppressLint("NewApi")
    public static final void recreateActivityCompat(final Activity a) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            a.recreate();
        } else {
            final Intent intent = a.getIntent();
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            a.finish();
            a.overridePendingTransition(0, 0);
            a.startActivity(intent);
            a.overridePendingTransition(0, 0);
        }
    }
 public static int dip2px(Context context, float dp) {
            Resources r = context.getResources();
            float px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics());
            return Math.round(px);
        }

        public static int getScreenWidth(Context context){
            DisplayMetrics dm = new DisplayMetrics();
            WindowManager wm = (WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
            wm.getDefaultDisplay().getMetrics(dm);
            return dm.widthPixels;

        }
        public static int getScreenHeight(Context context){
            DisplayMetrics dm = new DisplayMetrics();
            WindowManager wm = (WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
            wm.getDefaultDisplay().getMetrics(dm);
            return dm.heightPixels;
        }
}
