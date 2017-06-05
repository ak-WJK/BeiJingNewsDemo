package com.atguigu.beijingnewsdemo.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.atguigu.beijingnewsdemo.MainActivity;
import com.atguigu.beijingnewsdemo.R;
import com.atguigu.beijingnewsdemo.base.BaseFragment;
import com.atguigu.beijingnewsdemo.base.BasePager;
import com.atguigu.beijingnewsdemo.pager.HomePager;
import com.atguigu.beijingnewsdemo.pager.NewsPager;
import com.atguigu.beijingnewsdemo.pager.SettingPager;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/6/2.
 */

public class ContentFragment extends BaseFragment {
    @BindView(R.id.vp)
    ViewPager vp;
    @BindView(R.id.rb_home)
    RadioButton rbHome;
    @BindView(R.id.rb_news)
    RadioButton rbNews;
    @BindView(R.id.rb_setting)
    RadioButton rbSetting;
    @BindView(R.id.rg_main)
    RadioGroup rgMain;
    Unbinder unbinder;
    private ArrayList<BasePager> pagers;

    @Override
    public View initView() {
        View view = View.inflate(context, R.layout.fragment_content_layout, null);
        ButterKnife.bind(this, view);


        isEnableSlidingMenu(context, SlidingMenu.TOUCHMODE_NONE);
        rgMain.check(R.id.rb_home);

        return view;
    }


    @Override
    protected void initData() {

        pagers = new ArrayList<>();
        pagers.add(new HomePager(context));
        pagers.add(new NewsPager(context));
        pagers.add(new SettingPager(context));

        vp.setAdapter(new MyAdapter());

        vp.addOnPageChangeListener(new MyOnPageChangeListener());


    }

    class MyOnPageChangeListener implements ViewPager.OnPageChangeListener {


        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {


        }

        @SuppressLint("WrongConstant")
        @Override
        public void onPageSelected(int position) {
            //实现按钮的显示和隐藏
            BasePager pager = pagers.get(position);
            if (position == 1) {
                pager.ib_menu.setVisibility(View.VISIBLE);
            } else {
                pager.ib_menu.setVisibility(View.GONE);
            }


            if (position == 1) {

                isEnableSlidingMenu(context, SlidingMenu.TOUCHMODE_FULLSCREEN);


            } else {

                isEnableSlidingMenu(context, SlidingMenu.TOUCHMODE_NONE);
            }


        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }

    private static void isEnableSlidingMenu(Context context, int touchmodeFullscreen) {
        MainActivity mainActivity = (MainActivity) context;
        SlidingMenu slidingMenu = mainActivity.getSlidingMenu();
        slidingMenu.setTouchModeAbove(touchmodeFullscreen);
    }


    class MyAdapter extends PagerAdapter {

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            BasePager pager = pagers.get(position);

            View rootView = pager.rootView;

//            pager.initData();

            container.addView(rootView);

            return rootView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public int getCount() {
            return pagers.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
    }


    @OnClick({R.id.rb_home, R.id.rb_news, R.id.rb_setting, R.id.rg_main})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            /*
            * 第一个参数 在集合中的位置
            * 第二个参数 取消页面切换动画
            *
            *
            * */
            case R.id.rb_home:
                vp.setCurrentItem(0, false);
                //屏蔽viewPager的预加载
                pagers.get(0).initData();
                break;
            case R.id.rb_news:
                vp.setCurrentItem(1, false);
                pagers.get(1).initData();
                break;
            case R.id.rb_setting:
                vp.setCurrentItem(2, false);
                pagers.get(2).initData();
                break;

        }
    }

}
