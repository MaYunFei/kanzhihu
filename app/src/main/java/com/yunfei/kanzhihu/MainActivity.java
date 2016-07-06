package com.yunfei.kanzhihu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.socks.library.KLog;
import com.yunfei.kanzhihu.bean.CheckNew;
import com.yunfei.kanzhihu.home.HomeModel;

import rx.Observer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HomeModel homeModel = new HomeModel();
        homeModel.checkNew("1444899600").subscribe(new Observer<CheckNew>() {
            @Override
            public void onCompleted() {
                KLog.i("onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                KLog.i("onError = " + e.getMessage());
            }

            @Override
            public void onNext(CheckNew checkNew) {
                KLog.i("onNext " + checkNew.result );
            }
        });
    }
}
