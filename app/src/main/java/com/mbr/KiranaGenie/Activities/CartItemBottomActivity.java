package com.mbr.KiranaGenie.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mbr.KiranaGenie.R;

public class CartItemBottomActivity extends AppCompatActivity {
    private int minteger=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_item_bottom);
        final ImageView btn_increase =(ImageView)findViewById(R.id.increase);
        final ImageView btn_decrease = (ImageView) findViewById(R.id.decrease);
        final TextView txt=(TextView) findViewById(R.id.integer_number);
        final LinearLayout ln_applycoupen=(LinearLayout)findViewById(R.id.apply_coupen);
        final Button btn_continue_order=(Button)findViewById(R.id.continue_order);
        btn_increase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                minteger = minteger + 1;
                display(minteger);
            }

            private void display(int minteger1) {
                TextView displayInteger = (TextView)findViewById(R.id.integer_number);
                displayInteger.setText("" + minteger1);
            }
        });
        btn_decrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (minteger == 1) {

                }else{
                    minteger = minteger - 1;
                }
                display(minteger);

            }

            private void display(int minteger) {
                TextView displayInteger = (TextView)findViewById(R.id.integer_number);
                displayInteger.setText("" + minteger);
            }
        });
        ln_applycoupen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(CartItemBottomActivity.this, ApplyCoupenActivity.class);
                startActivity(intent);
            }
        });
        btn_continue_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(CartItemBottomActivity.this, OrderSummary.class);
                startActivity(intent);
            }
        });

    }



}