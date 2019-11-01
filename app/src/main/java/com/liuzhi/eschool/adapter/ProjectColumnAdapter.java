package com.liuzhi.eschool.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.liuzhi.eschool.entity.FirstResponseEntity;
import com.liuzhi.eschool.entity.SecondResponseEntity;
import com.liuzhi.eschool.view.fragment.DetailFragment;

import java.util.ArrayList;
import java.util.List;

public class ProjectColumnAdapter extends FragmentPagerAdapter {
    private List<SecondResponseEntity.DataBean.ColumnBean> dataBeans = null;

    public ProjectColumnAdapter(FragmentManager fm) {
        super(fm);
        this.dataBeans = new ArrayList<>();
    }

    /**
     * 数据列表
     *
     * @param datas
     */
    public void setDataList(List<SecondResponseEntity.DataBean.ColumnBean> datas) {
        this.dataBeans.clear();
        this.dataBeans.addAll(datas);
        notifyDataSetChanged();
    }

    @Override
    public Fragment getItem(int position) {
        DetailFragment fragment = new DetailFragment();
        Bundle bundle = new Bundle();
        bundle.putString("colId", dataBeans.get(position).getColId());
        bundle.putInt("colType", dataBeans.get(position).getColType());
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getCount() {
        return dataBeans.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String plateName = dataBeans.get(position).getColName();
        if (plateName == null) {
            plateName = "";
        } else if (plateName.length() > 8) {
            plateName = plateName.substring(0, 8) + "...";
        }
        return plateName;
    }
}
