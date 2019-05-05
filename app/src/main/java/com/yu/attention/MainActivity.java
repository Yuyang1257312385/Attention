package com.yu.attention;

import android.os.Bundle;
import android.view.View;

import com.yu.attention.base.BaseActivity;
import com.yu.attention.srt.SrtActivity;

import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {

    }

    @OnClick({R.id.btn_srt})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.btn_srt:
                //舒尔特方格
                SrtActivity.actionStart(this,SrtActivity.class);
                break;
        }
    }
}
