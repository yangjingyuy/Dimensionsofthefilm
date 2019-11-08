package com.bawei.dimensionsofthefilm.contract;

import com.bawei.dimensionsofthefilm.model.Banner;
import com.bawei.dimensionsofthefilm.model.Data;
import com.bawei.dimensionsofthefilm.model.Hot;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

/*时间:2019/11/6
创建人:yang 
创建人:杨靖宇*/
public interface IRequset {
    //登陆
    @FormUrlEncoded
    @POST("user/v2/login")
    Observable<Data<Long>> login(@Header("email")String email,@Header("pwd")String pwd);
    //查询banner
    @GET("tool/v2/banner")
    Observable<Data<List<Banner>>> banner();

    //热门电影列表
    @GET("movie/v2/findHotMovieList")
    Observable<Data<List<Hot>>> findHotMovieList(@Query("page")int page,@Query("count")int count);
}
