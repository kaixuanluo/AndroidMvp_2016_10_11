package com.example.admin.androidmvp_2016_10_11.utils.skinLoader.listener;

import android.view.View;

import com.example.admin.androidmvp_2016_10_11.utils.skinLoader.entity.DynamicAttr;

import java.util.List;

public interface IDynamicNewView {
	void dynamicAddView(View view, List<DynamicAttr> pDAttrs);
}
