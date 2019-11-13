package com.bawei.dimensionsofthefilm.moviefrgment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bawei.dimensionsofthefilm.R;
import com.bawei.dimensionsofthefilm.adapter.DayinAdapter;
import com.bawei.dimensionsofthefilm.adapter.YanyuanAdapter;
import com.bawei.dimensionsofthefilm.base.BaseFragmente;
import com.bawei.dimensionsofthefilm.contract.DataColl;
import com.bawei.dimensionsofthefilm.model.Data;
import com.bawei.dimensionsofthefilm.model.MovieActor;
import com.bawei.dimensionsofthefilm.model.MovieDirector;
import com.bawei.dimensionsofthefilm.model.Particulars;
import com.bawei.dimensionsofthefilm.presenter.ParticularsPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/*时间:2019/11/12
创建人:yang 
创建人:杨靖宇*/
public class IntroduceFragment extends BaseFragmente {
    @BindView(R.id.tv_juqing)
    TextView tvJuqing;
    @BindView(R.id.tv_daoyin)
    TextView tvDaoyin;
    @BindView(R.id.item_daoyin_rec)
    RecyclerView itemDaoyinRec;
    @BindView(R.id.tv_yanyuan)
    TextView tvYanyuan;
    @BindView(R.id.item_yanyuan_rec)
    RecyclerView itemYanyuanRec;
    Unbinder unbinder;
    private DayinAdapter dayinAdapter;
    private YanyuanAdapter yanyuanAdapter;

    @Override
    public View getLayoutID(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.introduce_layout, null, false);
        return view;
    }

    @Override
    public void initView() {

        Intent intent = getActivity().getIntent();
        int hotshowing = intent.getIntExtra("hotshowing", 0);

        ParticularsPresenter particularsPresenter = new ParticularsPresenter(new particularsColl());
        particularsPresenter.reqsuetData(hotshowing);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(getContext(),4);

        itemYanyuanRec.setLayoutManager(gridLayoutManager);
        itemDaoyinRec.setLayoutManager(linearLayoutManager);

        yanyuanAdapter = new YanyuanAdapter(getContext());
        itemYanyuanRec.setAdapter(yanyuanAdapter);

        dayinAdapter = new DayinAdapter(getContext());
        itemDaoyinRec.setAdapter(dayinAdapter);




    }

    class particularsColl implements DataColl<Particulars> {
        @Override
        public void suuess(Particulars rese) {
            tvJuqing.setText(rese.summary);
            tvDaoyin.setText("导演("+rese.movieDirector.size()+")");
            tvYanyuan.setText("演员("+rese.movieActor.size()+")");

            List<MovieDirector> movieDirector = rese.movieDirector;
            dayinAdapter.addAll(movieDirector);
            dayinAdapter.notifyDataSetChanged();

            List<MovieActor> movieActor = rese.movieActor;
            yanyuanAdapter.addAll(movieActor);
            yanyuanAdapter.notifyDataSetChanged();

        }

        @Override
        public void failure(Data data) {

        }
    }

    /*class dayinColl implements DataColl<List<MovieDirector>>{
        @Override
        public void suuess(List<MovieDirector> rese) {

    }

        @Override
        public void failure(Data data) {

        }
    }*/
}
