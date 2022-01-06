package com.mbr.KiranaGenie.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.mbr.KiranaGenie.Activities.ViewAllCategories;
import com.mbr.KiranaGenie.Model.CatModel;
import com.mbr.KiranaGenie.Model.FilterModel;
import com.mbr.KiranaGenie.R;

import java.util.ArrayList;

public class FilterAdapter extends RecyclerView.Adapter<FilterAdapter.MyViewHolder> {
    Context context;
    private LayoutInflater inflater;
    private ArrayList<FilterModel> filterModelArrayList;




    public FilterAdapter(Context ctx, ArrayList<FilterModel> imageModelArrayList) {
        inflater = LayoutInflater.from(ctx);
        this.filterModelArrayList = imageModelArrayList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.filter_list, parent, false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

    //    holder.iv.setImageResource(imageModelArrayList.get(position).getImage_drawable());
        holder.specialization.setText(filterModelArrayList.get(position).getName_specialization());


    }
    @Override
    public int getItemCount() {
        return filterModelArrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView specialization;
       // ImageView iv;

        public MyViewHolder(View itemView) {
            super(itemView);

            specialization = (TextView) itemView.findViewById(R.id.filter_specialization);
           // iv = (ImageView) itemView.findViewById(R.id.iv);
            context = itemView.getContext();

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    int itemPosition = getLayoutPosition();
                //    Toast.makeText(context, "" + itemPosition, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(context, ViewAllCategories.class);
                    context.startActivity(intent);

                }
            });
        }


    }
}
