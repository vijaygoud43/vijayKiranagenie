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
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.mbr.KiranaGenie.Activities.SelectProductList;
import com.mbr.KiranaGenie.Activities.ViewAllCategories;
import com.mbr.KiranaGenie.Activities.ViewProductFullDetails;
import com.mbr.KiranaGenie.Model.CategoryResposnseModel;
import com.mbr.KiranaGenie.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CategoryAdapter1 extends RecyclerView.Adapter<CategoryAdapter1.MyViewHolder> {
    private List<CategoryResposnseModel.CATEGORY> categoriesList1 = new ArrayList<>();
    private Context context;


    public CategoryAdapter1(List<CategoryResposnseModel.CATEGORY> list, Context context) {
        this.categoriesList1 = list;
        this.context = context;
    }


    @Override
    public CategoryAdapter1.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        return new CategoryAdapter1.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CategoryAdapter1.MyViewHolder holder, int position) {
        String imageUri = categoriesList1.get(position).getImage();
        holder.category.setText(categoriesList1.get(position).getName());
//holder.textView_cat_id.setText(categoriesList1.get(position).getCategory_id());

        int[] androidColors = context.getResources().getIntArray(R.array.androidcolors);
        int randomAndroidColor = androidColors[new Random().nextInt(androidColors.length)];
        holder.cardView.setBackgroundColor(randomAndroidColor);

        // Picasso.with(holder.itemView.getContext()).load(imageUri).into(holder.image);
        //   http://192.168.1.55/sskMart/image/cache/catalog/Maincategories/fruties_veg/fv1-500x500.png
        Picasso.with(context).load(imageUri).into(holder.image);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,SelectProductList.class);
                //intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
              //  intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("category_id", categoriesList1.get(position).getCategory_id()+"");
                Log.e("category_id", "" + categoriesList1);
                context.startActivity(intent);


            }


        });



    }

    @Override
    public int getItemCount() {
return this.categoriesList1.size();
        //int limit = 4;
       // return Math.min(categoriesList.size(), limit);

    }



    static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView category,textView_cat_id;
        ImageView image;
        ProgressBar progress;
        CardView cardView;
        MyViewHolder(View itemView) {
            super(itemView);

        category=itemView.findViewById(R.id.tv);
        image=itemView.findViewById(R.id.iv);
          cardView=itemView.findViewById(R.id.items_card);
textView_cat_id=itemView.findViewById(R.id.category_id);
      //  shopnow=itemView.findViewById(R.id.shopnow);

        }
    }
}
