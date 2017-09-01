package com.ymzs.funreading.model.local;

import android.content.Context;

import com.ymzs.funreading.model.DataSource;
import com.ymzs.funreading.model.Fun;
import com.ymzs.funreading.model.local.db.DaoSession;
import com.ymzs.funreading.model.local.db.DbHelper;
import com.ymzs.funreading.model.local.db.FunDao;

import org.greenrobot.greendao.query.Query;
import org.greenrobot.greendao.query.WhereCondition;

import java.util.List;

import io.reactivex.Single;

/**
 * Created by xumingtao on 2017/8/22.
 */

public class LocalDataSource implements DataSource{


    private DaoSession mDaoSession;

    public LocalDataSource(Context context){
        DbHelper dbHelper = new DbHelper(context);
        mDaoSession = dbHelper.getDaoSession();
    }

    @Override
    public Single<List<Fun>> getFuns(int type) {
        Query<Fun> funsQuery = mDaoSession.queryBuilder(Fun.class)
                .where(FunDao.Properties.Type.eq(type))
                .orderDesc(FunDao.Properties.Time).build();
        List<Fun> funs = funsQuery.list();
        return Single.just(funs);
    }

    public void saveFun(Fun fun){
        mDaoSession.getFunDao().insert(fun);
    }
}
