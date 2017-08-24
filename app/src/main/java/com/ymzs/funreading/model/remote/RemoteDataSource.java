package com.ymzs.funreading.model.remote;

import android.support.annotation.NonNull;

import com.ymzs.funreading.model.DataSource;
import com.ymzs.funreading.model.Fun;
import com.ymzs.funreading.model.remote.entity.qsbk.QsbkAdapter;
import com.ymzs.funreading.model.remote.entity.qsbk.QsbkFun;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by xumingtao on 2017/8/22.
 */

public class RemoteDataSource implements DataSource{
    @Override
    public Single<List<Fun>> getFuns() {
        Single<List<Fun>> observableForGetFunFromNetWork = null;
        String index = "1";
        ApiClient.init();
        ApiClient.mFunService.getQsbkWeather(index)
                .map(new Function<QsbkFun, List<Fun>>() {
                    @Override
                    public List<Fun> apply(@io.reactivex.annotations.NonNull QsbkFun qsbkFun) throws Exception {
                        return new QsbkAdapter(qsbkFun).getFuns();
                    }
                });
        return observableForGetFunFromNetWork;
    }
}
