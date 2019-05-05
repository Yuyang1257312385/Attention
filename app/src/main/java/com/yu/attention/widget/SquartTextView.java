package com.yu.attention.widget;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

/**
 * @author luyanjun
 * @description  正方形TextView
 */
public class SquartTextView extends AppCompatTextView {


    public SquartTextView(Context context) {
        super(context);
    }

    public SquartTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SquartTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
    }
}
