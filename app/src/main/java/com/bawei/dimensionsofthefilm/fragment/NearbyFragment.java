package com.bawei.dimensionsofthefilm.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.dimensionsofthefilm.R;
import com.bawei.dimensionsofthefilm.adapter.MyFujinyingyuanadapter;
import com.bawei.dimensionsofthefilm.base.BaseFragmente;
import com.bawei.dimensionsofthefilm.contract.DataColl;
import com.bawei.dimensionsofthefilm.model.Data;
import com.bawei.dimensionsofthefilm.model.Fujin;
import com.bawei.dimensionsofthefilm.presenter.FujinyingyuanPresenter;

import java.util.List;

/*时间:2019/11/8
创建人:yang 
创建人:杨靖宇*/
public class NearbyFragment extends BaseFragmente {
    private View view;
    private RecyclerView recyclerView4;
    private FujinyingyuanPresenter fujinyingyuanPresenter;
    private LinearLayoutManager linearLayoutManager;
    private MyFujinyingyuanadapter myFujinyingyuanadapter;

    @Override
    public View getLayoutID(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.nearby_layout, null, false);
        recyclerView4 = view.findViewById(R.id.recycler_view4);
        return view;
    }

    @Override
    public void initView() {


         //查询附近影院
        fujinyingyuanPresenter = new FujinyingyuanPresenter(new fujiny());
          fujinyingyuanPresenter.reqsuetData(1,5);

        linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView4.setLayoutManager(linearLayoutManager);

        myFujinyingyuanadapter = new MyFujinyingyuanadapter(getContext());
         recyclerView4.setAdapter(myFujinyingyuanadapter);



    }


    class fujiny implements DataColl<List<Fujin>>{

        @Override
        public void suuess(List<Fujin> rese) {
            myFujinyingyuanadapter.addAll(rese);
            myFujinyingyuanadapter.notifyDataSetChanged();
        }

        @Override
        public void failure(Data data) {

        }
    }
}
