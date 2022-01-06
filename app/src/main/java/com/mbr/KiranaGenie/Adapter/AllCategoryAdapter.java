package com.mbr.KiranaGenie.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.mbr.KiranaGenie.Activities.ViewAllCategories;
import com.mbr.KiranaGenie.Model.AllCategoryResponseModule;
import com.mbr.KiranaGenie.Model.Catallitems;
import com.mbr.KiranaGenie.Model.CategoryResposnseModel;
import com.mbr.KiranaGenie.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AllCategoryAdapter extends RecyclerView.Adapter<AllCategoryAdapter.MyViewHolder> {
    private List<AllCategoryResponseModule.ALLCATEGORIES> categoriesList = new ArrayList<>();
    private Context context;


    public AllCategoryAdapter(List<AllCategoryResponseModule.ALLCATEGORIES> list, Context context) {
        this.categoriesList = list;
        this.context = context;
    }


    @Override
    public AllCategoryAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_gridview, parent, false);
        return new AllCategoryAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(AllCategoryAdapter.MyViewHolder holder, int position) {
        String imageUri = categoriesList.get(position).getImage();
        holder.category.setText(categoriesList.get(position).getName());
        int[] androidColors = context.getResources().getIntArray(R.array.androidcolors);
        int randomAndroidColor = androidColors[new Random().nextInt(androidColors.length)];
        holder.cardView.setBackgroundColor(randomAndroidColor);

        // Picasso.with(holder.itemView.getContext()).load(imageUri).into(holder.image);
        //   http://192.168.1.55/sskMart/image/cache/catalog/Maincategories/fruties_veg/fv1-500x500.png
        Picasso.with(context).load(imageUri).into(holder.image);

       /* holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(context,ViewAllCategories.class);
                Bundle args = new Bundle();
                args.putInt("id",categoriesList.get(position).getCategory_id());
                args.putString("title",categoriesList.get(position).getName());
                context.startActivity(intent);




            }
        });*/



    }

    @Override
    public int getItemCount() {
return this.categoriesList.size();
        //int limit = 4;
       // return Math.min(categoriesList.size(), limit);

    }


    static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView category,shopnow;
        ImageView image;
        ProgressBar progress;
        CardView cardView;
        MyViewHolder(View itemView) {
            super(itemView);
     //   progress=itemView.findViewById(R.id.progress);
        category=itemView.findViewById(R.id.catall_itemname);
        image=itemView.findViewById(R.id.cat_allimage);
            cardView=itemView.findViewById(R.id.card_view);
      //  shopnow=itemView.findViewById(R.id.shopnow);

        }
    }
}
