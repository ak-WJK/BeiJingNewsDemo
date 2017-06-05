package com.atguigu.beijingnewsdemo.detailpager;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import com.atguigu.beijingnewsdemo.R;
import com.atguigu.beijingnewsdemo.base.MenuDetailBasePager;
import com.atguigu.beijingnewsdemo.domain.NewsPagerBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/6/5.
 */

public class NewsMenuDetailBasePager extends MenuDetailBasePager {


    private final List<NewsPagerBean.DataBean.ChildrenBean> dataBeanList;
    @BindView(R.id.viewpager)
    ViewPager viewpager;

    private ArrayList<TabDedailPager> tabDedailPagers;

    public NewsMenuDetailBasePager(Context context, List<NewsPagerBean.DataBean.ChildrenBean> dataBeanList) {
        super(context);
        this.dataBeanList = dataBeanList;
    }

    @Override
    public View initView() {

        View view = View.inflate(context, R.layout.news_tab_pager_layout, null);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void initData() {

        tabDedailPagers = new ArrayList<>();
        for (int i = 0; i < dataBeanList.size(); i++) {

            tabDedailPagers.add(new TabDedailPager(context , dataBeanList.get(i)));

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
        });


    }
}
