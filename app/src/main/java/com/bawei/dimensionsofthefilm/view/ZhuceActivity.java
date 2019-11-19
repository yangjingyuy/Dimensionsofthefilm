package com.bawei.dimensionsofthefilm.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.dimensionsofthefilm.R;
import com.bawei.dimensionsofthefilm.base.BaseActivity;
import com.bawei.dimensionsofthefilm.contract.DataColl;
import com.bawei.dimensionsofthefilm.model.Data;
import com.bawei.dimensionsofthefilm.model.LoginBean;
import com.bawei.dimensionsofthefilm.presenter.SendOutPresenter;
import com.bawei.dimensionsofthefilm.presenter.ZhucePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ZhuceActivity extends BaseActivity {


    @BindView(R.id.name)
    EditText name1;
    @BindView(R.id.user)
    EditText user;
    @BindView(R.id.pwdd)
    EditText pwdd;
    @BindView(R.id.code)
    EditText code;
    @BindView(R.id.Obtain)
    Button Obtain;
    @BindView(R.id.dl)
    TextView dl;
    @BindView(R.id.regist)
    Button regist;
    private ZhucePresenter zhucePresenter;
    private String email;
    private SendOutPresenter sendOutPresenter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_zhuce;
    }

    @Override
    protected void initView() {
        sendOutPresenter = new SendOutPresenter(new sendoutData());
        zhucePresenter = new ZhucePresenter(new relogin());
    }

    @OnClick({R.id.Obtain, R.id.regist})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.Obtain:
                email = user.getText().toString().trim();
                   sendOutPresenter.reqsuetData(email);
                //Toast.makeText(this, "发送成功", Toast.LENGTH_SHORT).show();
                break;

            case R.id.dl:
                startActivity(new Intent(getApplicationContext(),DengluActivity.class));
                break;

            case R.id.regist:

                break;

        }
        regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = name1.getText().toString().trim();
                String pass = user.getText().toString().trim();

                String yanzhegn = pwdd.getText().toString().trim();
                String emil = code.getText().toString().trim();

                zhucePresenter.reqsuetData(name1,pass,yanzhegn,emil);



            }
        });
    }

    class relogin implements DataColl<LoginBean>{

        @Override
        public void suuess(LoginBean rese) {
           // Log.d("aaa", "suuess: "+rese.userInfo.nickName);

            startActivity(new Intent(getApplicationContext(),DengluActivity.class));
        }

        @Override
        public void failure(Data data) {

        }
    }
     class sendoutData implements DataColl<Data>{

         @Override
         public void suuess(Data rese) {
             Toast.makeText(ZhuceActivity.this, ""+rese.message, Toast.LENGTH_SHORT).show();
         }

         @Override
         public void failure(Data data) {

         }
     }
}
