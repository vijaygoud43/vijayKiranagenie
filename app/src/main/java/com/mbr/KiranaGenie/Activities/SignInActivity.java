package com.mbr.KiranaGenie.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.mbr.KiranaGenie.Api.RetrofitClient;
import com.mbr.KiranaGenie.Constant.Session;
import com.mbr.KiranaGenie.MainActivity;
import com.mbr.KiranaGenie.Model.GetSessionIdResponse;
import com.mbr.KiranaGenie.Model.LoginResponseModel;
import com.mbr.KiranaGenie.R;
import com.mbr.KiranaGenie.data.request.LoginRequestBody;
import com.mbr.KiranaGenie.data.request.RegisterRequestBody;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignInActivity extends AppCompatActivity implements View.OnClickListener {
    AppCompatEditText edt_edt_email, edt_edt_pwd;
    AppCompatButton btn_loginbutton;
    AppCompatTextView txt_txt_register;
    private static long back_pressed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        getSupportActionBar().hide();
        btn_loginbutton = (AppCompatButton) findViewById(R.id.loginbutton);
        txt_txt_register = (AppCompatTextView) findViewById(R.id.txt_register);
        btn_loginbutton.setOnClickListener(this);

        edt_edt_email = (AppCompatEditText) findViewById(R.id.edt_email);
        edt_edt_pwd = (AppCompatEditText) findViewById(R.id.edt_pwd);

txt_txt_register.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(SignInActivity.this,RegistrationActivity.class);
        startActivity(intent);
    }
});
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.loginbutton:
                doValidation();
                break;
            case R.id.txt_register:
                Intent intent=new Intent(SignInActivity.this,RegistrationActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }
    private void doValidation()
    {
        String uemail = edt_edt_email.getText().toString().trim();
        String upassword = edt_edt_pwd.getText().toString().trim();

        if (!uemail.isEmpty() && !upassword.isEmpty()) {
            String regex = "^(.+)@(.+)$";
            Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(uemail);

            if (matcher.matches()){
                checkLoginDetails(uemail,upassword);
            }else {
                Toast.makeText(this, "Please Enter Correct Email", Toast.LENGTH_SHORT).show();
            }
        }
        else
        {
            if(uemail.isEmpty())
                edt_edt_email.setError("This field is required");
            if (upassword.isEmpty())
                edt_edt_pwd.setError("This field is required");
        }

    }

    private void checkLoginDetails(String uemail,String upassword) {


        final ProgressDialog progressDialog;
        progressDialog = new ProgressDialog(SignInActivity.this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        Call<LoginResponseModel> call = RetrofitClient.getInstance().getApi().getLoginData(new LoginRequestBody(uemail, upassword));

        call.enqueue(new Callback<LoginResponseModel>() {
            @Override
            public void onResponse(Call<LoginResponseModel> call, Response<LoginResponseModel> response) {
                Log.d("print",response.toString());
                if (response.isSuccessful()) {
                    if (response.body().getSession_id().equals("Login Successful")) {

                        Session session = new Session(SignInActivity.this);
                        session.saveSession(response.body().getSession_id(),response.body().getCustomer_id(),response.body().getEmail());
                         Log.d("session_id",response.body().getSession_id());
                       Log.d("tokens",response.body().getSuccess()+response.body().getStatusCode());

                        Intent intent = new Intent(SignInActivity.this, MainActivity.class);

                        startActivity(intent);
                        finish();
                        progressDialog.dismiss();
                        clearLoginText();

                    } else {
                        progressDialog.dismiss();
                        Toast.makeText(getApplicationContext(), "Wrong email or password", Toast.LENGTH_SHORT).show();
                        clearLoginText();
                    }

                }
                else
                {
                    progressDialog.dismiss();
                    Toast.makeText(getApplicationContext(), "Invalid details", Toast.LENGTH_SHORT).show();
                    clearLoginText();
                }

            }

            @Override
            public void onFailure(Call<LoginResponseModel> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_LONG).show();
                clearLoginText();
            }
        });



    }


    public void clearLoginText(){
        edt_edt_email.setText("");
        edt_edt_pwd.setText("");
    }

    @Override
    public void onBackPressed() {
        if (back_pressed + 2000 > System.currentTimeMillis()) {
            super.onBackPressed();
            finishAffinity();
            finish();
            System.exit(0);

        } else {
            Toast.makeText(getBaseContext(), "Press once again to exit",
                    Toast.LENGTH_SHORT).show();
            back_pressed = System.currentTimeMillis();
        }
    }
}