package com.yu.attention.base;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;

import butterknife.ButterKnife;

/**
 * @author luyanjun
 * @description
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initFullScreen();
        setContentView(initLayout());
        ButterKnife.bind(this);
        init();
    }

    //全屏
    private void initFullScreen() {
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setNavigationBarColor(Color.TRANSPARENT);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    //初始化布局
    protected abstract int initLayout();

    //初始化数据
    protected abstract void init();

    protected static void actionStart(Context context,Class clazz){
        Intent intent = new Intent(context,clazz);
        context.startActivity(intent);
    }
}
