package com.bawei.dimensionsofthefilm.view;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import com.bawei.dimensionsofthefilm.R;
import com.bawei.dimensionsofthefilm.base.BaseActivity;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    private int count=3;
    @BindView(R.id.tv)
    TextView tv;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage( Message msg) {
            super.handleMessage(msg);
            if (count<0){
                startActivity(new Intent(MainActivity.this, MovieActivity.class));
                finish();
            }else {
                tv.setText(count+"S");
                count--;
                handler.sendEmptyMessageDelayed(99, 1000);
            }
        }
    };
    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }


    @Override
    protected void initView() {
        handler.sendEmptyMessageDelayed(99, 1000);

    }


}
