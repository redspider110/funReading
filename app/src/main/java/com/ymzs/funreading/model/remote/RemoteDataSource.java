package com.ymzs.funreading.model.remote;

import com.ymzs.funreading.model.DataSource;
import com.ymzs.funreading.model.Fun;
import com.ymzs.funreading.model.remote.adapter.JiandanFunAdapter;
import com.ymzs.funreading.model.remote.adapter.NhdzFunAdapter;
import com.ymzs.funreading.model.remote.adapter.QsbkFunAdapter;
import com.ymzs.funreading.model.remote.entity.JiandanFun;
import com.ymzs.funreading.model.remote.entity.NhdzFun;
import com.ymzs.funreading.model.remote.entity.QsbkFun;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

/**
 * Created by xumingtao on 2017/8/22.
 */

public class RemoteDataSource implements DataSource{

    @Override
    public Single<List<Fun>> getFuns(int type) {
        Single<List<Fun>> observableForGetFunFromNetWork = null;
        String index = "1";
        ApiClient.init();

        switch (type){
            case ApiConstants.API_TYPE_JIANDAN:
                observableForGetFunFromNetWork = ApiClient.mJiandanFunService
                        .getJiandanFun(ApiConstants.JIANDAN_GET_FILED_NAME, index)
                        .map(new Function<JiandanFun, List<Fun>>() {
                            @Override
                            public List<Fun> apply(@NonNull JiandanFun jiandanFun) throws Exception {
                                return new JiandanFunAdapter(jiandanFun).getFuns();
                            }
                        });
                break;
            case ApiConstants.API_TYPE_NHDZ:
                observableForGetFunFromNetWork = ApiClient.mNhdzFunService
                        .getNhdzFun(ApiConstants.NHDZ_GET_FILED_NAME_CONTENT_TYPE, "20", index)
                        .map(new Function<NhdzFun, List<Fun>>() {
                            @Override
                            public List<Fun> apply(@NonNull NhdzFun nhdzFun) throws Exception {
                                return new NhdzFunAdapter(nhdzFun).getFuns();
                            }
                        });
                break;
            case ApiConstants.API_TYPE_QSBK:
            default:
                observableForGetFunFromNetWork = ApiClient.mQsbkFunService
                        .getQsbkFun(index)
                        .map(new Function<QsbkFun, List<Fun>>() {
                            @Override
                            public List<Fun> apply(@NonNull QsbkFun qsbkFun) throws Exception {
                                return new QsbkFunAdapter(qsbkFun).getFuns();
                            }
                        });
                break;
        }

        return observableForGetFunFromNetWork;
    }
}
