package com.yunfei.kanzhihu.home;

import android.support.v7.widget.Toolbar;

import com.socks.library.KLog;
import com.yunfei.kanzhihu.R;
import com.yunfei.mvp.BaseActivity;

import butterknife.BindView;

/**
 * Created by yunfei on 16/7/4.
 */
public class HomeActivity extends BaseActivity<HomePresenter> implements HomeContract.View {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;


    @Override
    protected int getLayout() {
        return R.layout.home_act;
    }

    @Override
    protected HomePresenter getPresenter() {
        return new HomePresenter(this);
    }

    @Override
    protected void initEventAndData() {
        setSupportActionBar(mToolbar);
        mPresenter.subscribe();
    }

    @Override
    public void showLoading() {
        KLog.i("showLoading");
    }

    @Override
    public void hideLoading() {
        KLog.i("hideLoading");
    }

    @Override
    public void onError(Throwable e) {

    }
}
