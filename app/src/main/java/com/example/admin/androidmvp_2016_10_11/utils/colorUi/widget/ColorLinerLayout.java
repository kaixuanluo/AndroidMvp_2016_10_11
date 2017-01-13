package com.example.admin.androidmvp_2016_10_11.utils.colorUi.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import com.example.admin.androidmvp_2016_10_11.utils.colorUi.ColorUiInterface;
import com.example.admin.androidmvp_2016_10_11.utils.colorUi.util.ViewAttributeUtil;

/**
 * Created by chengli on 15/6/8.
 */
public class ColorLinerLayout extends LinearLayout implements ColorUiInterface {

    private int attr_backgound = -1;

    public ColorLinerLayout(Context context) {
        super(context);
    }

    public ColorLinerLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.attr_backgound = ViewAttributeUtil.getBackgroundAttibute(attrs);
    }

    public ColorLinerLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.attr_backgound = ViewAttributeUtil.getBackgroundAttibute(attrs);
    }

    @Override
    public View getView() {
        return this;
    }

    @Override
    public void setTheme(Resources.Theme themeId) {
        if(attr_backgound != -1) {
            ViewAttributeUtil.applyBackgroundDrawable(this, themeId, attr_backgound);
        }
    }
}
