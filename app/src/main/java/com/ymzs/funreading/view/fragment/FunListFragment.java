package com.ymzs.funreading.view.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ymzs.funreading.R;
import com.ymzs.funreading.contract.FunListContract;
import com.ymzs.funreading.model.Fun;
import com.ymzs.funreading.presenter.FunListPresenter;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public abstract class FunListFragment extends BaseFragment implements FunListContract.View{

    public FunListContract.Presenter mFunListPresenter;

    public FunListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_fun_list, container, false);
        return root;
    }

    @Override
    public void showFuns(List<Fun> funs) {

    }

    @Override
    public void onResume() {
        super.onResume();
        //mFunListPresenter.takeView(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //mFunListPresenter.dropView();
    }
}
