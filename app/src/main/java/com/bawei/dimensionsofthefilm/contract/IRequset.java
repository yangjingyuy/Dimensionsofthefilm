package com.bawei.dimensionsofthefilm.contract;

import com.bawei.dimensionsofthefilm.model.Data;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

/*时间:2019/11/6
创建人:yang 
创建人:杨靖宇*/
public interface IRequset {
    //登陆
    @FormUrlEncoded
    @POST("user/v2/login")
    Observable<Data<Long>> login(@Header("email")String email,@Header("pwd")String pwd);
}
