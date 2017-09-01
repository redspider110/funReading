package com.ymzs.funreading.model.local.db;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import org.greenrobot.greendao.database.Database;

/**
 * Created by xumingtao on 2017/8/22.
 */

public class DbHelper extends DaoMaster.OpenHelper{

    private static final String DATABASE_NAME = "FunReading.db";
    private static final boolean ENCRYPTED = false;
    private DaoSession mDaoSession;

    public DbHelper(Context context){
        super(context, DATABASE_NAME);
        Database db = ENCRYPTED ? getEncryptedWritableDb("super-secret") : getWritableDb();
        mDaoSession = new DaoMaster(db).newSession();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onUpgrade(db, oldVersion, newVersion);
        // upgrade db.
        // ...
    }

    public DaoSession getDaoSession(){
        return mDaoSession;
    }

}
