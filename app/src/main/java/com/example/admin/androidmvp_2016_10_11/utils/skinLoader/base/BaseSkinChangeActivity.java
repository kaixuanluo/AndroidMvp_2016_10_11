package com.example.admin.androidmvp_2016_10_11.utils.skinLoader.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.admin.androidmvp_2016_10_11.utils.skinLoader.entity.DynamicAttr;
import com.example.admin.androidmvp_2016_10_11.utils.skinLoader.listener.IDynamicNewView;
import com.example.admin.androidmvp_2016_10_11.utils.skinLoader.listener.ISkinUpdate;
import com.example.admin.androidmvp_2016_10_11.utils.skinLoader.loader.SkinInflaterFactory;
import com.example.admin.androidmvp_2016_10_11.utils.skinLoader.loader.SkinManager;

import java.util.List;

/**
 * Base Activity for development
 * 
 * <p>NOTICE:<br> 
 * You should extends from this if you what to do skin change
 * 
 * @author fengjun
 */
public class BaseSkinChangeActivity extends AppCompatActivity implements ISkinUpdate, IDynamicNewView {
	
	/**
	 * Whether response to skin changing after create
	 */
	private boolean isResponseOnSkinChanging = true;
	
	private SkinInflaterFactory mSkinInflaterFactory;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		mSkinInflaterFactory = new SkinInflaterFactory();
//		LayoutInflaterCompat.setFactory(getLayoutInflater(), mSkinInflaterFactory);
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		 SkinManager.getInstance().attach(this);
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		 SkinManager.getInstance().detach(this);
		mSkinInflaterFactory.clean();
	}
	
	/**
	 * dynamic add a skin view 
	 * 
	 * @param view
	 * @param attrName
	 * @param attrValueResId
	 */
	protected void dynamicAddSkinEnableView(View view, String attrName, int attrValueResId){	
		mSkinInflaterFactory.dynamicAddSkinEnableView(this, view, attrName, attrValueResId);
	}
	
	protected void dynamicAddSkinEnableView(View view, List<DynamicAttr> pDAttrs){
		mSkinInflaterFactory.dynamicAddSkinEnableView(this, view, pDAttrs);
	}
	
	final protected void enableResponseOnSkinChanging(boolean enable){
		isResponseOnSkinChanging = enable;
	}

	@Override
	public void onThemeUpdate() {
		if(!isResponseOnSkinChanging){
			return;
		}
		mSkinInflaterFactory.applySkin();
	}

	@Override
	public void dynamicAddView(View view, List< DynamicAttr> pDAttrs) {
		mSkinInflaterFactory.dynamicAddSkinEnableView(this, view, pDAttrs);
	}
}
