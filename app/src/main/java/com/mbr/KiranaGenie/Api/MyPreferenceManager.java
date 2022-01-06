package com.mbr.KiranaGenie.Api;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public class MyPreferenceManager {

    private String TAG = MyPreferenceManager.class.getSimpleName();


    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;

    int PRIVATE_MODE = 0;


    private static final String PREF_NAME = "ritrac_amaze";

    private static final String KEY_VALUE = "valu";


    private static final String KEY_USER_ID = "user_id";
    private static final String KEY_USER_NAME = "user_name";
    private static final String KEY_USER_EMAIL = "user_email";
    private static final String KEY_USER_MOBILE = "user_mobile";

    // Constructor
    public MyPreferenceManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }


    public void setE_Id(String id) {
        editor.putString(KEY_VALUE, id);
        editor.commit();
        Log.e(TAG, "time IS " + id);
    }

    public String getE_Id(){
        String id = pref.getString(KEY_VALUE, null);
        return id;
    }
}
