package com.ymzs.funreading.model.remote.service;

import com.ymzs.funreading.model.remote.entity.JiandanFun;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by xumingtao on 2017/8/29.
 */

public interface JiandanFunService {
    /**
     * http://i.jandan.net/?oxwlxojflwblxbsapi=jandan.get_duan_comments&page=1
     *
     * @param name : jandan.get_duan_comments
     * @param index page index
     * @return JiandanFun
     */
    @GET("/")
    Single<JiandanFun> getJiandanFun(@Query("oxwlxojflwblxbsapi") String name, @Query("page") String index);
}
