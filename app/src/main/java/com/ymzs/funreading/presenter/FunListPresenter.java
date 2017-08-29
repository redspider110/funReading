package com.ymzs.funreading.presenter;

import android.util.Log;

import com.ymzs.funreading.contract.FunListContract;
import com.ymzs.funreading.model.DataRepository;
import com.ymzs.funreading.model.Fun;
import com.ymzs.funreading.model.remote.ApiConstants;
import com.ymzs.funreading.view.fragment.FunListFragment;
import com.ymzs.funreading.view.fragment.JiandanFragment;
import com.ymzs.funreading.view.fragment.NhdzFragment;
import com.ymzs.funreading.view.fragment.QsbkFragment;

import java.util.List;

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
    private boolean mIsRefreshing = false;
    private int apiType = ApiConstants.API_TYPE_QSBK;

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
        Log.d(TAG, "takeView: ");
        mFunListView = view;
        if(mFunListView instanceof FunListFragment){
            Log.d(TAG, "takeView: view = " + ((FunListFragment) mFunListView).getName());
            if(mFunListView instanceof JiandanFragment){
                apiType = ApiConstants.API_TYPE_JIANDAN;
            }else if(mFunListView instanceof NhdzFragment){
                apiType = ApiConstants.API_TYPE_NHDZ;
            }else {
                apiType = ApiConstants.API_TYPE_QSBK;
            }
        }
    }

    @Override
    public void dropView() {
        mFunListView = null;
    }

    private void loadFuns(){
        Log.d(TAG, "loadFuns: apiType = " + apiType);
        mDataRepository.getFuns(apiType)
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
                        showRefresh(true);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.d(TAG, "onError: e = " + e);
                        showRefresh(false);
                    }
                });

    }

    private void dispose(){
        if(mDisposable != null && !mDisposable.isDisposed()){
            mDisposable.dispose();
        }
    }

    @Override
    public void refresh() {
        mIsRefreshing = true;
        loadFuns();
    }

    private void showRefresh(boolean isOK){
        if(mIsRefreshing){
            mIsRefreshing = false;
            if(isOK){
                mFunListView.showRefreshError();
            }else {
                mFunListView.showRefreshOK();
            }
        }
    }
}
