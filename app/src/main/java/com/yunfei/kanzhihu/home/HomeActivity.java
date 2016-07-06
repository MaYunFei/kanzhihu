package com.yunfei.kanzhihu.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;

import com.yunfei.kanzhihu.R;
import com.yunfei.mvp.BaseActivity;
import com.yunfei.utils.ActivityUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by yunfei on 16/7/4.
 */
public class HomeActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_act);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);
        HomeFragment homeFragment = (HomeFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);
        if (homeFragment == null) {
            homeFragment = HomeFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), homeFragment, R.id.contentFrame);
        }

        new HomePresenter(homeFragment, new HomeModel());

    }
}
