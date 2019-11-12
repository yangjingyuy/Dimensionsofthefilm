package com.bawei.dimensionsofthefilm.presenter;

import com.bawei.dimensionsofthefilm.base.BasePresenter;
import com.bawei.dimensionsofthefilm.contract.DataColl;
import com.bawei.dimensionsofthefilm.contract.IRequset;
import io.reactivex.Observable;
/*时间:2019/11/12
创建人:yang 
创建人:杨靖宇
详情页面
*/
public class ParticularsPresenter extends BasePresenter {
    public ParticularsPresenter(DataColl dataColl) {
        super(dataColl);
    }

    @Override
    protected Observable getModle(IRequset iRequset, Object... arge) {
        return iRequset.findMoviesDetail((int)arge[0]);

    }
}
