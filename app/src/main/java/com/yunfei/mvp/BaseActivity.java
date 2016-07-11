package com.yunfei.mvp;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by yunfei on 16/7/4.
 */
public abstract class BaseActivity<T extends IPresenter> extends AppCompatActivity {
    protected T mPresenter;
    protected Context mContext;

    private Unbinder mUnbinder;
    protected final String TAG = getClass().getSimpleName();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        mUnbinder = ButterKnife.bind(this);
        mContext = this;
        mPresenter = getPresenter();
        initEventAndData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.unsubscribe();
        }
        mUnbinder.unbind();
    }

    protected abstract int getLayout();

    protected abstract T getPresenter();

    protected abstract void initEventAndData();
}
