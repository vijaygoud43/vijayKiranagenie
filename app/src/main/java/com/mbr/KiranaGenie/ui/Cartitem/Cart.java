package com.mbr.KiranaGenie.ui.Cartitem;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mbr.KiranaGenie.Activities.ApplyCoupenActivity;
import com.mbr.KiranaGenie.Activities.OrderSummary;
import com.mbr.KiranaGenie.R;
import com.mbr.KiranaGenie.ui.gallery.GalleryViewModel;


public class Cart extends Fragment  {

    private CartViewModel mViewModel;
    private Object CartViewModel;
private int minteger=1;
    public static Cart newInstance() {
        return new Cart();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
      /*  CartViewModel =
                ViewModelProviders.of(this).get(CartViewModel.class);*/
        View root = inflater.inflate(R.layout.cart_fragment, container, false);
       root.getContext();

        final ImageView btn_increase = root.findViewById(R.id.increase);
        final ImageView btn_decrease = root.findViewById(R.id.decrease);
        final TextView txt=root.findViewById(R.id.integer_number);
        final LinearLayout ln_applycoupen=(LinearLayout)root.findViewById(R.id.apply_coupen);
final Button btn_continue_order=(Button)root.findViewById(R.id.continue_order);
       btn_increase.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               minteger = minteger + 1;
               display(minteger);
           }

           private void display(int minteger1) {
               TextView displayInteger = (TextView)root.findViewById(R.id.integer_number);
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
               TextView displayInteger = (TextView)root.findViewById(R.id.integer_number);
               displayInteger.setText("" + minteger);
           }
       });
        ln_applycoupen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), ApplyCoupenActivity.class);
                startActivity(intent);
            }
        });
        btn_continue_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), OrderSummary.class);
                startActivity(intent);
            }
        });
        return root;
    }



}