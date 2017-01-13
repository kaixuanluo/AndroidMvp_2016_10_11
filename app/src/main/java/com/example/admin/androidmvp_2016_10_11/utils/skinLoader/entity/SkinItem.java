package com.example.admin.androidmvp_2016_10_11.utils.skinLoader.entity;

import android.view.View;

import com.example.admin.androidmvp_2016_10_11.utils.skinLoader.util.ListUtils;

import java.util.ArrayList;
import java.util.List;

public class SkinItem {
	
	public View view;
	
	public List<SkinAttr> attrs;
	
	public SkinItem(){
		attrs = new ArrayList<SkinAttr>();
	}
	
	public void apply(){
		if( ListUtils.isEmpty(attrs)){
			return;
		}
		for(SkinAttr at : attrs){
			at.apply(view);
		}
	}
	
	public void clean(){
		if( ListUtils.isEmpty(attrs)){
			return;
		}
		for(SkinAttr at : attrs){
			at = null;
		}
	}

	@Override
	public String toString() {
		return "SkinItem [view=" + view.getClass().getSimpleName() + ", attrs=" + attrs + "]";
	}
}
