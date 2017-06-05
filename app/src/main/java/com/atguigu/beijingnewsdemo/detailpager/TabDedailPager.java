package com.atguigu.beijingnewsdemo.detailpager;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.atguigu.beijingnewsdemo.base.MenuDetailBasePager;
import com.atguigu.beijingnewsdemo.domain.NewsPagerBean;

/**
 * Created by Administrator on 2017/6/5.
 */

public class TabDedailPager extends MenuDetailBasePager {

    private final NewsPagerBean.DataBean.ChildrenBean childrenBean;
    private TextView textView;

    public TabDedailPager(Context context, NewsPagerBean.DataBean.ChildrenBean childrenBean) {
        super(context);
        this.childrenBean = childrenBean;
    }


    @Override
    public View initView() {
        //创建子类的视图
        textView = new TextView(context);
        textView.setGravity(Gravity.CENTER);
        textView.setTextColor(Color.RED);
        return textView;
    }

    @Override
    public void initData() {
        textView.setText(childrenBean.getTitle());

    }
}
