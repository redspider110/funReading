package com.ymzs.funreading.view.fragment;

/**
 * Created by xumingtao on 2017/8/28.
 */

public class JiandanFragment extends FunListFragment {

    public JiandanFragment(){
        // Required empty public constructor
    }

    @Override
    public String getName() {
        return JiandanFragment.class.getSimpleName();
    }

    public static JiandanFragment newInstance(){
        return new JiandanFragment();
    }
}
