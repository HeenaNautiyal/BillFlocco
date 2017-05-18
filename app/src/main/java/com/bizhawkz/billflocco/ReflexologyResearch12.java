package com.bizhawkz.billflocco;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class ReflexologyResearch12 extends AppCompatActivity {
    Toolbar toolbar;
    WebView webView;
    ProgressDialog pb;
    String url;
    SwipeRefreshLayout mySwipeRefreshLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reflexology_research12);
        mySwipeRefreshLayout = (SwipeRefreshLayout) this.findViewById(R.id.swipeContainer);
        webView = (WebView) findViewById(R.id.web1);
        initToolBar();

        pb = new ProgressDialog(ReflexologyResearch12.this);
        pb.setMessage("Please wait while Loading...");
        pb.show();
        pb.setCancelable(false);

        webView.setWebViewClient(new MyWebViewClient());
        url = "http://www.americanacademyofreflexology.com/meaning-of-peer-review/#more-1114";
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
                webView.loadUrl("javascript:(function() { " +
                        "document.getElementsByClassName('responsive-menu-button responsive-menu-boring\n" +
                        "         responsive-menu-accessible')[0].style.display='none'; })()");

                pb.dismiss();
                mySwipeRefreshLayout.setRefreshing(false);
            }

            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(ReflexologyResearch12.this);
                TextView myMsg = new TextView(ReflexologyResearch12.this);
                myMsg.setText("Mobile Data is off");
                myMsg.setGravity(Gravity.CENTER_HORIZONTAL);
                myMsg.setTextSize(20);
                myMsg.setTextColor(Color.BLACK);
                builder.setCustomTitle(myMsg);
                builder.setMessage("Turn on mobile data or use Wi-Fi to access data.");
                builder.setPositiveButton("ok",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int which) {
                                dialog.cancel();
                            }
                        });
                builder.setNegativeButton("Setting", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,
                                        int which) {
                        startActivityForResult(new Intent(android.provider.Settings.ACTION_SETTINGS), 0);
                        dialog.cancel();
                    }
                });
                builder.show();
            }
        });
        webView.loadUrl(url);
        mySwipeRefreshLayout.setOnRefreshListener(
                new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        pb = new ProgressDialog(ReflexologyResearch12.this);
                        pb.setMessage("Please wait while Loading...");
                        pb.show();
                        pb.setCancelable(false);
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
        toolbar.setTitle("Meaning of PEER REVIEW");
        toolbar.setTitleTextColor(Color.BLACK);
        setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(R.drawable.back2_icon);
        toolbar.setNavigationOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent It = new Intent(ReflexologyResearch12.this, ResearchOption.class);
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
