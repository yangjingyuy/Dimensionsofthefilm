package com.bawei.dimensionsofthefilm.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.dimensionsofthefilm.R;
import com.bawei.dimensionsofthefilm.adapter.MyPaiqiadapter;
import com.bawei.dimensionsofthefilm.base.BaseFragmente;
import com.bawei.dimensionsofthefilm.contract.DataColl;
import com.bawei.dimensionsofthefilm.model.Data;
import com.bawei.dimensionsofthefilm.model.Paiqi;
import com.bawei.dimensionsofthefilm.presenter.PaiqiPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class Paiqi1_fragment extends BaseFragmente {

    @BindView(R.id.recommed_recyerview)
    RecyclerView recommedRecyerview;
    Unbinder unbinder;
    private View view;
    private LinearLayoutManager linearLayoutManager;
    private MyPaiqiadapter myPaiqiadapter;
    private PaiqiPresenter paiqiPresenter;

    @Override
    public View getLayoutID(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.p1_layout, container, false);
        return view;
    }

    @Override
    public void initView() {

        linearLayoutManager = new LinearLayoutManager(getContext());
        recommedRecyerview.setLayoutManager(linearLayoutManager);
        paiqiPresenter = new PaiqiPresenter(new paiqi());
         paiqiPresenter.reqsuetData(1,1,5);
        myPaiqiadapter = new MyPaiqiadapter(getContext());
          recommedRecyerview.setAdapter(myPaiqiadapter);

    }


      class paiqi implements DataColl<List<Paiqi>>{

          @Override
          public void suuess(List<Paiqi> rese) {
              Log.d("aaa", "suuess: "+rese.get(0).name);
              myPaiqiadapter.addAll(rese);
              myPaiqiadapter.notifyDataSetChanged();

          }

          @Override
          public void failure(Data data) {

          }
      }
}
