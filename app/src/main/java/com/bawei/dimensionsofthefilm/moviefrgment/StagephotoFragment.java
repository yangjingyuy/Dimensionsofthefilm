package com.bawei.dimensionsofthefilm.moviefrgment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.dimensionsofthefilm.R;
import com.bawei.dimensionsofthefilm.adapter.JuzhaoAdapter;
import com.bawei.dimensionsofthefilm.base.BaseFragmente;
import com.bawei.dimensionsofthefilm.contract.DataColl;
import com.bawei.dimensionsofthefilm.model.Data;
import com.bawei.dimensionsofthefilm.model.Particulars;
import com.bawei.dimensionsofthefilm.presenter.ParticularsPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/*时间:2019/11/12
创建人:yang 
创建人:杨靖宇*/
public class StagephotoFragment extends BaseFragmente {
    @BindView(R.id.recy_juzhao)
    RecyclerView recyJuzhao;
    Unbinder unbinder;
    private JuzhaoAdapter juzhaoAdapter;

    @Override
    public View getLayoutID(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.stagephoto_layout, null, false);
        return view;
    }

    @Override
    public void initView() {

        Intent intent = getActivity().getIntent();
        int hotshowing = intent.getIntExtra("hotshowing", 0);
        ParticularsPresenter particularsPresenter = new ParticularsPresenter(new juzhaoColl());
        particularsPresenter.reqsuetData(hotshowing);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(getContext(),3);
        recyJuzhao.setLayoutManager(gridLayoutManager);
        juzhaoAdapter = new JuzhaoAdapter(getContext());
        recyJuzhao.setAdapter(juzhaoAdapter);

    }

        class juzhaoColl implements DataColl<Particulars> {

            @Override
            public void suuess(Particulars rese) {
                List<String> posterList = rese.posterList;
                juzhaoAdapter.addAll(posterList);
                juzhaoAdapter.notifyDataSetChanged();

            }

            @Override
            public void failure(Data data) {

            }
        }

}
