package com.mbr.KiranaGenie.Activities;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.mbr.KiranaGenie.Adapter.CategoryAdapter1;
import com.mbr.KiranaGenie.Adapter.SelectedProductListAdapter;
import com.mbr.KiranaGenie.Api.RetrofitClient;
import com.mbr.KiranaGenie.Constant.Session;
import com.mbr.KiranaGenie.Model.CategoryResposnseModel;
import com.mbr.KiranaGenie.Model.GetProductListResponseModule;
import com.mbr.KiranaGenie.R;
import com.mbr.KiranaGenie.ui.Cartitem.CartViewModel;

import java.nio.charset.StandardCharsets;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SelectProductList extends AppCompatActivity {
    LinearLayout ln_product_fulldetails,ln_incdec_ln;
    private int minteger=1;
    Session session;
    String category_id;
    Button btn_btn_sort, btn_filter_button, btn_item_added;
    RelativeLayout relativeLayout;
TextView txt_item_subscribe,emptyView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_product);
        ln_product_fulldetails = (LinearLayout) findViewById(R.id.product_fulldetails);
        session = new Session(getApplication());//<-- this is what you missed
        emptyView=(TextView) findViewById(R.id.empty_view);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24);
        actionBar.setDisplayHomeAsUpEnabled(true);

        RecyclerView recyclerView = findViewById(R.id.selected_product_listrecycler);

        String data = getIntent().getExtras().getString("category_id")+"";
        Log.e("id", "" + data);
        Call<GetProductListResponseModule> shopby = RetrofitClient.getInstance().getApi().getproductlistcat(data);
        shopby.enqueue(new Callback<GetProductListResponseModule>() {

            @Override
            public void onResponse(Call<GetProductListResponseModule> call, Response<GetProductListResponseModule> response) {
                if (response.code() == 200) {
                 // Log.e("id",""+response.body().getproductlistList().get(0).getCategory_id());
                    SelectedProductListAdapter adapter = new SelectedProductListAdapter((List<GetProductListResponseModule.GETPRODUCTLIST>) response.body().getproductlistList(),SelectProductList.this);
                    recyclerView.setLayoutManager(
                            new LinearLayoutManager(SelectProductList.this, LinearLayoutManager.VERTICAL, false));
                    recyclerView.setAdapter(adapter);

                    //   progressDialog.dismiss();
                }
            }



            @Override
            public void onFailure(Call<GetProductListResponseModule> call, Throwable t) {

            }


        });


    }
}