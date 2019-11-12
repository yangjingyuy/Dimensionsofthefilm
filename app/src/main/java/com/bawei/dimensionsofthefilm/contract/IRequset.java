package com.bawei.dimensionsofthefilm.contract;

import com.bawei.dimensionsofthefilm.model.Area;
import com.bawei.dimensionsofthefilm.model.AreaQuery;
import com.bawei.dimensionsofthefilm.model.Banner;
import com.bawei.dimensionsofthefilm.model.Data;
import com.bawei.dimensionsofthefilm.model.Fujin;
import com.bawei.dimensionsofthefilm.model.Guanzhu;
import com.bawei.dimensionsofthefilm.model.Hot;
import com.bawei.dimensionsofthefilm.model.Jijiangshangying;
import com.bawei.dimensionsofthefilm.model.Recommend;
import com.bawei.dimensionsofthefilm.model.Zhengzaishangying;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.Field;
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
    Observable<Data<Long>> login(@Field("email") String email, @Field("pwd") String pwd);
    //查询banner
    @GET("tool/v2/banner")
    Observable<Data<List<Banner>>> banner();

    //热门电影列表
    @GET("movie/v2/findHotMovieList")
    Observable<Data<List<Hot>>> findHotMovieList(@Query("page")int page,@Query("count")int count);


    //查询即将上映电影列表
    @GET("movie/v2/findComingSoonMovieList")
    Observable<Data<List<Jijiangshangying>>> jijingshangshi(@Query("page")int page, @Query("count")int count);

    //查询正在上映电影列表
    @GET("movie/v2/findReleaseMovieList")
    Observable<Data<List<Zhengzaishangying>>> zhengzaishangying(@Query("page")int page, @Query("count")int count);
    //查询推荐影院信息
    @GET("cinema/v1/findRecommendCinemas")
    Observable<Data<List<Recommend>>> findRecommendCinemas(@Query("page")int page, @Query("count")int count);
    //查询附近影院
    @GET("cinema/v1/findNearbyCinemas")
    Observable<Data<List<Fujin>>> fujinyingyuan(@Query("page")int page, @Query("count")int count);

   @GET("user/v2/verify/findUserFollowMovieList?page=1&count=5")
    Observable<Data<List<Guanzhu>>> findUserFollowMovieList(@Header("userId")int userId,@Header("sessionId")String sessionId,@Query("page")int page,@Query("count")int count);
    //查询区域列表
    @GET("tool/v2/findRegionList")
    Observable<Data<List<Area>>> findRegionList();
    //根据区域查询影院
    @GET("cinema/v2/findCinemaByRegion")
    Observable<Data<List<AreaQuery>>> findCinemaByRegion (@Query("regionId") int regionId);



}
