package com.mbr.KiranaGenie.Adapter;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.mbr.KiranaGenie.Activities.ProductFullDetails;
import com.mbr.KiranaGenie.Activities.SelectProductList;
import com.mbr.KiranaGenie.Activities.ViewProductFullDetails;
import com.mbr.KiranaGenie.Api.RetrofitClient;
import com.mbr.KiranaGenie.Constant.Session;
import com.mbr.KiranaGenie.Model.CartResponseModel;
import com.mbr.KiranaGenie.Model.CategoryResposnseModel;
import com.mbr.KiranaGenie.Model.GetProductListResponseModule;
import com.mbr.KiranaGenie.R;
import com.mbr.KiranaGenie.data.request.AddCartRequest;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class SelectedProductListAdapter extends RecyclerView.Adapter<SelectedProductListAdapter.MyViewHolder> {
    private List<GetProductListResponseModule.GETPRODUCTLIST> categoriesList1 = new ArrayList<>();
    private Context context;


    public SelectedProductListAdapter(List<GetProductListResponseModule.GETPRODUCTLIST> list, Context context) {
        this.categoriesList1 = list;
        this.context = context;
    }



    @Override
    public SelectedProductListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.selected_product_list_recycle, parent, false);
        return new SelectedProductListAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(SelectedProductListAdapter.MyViewHolder holder, final int position) {
        String imageUri = categoriesList1.get(position).getImage();
        holder.category.setText(categoriesList1.get(position).getName());
        holder.brand.setText(categoriesList1.get(position).getManufacturer());
        holder.price.setText(categoriesList1.get(position).getPrice());
        holder.mrp.setText(categoriesList1.get(position).getMrpprice());
        holder.moq.setText(categoriesList1.get(position).getMinimum());


        Picasso.with(context).load(imageUri).into(holder.image);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             /*   Intent intent=new Intent(context, ViewProductFullDetails.class);
            //    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                Bundle args = new Bundle();
                intent.putExtra("product_id", categoriesList1.get(position).getProduct_id()+"");
                Log.e("product_id", "" + categoriesList1);
            //    intent.putExtra("category_id", String.valueOf(categoriesList1.get(position).getCategory_id()));
               // args.putString("title",categoriesList1.get(position).getName());

                context.startActivity(intent);*/


                Intent intent=new Intent(context, ViewProductFullDetails.class);
                //intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                //  intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                intent.putExtra("product_id", categoriesList1.get(position).getProduct_id()+"");
                Log.e("category_id", "" + categoriesList1);
                context.startActivity(intent);







            }
        });



            holder.addtocart.setText("Add to Cart");
            holder.addtocart.setEnabled(true);


        holder.addtocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressDialog progressDialog = new ProgressDialog(context);
                progressDialog.setMessage("Loading...");
                progressDialog.show();
                Session session = new Session(context);
                Call<CartResponseModel> call = RetrofitClient.getInstance().getApi().addCart(String.valueOf(categoriesList1.get(position).getProduct_id()),"");
                call.enqueue(new retrofit2.Callback<CartResponseModel>() {
                    @Override
                    public void onResponse(Call<CartResponseModel> call, Response<CartResponseModel> response) {
                        if (response.isSuccessful()) {
                            Toast.makeText(context, "The product has been added to the cart", Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();
                         //   RetrofitClient.getInstance().getCartCount(context);
                        }
                    }

                    @Override
                    public void onFailure(Call<CartResponseModel> call, Throwable t) {

                    }
                });
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
        TextView category,brand,price,mrp,moq,textView_cat_id;
        ImageView image;
        ProgressBar progress;
        CardView cardView;
        Button addtocart;
        MyViewHolder(View itemView) {
            super(itemView);
     //   progress=itemView.findViewById(R.id.progress);
        category=itemView.findViewById(R.id.productlistitem_name);
        brand=itemView.findViewById(R.id.selected_product_brand);
        image=itemView.findViewById(R.id.selected_product_imagelist);
            price=itemView.findViewById(R.id.selected_item_price);
            mrp=itemView.findViewById(R.id.selected_item_mrp);
            moq=itemView.findViewById(R.id.selected_item_moq);
            textView_cat_id=itemView.findViewById(R.id.cat_id);
         CardView cardView=itemView.findViewById(R.id.items_card);
            addtocart =itemView.findViewById(R.id.item_added_cart);




      //  shopnow=itemView.findViewById(R.id.shopnow);

        }
    }
}
