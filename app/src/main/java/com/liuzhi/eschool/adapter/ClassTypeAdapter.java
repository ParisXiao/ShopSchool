package com.liuzhi.eschool.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.liuzhi.eschool.entity.ClassTypeEntity;
import com.liuzhi.eschool.view.fragment.ClassListFragment;

import java.util.ArrayList;
import java.util.List;

public class ClassTypeAdapter extends FragmentPagerAdapter {
    private List<ClassTypeEntity.DataBean> dataBeans = null;

    public ClassTypeAdapter(FragmentManager fm) {
        super(fm);
        this.dataBeans = new ArrayList<>();
    }

    /**
     * 数据列表
     *
     * @param datas
     */
    public void setDataList(List<ClassTypeEntity.DataBean> datas) {
        this.dataBeans.clear();
        this.dataBeans.addAll(datas);
        notifyDataSetChanged();
    }

    @Override
    public Fragment getItem(int position) {
        ClassListFragment fragment = new ClassListFragment();
        Bundle bundle = new Bundle();
        bundle.putString("classId", dataBeans.get(position).getTpNodeId());
        bundle.putString("classTypeId", dataBeans.get(position).getTpId());
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getCount() {
        return dataBeans.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String plateName = dataBeans.get(position).getTpName();
        if (plateName == null) {
            plateName = "";
        } else if (plateName.length() > 5) {
            plateName = plateName.substring(0, 5) + "...";
        }
        return plateName;
    }
}
