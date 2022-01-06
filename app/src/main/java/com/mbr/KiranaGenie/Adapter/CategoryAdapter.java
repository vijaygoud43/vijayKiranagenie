package com.mbr.KiranaGenie.Adapter;



import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.makeramen.roundedimageview.RoundedTransformationBuilder;
import com.mbr.KiranaGenie.Activities.ViewAllCategories;
import com.mbr.KiranaGenie.Model.Catallitems;
import com.mbr.KiranaGenie.Model.CategoryResposnseModel;
import com.mbr.KiranaGenie.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder> {
    private List<CategoryResposnseModel.CATEGORY> categoriesList = new ArrayList<>();
    private Context context;


    public CategoryAdapter(List<CategoryResposnseModel.CATEGORY> list, Context context) {
        this.categoriesList = list;
        this.context = context;
    }



    @Override
    public CategoryAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        return new CategoryAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CategoryAdapter.MyViewHolder holder, int position) {
        String imageUri = categoriesList.get(position).getImage();
        holder.category.setText(categoriesList.get(position).getName());

        int[] androidColors = context.getResources().getIntArray(R.array.androidcolors);
        int randomAndroidColor = androidColors[new Random().nextInt(androidColors.length)];
        holder.cardView.setBackgroundColor(randomAndroidColor);
       /* Random rnd = new Random();



        int currentColor = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        holder.cardView.setBackgroundColor(currentColor);*/
        // Picasso.with(holder.itemView.getContext()).load(imageUri).into(holder.image);
        //   http://192.168.1.55/sskMart/image/cache/catalog/Maincategories/fruties_veg/fv1-500x500.png
        Picasso.with(context).load(imageUri).into(holder.image);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(context,ViewAllCategories.class);
                intent.putExtra("Category_id", categoriesList.get(position).getCategory_id());

                context.startActivity(intent);




            }
        });



    }

    @Override
    public int getItemCount() {
//return this.categoriesList.size();
        int limit = 4;
        return Math.min(categoriesList.size(), limit);

    }


    static class MyViewHolder extends RecyclerView.ViewHolder {
        public View parent;
        TextView category,shopnow;
        ImageView image;
        ProgressBar progress;
        CardView cardView;
        MyViewHolder(View itemView) {
            super(itemView);
     //   progress=itemView.findViewById(R.id.progress);
        category=itemView.findViewById(R.id.tv);
        image=itemView.findViewById(R.id.iv);
             cardView=itemView.findViewById(R.id.items_card);
      //  shopnow=itemView.findViewById(R.id.shopnow);

        }
    }
}
