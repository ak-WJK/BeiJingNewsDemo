package com.atguigu.beijingnewsdemo.base;

import android.content.Context;
import android.view.View;

/**
 * Created by Administrator on 2017/6/5.
 */

public abstract class MenuDetailBasePager {

    public final View rootView;
    public Context context;

    public MenuDetailBasePager(Context context) {

        this.context = context;

        rootView = initView();
    }

    //子类实现自己的视图
    public abstract View initView();


    //子类绑定数据
    public abstract void initData();


}
