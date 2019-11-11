package com.bawei.dimensionsofthefilm.presenter;

import com.bawei.dimensionsofthefilm.base.BasePresenter;
import com.bawei.dimensionsofthefilm.contract.DataColl;
import com.bawei.dimensionsofthefilm.contract.IRequset;

import io.reactivex.Observable;

/*时间:2019/11/9
创建人:yang 
创建人:杨靖宇
查询区域列表
*/
public class AreaQueryPresenter extends BasePresenter {
    public AreaQueryPresenter(DataColl dataColl) {
        super(dataColl);
    }

    @Override
    protected Observable getModle(IRequset iRequset, Object... arge) {
        return iRequset.findCinemaByRegion((int)arge[0]);
    }
}
