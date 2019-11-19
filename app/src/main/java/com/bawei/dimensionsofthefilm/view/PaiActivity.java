package com.bawei.dimensionsofthefilm.view;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.bawei.dimensionsofthefilm.R;
import com.bawei.dimensionsofthefilm.base.BaseActivity;
import com.bawei.dimensionsofthefilm.fragment.Paiqi1_fragment;
import com.bawei.dimensionsofthefilm.fragment.Paiqi2_fragment;
import com.bawei.dimensionsofthefilm.fragment.Paiqi3_fragment;
import com.bawei.dimensionsofthefilm.fragment.Paiqi4_fragment;
import com.bawei.dimensionsofthefilm.fragment.Paiqi5_fragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class PaiActivity extends BaseActivity {


    @BindView(R.id.table2)
    TabLayout table2;
    @BindView(R.id.view_pager2)
    ViewPager viewPager2;

    private ArrayList<Fragment> list = new ArrayList<>();
    private ArrayList<String> listtab = new ArrayList<>();
    @Override
    protected int getLayoutId() {
        return R.layout.activity_pai;
    }

    @Override
    protected void initView() {
         list.add(new Paiqi1_fragment());
        list.add(new Paiqi2_fragment());
        list.add(new Paiqi3_fragment());
        list.add(new Paiqi4_fragment());
        list.add(new Paiqi5_fragment());

        listtab.add("今天 05-27");
        listtab.add("明天 05-28");
        listtab.add("后天 05-29");
        listtab.add("周四 05-30");
        listtab.add("周五 05-31");

         viewPager2.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
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
         table2.setupWithViewPager(viewPager2);

    }


}
