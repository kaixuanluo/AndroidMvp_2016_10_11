package com.example.admin.androidmvp_2016_10_11.common.activity;

import me.yokeyword.swipebackfragment.SwipeBackActivity;

/**
 * 描述说明  <br/>
 * Author : luokaixuan <br/>
 * CreateDate : 2016/10/25 11:43 <br/>
 * Modified : luokaixuan <br/>
 * ModifiedDate : 2016/10/25 11:43 <br/>
 * Email : 1005949566@qq.com <br/>
 * Version 1.0
 */
public class SkinChangeActivity extends SwipeBackActivity

{
//        implements ISkinUpdate, IDynamicNewView {
//
//    private SkinInflaterFactory mSkinInflaterFactory;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        mSkinInflaterFactory = new SkinInflaterFactory();
//        mSkinInflaterFactory.setAppCompatActivity(this);
//        LayoutInflaterCompat.setFactory(getLayoutInflater(), mSkinInflaterFactory);
//        super.onCreate(savedInstanceState);
//        changeStatusColor();
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        SkinManager.getInstance().attach(this);
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        SkinManager.getInstance().detach(this);
//        mSkinInflaterFactory.clean();
//    }
//
//    @Override
//    public void onThemeUpdate() {
//        Log.i("SkinBaseActivity", "onThemeUpdate");
//        Log.e( "SkinChangeActivity", "onThemeUpdate" );
//        mSkinInflaterFactory.applySkin();
//        changeStatusColor();
//    }
//
//    public void changeStatusColor() {
//        if (!SkinConfig.isCanChangeStatusColor()) {
//            return;
//        }
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            SkinL.i("SkinChangeActivity", "changeStatus");
//            Log.e( "SkinChangeActivity", "changeStatus" );
//            int color = SkinManager.getInstance().getColorPrimaryDark();
//            StatusBarUtil statusBarBackground = new StatusBarUtil(
//                    this, color);
//            if (color != -1)
//                statusBarBackground.setStatusBarbackColor();
//        }
//    }
//
//    @Override
//    public void dynamicAddView(View view, List<DynamicAttr> pDAttrs) {
//        mSkinInflaterFactory.dynamicAddSkinEnableView(this, view, pDAttrs);
//    }
//
//    @Override
//    public void dynamicAddView(View view, String attrName, int attrValueResId) {
//        mSkinInflaterFactory.dynamicAddSkinEnableView(this, view, attrName, attrValueResId);
//    }
//
//    @Override
//    public void dynamicAddFontView(TextView textView) {
//        mSkinInflaterFactory.dynamicAddFontEnableView(textView);
//    }

}
