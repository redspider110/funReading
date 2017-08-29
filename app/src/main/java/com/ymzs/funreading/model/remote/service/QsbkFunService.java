package com.ymzs.funreading.model.remote.service;

import com.ymzs.funreading.model.remote.entity.QsbkFun;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by xumingtao on 2017/8/23.
 */

public interface QsbkFunService {
    /**
     * http://m2.qiushibaike.com/article/list/text?page=1
     *
     * @param index page index
     * @return QsbkFun
     */
    @GET("text")
    Single<QsbkFun> getQsbkFun(@Query("page") String index);
}
