package com.bawei.dimensionsofthefilm.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


import com.bawei.dimensionsofthefilm.R;
import com.bawei.dimensionsofthefilm.base.Base64;
import com.bawei.dimensionsofthefilm.base.BaseActivity;
import com.bawei.dimensionsofthefilm.base.EncryptUtil;
import com.bawei.dimensionsofthefilm.contract.DataColl;
import com.bawei.dimensionsofthefilm.model.Data;
import com.bawei.dimensionsofthefilm.model.LoginBean;
import com.bawei.dimensionsofthefilm.model.UserBean;
import com.bawei.dimensionsofthefilm.presenter.DengluPresenter;

/**
 * 登录页面
 */import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DengluActivity extends BaseActivity {


    @BindView(R.id.emailzh)
    EditText emailzh;
    @BindView(R.id.pwd)
    EditText pwd;
    @BindView(R.id.zc)
    TextView zc;
    @BindView(R.id.dl)
    Button dl;
    @BindView(R.id.wxdl)
    ImageButton wxdl;
    private DengluPresenter dengluPresenter;
    private DengluPresenter dengluPresenter1;
    private String email;
    private String pwd1;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_denglu;
    }

    @Override
    protected void initView() {
        dengluPresenter1 = new DengluPresenter(new loginj());

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.dl,R.id.zc,R.id.wxdl})
    public void onClick(View view) {
         switch (view.getId()){
             case R.id.zc:
                 Intent intent = new Intent(DengluActivity.this, ZhuceActivity.class);
                 startActivity(intent);
                 break;
             case R.id.dl:
                 email = emailzh.getText().toString().trim();
                 pwd1 = this.pwd.getText().toString().trim();
                  String JmPwd= Base64.encode(pwd1.getBytes());
        String encrypt = EncryptUtil.encrypt(JmPwd);
                 Log.d("ttt", "onClick: "+encrypt);
                 dengluPresenter1.reqsuetData(email,encrypt);
                   if (email.isEmpty()||pwd1.isEmpty()){
                       Toast.makeText(this, "内容不能为空", Toast.LENGTH_SHORT).show();
                   }else {
                       dl.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View v) {
                               /*Intent intent = new Intent(DengluActivity.this, YemiaoActivity.class);
                               startActivity(intent);*/
                           }
                       });
                   }

                 dengluPresenter1.reqsuetData(email, pwd1);

                 break;

             case R.id.wxdl:

                 break;
         }




    }

    class loginj implements DataColl<LoginBean>{

        @Override
        public void suuess(LoginBean rese) {
            Log.d("aaa", "suuess: "+rese.userInfo.nickName);
            Intent intent = new Intent(DengluActivity.this, YemiaoActivity.class);
            startActivity(intent);
        }

        @Override
        public void failure(Data data) {

        }
    }

}
