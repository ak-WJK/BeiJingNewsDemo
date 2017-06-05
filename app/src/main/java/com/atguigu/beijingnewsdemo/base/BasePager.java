package com.atguigu.beijingnewsdemo.base;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import com.atguigu.beijingnewsdemo.MainActivity;
import com.atguigu.beijingnewsdemo.R;

/**
 * Created by Administrator on 2017/6/3.
 */

public class BasePager {


    public TextView tv_title;
    public ImageButton ib_menu;
    public FrameLayout fl_content;
    public final View rootView;
    public Context context;

    public BasePager(final Context context) {
        this.context = context;

        rootView = View.inflate(context, R.layout.base_pager, null);

        tv_title = (TextView) rootView.findViewById(R.id.tv_title);
        ib_menu = (ImageButton) rootView.findViewById(R.id.ib_menu);

        fl_content = (FrameLayout) rootView.findViewById(R.id.fl_content);


        ib_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity mainActivity = (MainActivity) context;
                mainActivity.getSlidingMenu().toggle();

            }
        });


    }

    public void initData() {


    }

}
