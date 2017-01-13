package com.example.admin.androidmvp_2016_10_11.utils.skinLoader.listener;

import android.content.Context;

public interface ISkinChecker {
	
	/**
	 * Check whether the skin is exits or legal
	 * @param context
	 * @param path
	 * @return 
	 */
	boolean isSkinPackageLegality(Context context, String path);
}
