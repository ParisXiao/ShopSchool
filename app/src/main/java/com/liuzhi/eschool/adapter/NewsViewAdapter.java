package com.liuzhi.eschool.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.liuzhi.eschool.entity.ProjectDetailByIdEntity;
import com.liuzhi.eschool.view.fragment.NewsListFragment;
import com.liuzhi.eschool.view.fragment.RichTextFragment;

import java.util.ArrayList;
import java.util.List;

public class NewsViewAdapter extends FragmentPagerAdapter {
    private List<ProjectDetailByIdEntity.DataBean.InfoBeanX> dataBeans = null;

    public NewsViewAdapter(FragmentManager fm) {
        super(fm);
        this.dataBeans = new ArrayList<>();
    }

    /**
     * 数据列表
     *
     * @param datas
     */
    public void setDataList(List<ProjectDetailByIdEntity.DataBean.InfoBeanX> datas) {
        this.dataBeans.clear();
        this.dataBeans.addAll(datas);
        notifyDataSetChanged();
    }

    @Override
    public Fragment getItem(int position) {
        NewsListFragment fragment = new NewsListFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("NewsList", dataBeans.get(position).getInfo());
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getCount() {
        return dataBeans.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String plateName = dataBeans.get(position).getColumn().getColName();
        if (plateName == null) {
            plateName = "";
        } else if (plateName.length() > 5) {
            plateName = plateName.substring(0, 5) + "...";
        }
        return plateName;
    }
}
