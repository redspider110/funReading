package com.ymzs.funreading.contract;

import com.ymzs.funreading.model.Fun;
import com.ymzs.funreading.presenter.BasePresenter;
import com.ymzs.funreading.view.BaseView;

import java.util.List;

/**
 * Created by xumingtao on 2017/8/22.
 */

public interface FunListContract {

    interface View extends BaseView<Presenter>{
        void showFuns(List<Fun> funs);
        void showRefreshOK();
        void showRefreshError();
    }

    interface Presenter extends BasePresenter<View>{
        void refresh();
    }
}
