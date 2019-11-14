package com.bawei.dimensionsofthefilm.presenter;


import com.bawei.dimensionsofthefilm.base.BasePresenter;
import com.bawei.dimensionsofthefilm.contract.DataColl;
import com.bawei.dimensionsofthefilm.contract.IRequset;

import io.reactivex.Observable;

public  class DengluPresenter extends BasePresenter {


    public DengluPresenter(DataColl dataColl) {
        super(dataColl);
    }

    @Override
    protected Observable getModle(IRequset iRequset, Object... arge) {
        return iRequset.login((String)arge[0],(String)arge[1]);
    }
}
