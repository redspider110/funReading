package com.ymzs.funreading.model;

import android.util.Log;
import com.ymzs.funreading.model.local.LocalDataSource;
import com.ymzs.funreading.model.remote.RemoteDataSource;
import org.reactivestreams.Publisher;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;


/**
 * Created by xumingtao on 2017/8/22.
 */

public class DataRepository implements DataSource{
    private static final String TAG = ":XMT:DataRepository:";

    private final LocalDataSource mLocalDataSource;
    private final RemoteDataSource mRemoteDataSource;
    private Map<Integer, Fun> mCachedQsbkFuns = new LinkedHashMap<>();
    private Map<Integer, Fun> mCachedNhdzFuns = new LinkedHashMap<>();
    private Map<Integer, Fun> mCachedJiandanFuns = new LinkedHashMap<>();

    public DataRepository(LocalDataSource localDataSource, RemoteDataSource remoteDataSource) {
        mLocalDataSource = localDataSource;
        mRemoteDataSource = remoteDataSource;
    }

    @Override
    public Single<List<Fun>> getFuns(final int type) {
        Log.d(TAG, "getFuns: type = " + type);

        Single<List<Fun>> remoteFuns = getAndSaveRemoteFuns(type);
        Single<List<Fun>> localFuns = getAndCacheLocalFuns(type);
        return Single.concat(localFuns, remoteFuns)
                .flatMap(new Function<List<Fun>, Publisher<Fun>>() {
                    @Override
                    public Publisher<Fun> apply(@NonNull List<Fun> funs) throws Exception {
                        return Flowable.fromIterable(funs);
                    }
                })
                .distinct()
                .toList();
    }

    private Single<List<Fun>> getAndCacheLocalFuns(final int type) {
        Log.d(TAG, "getAndCacheLocalFuns: ");
        return mLocalDataSource.getFuns(type)
                .flatMap(new Function<List<Fun>, SingleSource<List<Fun>>>() {
                    @Override
                    public SingleSource<List<Fun>> apply(@NonNull List<Fun> funs) throws Exception {
                        return Observable.fromIterable(funs)
                                .doOnNext(new Consumer<Fun>() {
                                    @Override
                                    public void accept(Fun fun) throws Exception {
                                        putCachedFuns(type, fun);
                                    }
                                }).toList();
                    }
                });
    }

    private Single<List<Fun>> getAndSaveRemoteFuns(final int type){
        Log.d(TAG, "getAndSaveRemoteFuns: ");
        return mRemoteDataSource.getFuns(type)
                .flatMap(new Function<List<Fun>, SingleSource<List<Fun>>>() {
                    @Override
                    public SingleSource<List<Fun>> apply(@NonNull List<Fun> funs) throws Exception {
                        // 1. clear db.
                        Collection<Fun> cachesFuns = getCachedFuns(type).values();
                        if(cachesFuns != null && cachesFuns.size() > 0) {
                            mLocalDataSource.deleteFuns(cachesFuns);
                        }
                        return Observable.fromIterable(funs)
                                .doOnNext(new Consumer<Fun>() {
                                    @Override
                                    public void accept(Fun fun) throws Exception {
                                        // 2. save new fun from network.
                                        // db.
                                        mLocalDataSource.saveFun(fun);
                                        // cache.
                                        putCachedFuns(type, fun);
                                    }
                                })
                                .toList();
                    }
                });
    }

    public Single<List<Fun>> loadMoreFuns(final int type){
        Single<List<Fun>> remoteFuns = getAndSaveRemoteFuns(type);
        Single<List<Fun>> cachedFuns = Observable.fromIterable(getCachedFuns(type).values()).toList();

        return Single.concat(remoteFuns, cachedFuns)
                .flatMap(new Function<List<Fun>, Publisher<Fun>>() {
                    @Override
                    public Publisher<Fun> apply(@NonNull List<Fun> funs) throws Exception {
                        return Flowable.fromIterable(funs);
                    }
                })
                .distinct()
                .toList();
    }

    private Map<Integer, Fun> getCachedFuns(int type){
        switch (type) {
            case DataType.TYPE_JIANDAN:
                return mCachedJiandanFuns;
            case DataType.TYPE_NHDZ:
                return mCachedNhdzFuns;
            case DataType.TYPE_QSBK:
            default:
                return mCachedQsbkFuns;
        }
    }

    private void putCachedFuns(int type, Fun fun){
        Map<Integer, Fun> map = getCachedFuns(type);
        int index = map.size();
        map.put(index, fun);
    }
}
