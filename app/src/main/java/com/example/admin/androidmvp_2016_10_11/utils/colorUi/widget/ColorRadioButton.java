package com.example.admin.androidmvp_2016_10_11.utils.colorUi.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RadioButton;

import com.example.admin.androidmvp_2016_10_11.utils.colorUi.ColorUiInterface;
import com.example.admin.androidmvp_2016_10_11.utils.colorUi.util.ViewAttributeUtil;

/**
 * Created by chengli on 15/6/8.
 */
public class ColorRadioButton extends RadioButton implements ColorUiInterface {

    private int attr_background = -1;
    private int attr_textAppearance = -1;


    public ColorRadioButton(Context context) {
        super(context);
    }

    public ColorRadioButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.attr_background = ViewAttributeUtil.getBackgroundAttibute(attrs);
        this.attr_textAppearance = ViewAttributeUtil.getTextApperanceAttribute(attrs);
    }

    public ColorRadioButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.attr_background = ViewAttributeUtil.getBackgroundAttibute(attrs);
        this.attr_textAppearance = ViewAttributeUtil.getTextApperanceAttribute(attrs);
    }

    @Override
    public View getView() {
        return this;
    }

    @Override
    public void setTheme(Resources.Theme themeId) {
        ViewAttributeUtil.applyBackgroundDrawable(this, themeId, attr_background);
        ViewAttributeUtil.applyTextAppearance(this, themeId, attr_background);
    }
}