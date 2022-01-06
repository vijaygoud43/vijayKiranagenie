package com.mbr.KiranaGenie.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;

import com.mbr.KiranaGenie.R;


public class LoginActivity extends AppCompatActivity {
    AppCompatTextView appCompatTextView;
    AppCompatButton btn_get_otp;
    AppCompatEditText edt_et_contact_no;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        appCompatTextView=(AppCompatTextView)findViewById(R.id.txt_register);
        edt_et_contact_no=(AppCompatEditText)findViewById(R.id.et_contact_no);
        btn_get_otp=(AppCompatButton)findViewById(R.id.get_otp);
        getSupportActionBar().hide();
        appCompatTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginActivity.this,RegistrationActivity.class);
intent.putExtra("key","home");
                startActivity(intent);
                finish();

            }
        });
        btn_get_otp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edt_et_contact_no.getText().toString().trim().equals("")) {
                    edt_et_contact_no.setError("Please mobile number");
                    edt_et_contact_no.requestFocus();

                } else {
                    Intent intent = new Intent(LoginActivity.this, OtpScreen.class);
                    startActivity(intent);
                }
            }
        });
    }
}