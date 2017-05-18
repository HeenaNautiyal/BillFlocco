package com.bizhawkz.billflocco;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class OptionScreen extends AppCompatActivity implements ConnectivityReceiver.ConnectivityReceiverListener {
    ImageView tv_about,tv_blog,tv_home,tv_research,tv_resource,tv_contact;
    SessionManager1 session;
    TextView tv1,tv2,tv3,tv4,tv5,tv6;
    Button btn_1,btn_2,btn_3,btn_4;
    Toolbar toolbar;
    private CoordinatorLayout coordinatorLayout;
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option_screen);
         coordinatorLayout = (CoordinatorLayout) findViewById(R.id
                 .coordinatorlayout);

         session = new SessionManager1(getApplicationContext());
         session.checkLogin();


         ConnectivityManager connManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
         NetworkInfo mWifi = connManager.getActiveNetworkInfo();
         checkConnection();

        tv_home = (ImageView) findViewById(R.id.i_home);
        tv_about = (ImageView) findViewById(R.id.i_about);
        tv_blog = (ImageView) findViewById(R.id.i_article);
        tv_research = (ImageView) findViewById(R.id.i_research);
        tv_resource = (ImageView) findViewById(R.id.i_Resource);
        tv_contact = (ImageView) findViewById(R.id.i_contactUs);
         tv1=(TextView)findViewById(R.id.tvHome);
         tv2=(TextView)findViewById(R.id.tvAbout);
         tv3=(TextView)findViewById(R.id.tvarticle);
         tv4=(TextView)findViewById(R.id.tvReaserch);
         tv5=(TextView)findViewById(R.id.tvResource);
         tv6=(TextView)findViewById(R.id.tvcontact);

         btn_1=(Button)findViewById(R.id.btn1);
         btn_2=(Button)findViewById(R.id.btn2);

         btn_4=(Button)findViewById(R.id.btn4);

         tv2.setText("About Us & Reflexology");
         tv1.setText("Home");
         tv3.setText("Articles/Blogs");
         tv4.setText("Reflexology Research");
         tv5.setText("Resource Link");
         tv6.setText("Contact Us");

         Typeface tf = Typeface.createFromAsset(this.getAssets(),
                 "fonts2/GeosansLight.ttf");
         tv1.setTypeface(tf);
         tv2.setTypeface(tf);
         tv3.setTypeface(tf);
         tv4.setTypeface(tf);
         tv5.setTypeface(tf);
         tv6.setTypeface(tf);

         tv2.setTextSize(16);
         tv1.setTextSize(16);
         tv3.setTextSize(16);
         tv4.setTextSize(16);
         tv5.setTextSize(16);
         tv6.setTextSize(16);


        session = new SessionManager1(getApplicationContext());
        session.checkLogin();

         btn_1.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent ti = new Intent(OptionScreen.this, Main1.class);
                 startActivity(ti);
             }
         });
         btn_2.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent ti = new Intent(OptionScreen.this, Main2.class);
                 startActivity(ti);
             }
         });

         btn_4.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent ti = new Intent(OptionScreen.this, Main3.class);
                 startActivity(ti);
             }
         });

        tv_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ti = new Intent(OptionScreen.this, Home.class);
                startActivity(ti);
            }
        });
        tv_about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ti = new Intent(OptionScreen.this, MainActivity.class);
                startActivity(ti);
            }
        });
        tv_blog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ti = new Intent(OptionScreen.this, Blog.class);
                startActivity(ti);
            }
        });
        tv_research.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ti = new Intent(OptionScreen.this, ResearchOption.class);
                startActivity(ti);
            }
        });
        tv_resource.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ti = new Intent(OptionScreen.this, ResourceOption.class);
                startActivity(ti);
            }
        });
        tv_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent ti = new Intent(OptionScreen.this, Contactus.class);
                startActivity(ti);
            }
        });
    }

    private void checkConnection() {
                   boolean isConnected = ConnectivityReceiver.isConnected();
        showSnack(isConnected);
    }

    private void showSnack(boolean isConnected) {
        String message;
        int color;
        if (!isConnected) {
            message = "Sorry! Not connected to internet";
            color = Color.WHITE;
            Snackbar snackbar = Snackbar
                    .make(coordinatorLayout, message, Snackbar.LENGTH_LONG)
                    .setDuration(10000);

            View sbView = snackbar.getView();
            TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
            textView.setTextColor(color);
            snackbar.show();
        }

    }

    @Override
    public void onNetworkConnectionChanged(boolean isConnected) {
        showSnack(isConnected);
    }

    public void onBackPressed() {
        moveTaskToBack(false);
    }
}
