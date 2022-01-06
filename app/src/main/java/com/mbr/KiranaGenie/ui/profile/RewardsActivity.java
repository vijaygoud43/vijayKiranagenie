package com.mbr.KiranaGenie.ui.profile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;


import com.mbr.KiranaGenie.Activities.RewardDetails;
import com.mbr.KiranaGenie.Activities.SelectProductList;
import com.mbr.KiranaGenie.Activities.ViewAllCategories;
import com.mbr.KiranaGenie.Adapter.RewardAdapter;

import com.mbr.KiranaGenie.Model.Rewarditems;
import com.mbr.KiranaGenie.R;

import java.util.ArrayList;
import java.util.List;

public class RewardsActivity extends AppCompatActivity {
    private final int[] backgroundColors = {
            R.color.yellow,
            R.color.colorPrimary,
    };
    int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rewards);
        ActionBar actionBar = getSupportActionBar();

        actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24);


        actionBar.setDisplayHomeAsUpEnabled(true);

        List<Rewarditems> itemsList = new ArrayList<>();
        itemsList.add(new Rewarditems(R.drawable.topdeals_bekary, "Foodgrains,Oil saving up to 16% off"));
        itemsList.add(new Rewarditems(R.drawable.topdeals_dal, "Dals & Pulses saving up to 15% off"));
        itemsList.add(new Rewarditems(R.drawable.beverges, "Beverages saving up to 25% off"));
        itemsList.add(new Rewarditems(R.drawable.snaks, "Snaks saving up to 15% off"));
        itemsList.add(new Rewarditems(R.drawable.topdeal_taj, "Beaty & Hygiene saving up to 15% off"));
        itemsList.add(new Rewarditems(R.drawable.topdeal_taj, "Cleaning & Household saving up to 15% off"));
        itemsList.add(new Rewarditems(R.drawable.topdeal_taj, "Kitchen, Garden saving up to 15% off"));
        itemsList.add(new Rewarditems(R.drawable.topdeal_taj, "Pet Care saving up to 15% off"));
        itemsList.add(new Rewarditems(R.drawable.topdeal_taj, "World Food saving up to 15% off"));
        itemsList.add(new Rewarditems(R.drawable.topdeal_taj, "Baby Care saving up to 15% off"));
        itemsList.add(new Rewarditems(R.drawable.topdeal_taj, "Dry Fruits saving up to 15% off"));
        itemsList.add(new Rewarditems(R.drawable.topdeal_taj, "Dairy saving up to 15% off"));
        itemsList.add(new Rewarditems(R.drawable.topdeal_taj, "Ice Creams & Frozen saving up to 15% off"));
        itemsList.add(new Rewarditems(R.drawable.snaks, "Chocolates saving up to 15% off"));
        itemsList.add(new Rewarditems(R.drawable.topdeal_taj, "Coffee saving up to 15% off"));

        GridView gridView = findViewById(R.id.rewards_gridview);

        RewardAdapter customAdapter = new RewardAdapter(this, R.layout.rewards_custom_gridview, itemsList);
        gridView.setAdapter(customAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // set an Intent to Another Activity
                Intent intent = new Intent(RewardsActivity.this, RewardDetails.class);
                //  intent.putExtra("image", logos[position]); // put image data in Intent
                startActivity(intent); // start Intent
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