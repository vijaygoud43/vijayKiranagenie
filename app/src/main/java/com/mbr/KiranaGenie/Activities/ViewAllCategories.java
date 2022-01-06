package com.mbr.KiranaGenie.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;

import com.mbr.KiranaGenie.Adapter.AllCategoryAdapter;
import com.mbr.KiranaGenie.Adapter.CatallAdapter;
import com.mbr.KiranaGenie.Adapter.CategoryAdapter;
import com.mbr.KiranaGenie.Adapter.CategoryAdapter1;
import com.mbr.KiranaGenie.Adapter.CustomAdapter;
import com.mbr.KiranaGenie.Api.RetrofitClient;
import com.mbr.KiranaGenie.Constant.Session;
import com.mbr.KiranaGenie.Model.AllCategoryResponseModule;
import com.mbr.KiranaGenie.Model.Catallitems;
import com.mbr.KiranaGenie.Model.CategoryResposnseModel;
import com.mbr.KiranaGenie.R;
import com.mbr.KiranaGenie.data.request.CatgoryRequest;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewAllCategories extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_categories);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24);
        actionBar.setDisplayHomeAsUpEnabled(true);



        RecyclerView recyclerView = findViewById(R.id.view_recycler);


        Call<CategoryResposnseModel> shopby = RetrofitClient.getInstance().getApi().getcategories();
        shopby.enqueue(new Callback<CategoryResposnseModel>() {
            @Override
            public void onResponse(Call<CategoryResposnseModel> call, Response<CategoryResposnseModel> response) {
                if (response.code() == 200) {
                    CategoryAdapter1 adapter = new CategoryAdapter1((List<CategoryResposnseModel.CATEGORY>) response.body().getCategories(), ViewAllCategories.this);
                    recyclerView.setAdapter(adapter);
                    Session session1 = new Session(ViewAllCategories.this);
                    session1.Sessionsaved(String.valueOf(response.body().getCategories()));

                    Log.d("TAG", "onResponse: "+response.code());

                    recyclerView.setLayoutManager(new LinearLayoutManager(ViewAllCategories.this, LinearLayoutManager.HORIZONTAL, false));
                    GridLayoutManager gridLayoutManager = new GridLayoutManager(ViewAllCategories.this, 2);
                    recyclerView.setLayoutManager(gridLayoutManager);
                 //   progressDialog.dismiss();
                }
            }

            @Override
            public void onFailure(Call<CategoryResposnseModel> call, Throwable t) {

            }

        });


recyclerView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(ViewAllCategories.this,SelectProductList.class);
        startActivity(intent);
    }
});


    }
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private String decode(String url)
    {
        return url.replace("&amp;", "&");
    }


}