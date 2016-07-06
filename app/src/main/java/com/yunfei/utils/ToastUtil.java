package com.yunfei.utils;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.widget.Toast;

/**
 * 吐丝
 * Created by yunfei on 16/7/4.
 */
public class ToastUtil {

    public static void showShortToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public static void showShortToast(Fragment fragment, String message) {
        showShortToast(fragment.getContext(), message);
    }


}
