package com.ymzs.funreading.model;

import android.support.annotation.Nullable;
import android.util.Log;

import com.ymzs.funreading.model.local.LocalDataSource;
import com.ymzs.funreading.model.remote.RemoteDataSource;

import org.reactivestreams.Publisher;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;


/**
 * Created by xumingtao on 2017/8/22.
 */

public class DataRepository implements DataSource{
    private static final String TAG = ":XMT:DataRepository:";

    private final LocalDataSource mLocalDataSource;
    private final RemoteDataSource mRemoteDataSource;
    private Map<Long, Fun> mCachedFuns = new LinkedHashMap<>();;
    private boolean mCacheIsDirty = false;

    public DataRepository(LocalDataSource localDataSource, RemoteDataSource remoteDataSource) {
        mLocalDataSource = localDataSource;
        mRemoteDataSource = remoteDataSource;
    }

    /**
     * First get funs.
     * @param type: api type.
     * @return if network is connected, return funs from internet;
     *          or return funs from db.
     */
    @Override
    public Single<List<Fun>> getFuns(final int type) {
        Log.d(TAG, "getFuns: type = " + type + ", mCacheIsDirty = " + mCacheIsDirty);
        if (mCachedFuns != null && mCachedFuns.size() > 0 && !mCacheIsDirty) {
            Log.d(TAG, "getFuns: caches");
            Observable<Fun> funObservable = Observable.fromIterable(mCachedFuns.values());
            long count = funObservable.filter(new Predicate<Fun>() {
                @Override
                public boolean test(@NonNull Fun fun) throws Exception {
                    return (fun.getType() == type);
                }
            }).count().blockingGet();
            Log.d(TAG, "getFuns: count = " + count);
            if(count > 0) {
                return funObservable.toList();
            }
        }

        Single<List<Fun>> remoteFuns = getAndSaveRemoteFuns(type);
        if(mCacheIsDirty){
            return remoteFuns;
        }else {
            Single<List<Fun>> localFuns = getAndCacheLocalFuns(type);
            return Single.concat(localFuns, remoteFuns)
                    .filter(new Predicate<List<Fun>>() {
                        @Override
                        public boolean test(@NonNull List<Fun> funs) throws Exception {
                            return !funs.isEmpty();
                        }
                    })
                    .distinct()
                    .firstOrError();
        }
    }

    private Single<List<Fun>> getAndCacheLocalFuns(int type) {
        Log.d(TAG, "getAndCacheLocalFuns: ");
        return mLocalDataSource.getFuns(type)
                .flatMap(new Function<List<Fun>, SingleSource<List<Fun>>>() {
                    @Override
                    public SingleSource<List<Fun>> apply(@NonNull List<Fun> funs) throws Exception {
                        return Observable.fromIterable(funs)
                                .doOnNext(new Consumer<Fun>() {
                                    @Override
                                    public void accept(Fun fun) throws Exception {
                                        mCachedFuns.put(fun.getId(), fun);
                                    }
                                }).toList();
                    }
                });
    }

    private Single<List<Fun>> getAndSaveRemoteFuns(int type){
        Log.d(TAG, "getAndSaveRemoteFuns: ");
        return mRemoteDataSource.getFuns(type)
                .flatMap(new Function<List<Fun>, SingleSource<List<Fun>>>() {
                    @Override
                    public SingleSource<List<Fun>> apply(@NonNull List<Fun> funs) throws Exception {
                        return Observable.fromIterable(funs)
                                .doOnNext(new Consumer<Fun>() {
                                    @Override
                                    public void accept(Fun fun) throws Exception {
                                        mLocalDataSource.saveFun(fun);
                                        mCachedFuns.put(fun.getId(), fun);
                                    }
                                })
                                .toList();
                    }
                })
                .doAfterSuccess(new Consumer<List<Fun>>() {
                    @Override
                    public void accept(List<Fun> funs) throws Exception {
                        mCacheIsDirty = false;
                    }
                });
    }

    public Single<List<Fun>> loadMore(final int type){
        Log.d(TAG, "loadMore: ");
        Single<List<Fun>> remoteFuns = getAndSaveRemoteFuns(type);
        Single<List<Fun>> cachedFuns = Observable.fromIterable(mCachedFuns.values())
                .filter(new Predicate<Fun>() {
                    @Override
                    public boolean test(@NonNull Fun fun) throws Exception {
                        return (fun.getType() == type);
                    }
                }).toList();

        return Single.concat(remoteFuns, cachedFuns)
                .distinct()
                .firstOrError();
    }
}
