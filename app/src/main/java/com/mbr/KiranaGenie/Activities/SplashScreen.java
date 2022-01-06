package com.mbr.KiranaGenie.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.mbr.KiranaGenie.Api.RetrofitClient;
import com.mbr.KiranaGenie.Constant.Session;
import com.mbr.KiranaGenie.MainActivity;
import com.mbr.KiranaGenie.Model.GetSessionIdResponse;
import com.mbr.KiranaGenie.Model.RegisterResponseModel;
import com.mbr.KiranaGenie.R;
import com.mbr.KiranaGenie.data.request.RegisterRequestBody;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);
        getsessionId();


    }

    public void getsessionId() {

        Call<GetSessionIdResponse> call = RetrofitClient.getInstance().getApi().getsessionId();
        call.enqueue(new Callback<GetSessionIdResponse>() {

            @Override
            public void onResponse(Call<GetSessionIdResponse> call, Response<GetSessionIdResponse> response) {
                Log.d("TAG", "onResponse: " + response.code());
                if (response.code() == 200) {
                    Session session = new Session(SplashScreen.this);
                    session.getSESSION_ID();
                    session.getCATEGORY_ID();
                    session.getCUSTOMER_ID();
                    startActivity(new Intent(SplashScreen.this, MainActivity.class));
                    finish();
                } else {
                    Intent intent = new Intent(SplashScreen.this, SignInActivity.class);
                    startActivity(intent);
                    finish();
                }
            }

            @Override
            public void onFailure(Call<GetSessionIdResponse> call, Throwable t) {

                Toast.makeText(SplashScreen.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }


        });

    }

}