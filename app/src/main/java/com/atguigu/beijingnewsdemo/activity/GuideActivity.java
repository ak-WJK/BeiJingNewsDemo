package com.atguigu.beijingnewsdemo.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.atguigu.beijingnewsdemo.MainActivity;
import com.atguigu.beijingnewsdemo.R;
import com.atguigu.beijingnewsdemo.utils.DensityUtil;
import com.atguigu.beijingnewsdemo.utils.SPUtils;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GuideActivity extends AppCompatActivity {


    @BindView(R.id.viewpager)
    ViewPager viewpager;
    @BindView(R.id.btn_start_activity)
    Button btnStartActivity;
    @BindView(R.id.ll_point)
    LinearLayout llPoint;
    @BindView(R.id.iv_red_point)
    ImageView ivRedPoint;


    private int distance;


    private int[] icons = {
            R.drawable.guide_1,
            R.drawable.guide_2,
            R.drawable.guide_3

    };
    private ArrayList<ImageView> imageViews;
    private AlphaAnimation alphaAnimation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        ButterKnife.bind(this);
        setAnimation();
        initView();


    }

    private void setAnimation() {
        alphaAnimation = new AlphaAnimation(0, 1);
        alphaAnimation.setDuration(1000);
        alphaAnimation.setFillAfter(true);
    }

    private void initView() {
        imageViews = new ArrayList<>();
        for (int i = 0; i < icons.length; i++) {

            ImageView imageView = new ImageView(this);
            //设置imageview的背景色
            imageView.setBackgroundResource(icons[i]);
            //添加imageview到集合
            imageViews.add(imageView);

            //点的实现
            ImageView point = new ImageView(this);
            //设置点的背景色
            point.setBackgroundResource(R.drawable.guide_point_normal);

            LinearLayout.LayoutParams perams = new LinearLayout.LayoutParams(DensityUtil.dip2px(this, 10), DensityUtil.dip2px(this, 10));
            //设置点的大小
            point.setLayoutParams(perams);
            //设置点之间的距离
            if (i != 0) {
                perams.leftMargin = 28;

            }

            //得到两个点之间的距离
            llPoint.getViewTreeObserver().addOnGlobalLayoutListener(new MyOnGlobalLayoutListener());

            //装配到线性布局中
            llPoint.addView(point);


        }

        viewpager.setAdapter(new MyAdapter());


        viewpager.addOnPageChangeListener(new MyOnPageChangeListener());

    }

    class MyOnPageChangeListener implements ViewPager.OnPageChangeListener {


        /**
         * 当页面滑动的时候回调
         *
         * @param position             位置
         * @param positionOffset       滑动的百分比
         * @param positionOffsetPixels 滑动的像素位置
         */
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            //滑动的百分比 = 滑动的距离:屏幕的宽度
            //滑动距离/屏幕宽度 = 红点移动距离/点距离
            //红点移动距离=红点的距离*滑动百分比;
            float moveDistance = distance * (position + positionOffset);
            //得到红点控件的宽高参数
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ivRedPoint.getLayoutParams();

            //设置左边距为移动的距离
            layoutParams.leftMargin = (int) moveDistance;
            //用此函数重绘得到效果
            ivRedPoint.setLayoutParams(layoutParams);


        }

        /**
         * 当页面选中的时候回调
         *
         * @param position
         */
        @SuppressLint("WrongConstant")
        @Override
        public void onPageSelected(int position) {
            if (position == imageViews.size() - 1) {

                btnStartActivity.startAnimation(alphaAnimation);
                btnStartActivity.setVisibility(View.VISIBLE);

            } else {
                btnStartActivity.clearAnimation();
                btnStartActivity.setVisibility(View.GONE);
            }


        }

        /**
         * 当页面状态改变的时候回调
         *
         * @param state
         */
        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }

    class MyOnGlobalLayoutListener implements ViewTreeObserver.OnGlobalLayoutListener {


        @Override
        public void onGlobalLayout() {

            //取消监听
            llPoint.getViewTreeObserver().removeOnGlobalLayoutListener(this);

            distance = llPoint.getChildAt(1).getLeft() - llPoint.getChildAt(0).getLeft();


        }
    }


    class MyAdapter extends PagerAdapter {

        @Override
        public Object instantiateItem(ViewGroup container, int position) {

            ImageView imageView = imageViews.get(position);

            container.addView(imageView);


            return imageView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public int getCount() {
            return icons.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
    }


    @OnClick(R.id.btn_start_activity)
    public void onViewClicked() {

        SPUtils.saveBoolean(GuideActivity.this, "boolean", true);

        Intent intent = new Intent(GuideActivity.this, MainActivity.class);
        startActivity(intent);
    }


}
