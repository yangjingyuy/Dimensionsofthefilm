package com.bawei.dimensionsofthefilm.view;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;
import android.widget.ImageView;
import com.bawei.dimensionsofthefilm.R;
import com.bawei.dimensionsofthefilm.adapter.SeekAdapter;
import com.bawei.dimensionsofthefilm.base.BaseActivity;
import com.bawei.dimensionsofthefilm.contract.DataColl;
import com.bawei.dimensionsofthefilm.model.Data;
import com.bawei.dimensionsofthefilm.model.Inquiree;
import com.bawei.dimensionsofthefilm.presenter.SeekPresenter;
import java.util.List;
import butterknife.BindView;
import butterknife.OnClick;

public class HotActivity extends BaseActivity {

    @BindView(R.id.img_fh)
    ImageView imgFh;
    @BindView(R.id.edit_seek)
    EditText editSeek;
    @BindView(R.id.recyc_seek)
    RecyclerView recycSeek;
    private SeekAdapter seekAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_hot;
    }

    @Override
    protected void initView() {
        String str="中";
        String s = editSeek.getText().toString();
        SeekPresenter seekPresenter = new SeekPresenter(new seek());
        seekPresenter.reqsuetData(s,1,5);
        seekAdapter = new SeekAdapter(this);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recycSeek.setLayoutManager(linearLayoutManager);
        recycSeek.setAdapter(seekAdapter);

    }


    class seek implements DataColl<List<Inquiree>> {
        @Override
        public void suuess(List<Inquiree> rese) {
            seekAdapter.addAll(rese);
            seekAdapter.notifyDataSetChanged();
        }

        @Override
        public void failure(Data data) {

        }
    }

    //返回
    @OnClick(R.id.img_fh)
    public void onClick() {
        finish();
    }
}
