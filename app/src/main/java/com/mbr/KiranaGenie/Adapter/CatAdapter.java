package com.mbr.KiranaGenie.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;


import com.mbr.KiranaGenie.Activities.ViewAllCategories;
import com.mbr.KiranaGenie.Model.CatModel;
import com.mbr.KiranaGenie.R;


import java.util.ArrayList;

public class CatAdapter extends RecyclerView.Adapter<CatAdapter.MyViewHolder> {
    Context context;
    private LayoutInflater inflater;
    private ArrayList<CatModel> imageModelArrayList;




    public CatAdapter(Context ctx, ArrayList<CatModel> imageModelArrayList) {
        inflater = LayoutInflater.from(ctx);
        this.imageModelArrayList = imageModelArrayList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.recycler_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.iv.setImageResource(imageModelArrayList.get(position).getImage_drawable());
        holder.time.setText(imageModelArrayList.get(position).getName());


    }
    @Override
    public int getItemCount() {
        return imageModelArrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView time;
        ImageView iv;

        public MyViewHolder(View itemView) {
            super(itemView);

            time = (TextView) itemView.findViewById(R.id.tv);
            iv = (ImageView) itemView.findViewById(R.id.iv);
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
