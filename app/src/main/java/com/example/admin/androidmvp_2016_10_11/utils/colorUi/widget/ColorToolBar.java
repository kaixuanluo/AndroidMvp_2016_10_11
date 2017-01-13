package com.example.admin.androidmvp_2016_10_11.utils.colorUi.widget;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.View;

import com.example.admin.androidmvp_2016_10_11.utils.colorUi.ColorUiInterface;
import com.example.admin.androidmvp_2016_10_11.utils.colorUi.util.ViewAttributeUtil;

/**
 * 描述说明  <br/>
 * Author : luokaixuan <br/>
 * CreateDate : 2016/10/25 16:41 <br/>
 * Modified : luokaixuan <br/>
 * ModifiedDate : 2016/10/25 16:41 <br/>
 * Email : 1005949566@qq.com <br/>
 * Version 1.0
 */
public class ColorToolBar extends Toolbar implements ColorUiInterface {

    private int attr_textAppearance = -1;
    private int attr_background = -1;

    public ColorToolBar(Context context) {
        super(context);
    }

    public ColorToolBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        this.attr_background = ViewAttributeUtil.getBackgroundAttibute(attrs);
        this.attr_textAppearance = ViewAttributeUtil.getTextApperanceAttribute(attrs);

    }

    public ColorToolBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        this.attr_background = ViewAttributeUtil.getBackgroundAttibute(attrs);
        this.attr_textAppearance = ViewAttributeUtil.getTextApperanceAttribute(attrs);

    }

    @Override
    public View getView() {
        return this;
    }

    @Override
    public void setTheme(Theme themeId) {
        if(attr_textAppearance != -1) {
            ViewAttributeUtil.applyBackgroundDrawable(this, themeId, attr_background);
        }
        if(attr_background != -1) {
            ViewAttributeUtil.applyTextAppearance(this, themeId, attr_textAppearance);
        }
    }
}
