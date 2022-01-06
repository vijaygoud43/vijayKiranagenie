package com.mbr.KiranaGenie.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatButton;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.mbr.KiranaGenie.Activities.ViewProductFullDetails;
import com.mbr.KiranaGenie.Model.TopDealsModel;
import com.mbr.KiranaGenie.R;
import com.mbr.KiranaGenie.ui.Cartitem.Cart;


import java.util.ArrayList;

public class TopDealsAdapter extends  RecyclerView.Adapter<TopDealsAdapter.MyViewHolder> {

    Context context;
    private LayoutInflater inflater;
    private ArrayList<TopDealsModel> imageModelArrayListTopdeals;

    private Fragment getSupportFragmentManager;
    private Fragment fragment;
    private FragmentManager fragmentManager;
    int position;
private Fragment cartframent;

    private final int[] backgroundColors = {
            R.color.yellow,
            R.color.colorPrimary,
           };



    public TopDealsAdapter(Context ctx, ArrayList<TopDealsModel> imageModelArrayList) {
        inflater = LayoutInflater.from(ctx);
        this.imageModelArrayListTopdeals = imageModelArrayList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.topdeals_recycleritem, parent, false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.iv_topdeals_image.setImageResource(imageModelArrayListTopdeals.get(position).getImage_drawable());
        holder.txt_margin.setText(imageModelArrayListTopdeals.get(position).getName());
        holder.txt_topdeals_brand.setText(imageModelArrayListTopdeals.get(position).getBrandname());
        holder.txt_topdeals_itemname.setText(imageModelArrayListTopdeals.get(position).getItem_name());
        holder.txt_topdeals_actualprice.setText(imageModelArrayListTopdeals.get(position).getActual_price());
        holder.txt_topdeals_offerprice.setText(imageModelArrayListTopdeals.get(position).getTopdeals_offerprice());

       /* int index = position % backgroundColors.length;
        int color = ContextCompat.getColor(context, backgroundColors[index]);
        holder.cardView.setBackgroundColor(color);*/
    }

    @Override
    public int getItemCount() {
        return imageModelArrayListTopdeals.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txt_margin;
        TextView txt_topdeals_brand;
        TextView txt_topdeals_itemname;
        TextView txt_topdeals_actualprice;
        TextView txt_topdeals_offerprice;
        Spinner sp_topdeals_grams_spinner;
        ImageView iv_topdeals_image;
        AppCompatButton btn_topdeals_addcart;
        private FragmentManager supportFragmentManager;
CardView cardView;

        public MyViewHolder(View itemView) {
            super(itemView);

            txt_margin = (TextView) itemView.findViewById(R.id.margin);
            txt_topdeals_brand = (TextView) itemView.findViewById(R.id.topdeals_brand);
            txt_topdeals_itemname = (TextView) itemView.findViewById(R.id.topdeals_itemname);
            txt_topdeals_actualprice = (TextView) itemView.findViewById(R.id.topdeals_actualprice);
            txt_topdeals_offerprice = (TextView) itemView.findViewById(R.id.topdeals_offerprice);
            iv_topdeals_image = (ImageView) itemView.findViewById(R.id.topdeals_image);
            btn_topdeals_addcart = (AppCompatButton) itemView.findViewById(R.id.topdeals_addcart);
 cardView=(CardView)itemView.findViewById(R.id.adcard_view);

            context = itemView.getContext();
            //context = itemView1.getContext();

            btn_topdeals_addcart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int itemPosition = getLayoutPosition();
                    View layout = inflater.inflate(R.layout.custom_toast_layout,
                            (ViewGroup) v.findViewById(R.id.linear_toastlayout));
                    TextView toastTextView = (TextView) layout.findViewById(R.id.toast_msg);
                    ImageView toastImageView = (ImageView) layout.findViewById(R.id.toast_image);
                    LinearLayout cart_ln=(LinearLayout)layout.findViewById(R.id.cartlayoutfr);

                    toastImageView.setImageResource(R.drawable.rightok);
                    Toast toast = new Toast(layout.getContext());
                    toast.setDuration(Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);// set the duration for the Toast
                    toast.setView(layout); // set the inflated layout
                    toast.show();
                    layout.setClickable(true);
                    layout.setFocusableInTouchMode(true);




/*
Intent intent=new Intent(context, CartItemBottomActivity.class);
context.startActivity(intent);*/




                }
            });

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    int itemPosition = getLayoutPosition();
                    //    Toast.makeText(context, "" + itemPosition, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(context, ViewProductFullDetails.class);
                    context.startActivity(intent);

                }
            });


        }



    }
}