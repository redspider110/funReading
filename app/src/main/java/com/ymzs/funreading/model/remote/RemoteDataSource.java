package com.ymzs.funreading.model.remote;

import com.ymzs.funreading.model.DataSource;
import com.ymzs.funreading.model.DataType;
import com.ymzs.funreading.model.Fun;
import com.ymzs.funreading.model.remote.adapter.JiandanFunAdapter;
import com.ymzs.funreading.model.remote.adapter.NhdzFunAdapter;
import com.ymzs.funreading.model.remote.adapter.QsbkFunAdapter;
import com.ymzs.funreading.model.remote.entity.JiandanFun;
import com.ymzs.funreading.model.remote.entity.NhdzFun;
import com.ymzs.funreading.model.remote.entity.QsbkFun;

import java.util.Date;
import java.util.List;

import io.reactivex.Single;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

/**
 * Created by xumingtao on 2017/8/22.
 */

public class RemoteDataSource implements DataSource{

    private static final String DEFAULT_NHDZ_COUNT = "20";
    private static int mQsbkIndex = 1;
    private static int mJiandanIndex = 1;


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
}
