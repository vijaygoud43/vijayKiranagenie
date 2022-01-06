package com.mbr.KiranaGenie.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.mbr.KiranaGenie.Adapter.ProductFullDetailsAdapter;
import com.mbr.KiranaGenie.Api.RetrofitClient;
import com.mbr.KiranaGenie.Model.ProductfullDetailsResponseModel;
import com.mbr.KiranaGenie.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductFullDetails extends AppCompatActivity {
    TextView productname;
    TextView price;
    TextView mrp;
    TextView inclusvetaxestext;
    TextView txt_product_rating_fulldetails;
    TextView rating_content;
    TextView quantity;
    TextView availableoffers;
    TextView productdetails;
    TextView endrating, reviewrating, reviewtext;
    ImageView image;
    TextView product_id;
    ProgressBar progress;
    CardView cardView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_full_details);

        product_id=(TextView)findViewById(R.id.product_id);
        productname = (TextView)findViewById(R.id.product_name_fulldetails1);
        price = (TextView) findViewById(R.id.product_price_fulldetails1);
        mrp = (TextView) findViewById(R.id.product_mrp_fulldetails1);
        image =(ImageView) findViewById(R.id.product_image_fulldetails1);
        inclusvetaxestext = (TextView) findViewById(R.id.product_taxes_fulldetails1);
        // cardView = itemView.findViewById(R.id.items_card);
        txt_product_rating_fulldetails = (TextView) findViewById(R.id.product_rating_fulldetails1);
        //rating_content = (TextView) findViewById(R.id.product_ratingcontent_fulldetails1);
        quantity = (TextView) findViewById(R.id.product_quantity_fulldetails1);
        availableoffers = (TextView) findViewById(R.id.product_offers_fulldetails1);
        productdetails = (TextView) findViewById(R.id.product_details_fulldetails1);
        endrating = (TextView) findViewById(R.id.product_endrating_fulldetails1);
        reviewrating = (TextView) findViewById(R.id.product_reviewrating_fulldetails1);
      //  reviewtext = (TextView) findViewById(R.id.product_reviewtext_fulldetails1);


     //   String   data=getIntent().getStringExtra("product_id");


      Intent intent = getIntent();
        String data = intent.getStringExtra("product_id")+"";
     //   String data = getIntent().getExtras().getString("product_id")+"";
        Log.e("fullproduct_id", "" + data);


        Call<ProductfullDetailsResponseModel> shopby = RetrofitClient.getInstance().getApi().getproductfulldetails1(data);
        shopby.enqueue(new Callback<ProductfullDetailsResponseModel>() {

            @Override
            public void onResponse(Call<ProductfullDetailsResponseModel> call, Response<ProductfullDetailsResponseModel> response) {
                if (response.code()==200) {



                    Picasso.with(getApplication()).load(response.body().getfulldetails().get(0).getImage()).into(image, new com.squareup.picasso.Callback() {
                        @Override
                        public void onSuccess() {

                        }

                        @Override
                        public void onError() {

                        }

                    });


                    ProductfullDetailsResponseModel resObj=(ProductfullDetailsResponseModel)response.body();

                  //  product_id.setText(resObj.getfulldetails().get(0).getProduct_id());
                    productname.setText(resObj.getfulldetails().get(0).getName());
                    price.setText(resObj.getfulldetails().get(0).getPrice());
                    mrp.setText(resObj.getfulldetails().get(0).getMrpprice());
                    productdetails.setText(resObj.getfulldetails().get(0).getDescription());
                    txt_product_rating_fulldetails.setText(resObj.getfulldetails().get(0).getRating());




                    // Log.e("id",""+response.body().getproductlistList().get(0).getCategory_id());

                }
            }

            @Override
            public void onFailure(Call<ProductfullDetailsResponseModel> call, Throwable t) {

            }





        });


    }
}