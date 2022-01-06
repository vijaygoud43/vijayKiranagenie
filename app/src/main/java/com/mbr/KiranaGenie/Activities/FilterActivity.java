package com.mbr.KiranaGenie.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mbr.KiranaGenie.Adapter.CatAdapter;
import com.mbr.KiranaGenie.Adapter.FilterAdapter;
import com.mbr.KiranaGenie.Model.CatModel;
import com.mbr.KiranaGenie.Model.FilterModel;
import com.mbr.KiranaGenie.R;

import java.util.ArrayList;

public class FilterActivity extends AppCompatActivity {
    TextView txt_brand;
    CheckBox checkBox;
    private ArrayList<FilterModel> filter;
    private FilterAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
        txt_brand = (TextView) findViewById(R.id.brand);
       // checkBox = (CheckBox) findViewById(R.id.check);
        LinearLayout linearLayout=(LinearLayout)findViewById(R.id.filter_checkbox_list);

        txt_brand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (linearLayout.getVisibility() == View.VISIBLE) {
                    linearLayout.setVisibility(View.INVISIBLE);
                } else {
                    linearLayout.setVisibility(View.VISIBLE);
                }

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