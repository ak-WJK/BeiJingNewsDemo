package com.atguigu.beijingnewsdemo.pager;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.app.FragmentManager;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.atguigu.beijingnewsdemo.MainActivity;
import com.atguigu.beijingnewsdemo.base.BasePager;
import com.atguigu.beijingnewsdemo.base.MenuDetailBasePager;
import com.atguigu.beijingnewsdemo.detailpager.InteractMenuDetailBasePager;
import com.atguigu.beijingnewsdemo.detailpager.NewsMenuDetailBasePager;
import com.atguigu.beijingnewsdemo.detailpager.PhotosMenuDetailBasePager;
import com.atguigu.beijingnewsdemo.detailpager.TopicMenuDetailBasePager;
import com.atguigu.beijingnewsdemo.detailpager.VoteMenuDetailBasePager;
import com.atguigu.beijingnewsdemo.domain.NewsPagerBean;
import com.atguigu.beijingnewsdemo.fragment.LeftFragment;
import com.atguigu.beijingnewsdemo.utils.ContentUrl;
import com.atguigu.beijingnewsdemo.utils.LogUtils;
import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;

/**
 * Created by Administrator on 2017/6/2.
 */

public class NewsPager extends BasePager {
    private String url = ContentUrl.NEWSCENTER_PAGER_URL;
    private NewsPagerBean.DataBean dataBean;

    private ArrayList<MenuDetailBasePager> pagerArrayList;

    public NewsPager(Context context) {
        super(context);

    }

    @Override
    public void initData() {
        super.initData();
        tv_title.setText("新闻");

        TextView textView = new TextView(context);
        textView.setText("新闻页面");
        textView.setGravity(Gravity.CENTER);
        textView.setTextSize(25);
        textView.setTextColor(Color.BLACK);

        fl_content.addView(textView);

        requestNetData();

    }

    private void requestNetData() {


        OkHttpUtils.get()
                .url(url)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int i) {
                        LogUtils.e("TAG", "网络连接错误" + e.getMessage());
                    }

                    @Override
                    public void onResponse(String result, int i) {
//                        LogUtils.e("TAG", "网络连接成功==" + result);
                        anaylsisJson(result);
                    }
                });

        pagerArrayList = new ArrayList();

        pagerArrayList.add(new NewsMenuDetailBasePager(context));
        pagerArrayList.add(new TopicMenuDetailBasePager(context));
        pagerArrayList.add(new PhotosMenuDetailBasePager(context));
        pagerArrayList.add(new InteractMenuDetailBasePager(context));
        pagerArrayList.add(new VoteMenuDetailBasePager(context));

        setSwitchPager(0);
    }

    private void anaylsisJson(String json) {

        NewsPagerBean newsPagerBean = new Gson().fromJson(json, NewsPagerBean.class);
        List<NewsPagerBean.DataBean> dataBeanList = newsPagerBean.getData();

        for (int i = 0; i < dataBeanList.size(); i++) {
            dataBean = dataBeanList.get(i);
            String title = dataBean.getTitle();

//            LogUtils.e("TAG", "title" + title);

        }


        MainActivity mainActivity = (MainActivity) context;

        //方法一
        FragmentManager fragmentManager = mainActivity.getSupportFragmentManager();
        LeftFragment leftFragment = (LeftFragment) fragmentManager.findFragmentByTag(String.valueOf(mainActivity.TAG_LEFT));

        //方法二
//        LeftFragment leftFragment =  mainActivity.getLeftFragment();

        leftFragment.setMenuData(dataBeanList);


    }

    public void setSwitchPager(int prePosition) {
        MenuDetailBasePager pager = pagerArrayList.get(prePosition);
        fl_content.removeAllViews();
        View rootView = pager.rootView;
        pager.initData();
        fl_content.addView(rootView);

    }
}
