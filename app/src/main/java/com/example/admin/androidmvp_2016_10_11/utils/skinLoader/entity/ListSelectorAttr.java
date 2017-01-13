package com.example.admin.androidmvp_2016_10_11.utils.skinLoader.entity;

import android.view.View;
import android.widget.AbsListView;
 

public class ListSelectorAttr extends com.example.admin.androidmvp_2016_10_11.utils.skinLoader.entity.SkinAttr {

	@Override
	public void apply(View view) {
		if(view instanceof AbsListView){
			AbsListView tv = (AbsListView)view;
			
			if(RES_TYPE_NAME_COLOR.equals(attrValueTypeName)){
				tv.setSelector(com.example.admin.androidmvp_2016_10_11.utils.skinLoader.loader.SkinManager.getInstance().getColor(attrValueRefId));
			}else if(RES_TYPE_NAME_DRAWABLE.equals(attrValueTypeName)){
				tv.setSelector(com.example.admin.androidmvp_2016_10_11.utils.skinLoader.loader.SkinManager.getInstance().getDrawable(attrValueRefId));
			}
		}
	}
}
