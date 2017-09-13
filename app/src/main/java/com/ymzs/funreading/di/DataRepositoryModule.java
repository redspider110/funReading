package com.ymzs.funreading.di;

import android.content.Context;

import com.ymzs.funreading.model.local.LocalDataSource;
import com.ymzs.funreading.model.remote.RemoteDataSource;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by xumingtao on 2017/9/11.
 */

@Module
public class DataRepositoryModule {

    @Singleton
    @Provides
    LocalDataSource providerLocalDataSource(Context context){
        return new LocalDataSource(context);
    }

    @Singleton
    @Provides
    RemoteDataSource providerRemoteDataSource(){
        return new RemoteDataSource();
    }
}
