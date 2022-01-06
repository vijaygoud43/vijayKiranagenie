package com.mbr.KiranaGenie.Constant;

import android.content.Context;
import android.content.SharedPreferences;

public class Session {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String SHARED_PREF_NAME="session";
    String ACCESS_TOKEN_TYPE="access_token_type";
    String ACCESS_TOKEN="access_token";
    String IS_LOGIN = "IsLoggedIn";
    String USER_EMAIL="email";
String SESSION_ID="X-Oc-Session";
    String CUSTOMER_ID="customer_id";
    Context context;
    String CATEGORY_ID="category_id:68";

    public Session(Context context){
        sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void saveSession(String session_id,String customer_id,String email  ){

        editor.putString(SESSION_ID,session_id).commit();
        editor.putString(CUSTOMER_ID,customer_id).commit();
        editor.putString(USER_EMAIL,email).commit();


    }
    public void Sessionsaved(String category_id  ){

        editor.putString(CATEGORY_ID,category_id).commit();
      //  editor.putString(SESSION_ID,session_id).commit();


    }

    public boolean getSession(){
        return sharedPreferences.getBoolean(IS_LOGIN,false);
    }
    public String getSESSION_ID(){
        return sharedPreferences.getString(SESSION_ID,"");
    }
   /* public String getCATEGORY_ID(){
        return sharedPreferences.getString(CATEGORY_ID,"category_id");
    }*/
    public String getCUSTOMER_ID(){
        return sharedPreferences.getString(CUSTOMER_ID,"customer_id");
    }
    public String getAccesstokentype(){
        return sharedPreferences.getString(ACCESS_TOKEN_TYPE,null);
    }
    public String getAccesstoken(){
        return sharedPreferences.getString(ACCESS_TOKEN,null);
    }


    public void logoutUser(){
        editor.clear().commit();
    }
    public String logout(){
        return sharedPreferences.getString(SESSION_ID,"");
    }

    public String getCATEGORY_ID(){
        sharedPreferences.getString(CATEGORY_ID,"category_id");
        editor.putString("category_id","category_id");
        editor.clear().commit();

        return this.CATEGORY_ID;
    }



}

