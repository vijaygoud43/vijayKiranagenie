package com.mbr.KiranaGenie.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.mbr.KiranaGenie.Api.VolleySingleton;
import com.mbr.KiranaGenie.Model.RegisterResponseModel;
import com.mbr.KiranaGenie.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class SignUp extends AppCompatActivity implements View.OnClickListener{
    AppCompatButton btn_register;
    AppCompatEditText edt_edt_regfname, edt_edt_reglname, edt_edt_regmobile, edt_edt_regemail, edt_edt_regpwd;
    RequestQueue request;
    String session_id="602d6be17957f0a91d8127e875";
    String merchant_id="ov7jd2p8n3Stdlj0oXu5HGjzUHygco8s";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        btn_register = (AppCompatButton) findViewById(R.id.register);
        edt_edt_regfname = (AppCompatEditText) findViewById(R.id.edt_regfname);
        edt_edt_reglname = (AppCompatEditText) findViewById(R.id.edt_reglname);
        edt_edt_regmobile = (AppCompatEditText) findViewById(R.id.edt_regmobile);
        edt_edt_regemail = (AppCompatEditText) findViewById(R.id.edt_regemail);
        edt_edt_regpwd = (AppCompatEditText) findViewById(R.id.edt_regpwd);
        request= Volley.newRequestQueue(this);
        btn_register.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.register:
                registerUser();
                break;
        }
    }
    private void registerUser() {
        final ProgressDialog progressDialog = new ProgressDialog(SignUp.this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();
        String regexStr = "^[0-9]$";
        String MobilePattern = "[0-9]{10}";

        String remail = edt_edt_regemail.getText().toString().trim();
        String rpassword = edt_edt_regpwd.getText().toString().trim();
        String lname = edt_edt_reglname.getText().toString().trim();
        String rname = edt_edt_regfname.getText().toString().trim();
        String rphone = edt_edt_regmobile.getText().toString().trim();

        if (!remail.isEmpty() && !rpassword.isEmpty() && !lname.isEmpty() && !rname.isEmpty() && !rphone.isEmpty()) {
            if (rphone.length() == 10 && remail.matches(String.valueOf(Patterns.EMAIL_ADDRESS))
                    && rpassword.length() >= 8) {

                RequestQueue queue = Volley.newRequestQueue(this);
                 String URL_Reg = "http://192.168.1.65/sskMart/api/rest/register";
                StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_Reg,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                // progressBar.setVisibility(View.GONE);


                                try {
                                    //converting response to json object

                                    JSONObject obj = new JSONObject(response);
                                    Log.e("login response from reg", "" + response);
                                    //if no error in response
                                    if (obj.optString("success").equalsIgnoreCase("true")) {
                                        Toast.makeText(getApplicationContext(), obj.getString("data"), Toast.LENGTH_SHORT).show();

                                        //getting the user from the response
                                        JSONObject userJson = obj.getJSONObject("success");
                                        Log.e("respondse", "" + userJson);
                                        //creating a new user object
                                      /*  User user = new User(
                                                userJson.getString("firstname"),
                                                userJson.getString("lastname"),
                                                userJson.getString("email"),
                                                userJson.getString("telephone"),
                                                userJson.getString("password"),
                                                userJson.getString("Mbr@123123"),
                                                userJson.getString("id")

                                        );
*/
                                        //storing the user in shared preferences
                                   //     SharedPrefManager.getInstance(getApplicationContext()).userLogin(user);

                                        //starting the profile activity
                                        finish();
                                        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                                    } else {
                                        Toast.makeText(getApplicationContext(), obj.getString("message"), Toast.LENGTH_SHORT).show();
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        },

                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }) {
                    @Override
                    public String getBodyContentType() {
                        return "application/json; charset=utf-8";
                    }
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<>();
                        params.put("firstname", rname);
                        params.put("lastname", lname);
                        params.put("email", remail);
                        params.put("password", rpassword);
                        params.put("telephone", rphone);
                        params.put("confirm password", "Mbr@123123");
                        params.put("Content-Type", "application/json;charset=UTF-8");
                        params.put("X-Oc-Session",session_id);
                        params.put("X-Oc-Merchant-Id",merchant_id);
                     //   params.put("address", address);
                        return params;
                    }
                };
                queue.add(stringRequest);





            }
        }
        }
    }