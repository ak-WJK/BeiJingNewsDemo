package com.atguigu.beijingnewsdemo.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by Administrator on 2017/6/6.
 */

public class NoScrollViewPager extends ViewPager {

    private float downX;

    public NoScrollViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {


        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                getParent().requestDisallowInterceptTouchEvent(true);
                downX = ev.getRawX();

                break;
            case MotionEvent.ACTION_MOVE:
                float moveX = ev.getRawX();
                if (moveX - downX > 0 && getCurrentItem() == 0) {
                    getParent().requestDisallowInterceptTouchEvent(false);

                } else if (downX - moveX > 0 && getCurrentItem() == getAdapter().getCount() - 1) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                } else {
                    getParent().requestDisallowInterceptTouchEvent(true);
                }


                break;
            case MotionEvent.ACTION_UP:

                break;
        }


        return super.dispatchTouchEvent(ev);
    }
}
