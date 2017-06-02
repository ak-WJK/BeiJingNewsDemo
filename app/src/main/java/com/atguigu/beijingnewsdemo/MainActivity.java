package com.atguigu.beijingnewsdemo;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;

import com.atguigu.beijingnewsdemo.fragment.ContentFragment;
import com.atguigu.beijingnewsdemo.fragment.LeftFragment;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

public class MainActivity extends SlidingFragmentActivity {

    public static final String TAG_MAIN = "tag_main";
    public static final String TAG_LEFT = "tag_left";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initSlidingmenu();

        initFragment();


    }

    private void initFragment() {

        FragmentTransaction fm = getSupportFragmentManager().beginTransaction();

        fm.replace(R.id.fl_main, new ContentFragment(), TAG_MAIN);
        fm.replace(R.id.fl_left, new LeftFragment(), TAG_LEFT);

        fm.commit();


    }

    private void initSlidingmenu() {
        //主页面
        setContentView(R.layout.activity_main);
        //左侧页面
        setBehindContentView(R.layout.left_layout);


        SlidingMenu slidingMenu = getSlidingMenu();

        //设置模式：左侧+主页；左侧+主页+右侧；主页+右侧
        slidingMenu.setMode(SlidingMenu.LEFT);
        //设置滑动模式 不可用滑动，滑动编边缘，全屏滑动
        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        //设置主页所占宽度
        slidingMenu.setBehindOffset(900);
    }


}
