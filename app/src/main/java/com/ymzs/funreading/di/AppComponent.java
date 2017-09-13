package com.ymzs.funreading.di;

import android.content.Context;
import com.ymzs.funreading.model.DataRepository;
import javax.inject.Singleton;
import dagger.BindsInstance;
import dagger.Component;

/**
 * Created by xumingtao on 2017/9/11.
 */
@Singleton
@Component(modules = DataRepositoryModule.class)
public interface AppComponent {

    DataRepository getDataRepository();

    @Component.Builder
    interface Builder{
        @BindsInstance
        AppComponent.Builder providerContext(Context context);
        AppComponent build();
    }
}
