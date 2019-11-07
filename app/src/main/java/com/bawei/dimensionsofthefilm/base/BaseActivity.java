package com.bawei.dimensionsofthefilm.base;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        initView();
        ButterKnife.bind(this);
    }
    protected abstract int getLayoutId();
    protected abstract void initView();

}
