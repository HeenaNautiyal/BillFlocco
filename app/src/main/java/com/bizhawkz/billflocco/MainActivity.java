package com.bizhawkz.billflocco;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    Button bt1,bt2,bt3,bt4,bt5,bt6,bt7,bt8,bt9,bt10,bt11,bt12,bt13,bt14,bt15,bt16;
    SessionManager1 session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initToolBar();
        bt1=(Button)findViewById(R.id.btn_1);
        bt2=(Button)findViewById(R.id.btn_2);
        bt3=(Button)findViewById(R.id.btn_3);
        bt4=(Button)findViewById(R.id.btn_4);
        bt5=(Button)findViewById(R.id.btn_5);
        bt6=(Button)findViewById(R.id.btn_6);
        bt7=(Button)findViewById(R.id.btn_7);
        bt8=(Button)findViewById(R.id.btn_8);
        bt9=(Button)findViewById(R.id.btn_9);
        bt10=(Button)findViewById(R.id.btn_10);
        bt11=(Button)findViewById(R.id.btn_11);
        bt12=(Button)findViewById(R.id.btn_12);
        bt13=(Button)findViewById(R.id.btn_13);
        bt14=(Button)findViewById(R.id.btn_14);
        bt15=(Button)findViewById(R.id.btn_15);
        bt16=(Button)findViewById(R.id.btn_16);


        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ti = new Intent(MainActivity.this,AboutReflexology.class);
                startActivity(ti);
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ti = new Intent(MainActivity.this, AboutReflexology2.class);
                startActivity(ti);
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ti = new Intent(MainActivity.this, AboutReflexology3.class);
                startActivity(ti);
            }
        });
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ti = new Intent(MainActivity.this, AboutReflexology4.class);
                startActivity(ti);
            }
        });
        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ti = new Intent(MainActivity.this, AboutReflexology5.class);
                startActivity(ti);
            }
        });
        bt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ti = new Intent(MainActivity.this, AboutReflexology6.class);
                startActivity(ti);
            }
        });
        bt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ti = new Intent(MainActivity.this, AboutReflexology7.class);
                startActivity(ti);
            }
        });
        bt8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ti = new Intent(MainActivity.this, AboutReflexology8.class);
                startActivity(ti);
            }
        });
        bt9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ti = new Intent(MainActivity.this, AboutReflexology9.class);
                startActivity(ti);
            }
        });
        bt10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ti = new Intent(MainActivity.this, AboutReflexology10.class);
                startActivity(ti);
            }
        });
        bt11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ti = new Intent(MainActivity.this, AboutReflexology11.class);
                startActivity(ti);
            }
        });
        bt12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ti = new Intent(MainActivity.this, AboutReflexology12.class);
                startActivity(ti);
            }
        });
        bt13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ti = new Intent(MainActivity.this, AboutReflexology13.class);
                startActivity(ti);
            }
        });
        bt14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ti = new Intent(MainActivity.this, AboutReflexology14.class);
                startActivity(ti);
            }
        });
        bt15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ti = new Intent(MainActivity.this, AboutReflexology15.class);
                startActivity(ti);
            }
        });
        bt16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ti = new Intent(MainActivity.this, AboutReflexology16.class);
                startActivity(ti);
            }
        });
    }

    private void initToolBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("REFLEXOLOGY RESEARCH");
        toolbar.setTitleTextColor(Color.BLACK);
        setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(R.drawable.back2_icon);
        toolbar.setNavigationOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent It = new Intent(MainActivity.this, OptionScreen.class);
                        startActivity(It);
                    }
                });

    }
}
