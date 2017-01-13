package com.example.admin.androidmvp_2016_10_11.utils.skinLoader.entity;

import android.view.View;
import android.widget.TextView;

import com.example.admin.androidmvp_2016_10_11.utils.skinLoader.loader.SkinManager;
import com.example.admin.androidmvp_2016_10_11.utils.skinLoader.util.L;

public class TextColorAttr extends SkinAttr {

	@Override
	public void apply(View view) {
		if(view instanceof TextView){
			TextView tv = (TextView)view;
			if(RES_TYPE_NAME_COLOR.equals(attrValueTypeName)){
				L.e("attr1", "TextColorAttr");
				tv.setTextColor(SkinManager.getInstance().convertToColorStateList(attrValueRefId));
			}
		}
	}
}
