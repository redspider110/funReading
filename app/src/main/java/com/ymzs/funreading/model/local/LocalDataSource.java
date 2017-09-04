package com.ymzs.funreading.model.local;

import android.content.Context;
import android.util.Log;

import com.ymzs.funreading.model.DataSource;
import com.ymzs.funreading.model.Fun;
import com.ymzs.funreading.model.local.db.DaoSession;
import com.ymzs.funreading.model.local.db.DbHelper;
import com.ymzs.funreading.model.local.db.FunDao;

import org.greenrobot.greendao.query.Query;
import org.greenrobot.greendao.query.WhereCondition;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import io.reactivex.Single;

/**
 * Created by xumingtao on 2017/8/22.
 */

public class LocalDataSource implements DataSource{
    private static final String TAG = ":XMT:LocalDataSource:";

    private DaoSession mDaoSession;
    private FunDao mFunDao;

    public LocalDataSource(Context context){
        DbHelper dbHelper = new DbHelper(context);
        mDaoSession = dbHelper.getDaoSession();
        mFunDao = mDaoSession.getFunDao();
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
        mFunDao.insert(fun);
    }

    public void deleteFuns(Collection<Fun> funs){
        mFunDao.deleteInTx(funs);
    }
}
