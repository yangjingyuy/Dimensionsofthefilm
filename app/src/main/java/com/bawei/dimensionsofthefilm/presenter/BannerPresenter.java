package com.bawei.dimensionsofthefilm.presenter;

import com.bawei.dimensionsofthefilm.base.BasePresenter;
import com.bawei.dimensionsofthefilm.contract.DataColl;
import com.bawei.dimensionsofthefilm.contract.IRequset;
import com.bawei.dimensionsofthefilm.model.Banner;
import com.bawei.dimensionsofthefilm.model.Data;
import com.bawei.dimensionsofthefilm.utlis.HttpUtli;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/*时间:2019/11/7
创建人:yang 
创建人:杨靖宇*/
public class BannerPresenter extends BasePresenter {

    public BannerPresenter(DataColl dataColl) {
        super(dataColl);
    }

    @Override
    protected Observable getModle(IRequset iRequset, Object... arge) {
        return iRequset.banner();
    }
}
