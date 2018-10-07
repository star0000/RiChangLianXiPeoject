package com.moyu.channelmanagerdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * Created by 墨羽 on 2018/3/22.
 */

public class MyGridView extends GridView {

    public MyGridView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
