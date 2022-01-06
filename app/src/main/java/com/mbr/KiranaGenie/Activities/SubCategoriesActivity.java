package com.mbr.KiranaGenie.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.GridView;

import com.mbr.KiranaGenie.Adapter.CategoryAdapter1;
import com.mbr.KiranaGenie.Adapter.RewardAdapter;
import com.mbr.KiranaGenie.Adapter.SubCategoryAdapter;
import com.mbr.KiranaGenie.Api.RetrofitClient;
import com.mbr.KiranaGenie.Model.CategoryResposnseModel;
import com.mbr.KiranaGenie.Model.Rewarditems;
import com.mbr.KiranaGenie.Model.SubCategoriesResponse;
import com.mbr.KiranaGenie.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ss.com.bannerslider.banners.Banner;
import ss.com.bannerslider.banners.DrawableBanner;
import ss.com.bannerslider.banners.RemoteBanner;
import ss.com.bannerslider.views.BannerSlider;

public class SubCategoriesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_categories);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24);
        actionBar.setDisplayHomeAsUpEnabled(true);


        List<SubCategoriesResponse> itemsList = new ArrayList<>();
        itemsList.add(new SubCategoriesResponse(R.drawable.topdeals_bekary, "Ponds Dream Flower"));
        itemsList.add(new SubCategoriesResponse(R.drawable.topdeals_dal, "Vaseline"));
        itemsList.add(new SubCategoriesResponse(R.drawable.beverges, "Vaseline Lotion"));
        itemsList.add(new SubCategoriesResponse(R.drawable.snaks, "Himalaya Lotion"));
        itemsList.add(new SubCategoriesResponse(R.drawable.topdeal_taj, "Lakme"));
        itemsList.add(new SubCategoriesResponse(R.drawable.topdeal_taj, "Nivea"));
        itemsList.add(new SubCategoriesResponse(R.drawable.topdeal_taj, "Detol"));
        itemsList.add(new SubCategoriesResponse(R.drawable.topdeal_taj, "Lifeboy handwash"));
        itemsList.add(new SubCategoriesResponse(R.drawable.topdeal_taj, "Savlon Sanitizer"));


        BannerSlider bannerSlider1 = (BannerSlider)findViewById(R.id.subcat_banner);
        List<Banner> banners1 = new ArrayList<>();
        //add banner using image url
        banners1.add(new RemoteBanner("Put banner image url here ..."));
        //add banner using resource drawable
        banners1.add(new DrawableBanner(R.drawable.home_banner_welcome));
        bannerSlider1.setBanners(banners1);



     //   RecyclerView gridView = findViewById(R.id.recycle_shop_by_cat);

        RecyclerView recyclerView = findViewById(R.id.recycle_shop_by_cat);





        Call<CategoryResposnseModel> shopby = RetrofitClient.getInstance().getApi().getcategories();
        shopby.enqueue(new Callback<CategoryResposnseModel>() {
            @Override
            public void onResponse(Call<CategoryResposnseModel> call, Response<CategoryResposnseModel> response) {
                if (response.code() == 200) {
                    SubCategoryAdapter adapter = new SubCategoryAdapter((List<CategoryResposnseModel.CATEGORY>) response.body().getCategories(), getApplication());
                    recyclerView.setAdapter(adapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(SubCategoriesActivity.this, LinearLayoutManager.HORIZONTAL, false));
                    GridLayoutManager gridLayoutManager = new GridLayoutManager(SubCategoriesActivity.this, 3);
                    recyclerView.setLayoutManager(gridLayoutManager);
                    //   progressDialog.dismiss();
                }
            }

            @Override
            public void onFailure(Call<CategoryResposnseModel> call, Throwable t) {

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
}