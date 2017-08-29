package com.ymzs.funreading.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ymzs.funreading.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class QsbkFragment extends FunListFragment {

    public QsbkFragment() {
        // Required empty public constructor
    }

    @Override
    public String getName() {
        return QsbkFragment.class.getSimpleName();
    }

    public static QsbkFragment newInstance(){
        return new QsbkFragment();
    }
}
