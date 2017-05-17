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
import android.widget.TextView;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class Registration extends AppCompatActivity {
    EditText ed_firstname, ed_lastname, ed_emailid, ed_password, ednumber;
    String name, lstname, mail, password, number;
    Button btnRegi;
    int aging;
    ProgressDialog pb;
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
        setContentView(R.layout.activity_registration);
        pb = new ProgressDialog(com.bizhawkz.billflocco.Registration.this);
        ed_firstname = (EditText) findViewById(R.id.ed_firstName);
        ed_lastname = (EditText) findViewById(R.id.ed_LastName);
        ed_emailid = (EditText) findViewById(R.id.ed_mail);
        ed_password = (EditText) findViewById(R.id.ed_password);
        ednumber = (EditText) findViewById(R.id.ed_number);

        btnRegi = (Button) findViewById(R.id.btn_Submit);
        btnRegi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = ed_firstname.getText().toString();
                lstname = ed_lastname.getText().toString();
                mail = ed_emailid.getText().toString();
                password = ed_password.getText().toString();
                number=ednumber.getText().toString();
                if (password.length() < 4) {
                    ed_password.requestFocus();
                    ed_password.setError("You must have 6 characters in your password");
                    return;
                }
                if (name.matches("") || lstname.matches("") || mail.matches("") ||
                        password.matches("") || number.matches("")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(com.bizhawkz.billflocco.Registration.this);
                    TextView myMsg = new TextView(com.bizhawkz.billflocco.Registration.this);
                    myMsg.setText("Warning!");
                    myMsg.setGravity(Gravity.CENTER_HORIZONTAL);
                    myMsg.setTextSize(20);

                    myMsg.setTextColor(Color.BLACK);
                    builder.setCustomTitle(myMsg);
                    builder.setMessage("All fields are mandatory");
                    builder.setPositiveButton("OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,
                                                    int which) {
                                    dialog.cancel();
                                }
                            });
                    builder.show();
                } else {
                    if (mail.matches(Expn) && mail.length() > 0) {
                        new Register().execute();
                        Intent it = new Intent(Registration.this, Login.class);
                        startActivity(it);
                    }else {
                        ed_emailid.requestFocus();
                        ed_emailid.setError("Please enter a valid mail ID!");
                    }
                }
            }
        });
    }

    private class Register extends AsyncTask<String, String, String> {
        protected void onPreExecute() {
            super.onPreExecute();

            pb.setMessage("Please wait while Loading...");
            pb.show();
            pb.setCancelable(false);
            name = ed_firstname.getText().toString();
            lstname = ed_lastname.getText().toString();
            mail = ed_emailid.getText().toString();
            password = ed_password.getText().toString();
            number = ednumber.getText().toString();

        }

        @Override
        protected String doInBackground(String... strings) {
            HttpClient httpClient = new DefaultHttpClient();

            String url1 = "http://americanacademyofreflexology.com/App_mObile/insertdata.php?" +
                    "caseid=1&fname="+name.replaceAll(" ","")+"&lname="+lstname.replaceAll(" ","")+"" +
                    "&email="+mail.replaceAll(" ","")+"&password="+password.replaceAll(" ","")+"" +
                    "&mobileno="+number.replaceAll(" ","")+"";

            String SetServerString = "";
            HttpGet httpget = new HttpGet(url1);
            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            try {
                SetServerString = httpClient.execute(httpget, responseHandler);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Log.d("Response: ", "> " + SetServerString);
            return SetServerString;
        }

        protected void onPostExecute(String result) {
            try {
                pb.dismiss();
                JSONObject jsonResult = new JSONObject(result);
                String message = jsonResult.getString("udata");
                Log.d("Response: ", "> " + message);
                if (message.equals("1")) {
                    final AlertDialog.Builder builder = new AlertDialog.Builder(Registration.this);
                    TextView myMsg = new TextView(Registration.this);
                    myMsg.setText("Congratulations!");
                    myMsg.setGravity(Gravity.CENTER_HORIZONTAL);
                    myMsg.setTextSize(20);
                    myMsg.setTextColor(Color.BLACK);
                    builder.setCustomTitle(myMsg);
                    builder.setMessage("You have Registered in successfully.");
                    builder.setPositiveButton("OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,
                                                    int which) {
                                    dialog.dismiss();
                                    ed_firstname.setText("");
                                    ed_lastname.setText("");
                                    ed_emailid.setText("");
                                    ed_password.setText("");
                                    ednumber.setText("");
                                    Intent it = new Intent(Registration.this, Login.class);
                                    startActivity(it);
                                }
                            });
                    builder.show();
                } else {
                    final AlertDialog.Builder builder = new AlertDialog.Builder(Registration.this);
                    TextView myMsg = new TextView(Registration.this);
                    myMsg.setText("Warning!");
                    myMsg.setGravity(Gravity.CENTER_HORIZONTAL);
                    myMsg.setTextSize(20);
                    myMsg.setTextColor(Color.BLACK);
                    builder.setCustomTitle(myMsg);
                    builder.setMessage("This mail id is already registered.");
                    builder.setPositiveButton("OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,
                                                    int which) {
                                    dialog.dismiss();
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

