package com.bawei.dimensionsofthefilm.view;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.dimensionsofthefilm.R;
import com.bawei.dimensionsofthefilm.base.BaseActivity;
import com.bawei.dimensionsofthefilm.contract.DataColl;
import com.bawei.dimensionsofthefilm.model.Data;
import com.bawei.dimensionsofthefilm.model.Particulars;
import com.bawei.dimensionsofthefilm.moviefrgment.FilmreviewFragment;
import com.bawei.dimensionsofthefilm.moviefrgment.ForeshowFragment;
import com.bawei.dimensionsofthefilm.moviefrgment.IntroduceFragment;
import com.bawei.dimensionsofthefilm.moviefrgment.StagephotoFragment;
import com.bawei.dimensionsofthefilm.presenter.ParticularsPresenter;
import com.bumptech.glide.Glide;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HotShowingActivity extends BaseActivity {
    private static final String TAG = "HotShowingActivity";
    @BindView(R.id.poster)
    ImageView poster;
    @BindView(R.id.returnhot)
    ImageView returnhot;
    @BindView(R.id.score)
    TextView score;
    @BindView(R.id.comment)
    TextView comment;
    @BindView(R.id.movie_name)
    TextView movieName;
    @BindView(R.id.movie_type)
    TextView movieType;
    @BindView(R.id.movie_duration)
    TextView movieDuration;
    @BindView(R.id.movie_time)
    TextView movieTime;
    @BindView(R.id.movie_area)
    TextView movieArea;
    @BindView(R.id.emptyfalse)
    ImageView emptyfalse;
    @BindView(R.id.emptytrue)
    ImageView emptytrue;
    @BindView(R.id.movie_tab)
    TabLayout movieTab;
    @BindView(R.id.movie_pager)
    ViewPager moviePager;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_hot_showing;
    }

    @Override
    protected void initView() {



        Intent intent = getIntent();
        int hotshowing = intent.getIntExtra("hotshowing", 0);
        Log.i(TAG, "initView: " + hotshowing);
        ParticularsPresenter particularsPresenter = new ParticularsPresenter(new particularsColl());
        particularsPresenter.reqsuetData(hotshowing);

        final ArrayList<Fragment> list=new ArrayList<>();
        final ArrayList<String> listab=new ArrayList<>();
        list.add(new IntroduceFragment());
        list.add(new ForeshowFragment());
        list.add(new StagephotoFragment());
        list.add(new FilmreviewFragment());
        listab.add("介绍");
        listab.add("预告");
        listab.add("剧照");
        listab.add("影评");

        moviePager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return list.get(i);
            }

            @Override
            public int getCount() {
                return list.size();
            }

           // getPageTitle

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return listab.get(position);
            }
        });
        movieTab.setupWithViewPager(moviePager);


    }



    class particularsColl implements DataColl<Particulars> {

        @Override
        public void suuess(Particulars rese) {
            String duration = rese.duration;
            String imageUrl = rese.imageUrl;

            score.setText("评分  " + rese.score + "分");
            comment.setText("评论  " + rese.commentNum + "万条");
            movieName.setText(rese.name);
            movieType.setText(rese.movieType);
            movieDuration.setText(rese.duration);
            Date date = new Date(rese.releaseTime);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
            movieTime.setText(String.valueOf(simpleDateFormat.format(date) + "上映"));
            movieArea.setText(rese.placeOrigin);
            Glide.with(HotShowingActivity.this).load(imageUrl).into(poster);
        }

        @Override
        public void failure(Data data) {

        }
    }
}
