package com.bawei.dimensionsofthefilm.view;

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

public class MovieActivity extends BaseActivity {

    @BindView(R.id.movie_vp)
    ViewPager movieVp;
    @BindView(R.id.movie_rg)
    RadioGroup movieRg;

    private ArrayList<Fragment> list = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.activity_hom;
    }

    @Override
    protected void initView() {


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

        movieRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.movie_btn1:
                        movieVp.setCurrentItem(0);
                        break;
                    case R.id.movie_btn2:
                        movieVp.setCurrentItem(1);
                        break;
                    case R.id.movie_btn3:
                        movieVp.setCurrentItem(2);
                        break;

                }
            }
        });

    }



}
