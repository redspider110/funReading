package com.ymzs.funreading.presenter;

import android.util.Log;

import com.ymzs.funreading.contract.PhotoListContract;
import com.ymzs.funreading.model.DataRepository;
import com.ymzs.funreading.model.Photo;

import java.util.List;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by xumingtao on 2017/9/20.
 */

public class PhotoListPresenter implements PhotoListContract.Presenter{

    private static final String TAG = ":XMT:PhotoPresenter:";

    DataRepository mDataRepository;
    PhotoListContract.View mPhotoListView;

    private Disposable mDisposable;
    private boolean mIsRefreshing = false;

    public PhotoListPresenter(DataRepository dataRepository){
        mDataRepository = dataRepository;
    }

    @Override
    public void subscribe() {
        loadPhotos();
    }

    @Override
    public void unSubscribe() {
        dispose();
    }

    @Override
    public void takeView(PhotoListContract.View view) {
        mPhotoListView = view;
    }

    @Override
    public void dropView() {
        mPhotoListView = null;
    }

    @Override
    public void refresh() {
        mIsRefreshing = true;
        mDataRepository.loadMorePhotos()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<Photo>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        mDisposable = d;
                    }

                    @Override
                    public void onSuccess(@NonNull List<Photo> photos) {
                        mPhotoListView.showPhotos(photos);
                        Log.d(TAG, "onSuccess: photos.size: " + photos.size());
                        Log.d(TAG, "onSuccess: photos: " + photos);
                        showRefresh(true);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.d(TAG, "onError: e = " + e);
                        showRefresh(false);
                        e.printStackTrace();
                    }
                });
    }

    private void loadPhotos(){
        mDataRepository.loadPhotos()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<Photo>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        mDisposable = d;
                    }

                    @Override
                    public void onSuccess(@NonNull List<Photo> photos) {
                        mPhotoListView.showPhotos(photos);
                        Log.d(TAG, "onSuccess: photos.size: " + photos.size());
                        Log.d(TAG, "onSuccess: photos: " + photos);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.d(TAG, "onError: e = " + e.toString());
                        e.printStackTrace();
                    }
                });
    }

    private void dispose(){
        if(mDisposable != null && !mDisposable.isDisposed()){
            mDisposable.dispose();
        }
    }

    private void showRefresh(boolean isOK){
        if(mIsRefreshing){
            mIsRefreshing = false;
            if(isOK){
                mPhotoListView.showRefreshOK();
            }else {
                mPhotoListView.showRefreshError();
            }
        }
    }
}
