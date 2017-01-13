package com.example.admin.androidmvp_2016_10_11.common.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.androidmvp_2016_10_11.R;
import com.example.admin.androidmvp_2016_10_11.utils.SharedPreferenceUtil;
import com.example.admin.androidmvp_2016_10_11.utils.SystemUtil;
import com.example.admin.androidmvp_2016_10_11.view.StatusBarCompat;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * 描述说明  <br/>
 * Author : luokaixuan <br/>
 * CreateDate : 2016/10/11 14:26 <br/>
 * Modified : luokaixuan <br/>
 * ModifiedDate : 2016/10/11 14:26 <br/>
 * Email : 1005949566@qq.com <br/>
 * Version 1.0
 */
public class BaseActivity extends AppCompatActivity {

    SharedPreferences themePrefres;
    LayoutInflater layoutInflater;

    Toolbar toolbar;

    private View mContentView;
    
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        themePrefres = SharedPreferenceUtil.getThemePrefres(this);
        setBaseTheme();

        super.onCreate(savedInstanceState);

        //沉浸式状态栏
        StatusBarCompat.compat(this);

        layoutInflater = LayoutInflater.from(this);

        //判断是否在前台运行
        if (SystemUtil.isForeground(this) && SystemUtil.isAppOnForeground(this) && SystemUtil.isRunningForeground(this)) {
            Toast.makeText(this, "处于前台", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "处于后台", Toast.LENGTH_SHORT).show();
        }

    }

        @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

//    @Override
//    public void onStop() {
//        super.onStop();
//        EventBus.getDefault().unregister(this);
//    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageEventMainActivity event){
        Intent intent = new Intent(BaseActivity.this, FloatingActivity.class);
        startActivity(intent);
        Log.e("startactivity"," startactivity ");
    }

    public static class MessageEventMainActivity {

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        String text;

        public MessageEventMainActivity(String text) {
            this.text = text;
        }

    }

//    @Subscribe(threadMode = ThreadMode.MAIN)
//    public void onMessageEvent (FloatActivityMsg floatActivityMsg) {
//        Toast.makeText(this, " base ", Toast.LENGTH_SHORT).show();
//        recreate();
//    }
    public static class FloatActivityMsg{

    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(addTitleBar(getLayoutInflater().inflate(layoutResID, null)));
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(addTitleBar(view));
    }

    public View getContentView() {
        mContentView = mContentView == null ? findViewById(android.R.id.content) : mContentView;
        return mContentView;
    }

    protected void setOrgContentView(View view) {
        super.setContentView(view);
    }

    protected View addTitleBar (View view) {

        View toolbarView = getLayoutInflater().inflate(R.layout.layout_toolbar, null);
        FrameLayout toolbarContent = (FrameLayout) toolbarView.findViewById(R.id.toolbar_content);
        toolbarContent.addView(view);

//        ((ViewGroup)view).addView(toolbarView, 0);

//        View view = getLayoutInflater().inflate(R.layout.layout_toolbar, null);
//        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);

        toolbar = (Toolbar) toolbarView.findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setCollapsible(true);
        TextView tvTitle = (TextView) toolbarView.findViewById(R.id.toolbar_title_tv);
        tvTitle.setText(getSupportActionBar().getTitle()+"");

        // Enable ActionBar app icon to behave as action to go back
         getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
//        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

//        toolbar.setNavigationIcon(R.mipmap.ic_launcher);
        //        toolbar.setNavigationIcon(R.mipmap.ic_launcher);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        return toolbarView;
    }

    public Toolbar getToolbar() {
        return toolbar;
    }

    protected void setNavigationIcon (@Nullable Drawable drawable) {
        toolbar.setNavigationIcon(drawable);
    }

    protected void setBaseTheme() {
        String themeType = themePrefres.getString(SharedPreferenceUtil.THEM_TYPE, "");
        setBaseTheme(themeType);
    }
 
    protected void setBaseTheme(String themeType) {

        int themeId = 0;
        switch (themeType) {
            case SharedPreferenceUtil.GREEN:
                themeId = R.style.AppTheme_Base_Green;
                break;
            case SharedPreferenceUtil.BLUE:
                themeId = R.style.AppTheme_Base_Blue;
                break;
//            case THEME_ORANGE:
//                themeId = R.style.AppTheme_Base_Orange;
//                break;
//            case THEME_TEAL:
//                themeId = R.style.AppTheme_Base_Teal;
//                break;
//            case THEME_BROWN:
//                themeId = R.style.AppTheme_Base_Brown;
//                break;
            case SharedPreferenceUtil.GREY:
                themeId = R.style.AppTheme_Base_Grey;
                break;
            case SharedPreferenceUtil.PURPLE:
                themeId = R.style.AppTheme_Base_Purple;
                break;
            case SharedPreferenceUtil.DEFAULT:
                themeId = R.style.AppTheme_Base_Default;
                break;

            case SharedPreferenceUtil.RED:
                themeId = R.style.AppTheme_Base_Red;
                break;

//            default:
//                themeId = R.style.AppTheme_Base_Default;
        }
        if (themeId != 0) {
            setTheme(themeId);
        }
        themePrefres.edit().putString(SharedPreferenceUtil.THEM_TYPE, themeType).commit();

//        View rootView = getWindow().getDecorView();
//        ColorUiUtil.changeTheme(rootView, getTheme());

//        viewAll(((ViewGroup)getContentView()));

    }

    void viewAll (ViewGroup viewGroup) {
        int count = viewGroup.getChildCount();
        for (int i = 0; i < count; i++) {

            int[] attrs = new int[]{R.attr.colorPrimary, R.attr.colorPrimaryDark, R.attr.colorAccent,
                    R.attr.mainBgColor, R.attr.mainColor,
            R.attr.textColor};
            TypedArray attributes = obtainStyledAttributes(attrs);
            int main_bg = attributes.getColor(0, Color.TRANSPARENT);
            int button_color = attributes.getColor(1, Color.TRANSPARENT);
//            int text_color = attributes.getColor(2, Color.BLACK);
            int mainBgColor = attributes.getColor(3, Color.TRANSPARENT);
            int mainColor = attributes.getColor(4, Color.BLACK);
            int text_color = attributes.getColor(5, Color.TRANSPARENT);
            attributes.recycle();

            View view = viewGroup.getChildAt(i);
            if (view instanceof ViewGroup) {

//                if (view instanceof RecyclerView) {
//                }
//                else if (view instanceof LinearLayout) {
//                }
//                else if (view instanceof FrameLayout) {
//                }
//                else if (view instanceof RelativeLayout) {
//                }
////                else if (view instanceof NavigationMenuView) {
////                }
////                else if (view instanceof DrawerLayout) {
////                    view.setBackgroundColor(mainColor);
////                }
//                else if (view instanceof ImageView) {
//                } else {
////                    view.setBackgroundColor(mainColor);
//                }

                if (view instanceof Toolbar) {
                    view.setBackgroundColor(mainColor);
                }

                viewAll((ViewGroup)view);
            } else {
                if (view instanceof TextView || view instanceof EditText) {
                    ((TextView) view).setTextColor(text_color);
                } else if (view instanceof Button) {
                    ((Button) view).setTextColor(text_color);
                    ((Button) view).setBackgroundColor(button_color);
                } else if (view instanceof ImageView) {
                } else {

                    //沉浸式状态栏
                    StatusBarCompat.compat(this, mainColor);

                    view.setBackgroundColor(mainColor);
                }
            }
        }
    }

    /**
     * 设置各个视图与颜色属性的关联
     */
//    private void setupColorful() {
//        ViewGroupSetter listViewSetter = new ViewGroupSetter(mNewsListView);
//        // 绑定ListView的Item View中的news_title视图，在换肤时修改它的text_color属性
//        listViewSetter.childViewTextColor(R.id.news_title, R.attr.text_color);
//
//        // 构建Colorful对象来绑定View与属性的对象关系
//        mColorful = new Colorful.Builder(this)
//                .backgroundDrawable(R.id.root_view, R.attr.root_view_bg)
//                // 设置view的背景图片
//                .backgroundColor(R.id.change_btn, R.attr.btn_bg)
//                // 设置背景色
//                .textColor(R.id.textview, R.attr.text_color)
//                .setter(listViewSetter) // 手动设置setter
//                .create(); // 设置文本颜色
//    }
}
