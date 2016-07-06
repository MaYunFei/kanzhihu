package com.yunfei.kanzhihu.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.yunfei.kanzhihu.R;
import com.yunfei.mvp.BaseFragment;

/**
 * Created by yunfei on 16/7/4.
 */
public class HomeFragment extends BaseFragment implements HomeContract.View {

    private HomeContract.Presenter mPresenter;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter.subscribe();
    }

    @Override
    public void setPresenter(HomeContract.Presenter presenter) {
        mPresenter = presenter;
    }


}
