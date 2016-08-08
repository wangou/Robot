package com.wangou.robot.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.wangou.robot.R;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

@ContentView(R.layout.activity_web)
public class WebActivity extends BaseActivity {
    private String web_url;
    @ViewInject(R.id.webView)
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadWebView();
    }

    @Override
    protected void initViews() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(R.string.link);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    protected void initDatas(Intent intent) {
        web_url = intent.getStringExtra("url");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (android.R.id.home == item.getItemId()) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * 加载
     */
    private void loadWebView() {
        Toast.makeText(this, "页面加载中，请稍候...", Toast.LENGTH_SHORT).show();
        final WebViewClient client = new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                // TODO Auto-generated method stub
                //返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器
                view.loadUrl(url);
                return true;
            }

            public void onProgressChanged(WebView view, int newProgress) {
                // TODO Auto-generated method stub
                if (newProgress == 100) {
                    Toast.makeText(WebActivity.this, "网页加载完成", Toast.LENGTH_SHORT).show();
                } else {
                    // 加载中
                }
            }
        };
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        webView.setWebViewClient(client);
        webView.loadUrl(web_url);
    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack(); 
        } else {
            super.onBackPressed();
        }

    }
}
