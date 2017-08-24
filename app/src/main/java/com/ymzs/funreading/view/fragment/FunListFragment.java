package com.ymzs.funreading.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ymzs.funreading.R;
import com.ymzs.funreading.contract.FunListContract;
import com.ymzs.funreading.model.Fun;
import com.ymzs.funreading.view.adapter.FunListAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public abstract class FunListFragment extends BaseFragment implements FunListContract.View{
    public FunListContract.Presenter mFunListPresenter;
    private RecyclerView mFunRecyclerView;
    private FunListAdapter mFunListAdapter;

    public FunListFragment() {
        // Required empty public constructor
    }

    public void setFunListPresenter(FunListContract.Presenter presenter) {
        mFunListPresenter = presenter;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_fun_list, container, false);
        mFunRecyclerView = (RecyclerView) root.findViewById(R.id.fragment_fun_list_recyclerView);
        mFunRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mFunListAdapter = new FunListAdapter(getContext());
        mFunListAdapter.setData(new ArrayList<Fun>(0));
        mFunRecyclerView.setAdapter(mFunListAdapter);
        return root;
    }

    @Override
    public void showFuns(List<Fun> funs) {
        mFunListAdapter.setData(funs);
    }

    @Override
    public void onResume() {
        super.onResume();
        mFunListPresenter.takeView(this);
        mFunListPresenter.subscribe();
    }

    @Override
    public void onStop() {
        super.onStop();
        mFunListPresenter.unSubscribe();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mFunListPresenter.dropView();
    }
}
