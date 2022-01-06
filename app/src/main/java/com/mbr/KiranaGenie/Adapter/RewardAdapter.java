package com.mbr.KiranaGenie.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import com.mbr.KiranaGenie.Activities.RewardDetails;
import com.mbr.KiranaGenie.Model.Catallitems;
import com.mbr.KiranaGenie.Model.Rewarditems;
import com.mbr.KiranaGenie.R;

import java.util.ArrayList;
import java.util.List;

public class RewardAdapter extends ArrayAdapter<Rewarditems> {
    List<Rewarditems> rewarditemsList= new ArrayList<>();
    int reward_gridviewid;

    int position;
    Context context;
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


    public RewardAdapter(@NonNull Context context, int resource, List<Rewarditems> objects) {
        super(context, resource,objects);
        rewarditemsList = objects;
        reward_gridviewid = resource;



    }
    @Override
    public int getCount() {
        return rewarditemsList.size();
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View v = convertView;
        if (v == null) {

               // getting reference to the main layout and
            // initializing
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(reward_gridviewid, null);

        }


        ImageView imageView = v.findViewById(R.id.reward_allimage);
        TextView textView = v.findViewById(R.id.rewards_item_name);

        CardView cardView=v.findViewById(R.id.rewards_card);
        int index = position % backgroundColors.length;
        int color = ContextCompat.getColor(getContext(), backgroundColors[index]);
        cardView.setBackgroundColor(color);


        // get the item using the  position param
        Rewarditems item = rewarditemsList.get(position);

        imageView.setImageResource(item.getReward_image_id());
        textView.setText(item.getReward_text());


        return v;
    }

}
