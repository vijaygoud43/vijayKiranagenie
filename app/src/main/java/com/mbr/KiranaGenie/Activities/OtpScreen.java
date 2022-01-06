package com.mbr.KiranaGenie.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.alimuzaffar.lib.pin.PinEntryEditText;
import com.mbr.KiranaGenie.MainActivity;
import com.mbr.KiranaGenie.R;


public class OtpScreen extends AppCompatActivity {
    AppCompatButton btn_submit_otp;
    PinEntryEditText pin_txt_pin_entry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_screen);
        getSupportActionBar().hide();
        btn_submit_otp = (AppCompatButton) findViewById(R.id.submit_otp);
        pin_txt_pin_entry = (PinEntryEditText) findViewById(R.id.txt_pin_entry);
        btn_submit_otp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pin_txt_pin_entry.getText().toString().trim().equals("")) {
                    pin_txt_pin_entry.setError("Enter OTP here");
                    pin_txt_pin_entry.requestFocus();

                } else {
                    Intent intent = new Intent(OtpScreen.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}