package com.mbr.KiranaGenie.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.mbr.KiranaGenie.R;


public class CustomAdapter extends BaseAdapter {
    Context context;
    int logos[];
    LayoutInflater inflter;

    public CustomAdapter(Context applicationContext, int[] logos) {
        this.context = applicationContext;
        this.logos = logos;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return logos.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.activity_gridview, null); // inflate the layout
        ImageView icon = (ImageView) view.findViewById(R.id.icon); // get the reference of ImageView
        icon.setImageResource(logos[i]); // set logo images
        return view;
    }
    class MyViewHolder extends RecyclerView.ViewHolder {

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
                    Toast.makeText(context, "" + itemPosition, Toast.LENGTH_SHORT).show();
                   /* Intent intent = new Intent(context, CatselectedItem.class);

                    context.startActivity(intent);
*/
                }
            });
        }

    }
    }
