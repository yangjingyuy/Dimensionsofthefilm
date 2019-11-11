package com.bawei.dimensionsofthefilm.presenter;

import com.bawei.dimensionsofthefilm.base.BasePresenter;
import com.bawei.dimensionsofthefilm.contract.DataColl;
import com.bawei.dimensionsofthefilm.contract.IRequset;
import com.bawei.dimensionsofthefilm.model.Data;
import com.bawei.dimensionsofthefilm.model.Guanzhu;
import com.bawei.dimensionsofthefilm.utlis.HttpUtli;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;


public class GuanzhuPresenter  {

     private DataColl dataColl;

    public GuanzhuPresenter(DataColl dataColl) {
        this.dataColl = dataColl;
    }
    public void guanzhu( int userId,String sessionId, int page,int count ){
        HttpUtli.getInstance().create(IRequset.class)
                .findUserFollowMovieList(userId,sessionId,page,count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Data<List<Guanzhu>>>() {
                    @Override
                    public void accept(Data<List<Guanzhu>> listData) throws Exception {
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
                    }
                });
    }

}
