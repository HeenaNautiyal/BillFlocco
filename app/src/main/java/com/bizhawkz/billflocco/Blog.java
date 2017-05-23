package com.bizhawkz.billflocco;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Blog extends AppCompatActivity {
    Toolbar toolbar;
    WebView webView;
    ProgressDialog pb;
    String url;
    SwipeRefreshLayout mySwipeRefreshLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog);
        mySwipeRefreshLayout = (SwipeRefreshLayout) this.findViewById(R.id.swipeContainer);
        webView = (WebView) findViewById(R.id.web1);
        initToolBar();
        pb = new ProgressDialog(Blog.this);
        pb.setMessage("Please wait while Loading...");
        pb.show();
        pb.setCancelable(false);

        webView.setWebViewClient(new MyWebViewClient());
        url = "http://www.americanacademyofreflexology.com/articlesblogs-fascinating-facts/";
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                webView.loadUrl("javascript:(function() { " +
                        "document.getElementsByClassName('hiconleft')[0].style.display='none'; })()");
                webView.loadUrl("javascript:(function() { " +
                        "document.getElementsByClassName('bill_main_con')[0].style.display='none'; })()");
                webView.loadUrl("javascript:(function() { " +
                        "document.getElementsByClassName('top_mid_con')[0].style.display='none'; })()");
                webView.loadUrl("javascript:(function() { " +
                        "document.getElementsByClassName('logo_con')[0].style.display='none'; })()");
                webView.loadUrl("javascript:(function() { " +
                        "document.getElementsByClassName('tag_line_con')[0].style.display='none'; })()");
                webView.loadUrl("javascript:(function() { " +
                        "document.getElementsByClassName('footer_mid_con')[0].style.display='none'; })()");
                webView.loadUrl("javascript:document.getElementById(\"responsive-menu-item-28\").setAttribute(\"style\",\"display:none;\");");
                webView.loadUrl("javascript:document.getElementById(\"responsive-menu-item-3861\").setAttribute(\"style\",\"display:none;\");");
                webView.loadUrl("javascript:document.getElementById(\"responsive-menu-item-3734\").setAttribute(\"style\",\"display:none;\");");
                webView.loadUrl("javascript:document.getElementById(\"responsive-menu-item-3495\").setAttribute(\"style\",\"display:none;\");");
                webView.loadUrl("javascript:document.getElementById(\"responsive-menu-item-3465\").setAttribute(\"style\",\"display:none;\");");
                webView.loadUrl("javascript:document.getElementById(\"responsive-menu-item-22\").setAttribute(\"style\",\"display:none;\");");


                pb.dismiss();
                mySwipeRefreshLayout.setRefreshing(false);
            }

            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Intent it = new Intent(Blog.this, Network.class);
                startActivity(it);
            }
        });
        webView.loadUrl(url);
        mySwipeRefreshLayout.setOnRefreshListener(
                new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        webView.reload();
                    }
                }
        );
    }

    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }
    }


    private void initToolBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("ARTICLES/BLOGS");
        toolbar.setTitleTextColor(Color.BLACK);
        setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(R.drawable.back2_icon);
        toolbar.setNavigationOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent It = new Intent(Blog.this, OptionScreen.class);
                        startActivity(It);
                    }
                });
    }
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onBackPressed() {

        if (webView.canGoBack()) {
            pb.show();
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
