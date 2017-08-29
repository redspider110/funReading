package com.ymzs.funreading.view.fragment;

/**
 * Created by xumingtao on 2017/8/28.
 */

public class NhdzFragment extends FunListFragment {

    public NhdzFragment(){
        // Required empty public constructor
    }

    @Override
    public String getName() {
        return NhdzFragment.class.getSimpleName();
    }

    public static NhdzFragment newInstance(){
        return new NhdzFragment();
    }
}
