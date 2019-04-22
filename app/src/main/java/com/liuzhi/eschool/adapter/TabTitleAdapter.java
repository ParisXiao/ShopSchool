package com.liuzhi.eschool.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.liuzhi.eschool.entity.TabTitleEntity;
import com.liuzhi.eschool.view.fragment.TabFragment;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TabTitleAdapter extends FragmentPagerAdapter {
    private List<TabTitleEntity> dataBeans = null;

    public TabTitleAdapter(FragmentManager fm) {
        super(fm);
        this.dataBeans = new ArrayList<>();
    }

    /**
     * 数据列表
     *
     * @param datas
     */
    public void setDataList(List<TabTitleEntity> datas) {
        this.dataBeans.clear();
        this.dataBeans.addAll(datas);
        notifyDataSetChanged();
    }

    @Override
    public Fragment getItem(int position) {
        TabFragment fragment = new TabFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("TabId", dataBeans.get(position).getTabId());
        if (dataBeans.get(position).getEntitys()!=null){
            bundle.putSerializable("TabEntity", (Serializable) dataBeans.get(position).getEntitys());
        }
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getCount() {
        return dataBeans.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String plateName = "";
        if (dataBeans.get(position).isRed()) {
            plateName = dataBeans.get(position).getTitleName() + "(" + dataBeans.get(position).getDataSize() + ")";
        } else {
            plateName = dataBeans.get(position).getTitleName();
        }
        if (plateName.length() > 8) {
            plateName = plateName.substring(0, 8) + "...";
        }
        return plateName;
    }
}
