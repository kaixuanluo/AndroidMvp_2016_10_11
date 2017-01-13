package com.example.admin.androidmvp_2016_10_11.utils.skinLoader.base;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;

import com.example.admin.androidmvp_2016_10_11.utils.skinLoader.entity.DynamicAttr;
import com.example.admin.androidmvp_2016_10_11.utils.skinLoader.listener.IDynamicNewView;

import java.util.List;

public class BaseFragment extends Fragment implements IDynamicNewView {
	
	private IDynamicNewView mIDynamicNewView;
	private LayoutInflater mLayoutInflater;

	@Override
	public void onAttach(Context context) {
		super.onAttach(context);
		try{
			mIDynamicNewView = (IDynamicNewView)context;
		}catch(ClassCastException e){
			mIDynamicNewView = null;
		}
	}

	@Override
	public void dynamicAddView(View view, List<DynamicAttr> pDAttrs) {
		if(mIDynamicNewView == null){
			throw new RuntimeException("IDynamicNewView should be implements !");
		}else{
			mIDynamicNewView.dynamicAddView(view, pDAttrs);
		}
	}

	public LayoutInflater getLayoutInflater(Bundle savedInstanceState) {
		LayoutInflater result = getActivity().getLayoutInflater();
		return result;
	}
}
