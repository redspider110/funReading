package com.ymzs.funreading.model.remote;

import com.ymzs.funreading.model.remote.service.JiandanFunService;
import com.ymzs.funreading.model.remote.service.NhdzFunService;
import com.ymzs.funreading.model.remote.service.QsbkFunService;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by xumingtao on 2017/8/23.
 */

public final class ApiClient {
    public static QsbkFunService mQsbkFunService;
    public static JiandanFunService mJiandanFunService;
    public static NhdzFunService mNhdzFunService;

    public static void init(){
        mQsbkFunService = initService(ApiConstants.QSBK_TEXT_API_HOST, QsbkFunService.class);
        mJiandanFunService = initService(ApiConstants.JIANDAN_JOKE_API_HOST, JiandanFunService.class);
        mNhdzFunService = initService(ApiConstants.NHDZ_DUANZI_API_HOST, NhdzFunService.class);
    }

    private static <T> T initService(String url, Class<T> clazz){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit.create(clazz);
    }
}
