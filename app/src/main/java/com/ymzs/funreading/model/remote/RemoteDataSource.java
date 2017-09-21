package com.ymzs.funreading.model.remote;

import android.util.Log;

import com.ymzs.funreading.model.DataSource;
import com.ymzs.funreading.model.DataType;
import com.ymzs.funreading.model.Fun;
import com.ymzs.funreading.model.Photo;
import com.ymzs.funreading.model.remote.adapter.JiandanFunAdapter;
import com.ymzs.funreading.model.remote.adapter.NhdzFunAdapter;
import com.ymzs.funreading.model.remote.adapter.QsbkFunAdapter;
import com.ymzs.funreading.model.remote.adapter.TuChongPhotoAdapter;
import com.ymzs.funreading.model.remote.entity.JiandanFun;
import com.ymzs.funreading.model.remote.entity.NhdzFun;
import com.ymzs.funreading.model.remote.entity.QsbkFun;
import com.ymzs.funreading.model.remote.entity.TuChongPhoto;

import java.util.Date;
import java.util.List;

import io.reactivex.Single;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import retrofit2.http.POST;

/**
 * Created by xumingtao on 2017/8/22.
 */

public class RemoteDataSource implements DataSource{

    private static final String TAG = ":XMT:RemoteDataSource:";

    private static final String DEFAULT_NHDZ_COUNT = "20";
    private static int mQsbkIndex = 1;
    private static int mJiandanIndex = 1;

    private static int mTuChongIndex = 1;
    public static final int TUCHONG_DEFAULT_POST_ID = 12345678;
    private int post_id = TUCHONG_DEFAULT_POST_ID;


    public RemoteDataSource(){
        ApiClient.init();
    }

    @Override
    public Single<List<Fun>> getFuns(int type) {
        Single<List<Fun>> observableForGetFunFromNetWork = null;

        switch (type){
            case DataType.TYPE_JIANDAN:
                observableForGetFunFromNetWork = ApiClient.mJiandanFunService
                        .getJiandanFun(ApiConstants.JIANDAN_GET_FILED_NAME, String.valueOf(mJiandanIndex))
                        .map(new Function<JiandanFun, List<Fun>>() {
                            @Override
                            public List<Fun> apply(@NonNull JiandanFun jiandanFun) throws Exception {
                                mJiandanIndex++;
                                return new JiandanFunAdapter(jiandanFun).getFuns();
                            }
                        });
                break;
            case DataType.TYPE_NHDZ:
                String currentTime = String.valueOf(new Date().getTime());
                observableForGetFunFromNetWork = ApiClient.mNhdzFunService
                        .getNhdzFun(ApiConstants.NHDZ_GET_FILED_NAME_CONTENT_TYPE, DEFAULT_NHDZ_COUNT, currentTime)
                        .map(new Function<NhdzFun, List<Fun>>() {
                            @Override
                            public List<Fun> apply(@NonNull NhdzFun nhdzFun) throws Exception {
                                return new NhdzFunAdapter(nhdzFun).getFuns();
                            }
                        });
                break;
            case DataType.TYPE_QSBK:
            default:
                observableForGetFunFromNetWork = ApiClient.mQsbkFunService
                        .getQsbkFun(String.valueOf(mQsbkIndex))
                        .map(new Function<QsbkFun, List<Fun>>() {
                            @Override
                            public List<Fun> apply(@NonNull QsbkFun qsbkFun) throws Exception {
                                mQsbkIndex++;
                                return new QsbkFunAdapter(qsbkFun).getFuns();
                            }
                        });
                break;
        }

        return observableForGetFunFromNetWork;
    }

    public Single<List<Photo>> getPhotos(){
        Single<List<Photo>> observableForGetPhotosFromNetWork = null;
        if(mTuChongIndex == 1){
            observableForGetPhotosFromNetWork = ApiClient.mTuChongPhotoService
                    .firstLoadTuChongPhotos(ApiConstants.TU_CHONG_TYPE_FIRST_PAGE)
                    .map(new Function<TuChongPhoto, List<Photo>>() {
                        @Override
                        public List<Photo> apply(@NonNull TuChongPhoto photo) throws Exception {
                            updatePostId(photo);
                            return new TuChongPhotoAdapter(photo).getPhotos();
                        }
                    });
        }else {
            Log.d(TAG, "getPhotos: post_id = " + post_id + ", mTuChongIndex = " + mTuChongIndex);
            observableForGetPhotosFromNetWork = ApiClient.mTuChongPhotoService
                    .loadMoreTuChongPhotos(String.valueOf(post_id), ApiConstants.TU_CHONG_TYPE_LOAD_MORE)
                    .map(new Function<TuChongPhoto, List<Photo>>() {
                        @Override
                        public List<Photo> apply(@NonNull TuChongPhoto photo) throws Exception {
                            updatePostId(photo);
                            return new TuChongPhotoAdapter(photo).getPhotos();
                        }
                    });
        }
        return observableForGetPhotosFromNetWork;
    }

    private void updatePostId(TuChongPhoto photo){
        List<TuChongPhoto.FeedList> lists = photo.getFeedList();
        if(lists != null && lists.size() > 0){
            TuChongPhoto.FeedList feedList = lists.get(lists.size() -1 );
            post_id = feedList.getPost_id();
            Log.d(TAG, "updatePostId: post_id = " + post_id);
            if(post_id != TUCHONG_DEFAULT_POST_ID){
                mTuChongIndex++;
            }
        }
    }
}
