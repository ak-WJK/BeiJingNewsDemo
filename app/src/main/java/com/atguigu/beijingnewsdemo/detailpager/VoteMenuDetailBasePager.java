package com.atguigu.beijingnewsdemo.detailpager;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.atguigu.beijingnewsdemo.base.MenuDetailBasePager;

/**
 * Created by Administrator on 2017/6/5.
 */

public class VoteMenuDetailBasePager extends MenuDetailBasePager {

    private TextView textView;

    public VoteMenuDetailBasePager(Context context) {
        super(context);
    }

    @Override
    public View initView() {
        textView = new TextView(context);
        textView.setGravity(Gravity.CENTER);
        return textView;
    }

    @Override
    public void initData() {
        textView.setText("投票");

    }
}
