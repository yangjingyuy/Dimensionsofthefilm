package com.bawei.dimensionsofthefilm.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.dimensionsofthefilm.R;
import com.bawei.dimensionsofthefilm.base.BaseFragmente;

/*时间:2019/11/6
创建人:yang 
创建人:杨靖宇*/
public class CinemaFragment extends BaseFragmente {

    private View view;

    @Override
    public View getLayoutID(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.cinema_layout, null, false);
        return view;
    }

    @Override
    public void initView() {

    }
}