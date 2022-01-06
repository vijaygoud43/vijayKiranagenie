package com.mbr.KiranaGenie.Activities;

import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;

import com.mbr.KiranaGenie.Api.RetrofitClient;
import com.mbr.KiranaGenie.Model.RegisterResponseModel;
import com.mbr.KiranaGenie.R;
import com.mbr.KiranaGenie.data.request.RegisterRequestBody;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RegistrationActivity extends AppCompatActivity implements View.OnClickListener {
    AppCompatButton btn_register;
    AppCompatEditText edt_edt_regfname, edt_edt_reglname, edt_edt_regmobile, edt_edt_regemail, edt_edt_regpwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        getSupportActionBar().hide();
        btn_register = (AppCompatButton) findViewById(R.id.register);
        edt_edt_regfname = (AppCompatEditText) findViewById(R.id.edt_regfname);
        edt_edt_reglname = (AppCompatEditText) findViewById(R.id.edt_reglname);
        edt_edt_regmobile = (AppCompatEditText) findViewById(R.id.edt_regmobile);
        edt_edt_regemail = (AppCompatEditText) findViewById(R.id.edt_regemail);
        edt_edt_regpwd = (AppCompatEditText) findViewById(R.id.edt_regpwd);

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
        final ProgressDialog progressDialog = new ProgressDialog(RegistrationActivity.this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();
        String regexStr = "^[0-9]$";
        String MobilePattern = "[0-9]{10}";
        String rfname = edt_edt_regfname.getText().toString().trim();
        String rlastname = edt_edt_reglname.getText().toString().trim();
        String rphone = edt_edt_regmobile.getText().toString().trim();
        String remail = edt_edt_regemail.getText().toString().trim();
        String rpassword = edt_edt_regpwd.getText().toString().trim();


        if (!remail.isEmpty() && !rpassword.isEmpty() && !rlastname.isEmpty() && !rfname.isEmpty() && !rphone.isEmpty()) {
            if (rphone.length() == 10 && remail.matches(String.valueOf(Patterns.EMAIL_ADDRESS))
                    && rpassword.length()>=8) {

                Call<RegisterResponseModel> call= RetrofitClient.getInstance().getApi().registerDetails(new RegisterRequestBody(rfname,rlastname,remail,rpassword,rpassword,rphone,true,""));
                call.enqueue(new Callback<RegisterResponseModel>() {

                    @Override
                    public void onResponse(Call<RegisterResponseModel> call, Response<RegisterResponseModel> response) {
                        Log.d("TAG", "onResponse: "+response.code());
                        if (response.code() == 200) {
                            progressDialog.dismiss();
                            Toast.makeText(RegistrationActivity.this, "Successfully registered", Toast.LENGTH_LONG).show();
                            Log.d("response",response.message());

                            startActivity(new Intent(RegistrationActivity.this,SignInActivity.class));
                            finish();
                        }
                        if (response.code() == 200) {
                            Log.d("res code",String.valueOf(response.code()));
                            progressDialog.dismiss();
                            Toast.makeText(RegistrationActivity.this, "Phone number or email has already taken", Toast.LENGTH_LONG).show();
                        }
                    }
                    @Override
                    public void onFailure(Call<RegisterResponseModel> call, Throwable t) {
                        progressDialog.dismiss();
                        Toast.makeText(RegistrationActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
                    }

                });


    }

        else{

            progressDialog.dismiss();
            if (!remail.matches(String.valueOf(Patterns.EMAIL_ADDRESS))) {
                edt_edt_regemail.setError("Enter a valid email id");
                Toast.makeText(RegistrationActivity.this, "Incorrect Email Address", Toast.LENGTH_LONG).show();
            }

            if (!rphone.matches(MobilePattern))
            {
                edt_edt_regmobile.setError("Enter a 10 digit number");
                Toast.makeText(RegistrationActivity.this, "Incorrect Phone Number", Toast.LENGTH_LONG).show();
            }

                /*if(!rpassword.equals(rcnfpassword))
                {
                    Toast.makeText(RegistrationActivity.this, "Password and confirm password should be same", Toast.LENGTH_LONG).show();
                    edt_edt_regpwd.setError("Password and confirm password should be same");
                    cnfpassword.setError("Password and confirm password should be same");
                }*/
            if(rpassword.length()<8){
                Toast.makeText(RegistrationActivity.this, "The password should consist at least 8 characters", Toast.LENGTH_LONG).show();
                edt_edt_regpwd.setError("The password should consist at least 8 characters");
            }

        }

    } else {
        Toast.makeText(RegistrationActivity.this, "Incorrect details", Toast.LENGTH_LONG).show();
        progressDialog.dismiss();
        if (remail.isEmpty())
            edt_edt_regemail.setError("This field is required");
        if (rpassword.isEmpty())
            edt_edt_regpwd.setError("This field is required");
        if (rlastname.isEmpty())
            edt_edt_reglname.setError("This field is required");
        if (rfname.isEmpty())
            edt_edt_regfname.setError("This field is required");
        if (rphone.isEmpty())
            edt_edt_regmobile.setError("This field is required");

    }

}}