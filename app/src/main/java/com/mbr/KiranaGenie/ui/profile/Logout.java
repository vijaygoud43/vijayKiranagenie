package com.mbr.KiranaGenie.ui.profile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.mbr.KiranaGenie.Activities.SignInActivity;
import com.mbr.KiranaGenie.Api.RetrofitClient;
import com.mbr.KiranaGenie.Constant.Session;
import com.mbr.KiranaGenie.MainActivity;
import com.mbr.KiranaGenie.Model.LogoutResponseModel;
import com.mbr.KiranaGenie.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Logout extends AppCompatActivity {
    Button yesButton,noButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout);
        yesButton=(Button)findViewById(R.id.yesButton);
        noButton=(Button) findViewById(R.id.noButton);

        yesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


             /*   Call<LogoutResponseModel> call = RetrofitClient.getInstance().getApi().logout();
                call.enqueue(new Callback<LogoutResponseModel>() {
                    @Override
                    public void onResponse(Call<LogoutResponseModel> call, Response<LogoutResponseModel> response) {
                        if (response.isSuccessful()) {
                            if (response.body().getSession_id().equals("Logout Successful")) {

                                Session session = new Session(Logout.this);
                                session.logoutUser();
                                session.saveSession(response.body().getSession_id(),response.body().getCustomer_id(),response.body().getEmail());
                                Log.d("session_id",response.body().getSession_id());
                                Log.d("tokens",response.body().getSuccess()+response.body().getStatusCode());

                                Intent intent = new Intent(Logout.this, MainActivity.class);

                                startActivity(intent);
                                finish();


                            }

                        }

                    }

                    @Override
                    public void onFailure(Call<LogoutResponseModel> call, Throwable t) {

                    }
                });*/

            }
        });
    }
}