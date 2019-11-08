package com.bawei.dimensionsofthefilm.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bawei.dimensionsofthefilm.R;
import com.bawei.dimensionsofthefilm.adapter.HotAdapter;
import com.bawei.dimensionsofthefilm.base.BaseFragmente;
import com.bawei.dimensionsofthefilm.contract.DataColl;
import com.bawei.dimensionsofthefilm.model.Banner;
import com.bawei.dimensionsofthefilm.model.Data;
import com.bawei.dimensionsofthefilm.model.Hot;
import com.bawei.dimensionsofthefilm.presenter.BannerPresenter;
import com.bawei.dimensionsofthefilm.presenter.HotPresenter;
import com.bumptech.glide.Glide;
import com.stx.xhb.xbanner.XBanner;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/*时间:2019/11/6
创建人:yang 
创建人:杨靖宇*/
public class MovieFragment extends BaseFragmente {

    @BindView(R.id.xbander)
    XBanner xbander;
    Unbinder unbinder;
    @BindView(R.id.recy_hot)
    RecyclerView recyHot;
    private View view;
    private HotAdapter hotAdapter;

    @Override
    public View getLayoutID(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.movie_layout, null, false);
        return view;
    }

    @Override
    public void initView() {
        //轮播图
        BannerPresenter bannerPresenter = new BannerPresenter(new bannerColl());
        bannerPresenter.reqsuetData();
        //热门电影
        HotPresenter hotPresenter = new HotPresenter(new hotColl());
        hotPresenter.reqsuetData(1, 5);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        hotAdapter = new HotAdapter(getContext());
        recyHot.setAdapter(hotAdapter);
        recyHot.setLayoutManager(linearLayoutManager);




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

    //轮播图
    class bannerColl implements DataColl<List<Banner>> {
        @Override
        public void suuess(final List<Banner> rese) {

            xbander.setData(rese, null);
            xbander.setmAdapter(new XBanner.XBannerAdapter() {
                @Override
                public void loadBanner(XBanner banner, View view, int position) {
                    Glide.with(getContext()).load(rese.get(position).imageUrl).into((ImageView) view);
                }
            });

        }

        @Override
        public void failure(Data data) {

        }
    }
    //热门电影
    class hotColl implements DataColl<List<Hot>> {
        @Override
        public void suuess(List<Hot> rese) {
            hotAdapter.addAll(rese);
            hotAdapter.notifyDataSetChanged();

        }

        @Override
        public void failure(Data data) {

        }
    }
}
