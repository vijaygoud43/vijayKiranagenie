package com.mbr.KiranaGenie.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.mbr.KiranaGenie.Activities.SubCategoriesActivity;
import com.mbr.KiranaGenie.Model.CategoryResposnseModel;
import com.mbr.KiranaGenie.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class SubCategoryAdapter extends RecyclerView.Adapter<SubCategoryAdapter.MyViewHolder> {
    private List<CategoryResposnseModel.CATEGORY> categoriesList1 = new ArrayList<>();
    private Context context;
    private final int[] backgroundColors = {
            R.color.reward1,
            R.color.reward2,
            R.color.reward3,
            R.color.reward4,
            R.color.reward5,
            R.color.reward6,
            R.color.reward7,
            R.color.reward8,
            R.color.reward9,
            R.color.reward10,
    };

    public SubCategoryAdapter(List<CategoryResposnseModel.CATEGORY> list, Context context) {
        this.categoriesList1 = list;
        this.context = context;
    }



    @Override
    public SubCategoryAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.subcat_recycler_item, parent, false);
        return new SubCategoryAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(SubCategoryAdapter.MyViewHolder holder, int position) {
        String imageUri = categoriesList1.get(position).getImage();
        holder.category.setText(categoriesList1.get(position).getName());


        // Picasso.with(holder.itemView.getContext()).load(imageUri).into(holder.image);
        //   http://192.168.1.55/sskMart/image/cache/catalog/Maincategories/fruties_veg/fv1-500x500.png
        Picasso.with(context).load(imageUri).into(holder.image);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, SubCategoriesActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

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
return this.categoriesList1.size();
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
        category=itemView.findViewById(R.id.subcat_item_name);
        image=itemView.findViewById(R.id.subcat_allimage);
       //  CardView cardView=itemView.findViewById(R.id.items_card);

      //  shopnow=itemView.findViewById(R.id.shopnow);

        }
    }
}
