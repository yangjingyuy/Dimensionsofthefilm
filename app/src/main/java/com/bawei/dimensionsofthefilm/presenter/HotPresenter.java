package com.bawei.dimensionsofthefilm.presenter;

import com.bawei.dimensionsofthefilm.base.BasePresenter;
import com.bawei.dimensionsofthefilm.contract.DataColl;
import com.bawei.dimensionsofthefilm.contract.IRequset;

import io.reactivex.Observable;

/*时间:2019/11/7
创建人:yang 
创建人:杨靖宇
热门电影P层
*/
public class HotPresenter extends BasePresenter {
    public HotPresenter(DataColl dataColl) {
        super(dataColl);
    }

    @Override
    protected Observable getModle(IRequset iRequset, Object... arge) {
        return iRequset.findHotMovieList((int)arge[0],(int)arge[1]);
    }
}
