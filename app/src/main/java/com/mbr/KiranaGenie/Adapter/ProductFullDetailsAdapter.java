package com.mbr.KiranaGenie.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.mbr.KiranaGenie.Activities.SelectProductList;
import com.mbr.KiranaGenie.Model.ProductfullDetailsResponseModel;
import com.mbr.KiranaGenie.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ProductFullDetailsAdapter extends RecyclerView.Adapter<ProductFullDetailsAdapter.MyViewHolder> {
    private List<ProductfullDetailsResponseModel.PRODUCTFULLDETAILS> productfulllistdetial = new ArrayList<>();
    private Context context;
    private List<ProductfullDetailsResponseModel> mData;


    public ProductFullDetailsAdapter(List<ProductfullDetailsResponseModel.PRODUCTFULLDETAILS> list, Context context) {
        this.productfulllistdetial = list;
        this.context = context;
    }


    @Override
    public ProductFullDetailsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_fulldetails_recycler, parent, false);
        return new ProductFullDetailsAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ProductFullDetailsAdapter.MyViewHolder holder, int position) {
        holder.productname.setText(productfulllistdetial.get(position).getName());
        holder.price.setText(productfulllistdetial.get(position).getPrice());
        holder.mrp.setText(productfulllistdetial.get(position).getMrpprice());
        String imageUri = productfulllistdetial.get(position).getImage();
        holder.txt_product_rating_fulldetails.setText(productfulllistdetial.get(position).getRating());


        holder.productdetails.setText(productfulllistdetial.get(position).getDescription());
        // Picasso.with(holder.itemView.getContext()).load(imageUri).into(holder.image);
        //   http://192.168.1.55/sskMart/image/cache/catalog/Maincategories/fruties_veg/fv1-500x500.png
        Picasso.with(context).load(imageUri).into(holder.image);

//        Log.e("gvh",""+productfulllistdetial.get(position).getImage());

       /* holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SelectProductList.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                Bundle args = new Bundle();
                context.startActivity(intent);
            }
        });*/

      /*  holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,SelectProductList.class);
                Bundle args = new Bundle();
                args.putInt("id",categoriesList1.get(position).getCategory_id());
                args.putString("title",categoriesList1.get(position).getName());
                context.startActivity(intent);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            }
        });*/


    }

    @Override
    public int getItemCount() {
        return this.productfulllistdetial.size();
        //int limit = 4;
        // return Math.min(categoriesList.size(), limit);

    }
   /* public void add(List<ProductfullDetailsResponseModel> models) {
        mData.addAll(models);
        notifyDataSetChanged();
    }

    public void clear() {
        mData.clear();
        notifyDataSetChanged();
    }*/





            static class MyViewHolder extends RecyclerView.ViewHolder {
                TextView productname, price, mrp, inclusvetaxestext, txt_product_rating_fulldetails, rating_content, quantity, availableoffers, productdetails;
                TextView endrating, reviewrating, reviewtext;
                ImageView image;
                ProgressBar progress;
                CardView cardView;
                MyViewHolder(View itemView) {
                    super(itemView);

                    productname = itemView.findViewById(R.id.product_name_fulldetails);
                    price = itemView.findViewById(R.id.product_price_fulldetails);
                    mrp = itemView.findViewById(R.id.product_mrp_fulldetails);
                    image = itemView.findViewById(R.id.product_image_fulldetails);
                    inclusvetaxestext = itemView.findViewById(R.id.product_taxes_fulldetails);
                    // cardView = itemView.findViewById(R.id.items_card);
                    txt_product_rating_fulldetails = itemView.findViewById(R.id.product_rating_fulldetails);
                    rating_content = itemView.findViewById(R.id.product_ratingcontent_fulldetails);
                    quantity = itemView.findViewById(R.id.product_quantity_fulldetails);
                    availableoffers = itemView.findViewById(R.id.product_offers_fulldetails);
                    productdetails = itemView.findViewById(R.id.product_details_fulldetails);
                    endrating = itemView.findViewById(R.id.product_endrating_fulldetails);
                    reviewrating = itemView.findViewById(R.id.product_reviewrating_fulldetails);
                    reviewtext = itemView.findViewById(R.id.product_reviewtext_fulldetails);


        }
    }
}
