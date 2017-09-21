package com.ymzs.funreading.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;

import com.ymzs.funreading.FunReadingApplication;
import com.ymzs.funreading.R;
import com.ymzs.funreading.model.DataRepository;
import com.ymzs.funreading.presenter.PhotoListPresenter;
import com.ymzs.funreading.utils.ActivityUtils;
import com.ymzs.funreading.view.fragment.PhotoListFragment;

public class PhotoListActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.activity_photo_list_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        PhotoListFragment photoListFragment = (PhotoListFragment) getSupportFragmentManager()
                .findFragmentById(R.id.activity_photo_list_framelayout);
        if(photoListFragment == null){
            photoListFragment = PhotoListFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                    photoListFragment, R.id.activity_photo_list_framelayout);
        }

        DataRepository dataRepository = ((FunReadingApplication)getApplication()).getDataRepository();
        PhotoListPresenter photoListPresenter = new PhotoListPresenter(dataRepository);
        photoListFragment.setPhotoListPresenter(photoListPresenter);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}
