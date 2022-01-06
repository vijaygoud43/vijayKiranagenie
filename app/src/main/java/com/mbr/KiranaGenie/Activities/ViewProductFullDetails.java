package com.mbr.KiranaGenie.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mbr.KiranaGenie.Adapter.CategoryAdapter1;
import com.mbr.KiranaGenie.Adapter.ProductFullDetailsAdapter;

import com.mbr.KiranaGenie.Adapter.SelectedProductListAdapter;
import com.mbr.KiranaGenie.Adapter.TopDealsAdapter;
import com.mbr.KiranaGenie.Api.RetrofitClient;
import com.mbr.KiranaGenie.Model.CategoryResposnseModel;
import com.mbr.KiranaGenie.Model.ProductfullDetailsResponseModel;
import com.mbr.KiranaGenie.Model.TopDealsModel;
import com.mbr.KiranaGenie.R;
import com.mbr.KiranaGenie.data.request.CustomerRequest;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewProductFullDetails extends AppCompatActivity implements View.OnClickListener {
    ImageView imageView1;
    Button btn_all_details_cart;
    TextView txt_txt_100gms;
    int tophone;

    private ArrayList<TopDealsModel> viewSimilarModelArrayList;
    private ArrayList<TopDealsAdapter> myviewImageArraylist;
    private TopDealsAdapter topDealsAdapter;

    RecyclerView rv_viewsimilar_products, rv_basedon_search_products, rv_more_frombrand_products;

    private int[] topdealsimagelist = new int[]{R.drawable.topdeal_taj, R.drawable.deals_freedom, R.drawable.deals_freedom, R.drawable.topdeal_taj};
    private String[] topdealsnames = new String[]{"10% off", "20% off", "20% off", "30% off"};
    private String[] topdeal_brand = new String[]{"Taj Mahal", "Freedam", "Freedam", "Taj Mahal"};
    private String[] topdeal_item = new String[]{"Tea", "Freedam Oil", "Freedam Oil", "Tea"};
    private String[] topdeal_actualprice = new String[]{"Rs.135", "Rs.135", "Rs.135", "Rs.135"};
    private String[] topdeal_offerprice = new String[]{"Rs.250", "Rs.250", "Rs.250", "Rs.250"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_product_full_details);
      /*  rv_viewsimilar_products = (RecyclerView) findViewById(R.id.viewsimilar_products);
        rv_basedon_search_products = (RecyclerView) findViewById(R.id.basedon_search_products);
        rv_more_frombrand_products = (RecyclerView) findViewById(R.id.more_frombrand_products);*/
        btn_all_details_cart = (Button) findViewById(R.id.all_details_cart);
     //   txt_txt_100gms=(TextView)findViewById(R.id.txt_100gms);

     /*   if (getIntent().getExtras().getString("category_id")!=null) {
            String data = getIntent().getExtras().getString("category_id");
            Log.e("id", "" + data);
        }*/
        RecyclerView recyclerView = findViewById(R.id.view_full_productdetails);
        String data = getIntent().getExtras().getString("product_id")+"";
        Log.e("fullproduct_id", "" + data);
        Call<ProductfullDetailsResponseModel> shopby = RetrofitClient.getInstance().getApi().getproductfulldetails1(data);
        shopby.enqueue(new Callback<ProductfullDetailsResponseModel>() {

            @Override
            public void onResponse(Call<ProductfullDetailsResponseModel> call, Response<ProductfullDetailsResponseModel> response) {
                if (response.code() == 200) {

                    // Log.e("id",""+response.body().getproductlistList().get(0).getCategory_id());
                    ProductFullDetailsAdapter adapter = new ProductFullDetailsAdapter((List<ProductfullDetailsResponseModel.PRODUCTFULLDETAILS>) response.body().getfulldetails(),ViewProductFullDetails.this);
                    recyclerView.setLayoutManager(
                            new LinearLayoutManager(ViewProductFullDetails.this, LinearLayoutManager.VERTICAL, false));
                    recyclerView.setAdapter(adapter);
                    //   progressDialog.dismiss();
                }
            }

            @Override
            public void onFailure(Call<ProductfullDetailsResponseModel> call, Throwable t) {

            }





        });




        //these all coming from topdeals adapter
        //add adapter,model class for similar products seperat
      /*  viewSimilarModelArrayList = topdealsitems();
        topDealsAdapter = new TopDealsAdapter(ViewProductFullDetails.this, viewSimilarModelArrayList);
        rv_viewsimilar_products.setAdapter(topDealsAdapter);
        topDealsAdapter.notifyDataSetChanged();
        rv_viewsimilar_products.setLayoutManager(new LinearLayoutManager(ViewProductFullDetails.this,
                LinearLayoutManager.HORIZONTAL, false));


        //add adapter,model class for based on search brand seperat
        viewSimilarModelArrayList = topdealsitems();
        topDealsAdapter = new TopDealsAdapter(ViewProductFullDetails.this, viewSimilarModelArrayList);
        rv_basedon_search_products.setAdapter(topDealsAdapter);
        topDealsAdapter.notifyDataSetChanged();
        rv_basedon_search_products.setLayoutManager(new LinearLayoutManager(ViewProductFullDetails.this,
                LinearLayoutManager.HORIZONTAL, false));

        //add adapter,model class for morefrom brand seperat
        viewSimilarModelArrayList = topdealsitems();
        topDealsAdapter = new TopDealsAdapter(ViewProductFullDetails.this, viewSimilarModelArrayList);
        rv_more_frombrand_products.setAdapter(topDealsAdapter);
        topDealsAdapter.notifyDataSetChanged();
        rv_more_frombrand_products.setLayoutManager(new LinearLayoutManager(ViewProductFullDetails.this,
                LinearLayoutManager.HORIZONTAL, false));
*/
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24);
        actionBar.setDisplayHomeAsUpEnabled(true);


        btn_all_details_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = getLayoutInflater();
                View layout = inflater.inflate(R.layout.custom_toast_layout,
                        (ViewGroup) findViewById(R.id.linear_toastlayout));
                // get the reference of TextView and ImageVIew from inflated layout
                TextView toastTextView = (TextView) layout.findViewById(R.id.toast_msg);
                ImageView toastImageView = (ImageView) layout.findViewById(R.id.toast_image);
                // set the text in the TextView

                toastImageView.setImageResource(R.drawable.rightok);

                Toast toast = new Toast(getApplicationContext());
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);// set the duration for the Toast
                toast.setView(layout); // set the inflated layout
                toast.show();
            }
        });





       /* tophone = R.drawable.powder;
        ImageView imageView2 = (ImageView) findViewById(R.id.imageView2);
        ImageView imageView3 = (ImageView) findViewById(R.id.imageView3);
        ImageView imageView4 = (ImageView) findViewById(R.id.imageView4);
        ImageView imageView5 = (ImageView) findViewById(R.id.imageView5);
        ImageView imageView6 = (ImageView) findViewById(R.id.imageView6);
        ImageView imageView7 = (ImageView) findViewById(R.id.imageView7);
        imageView2.setOnClickListener(this);
        imageView3.setOnClickListener(this);
        imageView4.setOnClickListener(this);

        imageView5.setOnClickListener(this);
        imageView2.setOnClickListener(this);
        imageView6.setOnClickListener(this);
        imageView7.setOnClickListener(this);*/
    }

    private ArrayList<TopDealsModel> topdealsitems() {

        ArrayList<TopDealsModel> list1 = new ArrayList<>();

        for (int i = 0; i < topdealsimagelist.length; i++) {
            TopDealsModel topDealsModel = new TopDealsModel();
            topDealsModel.setName(topdealsnames[i]);
            topDealsModel.setBrandname(topdeal_brand[i]);
            topDealsModel.setItem_name(topdeal_item[i]);
            topDealsModel.setActual_price(topdeal_actualprice[i]);
            topDealsModel.setTopdeals_offerprice(topdeal_offerprice[i]);
            topDealsModel.setImage_drawable(topdealsimagelist[i]);
            list1.add(topDealsModel);
        }

        return list1;
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
       /* switch (v.getId()) {
            case R.id.imageView2:
                imageView1.setImageResource(R.drawable.powder);
                tophone = R.drawable.powder;
                break;
            case R.id.imageView3:
                imageView1.setImageResource(R.drawable.powder_back);
                tophone = R.drawable.talcon;
                break;
            case R.id.imageView4:
                imageView1.setImageResource(R.drawable.powder_pack);
                tophone = R.drawable.powder;
                break;
            case R.id.imageView5:
                imageView1.setImageResource(R.drawable.powder_fashion);
                tophone = R.drawable.powder;
                break;
            case R.id.imageView6:
                imageView1.setImageResource(R.drawable.deals_freedom);
                tophone = R.drawable.powder;
                break;
            case R.id.imageView7:
                imageView1.setImageResource(R.drawable.powder1);
                tophone = R.drawable.powder;*/

        }

}