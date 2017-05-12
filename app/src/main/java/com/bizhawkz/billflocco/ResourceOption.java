package com.bizhawkz.billflocco;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class ResourceOption extends AppCompatActivity {
    Toolbar toolbar;
    Button bt1,bt2,bt3,bt4,bt5,bt6,bt7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resource_option);

        initToolBar();
        bt1=(Button)findViewById(R.id.btn_1);
        bt2=(Button)findViewById(R.id.btn_2);
        bt3=(Button)findViewById(R.id.btn_3);
        bt4=(Button)findViewById(R.id.btn_4);
        bt5=(Button)findViewById(R.id.btn_5);
        bt6=(Button)findViewById(R.id.btn_6);
        bt7=(Button)findViewById(R.id.btn_7);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ti = new Intent(ResourceOption.this,ReflexologyResource.class);
                startActivity(ti);
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ti = new Intent(ResourceOption.this, ReflexologyResource2.class);
                startActivity(ti);
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ti = new Intent(ResourceOption.this, ReflexologyResource3.class);
                startActivity(ti);
            }
        });
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ti = new Intent(ResourceOption.this, ReflexologyResource4.class);
                startActivity(ti);
            }
        });
        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ti = new Intent(ResourceOption.this, ReflexologyResource5.class);
                startActivity(ti);
            }
        });
        bt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ti = new Intent(ResourceOption.this, ReflexologyResource6.class);
                startActivity(ti);
            }
        });
        bt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ti = new Intent(ResourceOption.this, ReflexologyResource7.class);
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
                        Intent It = new Intent(ResourceOption.this, OptionScreen.class);
                        startActivity(It);
                    }
                });
    }

}
