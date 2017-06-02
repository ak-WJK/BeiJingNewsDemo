package com.atguigu.beijingnewsdemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.atguigu.beijingnewsdemo.MainActivity;
import com.atguigu.beijingnewsdemo.R;
import com.atguigu.beijingnewsdemo.utils.DensityUtil;

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

    private int[] icons = {
            R.drawable.guide_1,
            R.drawable.guide_2,
            R.drawable.guide_3

    };
    private ArrayList<ImageView> imageViews;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        ButterKnife.bind(this);

        initView();


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
                perams.leftMargin = 20;

            }

            //装配到线性布局中
            llPoint.addView(point);


        }

        viewpager.setAdapter(new MyAdapter());
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
        Intent intent = new Intent(GuideActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
