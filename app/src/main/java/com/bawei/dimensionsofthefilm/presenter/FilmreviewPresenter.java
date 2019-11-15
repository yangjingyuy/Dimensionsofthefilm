package com.bawei.dimensionsofthefilm.presenter;

import com.bawei.dimensionsofthefilm.base.BasePresenter;
import com.bawei.dimensionsofthefilm.contract.DataColl;
import com.bawei.dimensionsofthefilm.contract.IRequset;

import io.reactivex.Observable;

/*时间:2019/11/15
创建人:yang 
创建人:杨靖宇*/
public class FilmreviewPresenter extends BasePresenter {
    public FilmreviewPresenter(DataColl dataColl) {
        super(dataColl);
    }

    @Override
    protected Observable getModle(IRequset iRequset, Object... arge) {
        return iRequset.findAllMovieComment((int)arge[0],(int)arge[1],(int)arge[2]);
    }
}
