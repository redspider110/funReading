package com.ymzs.funreading.model.remote.service;

import com.ymzs.funreading.model.Photo;
import com.ymzs.funreading.model.remote.entity.TuChongPhoto;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by xumingtao on 2017/9/20.
 */

public interface TuChongPhotoService {

    /**
     * https://api.tuchong.com/feed-app?type=refresh
     * @param type: refresh
     * @return
     */
    @GET("feed-app")
    Single<TuChongPhoto> firstLoadTuChongPhotos(@Query("type") String type);

    /**
     * https://api.tuchong.com/feed-app?post_id=15382883&type=loadmore
     * @param post_id: the last post_id in getTuChongPhotos:json.
     * @param type: loadmore
     * @return
     */
    @GET("feed-app")
    Single<TuChongPhoto> loadMoreTuChongPhotos(@Query("post_id") String post_id, @Query("type") String type);
}
