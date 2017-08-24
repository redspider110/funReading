package com.ymzs.funreading.model.remote;

import com.ymzs.funreading.model.remote.service.FunService;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by xumingtao on 2017/8/23.
 */

public final class ApiClient {
    public static FunService mFunService;

    public static void init(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiConstants.QSBK_TEXT_API_HOST)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        mFunService = retrofit.create(FunService.class);
    }
}
