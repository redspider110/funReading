package com.ymzs.funreading;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;
import com.ymzs.funreading.di.DaggerAppComponent;
import com.ymzs.funreading.model.DataRepository;
import javax.inject.Inject;

/**
 * Created by xumingtao on 2017/9/11.
 */

public class FunReadingApplication extends Application {
    @Inject
    DataRepository dataRepository;

    @Override
    public void onCreate() {
        super.onCreate();
        // leak canary
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);

        dataRepository = DaggerAppComponent.builder()
                .providerContext(getApplicationContext())
                .build()
                .getDataRepository();
    }

    public DataRepository getDataRepository(){
        return dataRepository;
    }

}
