package com.bawei.dimensionsofthefilm.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.dimensionsofthefilm.R;
import com.bawei.dimensionsofthefilm.adapter.Myguanzhuadapter;
import com.bawei.dimensionsofthefilm.base.BaseFragmente;
import com.bawei.dimensionsofthefilm.contract.DataColl;
import com.bawei.dimensionsofthefilm.model.Data;
import com.bawei.dimensionsofthefilm.model.Guanzhu;
import com.bawei.dimensionsofthefilm.presenter.GuanzhuPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class YingyuanFragment extends BaseFragmente {

    @BindView(R.id.guanzhurecyview)
    RecyclerView guanzhurecyview;
    Unbinder unbinder;
    private View view;
    private GuanzhuPresenter guanzhuPresenter;
    private LinearLayoutManager linearLayoutManager;
    private Myguanzhuadapter myguanzhuadapter;

    @Override
    public View getLayoutID(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.yingyuan_layout, container, false);
        return view;
    }

    @Override
    public void initView() {

        guanzhuPresenter = new GuanzhuPresenter(new guanzhu());
        guanzhuPresenter.guanzhu(13775, "157347192443413775", 1, 5);

        linearLayoutManager = new LinearLayoutManager(getContext());
          guanzhurecyview.setLayoutManager(linearLayoutManager);

        myguanzhuadapter = new Myguanzhuadapter(getContext());
           guanzhurecyview.setAdapter(myguanzhuadapter);

    }


    class guanzhu implements DataColl<List<Guanzhu>> {

        @Override
        public void suuess(List<Guanzhu> rese) {
            Log.d("aaa", "suuess: " + rese.get(0).name);
            myguanzhuadapter.addAll(rese);
            myguanzhuadapter.notifyDataSetChanged();

        }

        @Override
        public void failure(Data data) {

        }
    }


}
