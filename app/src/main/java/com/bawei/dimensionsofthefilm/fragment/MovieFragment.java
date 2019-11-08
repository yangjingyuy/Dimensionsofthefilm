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
        view = inflater.inflate(R.layout.movie_layout, null, false);
        recyclerView2 = view.findViewById(R.id.recyer_view2);
        recyclerView3 = view.findViewById(R.id.recyer_view3);
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


        //即将上市电影
        jijiangshangsgiPresenter = new JijiangshangsgiPresenter(new jijiang());
                jijiangshangsgiPresenter.reqsuetData(1,5);

        linearLayoutManager1 = new LinearLayoutManager(getContext());
        myrecyclview = new Myrecyclview(getContext());
       recyclerView2.setAdapter(myrecyclview);
       recyclerView2.setLayoutManager(linearLayoutManager1);

       //正在上市电影

        zhengzaishangyingPresenter = new ZhengzaishangyingPresenter(new zhengzaishangshi());
        zhengzaishangyingPresenter.reqsuetData(1,5);
        linearLayoutManager2 = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        myrecyview3adapter = new Myrecyview3adapter(getContext());
        recyclerView3.setAdapter(myrecyclview);
        recyclerView3.setLayoutManager(linearLayoutManager2);
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


      //即将上市电影
    class jijiang implements DataColl<List<Jijiangshangying>>{

          @Override
          public void suuess(List<Jijiangshangying> rese) {
              myrecyclview.addAll(rese);
              myrecyclview.notifyDataSetChanged();
          }

          @Override
          public void failure(Data data) {

          }
      }

    //正在上市电影
   class zhengzaishangshi implements DataColl<List<Zhengzaishangying>>{

        @Override
        public void suuess(List<Zhengzaishangying> rese) {
                 myrecyview3adapter.addAll(rese);
                 myrecyview3adapter.notifyDataSetChanged();
        }

        @Override
        public void failure(Data data) {

        }
    }


}
