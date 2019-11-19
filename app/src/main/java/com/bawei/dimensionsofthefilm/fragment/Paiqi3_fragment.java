package com.bawei.dimensionsofthefilm.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.dimensionsofthefilm.R;
import com.bawei.dimensionsofthefilm.base.BaseFragmente;

public class Paiqi3_fragment extends BaseFragmente {

    private View view;

    @Override
    public View getLayoutID(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.p3_layout,container,false);
        return view;
    }

    @Override
    public void initView() {

    }
}
