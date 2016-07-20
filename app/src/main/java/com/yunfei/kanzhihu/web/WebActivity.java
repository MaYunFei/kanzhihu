package com.yunfei.kanzhihu.web;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.socks.library.KLog;
import com.yunfei.kanzhihu.R;
import com.yunfei.mvp.BaseActivity;
import com.yunfei.mvp.IPresenter;

import butterknife.BindView;

/**
 * Created by yunfei on 16/7/11.
 */
public class WebActivity extends BaseActivity {
    private static final String EXTRA_URL = "extra_url";


    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.progress_bar)
    ProgressBar mProgressBar;
    @BindView(R.id.webView)
    WebView mWebView;

    public static void startActivity(Context context, String url) {
        Intent intent = new Intent(context, WebActivity.class);
        intent.putExtra(EXTRA_URL, url);
        context.startActivity(intent);
    }


    @Override
    protected int getLayout() {
        return R.layout.web_act;
    }

    @Override
    protected IPresenter getPresenter() {
        return null;
    }

    @Override
    protected void initEventAndData() {

        String url = getIntent().getStringExtra(EXTRA_URL);
        if (TextUtils.isEmpty(url)) {
            finish();
            return;
        }

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        mToolbar.setNavigationOnClickListener(v -> {
            checkGoBack();
        });

        WebSettings settings = mWebView.getSettings();
        KLog.i(settings.getUserAgentString());
        settings.setJavaScriptEnabled(true);
        settings.setLoadWithOverviewMode(true);
        settings.setAppCacheEnabled(true);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        settings.setSupportZoom(true);
        mWebView.setWebChromeClient(new ChromeClient());
        mWebView.setWebViewClient(new Client());
        KLog.i(TAG,url);
        mWebView.loadUrl(url);
    }


    private class ChromeClient extends WebChromeClient {
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            mProgressBar.setProgress(newProgress);
            if (newProgress == 100) {
                mProgressBar.setVisibility(View.GONE);
            } else {
                mProgressBar.setVisibility(View.VISIBLE);
            }
            super.onProgressChanged(view, newProgress);
        }

        @Override
        public void onReceivedTitle(WebView view, String title) {
            super.onReceivedTitle(view, title);
        }
    }

    private class Client extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (url != null) {
                KLog.i(TAG, url);
                view.loadUrl(url);
            }
            return true;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        checkGoBack();
    }


    public void checkGoBack() {
        if (mWebView.canGoBack()) {
            mWebView.canGoBack();
        } else {
            finish();
        }
    }
}
