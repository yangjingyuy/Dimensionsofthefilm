package com.bawei.dimensionsofthefilm.moviefrgment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.dimensionsofthefilm.R;
import com.bawei.dimensionsofthefilm.base.BaseFragmente;

/*时间:2019/11/12
创建人:yang 
创建人:杨靖宇*/
public class StagephotoFragment extends BaseFragmente {
    @Override
    public View getLayoutID(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.stagephoto_layout, null, false);
        return  view;
    }

    @Override
    public void initView() {

    }
}
