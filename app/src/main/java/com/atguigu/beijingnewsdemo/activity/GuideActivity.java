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

        imageViews = new ArrayList<>();
        for (int i = 0; i < icons.length; i++) {

            ImageView imageView = new ImageView(this);

            imageView.setBackgroundResource(icons[i]);

            imageViews.add(imageView);

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
