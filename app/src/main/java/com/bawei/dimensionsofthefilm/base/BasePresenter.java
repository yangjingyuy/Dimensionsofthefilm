package com.bawei.dimensionsofthefilm.base;

import com.bawei.dimensionsofthefilm.contract.DataColl;
import com.bawei.dimensionsofthefilm.contract.IRequset;
import com.bawei.dimensionsofthefilm.model.Data;
import com.bawei.dimensionsofthefilm.utlis.HttpUtli;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/*时间:2019/11/7
创建人:yang 
创建人:杨靖宇*/
public abstract class BasePresenter {
    private DataColl dataColl;

    public BasePresenter(DataColl dataColl) {
        this.dataColl = dataColl;
    }

    public void reqsuetData(Object...arge){
        IRequset iRequset = HttpUtli.getInstance().create(IRequset.class);
        getModle(iRequset,arge)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Data>() {
                    @Override
                    public void accept(Data listData) throws Exception {
                        if (listData.status.equals("0000")){
                            dataColl.suuess(listData.result);

                        }else {
                            dataColl.failure(listData);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        throwable.printStackTrace();
                        dataColl.failure(new Data(throwable.getMessage()));
                    }
                });
    }
    protected abstract Observable getModle( IRequset iRequset,Object...arge);
}
