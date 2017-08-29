package com.ymzs.funreading.model.remote.service;

import com.ymzs.funreading.model.remote.entity.NhdzFun;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by xumingtao on 2017/8/29.
 */

public interface NhdzFunService {
    /**
     * http://iu.snssdk.com/neihan/stream/mix/v1/?content_type=-102&count=%s&min_time=%s
     * http://iu.snssdk.com/neihan/stream/mix/v1/?content_type=-102&count=5&min_time=1503986352
     *
     * @param  type: content_type, -102 is text.
     * @param count : count of content;
     * @param time: cut-off time
     * @return NhdzFun
     */
    @GET("neihan/stream/mix/v1/")
    Single<NhdzFun> getNhdzFun(@Query("content_type") String type, @Query("count") String count, @Query("min_time") String time);
}
