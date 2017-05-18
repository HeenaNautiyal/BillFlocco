package com.bizhawkz.billflocco;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class Contactus extends AppCompatActivity {
    EditText mail,sub,message;
    String ed_mal,ed_sub,ed_message;
    Button btn1;
    ProgressDialog pb;
    ImageView tvpower;
    SessionManager1 session;
    String Expn =
            "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                    + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                    + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                    + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                    + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
                    + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactus);
        pb = new ProgressDialog(Contactus.this);
        mail=(EditText)findViewById(R.id.ed_emil);
        sub=(EditText)findViewById(R.id.ed_su);
        message=(EditText)findViewById(R.id.ed_message);
        btn1=(Button)findViewById(R.id.btn_Submit);
        tvpower=(ImageView)findViewById(R.id.iv_log);


        session = new SessionManager1(getApplicationContext());
        tvpower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(Contactus.this);
                TextView myMsg = new TextView(Contactus.this);
                myMsg.setText("Logout!");
                myMsg.setGravity(Gravity.CENTER_HORIZONTAL);
                myMsg.setTextSize(20);

                myMsg.setTextColor(Color.BLACK);
                builder.setCustomTitle(myMsg);
                builder.setMessage("Do you want to logout?");
                builder.setPositiveButton("Yes,Logout",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int which) {
                               session.logoutUser();
                                Intent intent = new Intent(Contactus.this, Login.class);
                                startActivity(intent);
                                finish();
                            }
                        });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,
                                        int which) {
                    }
                });
                builder.show();
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ed_mal=mail.getText().toString();
                ed_sub=sub.getText().toString();
                ed_message=message.getText().toString();
                if (ed_mal.matches("") || ed_sub.matches("")||(ed_message.matches(""))) {

                    AlertDialog.Builder builder = new AlertDialog.Builder(Contactus.this);
                    TextView myMsg = new TextView(Contactus.this);
                    myMsg.setText("Warning!");
                    myMsg.setGravity(Gravity.CENTER_HORIZONTAL);
                    myMsg.setTextSize(20);

                    myMsg.setTextColor(Color.BLACK);
                    builder.setCustomTitle(myMsg);
                    builder.setMessage("All fields are mandatory.");
                    builder.setPositiveButton("OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,
                                                    int which) {
                                    dialog.cancel();
                                }
                            });
                    builder.show();
                }
                else {
                    if (ed_mal.matches(Expn) && ed_mal.length() > 0) {
                        session.createLoginSession(ed_mal.replaceAll(" ", ""));
                        //new Contact().execute();
                    }else {
                        mail.requestFocus();
                        mail.setError("Please enter a valid mail ID!");
                    }
                 //
                }

            }
        });

    }

    private class Contact extends AsyncTask<String,String ,String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pb.setMessage("Please wait while Loading...");
            pb.show();
            ed_mal=mail.getText().toString();
            ed_sub=sub.getText().toString();
            ed_message=message.getText().toString();
            ed_message=ed_message.replaceAll("\n","%20");
        }


        @Override
        protected String doInBackground(String... urls) {
            HttpClient httpClient = new DefaultHttpClient();
            String url ="http://americanacademyofreflexology.com/App_mObile/insertdata.php?caseid=4" +
                    "&email="+ed_mal.replaceAll(" ","")+"&subject="+ed_mal.replaceAll(" ","")+"" +
                    "&message="+ed_message.replaceAll(" ","")+"";
            String SetServerString = "";
            HttpGet httpget = new HttpGet(url);
            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            try {
                SetServerString = httpClient.execute(httpget, responseHandler);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Log.d("Response: ", "> " + SetServerString);
            return SetServerString;
        }
        @Override
        protected void onPostExecute(String result) {
            pb.cancel();
            try {
                pb.dismiss();
                JSONObject jsonResult = new JSONObject(result);
                final String message = jsonResult.getString("udata");
                Log.d("Response: ", "> " + message);
                if (message.equals("1")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(Contactus.this);
                    TextView myMsg = new TextView(Contactus.this);
                    myMsg.setText("Thanks!");
                    myMsg.setGravity(Gravity.CENTER_HORIZONTAL);
                    myMsg.setTextSize(20);
                    myMsg.setTextColor(Color.BLACK);
                    builder.setCustomTitle(myMsg);
                    builder.setMessage("Your message has been sent successfully.");
                    builder.setPositiveButton("Continue",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,
                                                    int which) {
                                    mail.setText("");
                                    sub.setText("");
                                    Intent it = new Intent(Contactus.this, OptionScreen.class);
                                    startActivity(it);
                                }
                            });
                    builder.show();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

    }
}
