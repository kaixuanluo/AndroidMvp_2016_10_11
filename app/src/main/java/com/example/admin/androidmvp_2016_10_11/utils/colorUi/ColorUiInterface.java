package com.example.admin.androidmvp_2016_10_11.utils.colorUi;

import android.content.res.Resources;
import android.view.View;

/**
 * 换肤接口
 * Created by chengli on 15/6/8.
 */
public interface ColorUiInterface {


    public View getView();

    public void setTheme(Resources.Theme themeId);
}
