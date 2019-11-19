package com.bawei.dimensionsofthefilm.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.bawei.dimensionsofthefilm.R;
import com.bawei.dimensionsofthefilm.base.BaseActivity;
import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

public class SeatActivity extends BaseActivity {


    @BindView(R.id.xz_yp)
    JCVideoPlayer xzYp;
    @BindView(R.id.seat_name)
    TextView seatName;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_seat;
    }

    @Override
    protected void initView() {
        Intent intent = getIntent();
        String yp = intent.getStringExtra("yp");
        String name = intent.getStringExtra("name");
        String img = intent.getStringExtra("img");
        xzYp.setUp(yp, null);
        seatName.setText(name);
        Glide.with(SeatActivity.this).load(img).into(xzYp.ivThumb);

    }

}
