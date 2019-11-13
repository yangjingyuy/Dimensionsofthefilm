package com.bawei.dimensionsofthefilm.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.bawei.dimensionsofthefilm.R;
import com.bawei.dimensionsofthefilm.base.BaseFragmente;
import com.bawei.dimensionsofthefilm.view.PaiActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class Yyxiangq_Fragment extends BaseFragmente {

    @BindView(R.id.btn_paiqi)
    Button btnPaiqi;
    Unbinder unbinder;
    private View view;
    private Intent intent;

    @Override
    public View getLayoutID(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.yyxiaingqing_layout, container, false);
        return view;
    }

    @Override
    public void initView() {

    }



    @OnClick(R.id.btn_paiqi)
    public void onClick() {

        intent = new Intent(getContext(), PaiActivity.class);
           startActivity(intent);

    }
}
