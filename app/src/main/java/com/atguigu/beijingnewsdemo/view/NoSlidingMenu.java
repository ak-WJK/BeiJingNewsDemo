package com.atguigu.beijingnewsdemo.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Created by Administrator on 2017/6/4.
 */

public class NoSlidingMenu extends ViewPager {
    public NoSlidingMenu(Context context, @Nullable AttributeSet attrs) {

        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return true;
    }



}
