package com.bawei.dimensionsofthefilm.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.dimensionsofthefilm.R;
import com.bawei.dimensionsofthefilm.adapter.RecommendAdapter;
import com.bawei.dimensionsofthefilm.base.BaseFragmente;
import com.bawei.dimensionsofthefilm.contract.DataColl;
import com.bawei.dimensionsofthefilm.model.Data;
import com.bawei.dimensionsofthefilm.model.Recommend;
import com.bawei.dimensionsofthefilm.presenter.RecommendPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/*时间:2019/11/8
创建人:yang 
创建人:杨靖宇*/
public class RecommendFragment extends BaseFragmente {
    @BindView(R.id.recommemd_recyc)
    RecyclerView recommemdRecyc;
    Unbinder unbinder;
    private View view;
    private RecommendAdapter recommendAdapter;

    @Override
    public View getLayoutID(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.recommend_layout, null, false);
        return view;
    }

    @Override
    public void initView() {
        //查询推荐影院信息
        RecommendPresenter recommendPresenter=new RecommendPresenter(new cecomColl());
        recommendPresenter.reqsuetData(1,10);
        //推荐影院信息 适配器
        recommendAdapter = new RecommendAdapter(getContext());
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        recommemdRecyc.setLayoutManager(linearLayoutManager);
        recommemdRecyc.setAdapter(recommendAdapter);


    }
    //查询推荐影院信息
    class cecomColl implements DataColl<List<Recommend>>{
        @Override
        public void suuess(List<Recommend> rese) {
            recommendAdapter.addAll(rese);
            recommendAdapter.notifyDataSetChanged();
        }

        @Override
        public void failure(Data data) {

        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
