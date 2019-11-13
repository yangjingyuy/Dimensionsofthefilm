package com.bawei.dimensionsofthefilm.view;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.bawei.dimensionsofthefilm.R;
import com.bawei.dimensionsofthefilm.adapter.MyPaiqiadapter;
import com.bawei.dimensionsofthefilm.base.BaseActivity;
import com.bawei.dimensionsofthefilm.contract.DataColl;
import com.bawei.dimensionsofthefilm.model.Data;
import com.bawei.dimensionsofthefilm.model.Paiqi;
import com.bawei.dimensionsofthefilm.presenter.PaiqiPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PaiActivity extends BaseActivity {


    @BindView(R.id.paiqiview)
    RecyclerView paiqiview;
    private PaiqiPresenter paiqiPresenter;
    private LinearLayoutManager linearLayoutManager;
    private MyPaiqiadapter myPaiqiadapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_pai;
    }

    @Override
    protected void initView() {
        paiqiPresenter = new PaiqiPresenter(new paiqi());
        paiqiPresenter.reqsuetData(1, 1, 5);




    }



    class paiqi implements DataColl<List<Paiqi>> {

        @Override
        public void suuess(List<Paiqi> rese) {

            Log.d("aaa", "suuess: " + rese.get(0).name);
        }

        @Override
        public void failure(Data data) {

        }
    }
}
