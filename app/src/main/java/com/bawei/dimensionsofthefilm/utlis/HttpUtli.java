package com.bawei.dimensionsofthefilm.utlis;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/*时间:2019/11/6
创建人:yang 
创建人:杨靖宇*/
public class HttpUtli {
    private static HttpUtli httpUtli;
    private  Retrofit retrofit;

    private HttpUtli() {
        //拦截器
        HttpLoggingInterceptor interceptor=new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client=new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();
        retrofit = new Retrofit.Builder()
        .client(client)
        .baseUrl("http://172.17.8.100/movieApi/")
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build();
    }

    public static HttpUtli getInstance() {
        if (httpUtli==null) {
            httpUtli=new HttpUtli();
        }
        return httpUtli;
    }
    public <T> T create(final Class<T> service) {

        return retrofit.create(service);
    }
}
