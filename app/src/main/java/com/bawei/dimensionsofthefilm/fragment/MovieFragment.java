package com.bawei.dimensionsofthefilm.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bawei.dimensionsofthefilm.R;
import com.bawei.dimensionsofthefilm.adapter.HotAdapter;
import com.bawei.dimensionsofthefilm.adapter.Myrecyclview;
import com.bawei.dimensionsofthefilm.adapter.Myrecyview3adapter;
import com.bawei.dimensionsofthefilm.base.BaseFragmente;
import com.bawei.dimensionsofthefilm.contract.DataColl;
import com.bawei.dimensionsofthefilm.model.Banner;
import com.bawei.dimensionsofthefilm.model.Data;
import com.bawei.dimensionsofthefilm.model.Hot;
import com.bawei.dimensionsofthefilm.model.Jijiangshangying;
import com.bawei.dimensionsofthefilm.model.Zhengzaishangying;
import com.bawei.dimensionsofthefilm.presenter.BannerPresenter;
import com.bawei.dimensionsofthefilm.presenter.HotPresenter;
import com.bawei.dimensionsofthefilm.presenter.JijiangshangsgiPresenter;
import com.bawei.dimensionsofthefilm.presenter.ZhengzaishangyingPresenter;
import com.bawei.dimensionsofthefilm.view.HotActivity;
import com.bawei.dimensionsofthefilm.view.HotShowingActivity;
import com.bumptech.glide.Glide;
import com.stx.xhb.xbanner.XBanner;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/*时间:2019/11/6
创建人:yang 
创建人:杨靖宇*/
public class MovieFragment extends BaseFragmente {

    @BindView(R.id.xbander)
    XBanner xbander;
    @BindView(R.id.recy_hot)
    RecyclerView recyHot;
    Unbinder unbinder;
    @BindView(R.id.search)
    ImageView search;
    Unbinder unbinder1;

    private View view;
    private HotAdapter hotAdapter;
    private RecyclerView recyclerView2;
    private RecyclerView recyclerView3;
    private JijiangshangsgiPresenter jijiangshangsgiPresenter;
    private LinearLayoutManager linearLayoutManager1;
    private Myrecyclview myrecyclview;
    private ZhengzaishangyingPresenter zhengzaishangyingPresenter;
    private LinearLayoutManager linearLayoutManager2;
    private Myrecyview3adapter myrecyview3adapter;

    @Override
    public View getLayoutID(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.movie_layout, null, false);
    }

    @Override
    public void initView() {
        recyclerView2 = getView().findViewById(R.id.recyer_view2);
        recyclerView3 = getView().findViewById(R.id.recyer_view3);
        //轮播图
        BannerPresenter bannerPresenter = new BannerPresenter(new bannerColl());
        //正在热映电影
        HotPresenter hotPresenter = new HotPresenter(new hotColl());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyHot.setLayoutManager(linearLayoutManager);
        hotAdapter = new HotAdapter(getContext());
        recyHot.setAdapter(hotAdapter);
        //即将上市电影
        jijiangshangsgiPresenter = new JijiangshangsgiPresenter(new jijiang());
        linearLayoutManager1 = new LinearLayoutManager(getContext());
        recyclerView2.setLayoutManager(linearLayoutManager1);
        myrecyclview = new Myrecyclview(getContext());
        recyclerView2.setAdapter(myrecyclview);
        //正在上市电影
        zhengzaishangyingPresenter = new ZhengzaishangyingPresenter(new zhengzaishangshi());
        linearLayoutManager2 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView3.setLayoutManager(linearLayoutManager2);
        myrecyview3adapter = new Myrecyview3adapter(getContext());
        recyclerView3.setAdapter(myrecyview3adapter);
        //请求
        bannerPresenter.reqsuetData();
        hotPresenter.reqsuetData(1, 5);
        jijiangshangsgiPresenter.reqsuetData(1, 5);
        zhengzaishangyingPresenter.reqsuetData(1, 5);

    }
    //点击搜索
    @OnClick(R.id.search)
    public void onClick() {
        Intent intent=new Intent(getContext(), HotActivity.class);
        startActivity(intent);

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

    //正在热映电影
    class hotColl implements DataColl<List<Hot>> {
        @Override
        public void suuess(final List<Hot> rese) {

            hotAdapter.addAll(rese);
            hotAdapter.notifyDataSetChanged();
            //正在热映电影
            hotAdapter.setListener(new HotAdapter.OnItemClickListener() {


                private int movieId;

                @Override
                public void onClick(View view, int position) {
                    for (int i = 0; i < rese.size(); i++) {
                        movieId = rese.get(position).movieId;
                    }
                   // Toast.makeText(getContext(), "点击了" + movieId, Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(getContext(), HotShowingActivity.class);
                    intent.putExtra("hotshowing", movieId);
                    startActivity(intent);
                }
            });

        }

        @Override
        public void failure(Data data) {

        }
    }


    //即将上映电影
    class jijiang implements DataColl<List<Jijiangshangying>> {

        private int movieId;

        @Override
        public void suuess(final List<Jijiangshangying> rese) {
            myrecyclview.addAll(rese);
            myrecyclview.notifyDataSetChanged();

            //点击
            myrecyclview.setListenerSying(new Myrecyclview.OnItemClickListener() {
                @Override
                public void onClick(View view, int position) {
                    for (int i = 0; i < rese.size(); i++) {
                        movieId = rese.get(position).movieId;
                    }
               /*    // Toast.makeText(getContext(), "点击了"+movieId, Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(getContext(), ShowActivity.class);
                    intent.putExtra("show",movieId);
                    startActivity(intent);*/
                    Intent intent = new Intent(getContext(), HotShowingActivity.class);
                    intent.putExtra("hotshowing", movieId);
                    startActivity(intent);

                }
            });

        }

        @Override
        public void failure(Data data) {

        }
    }

    //正在上市电影
    class zhengzaishangshi implements DataColl<List<Zhengzaishangying>> {

        @Override
        public void suuess(final List<Zhengzaishangying> rese) {
            myrecyview3adapter.addAll(rese);
            myrecyview3adapter.notifyDataSetChanged();
            //点击
            myrecyview3adapter.setListenerhotmy(new Myrecyview3adapter.OnItemClickListener() {


                private int movieId;

                @Override
                public void onClick(View view, int position) {
                    for (int i = 0; i < rese.size(); i++) {
                        movieId = rese.get(position).movieId;
                    }
                  /*  Toast.makeText(getContext(), "点击了"+movieId, Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(getContext(), HotActivity.class);
                    intent.putExtra("hot",movieId);
                    startActivity(intent);*/
                    Intent intent = new Intent(getContext(), HotShowingActivity.class);
                    intent.putExtra("hotshowing", movieId);
                    startActivity(intent);


                }
            });

        }

        @Override
        public void failure(Data data) {

        }
    }


}
