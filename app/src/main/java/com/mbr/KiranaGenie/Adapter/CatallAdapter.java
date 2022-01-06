package com.mbr.KiranaGenie.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.mbr.KiranaGenie.Model.Catallitems;
import com.mbr.KiranaGenie.R;

import java.util.ArrayList;
import java.util.List;

public class CatallAdapter extends ArrayAdapter<Catallitems> {
    List<Catallitems> catallitemsList = new ArrayList<>();
    int custom_gridviewid;

    public CatallAdapter(@NonNull Context context, int resource, List<Catallitems> objects) {
        super(context, resource, objects);
        catallitemsList = objects;
        custom_gridviewid = resource;
    }

    @Override
    public int getCount() {
        return catallitemsList.size();
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View v = convertView;
        if (v == null) {
            // getting reference to the main layout and
            // initializing
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(custom_gridviewid, null);
        }

        // initializing the imageview and textview and
        // setting data
        ImageView imageView = v.findViewById(R.id.cat_allimage);
        TextView textView = v.findViewById(R.id.catall_itemname);
        // get the item using the  position param
        Catallitems item = catallitemsList.get(position);
        imageView.setImageResource(item.getCatimage_id());
        textView.setText(item.getText());
        return v;


    }

}