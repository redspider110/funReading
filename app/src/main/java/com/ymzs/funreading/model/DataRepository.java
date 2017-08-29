package com.ymzs.funreading.model;

import android.support.annotation.NonNull;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;

/**
 * Created by xumingtao on 2017/8/22.
 */

public class DataRepository implements DataSource{

    private final DataSource mRemoteDataSource;

    public DataRepository(DataSource remoteDataSource) {
        mRemoteDataSource = remoteDataSource;
    }

    @Override
    public Single<List<Fun>> getFuns(int type) {
        Single<List<Fun>> remoteFuns = getFunsFromRemoteDataSource(type);
        return remoteFuns;
    }

    private Single<List<Fun>> getFunsFromRemoteDataSource(int type) {
        return mRemoteDataSource.getFuns(type);
    }
}
