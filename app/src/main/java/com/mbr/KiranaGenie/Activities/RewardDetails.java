package com.mbr.KiranaGenie.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.mbr.KiranaGenie.R;

public class RewardDetails extends AppCompatActivity {
AppCompatButton btn_coupen_copy,btn_reward_claimed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reward_details);
        btn_coupen_copy=(AppCompatButton)findViewById(R.id.coupen_copy);
        btn_reward_claimed=(AppCompatButton)findViewById(R.id.reward_claimed);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24);
        actionBar.setDisplayHomeAsUpEnabled(true);

        btn_coupen_copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RewardDetails.this,"Coupen Copied", Toast.LENGTH_SHORT).show();
            }
        });
        btn_reward_claimed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RewardDetails.this, "Your Reward Claimed", Toast.LENGTH_SHORT).show();
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