package com.bawei.dimensionsofthefilm.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.RadioGroup;

import com.bawei.dimensionsofthefilm.R;
import com.bawei.dimensionsofthefilm.base.BaseActivity;
import com.bawei.dimensionsofthefilm.fragment.CinemaFragment;
import com.bawei.dimensionsofthefilm.fragment.MovieFragment;
import com.bawei.dimensionsofthefilm.fragment.MyFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieActivity extends BaseActivity {

    @BindView(R.id.movie_vp)
    ViewPager movieVp;
    private ArrayList<Fragment> list = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {

        //孔平平写的
        //添加fragemnt
        list.add(new MovieFragment());
        list.add(new CinemaFragment());
        list.add(new MyFragment());
        movieVp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return list.get(i);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });
    }




}
