package com.mbr.KiranaGenie.Api;

import android.content.Context;

import androidx.annotation.NonNull;

import com.github.juanlabrador.badgecounter.BadgeCounter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mbr.KiranaGenie.Activities.SignInActivity;
import com.mbr.KiranaGenie.Constant.Session;
import com.mbr.KiranaGenie.Model.CartCountResponseModel;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Url;

public class RetrofitClient {
    public static final String BASE_URL = "http://192.168.1.72/sskMart/api/";

    Retrofit retrofit;
    private static RetrofitClient instance;



    public RetrofitClient() {
        //logging of request and response
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        Gson gson = new GsonBuilder().setLenient().create();
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                

                .addInterceptor(new Interceptor() {
                    @NonNull
                    @Override
                    public Response intercept(@NonNull Chain chain) throws IOException {
                        Request.Builder request=chain.request()
                                .newBuilder();
                        request.header("Accept","application/json; charset=utf-8");
                        request.header("Content_Type","application/json; charset=utf-8");
                        request.header("X-Oc-Merchant-Id","ov7jd2p8n3Stdlj0oXu5HGjzUHygco8s");
                     //   request.header("X-Oc-Session","");
                        getApi().getsessionId();

                        return chain.proceed(request.build());
                       // return request;
                    }
                })
              .addInterceptor(loggingInterceptor)
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .build();



        retrofit = new Retrofit.Builder().
                baseUrl(BASE_URL).
                addConverterFactory(GsonConverterFactory.create(gson)).
                client(okHttpClient).
                build();
    }



    public static synchronized RetrofitClient getInstance() {
        if (instance == null) {
            instance = new RetrofitClient();
        }
        return instance;
    }

    public RetrofitApi getApi() {
        return retrofit.create(RetrofitApi.class);
    }


   /* public  void getCartCount(final Context context) {
        Session session=new Session(context);
        Call<CartCountResponseModel> call= RetrofitClient.getInstance().getApi().cartCount(session.getAccesstokentype()+" "+session.getAccesstoken());
        call.enqueue(new Callback<CartCountResponseModel>() {
            @Override
            public void onResponse(Call<CartCountResponseModel> call, retrofit2.Response<CartCountResponseModel> response) {
                if(response.code()==200)
                {
                  //  DrawerActivity.cNotificationCounter=response.body().getCount();
                   // BadgeCounter.update(DrawerActivity.menuItem, DrawerActivity.cNotificationCounter);

                }
                if(response.code()==401)
                {

                }
            }

            @Override
            public void onFailure(Call<CartCountResponseModel> call, Throwable t) {

            }
        });
    }*/

    public RetrofitApi getIn() {
        return retrofit.
                create(RetrofitApi.class);
    }


}