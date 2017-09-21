package com.ymzs.funreading.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ymzs.funreading.R;
import com.ymzs.funreading.contract.PhotoListContract;
import com.ymzs.funreading.model.Photo;
import com.ymzs.funreading.view.adapter.PhotoListAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class PhotoListFragment extends BaseFragment implements PhotoListContract.View {

    PhotoListContract.Presenter mPhotoListPresenter;
    private RecyclerView mPhotoRecyclerView;
    private PhotoListAdapter mPhotoListAdapter;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private static final int DEFAULT_RECYCLER_VIEW_COLUMN = 2;


    public PhotoListFragment() {
        // Required empty public constructor
    }

    public static PhotoListFragment newInstance(){
        return new PhotoListFragment();
    }

    public void setPhotoListPresenter(PhotoListContract.Presenter presenter){
        mPhotoListPresenter = presenter;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_photo_list, container, false);
        mPhotoRecyclerView = (RecyclerView) root.findViewById(R.id.fragment_photo_list_recyclerView);
//        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(
//                DEFAULT_RECYCLER_VIEW_COLUMN, StaggeredGridLayoutManager.VERTICAL);
//        mPhotoRecyclerView.setLayoutManager(layoutManager);
        mPhotoRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mPhotoListAdapter = new PhotoListAdapter(getContext());
        mPhotoListAdapter.setData(new ArrayList<Photo>(0));
        mPhotoRecyclerView.setAdapter(mPhotoListAdapter);
        mSwipeRefreshLayout = (SwipeRefreshLayout) root.findViewById(R.id.fragment_photo_list_swipeRefreshLayout);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPhotoListPresenter.refresh();
            }
        });
        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPhotoListPresenter.takeView(this);
        mPhotoListPresenter.subscribe();
    }

    @Override
    public void onStop() {
        super.onStop();
        mPhotoListPresenter.unSubscribe();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPhotoListPresenter.dropView();
    }

    @Override
    public void showPhotos(List<Photo> photos) {
        mPhotoListAdapter.setData(photos);
    }

    @Override
    public void showRefreshOK() {
        if(mSwipeRefreshLayout.isRefreshing()){
            mSwipeRefreshLayout.setRefreshing(false);
        }
    }

    @Override
    public void showRefreshError() {
        if(mSwipeRefreshLayout.isRefreshing()){
            mSwipeRefreshLayout.setRefreshing(false);
        }
    }
}
