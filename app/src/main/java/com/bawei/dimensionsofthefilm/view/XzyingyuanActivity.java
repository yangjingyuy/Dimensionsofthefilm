package com.bawei.dimensionsofthefilm.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.dimensionsofthefilm.R;
import com.bawei.dimensionsofthefilm.adapter.RecommendAdapter;
import com.bawei.dimensionsofthefilm.base.BaseActivity;
import com.bawei.dimensionsofthefilm.contract.DataColl;
import com.bawei.dimensionsofthefilm.fragment.RecommendFragment;
import com.bawei.dimensionsofthefilm.model.Data;
import com.bawei.dimensionsofthefilm.model.MovieDirector;
import com.bawei.dimensionsofthefilm.model.Particulars;
import com.bawei.dimensionsofthefilm.model.Recommend;
import com.bawei.dimensionsofthefilm.model.ShortFilmList;
import com.bawei.dimensionsofthefilm.presenter.ParticularsPresenter;
import com.bawei.dimensionsofthefilm.presenter.RecommendPresenter;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

public class XzyingyuanActivity extends BaseActivity {

    private static final String TAG = "XzyingyuanActivity";
    @BindView(R.id.text_namexq)
    TextView textNamexq;
    @BindView(R.id.tet_time)
    TextView tetTime;
    @BindView(R.id.text_pf)
    TextView textPf;
    @BindView(R.id.text_dy)
    TextView textDy;
    @BindView(R.id.jc_yp)
    JCVideoPlayer jcYp;
    @BindView(R.id.yp_recyc)
    RecyclerView ypRecyc;
    private RecommendAdapter recommendAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_xzyingyuan;
    }

    @Override
    protected void initView() {
        Intent intent = getIntent();
        int hotshowing = intent.getIntExtra("keyy", 0);
        Log.i(TAG, "initView: " + hotshowing);
        ParticularsPresenter particularsPresenter = new ParticularsPresenter(new particularsColl());
        particularsPresenter.reqsuetData(hotshowing);
        //查询推荐影院信息
        RecommendPresenter recommendPresenter=new RecommendPresenter(new cecomColl());
        recommendPresenter.reqsuetData(1,10);
        //推荐影院信息 适配器
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        ypRecyc.setLayoutManager(linearLayoutManager);
        recommendAdapter = new RecommendAdapter(this);
        ypRecyc.setAdapter(recommendAdapter);
    }
    //查询推荐影院信息
    class cecomColl implements DataColl<List<Recommend>>{

        @Override
        public void suuess(List<Recommend> rese) {
            Log.i("aaa", "suuess: "+rese);
            recommendAdapter.addAll(rese);
            recommendAdapter.notifyDataSetChanged();


        }

        @Override
        public void failure(Data data) {

        }
    }


    class particularsColl implements DataColl<Particulars> {

        private List<ShortFilmList> shortFilmList;

        @Override
        public void suuess(final Particulars rese) {
            textNamexq.setText(rese.name);
            tetTime.setText(rese.duration);
            textPf.setText(rese.score + "分");
            List<MovieDirector> movieDirector = rese.movieDirector;
            textDy.setText(movieDirector.get(0).name);
            shortFilmList = rese.shortFilmList;
            jcYp.setUp(shortFilmList.get(0).videoUrl, null);
            Glide.with(XzyingyuanActivity.this).load(shortFilmList.get(0).imageUrl).into(jcYp.ivThumb);

            recommendAdapter.setOnItemClickListener(new RecommendAdapter.OnItemClickListener() {
                @Override
                public void onClick(View view, int position) {
                    Intent intent=new Intent(XzyingyuanActivity.this,SeatActivity.class);
                    intent.putExtra("yp", shortFilmList.get(0).videoUrl);
                    intent.putExtra("name", rese.name);
                    intent.putExtra("img", shortFilmList.get(0).imageUrl);
                    startActivity(intent);

                }
            });


        }

        @Override
        public void failure(Data data) {

        }
    }
}
