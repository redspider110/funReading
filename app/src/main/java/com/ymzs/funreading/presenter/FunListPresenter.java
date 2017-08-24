package com.ymzs.funreading.presenter;

import android.util.Log;

import com.ymzs.funreading.contract.FunListContract;
import com.ymzs.funreading.model.DataRepository;
import com.ymzs.funreading.model.DataSource;
import com.ymzs.funreading.model.Fun;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by xumingtao on 2017/8/22.
 */

public class FunListPresenter implements FunListContract.Presenter{
    private static final String TAG = ":XMT:FunListPresenter:";
    public DataRepository mDataRepository;
    public FunListContract.View mFunListView;
    public Disposable mDisposable;

    public FunListPresenter(DataRepository dataRepository){
        mDataRepository = dataRepository;
    }

    @Override
    public void subscribe() {
        loadFuns();
    }

    @Override
    public void unSubscribe() {
        dispose();
    }

    @Override
    public void takeView(FunListContract.View view) {
        mFunListView = view;
    }

    @Override
    public void dropView() {
        mFunListView = null;
    }

    private void loadFuns(){
        mDataRepository.getFuns()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<Fun>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        mDisposable = d;
                    }

                    @Override
                    public void onSuccess(@NonNull List<Fun> funs) {
                        for(Fun fun : funs) {
                            Log.d(TAG, "onSuccess: fun = " + fun.getAuthor());
                        }
                        mFunListView.showFuns(funs);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.d(TAG, "onError: e = " + e);
                    }
                });

    }

    private void dispose(){
        if(mDisposable != null && !mDisposable.isDisposed()){
            mDisposable.dispose();
        }
    }
}
