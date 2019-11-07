package com.bawei.dimensionsofthefilm.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.dimensionsofthefilm.R;
import com.bawei.dimensionsofthefilm.base.BaseFragmente;
import com.bawei.dimensionsofthefilm.contract.DataColl;
import com.bawei.dimensionsofthefilm.model.Banner;
import com.bawei.dimensionsofthefilm.model.Data;
import com.bawei.dimensionsofthefilm.presenter.BannerPresenter;

import java.util.List;

/*时间:2019/11/6
创建人:yang 
创建人:杨靖宇*/
public class MovieFragment extends BaseFragmente {

    private View view;

    @Override
    public View getLayoutID(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.movie_layout, null, false);
        return view;
    }

    @Override
    public void initView() {
        BannerPresenter bannerPresenter=new BannerPresenter(new bannerColl());
        bannerPresenter.reqsuetData();


    }
    //轮播图
    class bannerColl implements DataColl<List<Banner>>{
        @Override
        public void suuess(List<Banner> rese) {

        }

        @Override
        public void failure(Data data) {

        }
    }
}
