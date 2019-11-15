package com.bawei.dimensionsofthefilm.moviefrgment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.dimensionsofthefilm.R;
import com.bawei.dimensionsofthefilm.adapter.FilmreviewAdapter;
import com.bawei.dimensionsofthefilm.adapter.ForeshowAdapter;
import com.bawei.dimensionsofthefilm.base.BaseFragmente;
import com.bawei.dimensionsofthefilm.contract.DataColl;
import com.bawei.dimensionsofthefilm.model.Data;
import com.bawei.dimensionsofthefilm.model.Particulars;
import com.bawei.dimensionsofthefilm.model.ShortFilmList;
import com.bawei.dimensionsofthefilm.presenter.ParticularsPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/*时间:2019/11/12
创建人:yang 
创建人:杨靖宇*/
public class ForeshowFragment extends BaseFragmente {

    Unbinder unbinder;
    @BindView(R.id.recyc_sp)
    RecyclerView recycSp;
    Unbinder unbinder1;
    private ForeshowAdapter foreshowAdapter;

    @Override
    public View getLayoutID(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.foreshow_layout, null, false);
        return view;
    }

    @Override
    public void initView() {
/*
        spJzvid.setUp();*/


        Intent intent = getActivity().getIntent();
        int hotshowing = intent.getIntExtra("hotshowing", 0);

        ParticularsPresenter particularsPresenter = new ParticularsPresenter(new spColl());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recycSp.setLayoutManager(linearLayoutManager);
        foreshowAdapter = new ForeshowAdapter(getContext());
        recycSp.setAdapter(foreshowAdapter);
        particularsPresenter.reqsuetData(hotshowing);



    }

    class spColl implements DataColl<Particulars> {

        private String videoUrl;

        @Override
        public void suuess(Particulars rese) {
            List<ShortFilmList> shortFilmList = rese.shortFilmList;
            foreshowAdapter.addAll(shortFilmList);
            foreshowAdapter.notifyDataSetChanged();

        }

        @Override
        public void failure(Data data) {

        }
    }

    /*@Override
    public void onBackPressed() {
        if (JZVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }
    @Override
    protected void onPause() {
        super.onPause();
        JZVideoPlayer.releaseAllVideos();
    }*/

}
