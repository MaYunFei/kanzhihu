package com.yunfei.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.socks.library.KLog;
import com.yunfei.net.APIException;
import com.yunfei.utils.ToastUtil;

import java.net.ConnectException;
import java.net.SocketTimeoutException;

import butterknife.ButterKnife;

/**
 * Created by yunfei on 16/7/4.
 */
public abstract class BaseFragment extends Fragment implements ILoading {


    private static final String TAG = "BaseFragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(getLayout(), container, false);
        ButterKnife.bind(this, root);
        return root;
    }

    protected abstract int getLayout();

    @Override
    public void onResume() {
        super.onResume();
        //方便 查看是哪个页面
        KLog.i("-----------------" + getClass().getName() + "-----------------");
    }

    @Override
    public void showLoading() {
        ToastUtil.showShortToast(this, "showLoading");
        KLog.i(TAG, "show "+Thread.currentThread().getName());
    }

    @Override
    public void hideLoading() {
        ToastUtil.showShortToast(this, "hideLoading");
        KLog.i(TAG, "hide "+Thread.currentThread().getName());
    }

    @Override
    public void onError(Throwable e) {
        if (e instanceof APIException) {
            showServerError(e.getMessage());
        } else if (e instanceof SocketTimeoutException) {
            ToastUtil.showShortToast(this, "网络中断，请检查您的网络状态");
        } else if (e instanceof ConnectException) {
            ToastUtil.showShortToast(this, "网络中断，请检查您的网络状态");
        }
    }

    protected void showServerError(String message) {
        ToastUtil.showShortToast(this, message);
    }
}
