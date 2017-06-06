package com.atguigu.beijingnewsdemo.fragment;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.atguigu.beijingnewsdemo.MainActivity;
import com.atguigu.beijingnewsdemo.R;
import com.atguigu.beijingnewsdemo.base.BaseFragment;
import com.atguigu.beijingnewsdemo.domain.NewsPagerBean;
import com.atguigu.beijingnewsdemo.pager.NewsPager;
import com.atguigu.beijingnewsdemo.utils.DensityUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/6/3.
 */

public class LeftFragment extends BaseFragment {


    private ListView listView;
    private List<NewsPagerBean.DataBean> menuData;
    private MenuAdapter adapter;

    private int prePosition = 0;

    @Override
    public View initView() {


        listView = new ListView(context);

        listView.setPadding(0, DensityUtil.dip2px(context, 50), 0, 0);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                //实现菜单的点击状态的改变
                prePosition = position;
                adapter.notifyDataSetChanged();

                //实现点击关闭菜单栏
                MainActivity mainActivity = (MainActivity) context;
                mainActivity.getSlidingMenu().toggle();


                switchPager(prePosition);


            }
        });


        return listView;
    }

    private void switchPager(int prePosition) {

        MainActivity mainActivity = (MainActivity) context;
        ContentFragment contentFragment = (ContentFragment) mainActivity.getSupportFragmentManager().findFragmentByTag(mainActivity.TAG_MAIN);
        NewsPager newsPager = contentFragment.getNewsPager();
        newsPager.setSwitchPager(prePosition);

    }


    @Override
    public void initData() {


    }

    public void setMenuData(List<NewsPagerBean.DataBean> menuData) {
        this.menuData = menuData;
//        for (int i = 0; i < menuData.size(); i++) {
//            String title = menuData.get(i).getTitle();
//            LogUtils.e("TAG", "=======" + title);
//
//        }



        adapter = new MenuAdapter();
        listView.setAdapter(adapter);



    }

    class MenuAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return menuData.size();
        }

        @Override
        public NewsPagerBean.DataBean getItem(int position) {
            return menuData.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            if (convertView == null) {
                convertView = View.inflate(context, R.layout.meun_item, null);
                viewHolder = new ViewHolder(convertView);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

            //实现菜单的点击状态的改变
            if (prePosition == position) {
                //高亮
                viewHolder.tvMenuGuidle.setEnabled(true);
            } else {
                //默认
                viewHolder.tvMenuGuidle.setEnabled(false);
            }

            NewsPagerBean.DataBean dataBean = menuData.get(position);

            viewHolder.tvMenuGuidle.setText(dataBean.getTitle());


            return convertView;
        }

    }

    static class ViewHolder {
        @BindView(R.id.tv_menu_guidle)
        TextView tvMenuGuidle;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

}
