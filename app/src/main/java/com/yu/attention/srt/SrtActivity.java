package com.yu.attention.srt;

import android.os.CountDownTimer;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.yu.attention.R;
import com.yu.attention.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author luyanjun
 * @description  舒尔特方格 Activity
 */
public class SrtActivity extends BaseActivity implements SrtAdapter.ItemClickListener {

    @BindView(R.id.tv_tip)
    TextView mTipTv;
    @BindView(R.id.rv_srt)
    RecyclerView mSrtRv;
    @BindView(R.id.btn_start)
    Button mStartBtn;
    @BindView(R.id.tv_time)
    TextView mTimeTv;

    private List<Integer> mDataList = new ArrayList<>();
    private SrtAdapter mAdapter;
    private CountDownTimer mTimer;
    private int mCount = 0;

    @Override
    protected int initLayout() {
        return R.layout.act_srt;
    }

    @Override
    protected void init() {
        mTipTv.setText("请按 开始");
        mSrtRv.setLayoutManager(new GridLayoutManager(this,5));
        mAdapter = new SrtAdapter(this);
        mSrtRv.setAdapter(mAdapter);
        mTimer = new CountDownTimer(1000*1000,1*1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeTv.setText((1000-millisUntilFinished/1000)+" 秒");
            }

            @Override
            public void onFinish() {
                mStartBtn.setText("再来一局");
            }

        };
        initData();
    }

    private void initData() {
        mDataList.clear();
        int[] array = new int[25];
        for(int i=0;i<array.length;i++){
            Random random = new Random();
            int randomInt = random.nextInt(25);//[0,25)
            for(int j=0;j<i;j++){
                if(randomInt == array[j]){
                    randomInt = random.nextInt(25);
                    j = -1;
                }
            }
            array[i] = randomInt;
            mDataList.add(randomInt);
        }

        mAdapter.setData(mDataList);
    }



    @Override
    public void onItemClick(int position) {
        int num = mDataList.get(position);
        if(mCount == num){
            mCount = mCount+1;
        }

        if(mCount == 25){
            mTimer.cancel();
            mStartBtn.setText("再来一局");
            mTipTv.setText("恭喜你完成测试");
        }else {
            mTipTv.setText("请按 "+mCount);
        }
    }

    @OnClick({R.id.btn_start})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.btn_start:
                String text = mStartBtn.getText().toString().trim();
                if("再来一局".equals(text)){
                    initData();
                    mTimeTv.setText("0 秒");
                    mTimer.cancel();
                    mCount = 0;
                    mTipTv.setText("请按 "+mCount);
                    mTimer.start();
                }else if("开始".equals(text)){
                    mTipTv.setText("请按 "+mCount);
                    mTimer.start();
                }
                break;
        }
    }

//    static class MyTimer extends CountDownTimer{
//
//        @Override
//        public void onTick(long millisUntilFinished) {
//
//        }
//
//        @Override
//        public void onFinish() {
//
//        }
//    }
}
