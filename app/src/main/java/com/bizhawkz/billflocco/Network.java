package com.bizhawkz.billflocco;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Network extends AppCompatActivity {
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network);
        Typeface tf = Typeface.createFromAsset(this.getAssets(),
                "fonts2/GeosansLight.ttf");
        tv=(TextView)findViewById(R.id.tv1);
        tv.setTypeface(tf);
        tv.setTextSize(25);
        tv.setText("No internet connection.Please check your connection settings and try again,please click here..");
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Network.this,OptionScreen.class);
                startActivity(it);
            }
        });
    }
    public void onBackPressed() {
        moveTaskToBack(false);
    }
}
