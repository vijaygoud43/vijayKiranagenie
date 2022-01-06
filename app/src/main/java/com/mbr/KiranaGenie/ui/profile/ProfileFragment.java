package com.mbr.KiranaGenie.ui.profile;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.mbr.KiranaGenie.Activities.RegistrationActivity;
import com.mbr.KiranaGenie.Activities.SignInActivity;
import com.mbr.KiranaGenie.Activities.SplashScreen;
import com.mbr.KiranaGenie.Api.RetrofitClient;
import com.mbr.KiranaGenie.Constant.Session;
import com.mbr.KiranaGenie.MainActivity;
import com.mbr.KiranaGenie.Model.LogoutResponseModel;
import com.mbr.KiranaGenie.R;
import com.mbr.KiranaGenie.data.request.LoginRequestBody;
import com.mbr.KiranaGenie.data.request.LogoutRequestBoday;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ProfileFragment extends Fragment {
    public ProfileFragment() {
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_profile, container, false);
        Session session = new Session(getContext());

        final AppCompatTextView appCompatTextView = root.findViewById(R.id.myorders);
        final AppCompatTextView appCompatTextView_smartorders = root.findViewById(R.id.mysmartorders);
        final AppCompatTextView apptxt_mysubscriptions = root.findViewById(R.id.mysubscriptions);
        final AppCompatTextView appCompatTextView_transactions = root.findViewById(R.id.transactions);
        final AppCompatTextView appCompatTextView_refunds = root.findViewById(R.id.refunds);
        final AppCompatTextView appCompatTextView_mycoupens = root.findViewById(R.id.mycoupes);
        final AppCompatTextView appCompatTextView_myrewards = root.findViewById(R.id.myrewards);
        final AppCompatTextView appCompatTextView_mycredits = root.findViewById(R.id.mycredits);
        final AppCompatTextView appCompatTextView_profileinfo = root.findViewById(R.id.profileinfo);
        final AppCompatTextView logout = root.findViewById(R.id.logout);
        final AppCompatTextView signin = root.findViewById(R.id.sing_in);
        final AppCompatTextView signup = root.findViewById(R.id.Sign_Up);

        final AppCompatTextView appCompatTextView_deliveraddress = root.findViewById(R.id.deliveryaddress);


        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SignInActivity.class);
                startActivity(intent);
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), RegistrationActivity.class);
                startActivity(intent);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<LogoutResponseModel> call = RetrofitClient.getInstance().getApi().getlogout(new LogoutRequestBoday(session.getSESSION_ID()));
                call.enqueue(new Callback<LogoutResponseModel>() {
                    @Override
                    public void onResponse(Call<LogoutResponseModel> call, Response<LogoutResponseModel> response) {
                        if (response.code() == 200) {
                            Toast.makeText(getContext(), "You have successfully logged out", Toast.LENGTH_SHORT).show();
                            session.logoutUser();
                            session.logout();
                            Intent redirect=new Intent(getContext(), SignInActivity.class);
                            startActivity(redirect);
                          // startActivity(new Intent(getActivity(), SignInActivity.class));
                        }else {
                            Intent intent = new Intent(getActivity(), SignInActivity.class);
                            startActivity(intent);
                            session.logoutUser();
                            session.logout();
                            Toast.makeText(getActivity(), "You are logout out", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<LogoutResponseModel> call, Throwable t) {

                    }
                });

            }
        });

        appCompatTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MyOrders.class);
                startActivity(intent);
            }
        });
        appCompatTextView_smartorders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MyOrders.class);
                startActivity(intent);
            }
        });
        apptxt_mysubscriptions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MySubscription.class);
                startActivity(intent);
            }
        });

        appCompatTextView_transactions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Transactions.class);
                startActivity(intent);
            }
        });
        appCompatTextView_refunds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Refunds.class);
                startActivity(intent);
            }
        });
        appCompatTextView_mycoupens.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MyCoupensActivity.class);
                startActivity(intent);
            }
        });
        appCompatTextView_myrewards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), RewardsActivity.class);
                startActivity(intent);
            }
        });
        appCompatTextView_mycredits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), CreditsActivity.class);
                startActivity(intent);
            }
        });
        appCompatTextView_deliveraddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), DeliveryAdress.class);
                startActivity(intent);
            }
        });
        appCompatTextView_profileinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ProfileInformation.class);
                startActivity(intent);
            }
        });
        return root;
    }
}