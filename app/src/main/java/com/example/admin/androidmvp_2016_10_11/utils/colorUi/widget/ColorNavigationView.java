package com.example.admin.androidmvp_2016_10_11.utils.colorUi.widget;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.support.design.widget.NavigationView;
import android.util.AttributeSet;
import android.view.View;

import com.example.admin.androidmvp_2016_10_11.utils.colorUi.ColorUiInterface;
import com.example.admin.androidmvp_2016_10_11.utils.colorUi.util.ViewAttributeUtil;

/**
 * 描述说明  <br/>
 * Author : luokaixuan <br/>
 * CreateDate : 2016/10/25 16:49 <br/>
 * Modified : luokaixuan <br/>
 * ModifiedDate : 2016/10/25 16:49 <br/>
 * Email : 1005949566@qq.com <br/>
 * Version 1.0
 */
public class ColorNavigationView extends NavigationView implements ColorUiInterface {

    private int attr_textAppearance = -1;
    private int attr_background = -1;

    public ColorNavigationView(Context context) {
        super(context);
    }

    public ColorNavigationView(Context context, AttributeSet attrs) {
        super(context, attrs);

        this.attr_background = ViewAttributeUtil.getBackgroundAttibute(attrs);
        this.attr_textAppearance = ViewAttributeUtil.getTextApperanceAttribute(attrs);
    }

    public ColorNavigationView(Context context, AttributeSet attrs, int defStyleAttr) {
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
