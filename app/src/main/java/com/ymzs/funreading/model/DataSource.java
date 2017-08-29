package com.ymzs.funreading.model;

import android.support.annotation.NonNull;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;

/**
 * Created by xumingtao on 2017/8/22.
 */

public interface DataSource {
    Single<List<Fun>> getFuns(int type);
}
