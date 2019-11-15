package com.bawei.dimensionsofthefilm.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.bawei.dimensionsofthefilm.R;
import com.bawei.dimensionsofthefilm.base.BaseFragmente;
import com.bawei.dimensionsofthefilm.view.DengluActivity;
import com.bawei.dimensionsofthefilm.view.GoupiaoActivity;
import com.bawei.dimensionsofthefilm.view.GuanzhuActivity;
import com.bawei.dimensionsofthefilm.view.KanguoActivity;
import com.bawei.dimensionsofthefilm.view.PinglunActivity;
import com.bawei.dimensionsofthefilm.view.ShezhiActivity;
import com.bawei.dimensionsofthefilm.view.YijActivity;
import com.bawei.dimensionsofthefilm.view.YuyueActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


/*时间:2019/11/6
创建人:yang 
创建人:杨靖宇*/
public class MyFragment extends BaseFragmente {


    @BindView(R.id.gz)
    ImageView gz;
    @BindView(R.id.yuyue)
    ImageView yuyue;
    @BindView(R.id.goupiao)
    ImageView goupiao;
    @BindView(R.id.kanguo)
    ImageView kanguo;
    @BindView(R.id.pinglun)
    ImageView pinglun;
    @BindView(R.id.yij)
    ImageView yij;
    @BindView(R.id.shezhi)
    ImageView shezhi;
    Unbinder unbinder;

    @BindView(R.id.guanzhu)
    RelativeLayout guanzhu;
    Unbinder unbinder1;
    @BindView(R.id.denglu)
    ImageView denglu;
    Unbinder unbinder2;
    @BindView(R.id.denglu1)
    CardView denglu1;
    Unbinder unbinder3;
    private View view;
    private RelativeLayout relativeLayout;
    private Intent intent7;


    @Override
    public View getLayoutID(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.my_layout, null, false);

        return view;


    }


    @Override
    public void initView() {


    }


    @OnClick({R.id.gz, R.id.yuyue, R.id.goupiao, R.id.kanguo, R.id.pinglun, R.id.yij, R.id.shezhi, R.id.denglu,R.id.denglu1})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.gz:
                Toast.makeText(getContext(), "点击了", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getContext(), GuanzhuActivity.class);
                startActivity(intent);
                break;
            case R.id.yuyue:
                Toast.makeText(getContext(), "点击了", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(getContext(), YuyueActivity.class);
                startActivity(intent1);

                break;
            case R.id.goupiao:
                Toast.makeText(getContext(), "点击了", Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(getContext(), GoupiaoActivity.class);
                startActivity(intent2);
                break;
            case R.id.kanguo:
                Toast.makeText(getContext(), "点击了", Toast.LENGTH_SHORT).show();
                Intent intent3 = new Intent(getContext(), KanguoActivity.class);
                startActivity(intent3);
                break;
            case R.id.pinglun:
                Toast.makeText(getContext(), "点击了", Toast.LENGTH_SHORT).show();
                Intent intent4 = new Intent(getContext(), PinglunActivity.class);
                startActivity(intent4);
                break;
            case R.id.yij:
                Toast.makeText(getContext(), "点击了", Toast.LENGTH_SHORT).show();
                Intent intent5 = new Intent(getContext(), YijActivity.class);
                startActivity(intent5);
                break;
            case R.id.shezhi:
                Toast.makeText(getContext(), "点击了", Toast.LENGTH_SHORT).show();
                Intent intent6 = new Intent(getContext(), ShezhiActivity.class);
                startActivity(intent6);
                break;

            case R.id.denglu:
                Intent intent7 = new Intent(getContext(), DengluActivity.class);
                startActivity(intent7);
                break;
            case R.id.denglu1:
                Intent intent8 = new Intent(getContext(), DengluActivity.class);
                startActivity(intent8);

                break;

        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder3 = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder3.unbind();
    }
}
