package com.ymzs.funreading.activity;

import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.ymzs.funreading.R;
import com.ymzs.funreading.contract.FunListContract;
import com.ymzs.funreading.model.DataRepository;
import com.ymzs.funreading.model.local.LocalDataSource;
import com.ymzs.funreading.model.remote.RemoteDataSource;
import com.ymzs.funreading.presenter.FunListPresenter;
import com.ymzs.funreading.view.fragment.FunListFragment;
import com.ymzs.funreading.view.fragment.JiandanFragment;
import com.ymzs.funreading.view.fragment.NhdzFragment;
import com.ymzs.funreading.view.fragment.QsbkFragment;

public class FunListActivity extends BaseActivity {

    public static final int VIEW_PAGER_LIMIT = 3;
    private DrawerLayout mDrawerLayout;
    private DataRepository mDataRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun_list_activity);

        Toolbar toolbar = (Toolbar) findViewById(R.id.activity_fun_list_toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.drawable.ic_menu);
        ab.setDisplayHomeAsUpEnabled(true);

        // Set up the navigation drawer.
        mDrawerLayout = (DrawerLayout) findViewById(R.id.activity_fun_list_drawerLayout);
        mDrawerLayout.setStatusBarBackground(R.color.colorPrimaryDark);
        NavigationView navigationView = (NavigationView) findViewById(R.id.activity_fun_list_nav);
        if (navigationView != null) {
            setupDrawerContent(navigationView);
        }

        ViewPager viewPager = (ViewPager) findViewById(R.id.activity_fun_list_viewPager);
        viewPager.setOffscreenPageLimit(VIEW_PAGER_LIMIT);
        viewPager.setAdapter(new FunListPagerAdapter(getSupportFragmentManager()));
        TabLayout tabLayout = (TabLayout) findViewById(R.id.activity_fun_list_tabLayout);
        tabLayout.setupWithViewPager(viewPager);

        mDataRepository = new DataRepository(new LocalDataSource(this), new RemoteDataSource());
    }

    private class FunListPagerAdapter extends FragmentPagerAdapter{
        private String[] mTitles;

        public FunListPagerAdapter(FragmentManager fm) {
            super(fm);
            mTitles = getResources().getStringArray(R.array.view_pager_titles);
        }

        @Override
        public Fragment getItem(int position) {
            FunListFragment funListFragment;
            String title = mTitles[position];
            String qsbk = getString(R.string.title_qsbk);
            String jiandan = getString(R.string.title_jian_dan);
            String nhdz = getString(R.string.title_nhdz);
            if(title.equals(qsbk)){
                funListFragment = QsbkFragment.newInstance();
            }else if(title.equals(jiandan)){
                funListFragment = JiandanFragment.newInstance();
            }else if(title.equals(nhdz)){
                funListFragment = NhdzFragment.newInstance();
            }else {
                funListFragment = QsbkFragment.newInstance();
            }
            FunListContract.Presenter funListPresenter = new FunListPresenter(mDataRepository);
            funListFragment.setFunListPresenter(funListPresenter);
            return funListFragment;
        }

        @Override
        public int getCount() {
            return mTitles.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles[position];
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // Open the navigation drawer when the home icon is selected from the toolbar.
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.nav_menu_fun_list:
                                // null
                                break;
                            case R.id.nav_menu_about:
                                // null
                                break;
                            default:
                                break;
                        }
                        // Close the navigation drawer when an item is selected.
                        menuItem.setChecked(true);
                        mDrawerLayout.closeDrawers();
                        return true;
                    }
                });
    }
}
