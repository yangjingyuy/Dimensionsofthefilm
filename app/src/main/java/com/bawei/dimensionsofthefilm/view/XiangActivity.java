package com.bawei.dimensionsofthefilm.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.bawei.dimensionsofthefilm.R;
import com.bawei.dimensionsofthefilm.base.BaseActivity;
import com.bawei.dimensionsofthefilm.fragment.Yypingj_Fragment;
import com.bawei.dimensionsofthefilm.fragment.Yyxiangq_Fragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 影院详情页
 */
public class XiangActivity extends BaseActivity {

    @BindView(R.id.sdyanj)
    BorderTextView sdyanj;
    @BindView(R.id.ertong)
    BorderTextView ertong;
    @BindView(R.id.k)
    BorderTextView k;
    private ArrayList<Fragment> list = new ArrayList<>();
    private ArrayList<String> listtab = new ArrayList<>();
    @BindView(R.id.table1)
    TabLayout table1;
    @BindView(R.id.view_pager1)
    ViewPager viewPager1;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_xiang;
    }

    @Override
    protected void initView() {


        list.add(new Yyxiangq_Fragment());
        list.add(new Yypingj_Fragment());

        listtab.add("影院详情");
        listtab.add("影院评价");

        viewPager1.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
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
        table1.setupWithViewPager(viewPager1);
    }



}
