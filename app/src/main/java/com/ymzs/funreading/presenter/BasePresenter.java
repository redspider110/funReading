package com.ymzs.funreading.presenter;

import com.ymzs.funreading.view.BaseView;

/**
 * Created by xumingtao on 2017/8/22.
 */

public interface BasePresenter<T extends BaseView> {
    void subscribe();
    void unSubscribe();

    void takeView(T view);
    void dropView();
}
