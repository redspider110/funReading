package com.ymzs.funreading.contract;

import com.ymzs.funreading.model.Photo;
import com.ymzs.funreading.presenter.BasePresenter;
import com.ymzs.funreading.view.BaseView;

import java.util.List;

/**
 * Created by xumingtao on 2017/9/20.
 */

public interface PhotoListContract {

    interface View extends BaseView<Presenter>{
        void showPhotos(List<Photo> photos);
        void showRefreshOK();
        void showRefreshError();
    }

    interface Presenter extends BasePresenter<View>{
        void refresh();
    }
}
