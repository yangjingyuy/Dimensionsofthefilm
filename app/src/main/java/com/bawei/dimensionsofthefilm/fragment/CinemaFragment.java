package com.bawei.dimensionsofthefilm.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.dimensionsofthefilm.R;
import com.bawei.dimensionsofthefilm.base.BaseFragmente;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/*时间:2019/11/6
创建人:yang 
创建人:杨靖宇*/
public class CinemaFragment extends BaseFragmente {

    @BindView(R.id.cinema_tab)
    TabLayout cinemaTab;
    @BindView(R.id.cinema_vp)
    ViewPager cinemaVp;
    Unbinder unbinder;
    private View view;
    private ArrayList<Fragment> list = new ArrayList<>();
    private ArrayList<String> listtab = new ArrayList<>();

    @Override
    public View getLayoutID(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.cinema_layout, null, false);
        return view;
    }

    @Override
    public void initView() {
        list.add(new RecommendFragment());
        list.add(new NearbyFragment());
        list.add(new LocationFragment());
        listtab.add("推荐影院");
        listtab.add("附近影院");
        listtab.add("海淀区");
        cinemaVp.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return list.get(i);
            }

            @Override
            public int getCount() {
                return list.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return listtab.get(position);
            }
        });
        cinemaTab.setupWithViewPager(cinemaVp);


    }


}
