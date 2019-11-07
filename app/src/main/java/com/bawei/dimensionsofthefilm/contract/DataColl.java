package com.bawei.dimensionsofthefilm.contract;

import com.bawei.dimensionsofthefilm.model.Data;

/*时间:2019/11/6
创建人:yang 
创建人:杨靖宇*/
public interface DataColl<T> {
    //成功
    void suuess(T rese);
    //失败
    void failure(Data data);
}
