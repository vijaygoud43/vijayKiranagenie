package com.mbr.KiranaGenie.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.mbr.KiranaGenie.R;
import com.mbr.KiranaGenie.ui.profile.AddNewAddress;
import com.mbr.KiranaGenie.ui.profile.DeliveryAdress;

public class OrderSummary extends AppCompatActivity {
AppCompatTextView txt_change_or_addaddress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_summary);
        txt_change_or_addaddress=(AppCompatTextView)findViewById(R.id.change_or_addaddress);
        txt_change_or_addaddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(OrderSummary.this, AddNewAddress.class);
                startActivity(intent);
            }
        });
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24);
        actionBar.setDisplayHomeAsUpEnabled(true);

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