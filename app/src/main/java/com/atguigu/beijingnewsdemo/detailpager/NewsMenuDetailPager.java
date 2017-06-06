package com.atguigu.beijingnewsdemo.detailpager;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.atguigu.beijingnewsdemo.R;
import com.atguigu.beijingnewsdemo.base.MenuDetailBasePager;
import com.atguigu.beijingnewsdemo.domain.NewsPagerBean;
import com.atguigu.beijingnewsdemo.view.NoScrollViewPager;
import com.atguigu.beijingnewsdemo.view.ScrollTabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/6/5.
 */

public class NewsMenuDetailPager extends MenuDetailBasePager {


    private final List<NewsPagerBean.DataBean.ChildrenBean> dataBeanList;
    @BindView(R.id.viewpager)
    NoScrollViewPager viewpager;
    @BindView(R.id.tab)
    ScrollTabLayout tab;
    @BindView(R.id.ib_next)
    ImageButton ibNext;

    private ArrayList<TabDedailPager> tabDedailPagers;

    public NewsMenuDetailPager(Context context, List<NewsPagerBean.DataBean.ChildrenBean> dataBeanList) {
        super(context);
        this.dataBeanList = dataBeanList;
    }

    @Override
    public View initView() {

        View view = View.inflate(context, R.layout.news_tab_pager_layout, null);
        ButterKnife.bind(this, view);

        ibNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewpager.setCurrentItem(viewpager.getCurrentItem() + 1);

            }
        });


        //将tablayout与viewpager建立关系
        tab.setupWithViewPager(viewpager);


        return view;
    }

    @Override
    public void initData() {

        tabDedailPagers = new ArrayList<>();
        for (int i = 0; i < dataBeanList.size(); i++) {

            tabDedailPagers.add(new TabDedailPager(context, dataBeanList.get(i)));

        }

        viewpager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return dataBeanList.size();
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                TabDedailPager tabDedailPager = tabDedailPagers.get(position);

                View rootView = tabDedailPager.rootView;

                tabDedailPager.initData();
                container.addView(rootView);


                return rootView;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView((View) object);
            }

            @Override
            public boolean isViewFromObject(View view, Object o) {
                return view == o;
            }


            @Override
            public CharSequence getPageTitle(int position) {
                return dataBeanList.get(position).getTitle();
            }
        });


    }
}
