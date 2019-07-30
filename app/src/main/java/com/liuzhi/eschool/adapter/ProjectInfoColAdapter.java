package com.liuzhi.eschool.adapter;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.text.Html;
import android.util.Log;
import com.liuzhi.eschool.entity.ProjectInfoColEntity;
import com.liuzhi.eschool.view.fragment.DanyeFragment;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ProjectInfoColAdapter extends FragmentPagerAdapter {
    private List<ProjectInfoColEntity.DataBean> dataBeans = null;

    public ProjectInfoColAdapter(FragmentManager fm) {
        super(fm);
        this.dataBeans = new ArrayList<>();
    }

    /**
     * 数据列表
     *
     * @param datas
     */
    public void setDataList(List<ProjectInfoColEntity.DataBean> datas) {
        this.dataBeans.clear();
        this.dataBeans.addAll(datas);
        notifyDataSetChanged();
    }

    @Override
    public Fragment getItem(int position) {
        DanyeFragment fragment = new DanyeFragment();
        Bundle bundle = new Bundle();
        bundle.putString("ProjectInfoById", dataBeans.get(position).getColId());
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
        } else if (plateName.length() > 5) {
            plateName = plateName.substring(0, 5) + "...";
        }
        return plateName;
    }
}
