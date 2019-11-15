package com.bawei.dimensionsofthefilm.moviefrgment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.dimensionsofthefilm.R;
import com.bawei.dimensionsofthefilm.adapter.FilmreviewAdapter;
import com.bawei.dimensionsofthefilm.base.BaseFragmente;
import com.bawei.dimensionsofthefilm.contract.DataColl;
import com.bawei.dimensionsofthefilm.model.Data;
import com.bawei.dimensionsofthefilm.model.Filmreview;
import com.bawei.dimensionsofthefilm.presenter.FilmreviewPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/*时间:2019/11/12
创建人:yang 
创建人:杨靖宇*/
public class FilmreviewFragment extends BaseFragmente {
    @BindView(R.id.recy_yp)
    RecyclerView recyYp;
    Unbinder unbinder;
    private FilmreviewAdapter filmreviewAdapter;

    @Override
    public View getLayoutID(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.filmreview_layout, null, false);
        return view;
    }

    @Override
    public void initView() {

        Intent intent = getActivity().getIntent();
        int hotshowing = intent.getIntExtra("hotshowing", 0);

        FilmreviewPresenter filmreviewPresenter = new FilmreviewPresenter(new filmreviewColl());
        filmreviewPresenter.reqsuetData(hotshowing, 1, 5);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        filmreviewAdapter = new FilmreviewAdapter(getContext());
        recyYp.setLayoutManager(linearLayoutManager);
        recyYp.setAdapter(filmreviewAdapter);


    }





    class filmreviewColl implements DataColl<List<Filmreview>> {
        @Override
        public void suuess(List<Filmreview> rese) {

            Log.i("aaa", "suuess: "+rese);
            filmreviewAdapter.addAll(rese);
            filmreviewAdapter.notifyDataSetChanged();

        }

        @Override
        public void failure(Data data) {

        }
    }
}
