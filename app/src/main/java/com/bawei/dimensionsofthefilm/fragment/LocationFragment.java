package com.bawei.dimensionsofthefilm.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.dimensionsofthefilm.R;
import com.bawei.dimensionsofthefilm.adapter.AreaAdapter;
import com.bawei.dimensionsofthefilm.adapter.AreaQueryAdapter;
import com.bawei.dimensionsofthefilm.base.BaseFragmente;
import com.bawei.dimensionsofthefilm.contract.DataColl;
import com.bawei.dimensionsofthefilm.model.Area;
import com.bawei.dimensionsofthefilm.model.AreaQuery;
import com.bawei.dimensionsofthefilm.model.Data;
import com.bawei.dimensionsofthefilm.presenter.AreaPresenter;
import com.bawei.dimensionsofthefilm.presenter.AreaQueryPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/*时间:2019/11/8
创建人:yang 
创建人:杨靖宇*/
public class LocationFragment extends BaseFragmente implements DataColl<List<Area>> {

    @BindView(R.id.area_recyc)
    RecyclerView areaRecyc;
    Unbinder unbinder;
    @BindView(R.id.area_query_recyc)
    RecyclerView areaQueryRecyc;
    Unbinder unbinder1;
    private View view;
    private AreaAdapter areaAdapter;
    private AreaQueryPresenter areaQueryPresenter;
    private AreaQueryAdapter areaQueryAdapter;

    @Override
    public View getLayoutID(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.location_layout, null, false);
        return view;
    }

    @Override
    public void initView() {

        //查询区域列表
        AreaPresenter areaPresenter = new AreaPresenter(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        areaAdapter = new AreaAdapter(getContext());
        areaRecyc.setAdapter(areaAdapter);
        areaRecyc.setLayoutManager(linearLayoutManager);
        areaPresenter.reqsuetData();

        //根据区域查询影院
        areaQueryPresenter = new AreaQueryPresenter(new areaquColl());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        areaQueryRecyc.setLayoutManager(layoutManager);
        areaQueryAdapter = new AreaQueryAdapter(getContext());
        areaQueryRecyc.setAdapter(areaQueryAdapter);



        areaAdapter.setOnActi(new AreaAdapter.OnActi() {
            @Override
            public void onActi(int i) {
                /* Toast.makeText(getContext(), ""+i, Toast.LENGTH_SHORT).show();*/
                areaQueryPresenter.reqsuetData(i);

            }
        });

    }

    //根据区域查询影院

    class areaquColl implements DataColl<List<AreaQuery>> {

        @Override
        public void suuess(List<AreaQuery> rese) {
            areaQueryAdapter.clear();
            Log.i("aaa", "suuess: "+rese);
            areaQueryAdapter.addAll(rese);
            areaQueryAdapter.notifyDataSetChanged();
        }

        @Override
        public void failure(Data data) {

        }
    }


    //查询区域成功
    @Override
    public void suuess(List<Area> rese) {

        areaAdapter.addAll(rese);
        areaAdapter.notifyDataSetChanged();

    }

    //查询区域失败
    @Override
    public void failure(Data data) {

    }
}
