package com.mbr.KiranaGenie.ui.home;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mbr.KiranaGenie.Activities.SignInActivity;
import com.mbr.KiranaGenie.Activities.SplashScreen;
import com.mbr.KiranaGenie.Activities.ViewAllCategories;
import com.mbr.KiranaGenie.Adapter.CatAdapter;
import com.mbr.KiranaGenie.Adapter.CategoryAdapter;
import com.mbr.KiranaGenie.Adapter.TopDealsAdapter;
import com.mbr.KiranaGenie.Api.RetrofitClient;
import com.mbr.KiranaGenie.Constant.Session;
import com.mbr.KiranaGenie.Model.CatModel;
import com.mbr.KiranaGenie.Model.CategoryResposnseModel;
import com.mbr.KiranaGenie.Model.TopDealsModel;
import com.mbr.KiranaGenie.R;
import com.mbr.KiranaGenie.ui.Cartitem.Cart;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ss.com.bannerslider.banners.Banner;
import ss.com.bannerslider.banners.DrawableBanner;
import ss.com.bannerslider.banners.RemoteBanner;
import ss.com.bannerslider.views.BannerSlider;

public class HomeFragment extends Fragment {
    private ArrayList<TopDealsModel> topDealsModelArrayList;
    private ArrayList<TopDealsAdapter> myTodealsImageArraylist;
    private TopDealsAdapter topDealsAdapter;
private ArrayList<CategoryAdapter> catmodellist;



    private ArrayList<CatModel> imageModelArrayList;
    private ArrayList<CatAdapter> myImageArraylist;
    private HomeViewModel homeViewModel;
    private CatAdapter adapter;
    private int[] myImageList = new int[]{R.drawable.oil, R.drawable.topdeals_surf, R.drawable.topdeals_dal, R.drawable.topdeals_bekary, R.drawable.topdeals_bekary};
    private String[] myImageNameList = new String[]{"Food grains,oil & masala", "Cleaning & Household", "Dals & pulses", ""};


    private int[] topdealsimagelist = new int[]{R.drawable.topdeal_taj, R.drawable.deals_freedom, R.drawable.deals_freedom, R.drawable.topdeal_taj};
    private String[] topdealsnames = new String[]{"10% off", "20% off", "20% off", "30% off"};
    private String[] topdeal_brand = new String[]{"Taj Mahal", "Freedam", "Freedam", "Taj Mahal"};
    private String[] topdeal_item = new String[]{"Tea", "Freedam Oil", "Freedam Oil", "Tea"};
    private String[] topdeal_actualprice = new String[]{"Rs.135", "Rs.135", "Rs.135", "Rs.135"};
    private String[] topdeal_offerprice = new String[]{"Rs.250", "Rs.250", "Rs.250", "Rs.250"};

    ImageView img_offer_home_banner;
    private Object CategoryResposnseModel;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);

        View root = inflater.inflate(R.layout.fragment_home, container, false);
        root.getContext();


        final RecyclerView recyclerView = root.findViewById(R.id.recycler);
        final RecyclerView topdeals = root.findViewById(R.id.topdeals_recycler);
        final AppCompatButton btn_topdeals_addcart = root.findViewById(R.id.topdeals_addcart);
        final LinearLayout ln_offer_on_grocery = (LinearLayout) root.findViewById(R.id.offer_on_grocery);
        final ImageView imageView = root.findViewById(R.id.offer_home_banner);






        ln_offer_on_grocery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ViewAllCategories.class);
                startActivity(intent);
            }
        });

        BannerSlider bannerSlider = (BannerSlider) root.findViewById(R.id.banner_slider1);
        List<Banner> banners = new ArrayList<>();
        //add banner using image url
        banners.add(new RemoteBanner("Put banner image url here ..."));
        //add banner using resource drawable
        banners.add(new DrawableBanner(R.drawable.home_offerbanner));
        bannerSlider.setBanners(banners);

        BannerSlider bannerSlider1 = (BannerSlider) root.findViewById(R.id.welcome_banner);
        List<Banner> banners1 = new ArrayList<>();
        //add banner using image url
        banners1.add(new RemoteBanner("Put banner image url here ..."));
        //add banner using resource drawable
        banners1.add(new DrawableBanner(R.drawable.home_banner_welcome));
        bannerSlider1.setBanners(banners1);


        topDealsModelArrayList = topdealsitems();
        topDealsAdapter = new TopDealsAdapter(getActivity(), topDealsModelArrayList);
        topdeals.setAdapter(topDealsAdapter);
        topDealsAdapter.notifyDataSetChanged();
        topdeals.setLayoutManager(new LinearLayoutManager(getActivity(),
                LinearLayoutManager.HORIZONTAL, false));


     /*   imageModelArrayList = beverges();
        adapter = new CatAdapter(getActivity(), imageModelArrayList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),
                LinearLayoutManager.HORIZONTAL, false));
        GridLayoutManager glm = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(glm);
*/

        final ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Loading..");
        progressDialog.setMessage("Loading..");
        progressDialog.show();

        Call<CategoryResposnseModel> shopby = RetrofitClient.getInstance().getApi().getcategories();
        shopby.enqueue(new Callback<CategoryResposnseModel>() {
            @Override
            public void onResponse(Call<CategoryResposnseModel> call, Response<CategoryResposnseModel> response) {
                if (response.code() == 200) {
                    Session session = new Session(getContext());
                    session.getSESSION_ID();
                    session.getCUSTOMER_ID();
                    session.getCATEGORY_ID();

                    Session session1 = new Session(getContext());
                    session1.Sessionsaved(String.valueOf(response.body().getCategories()));


                    CategoryAdapter adapter = new CategoryAdapter((List<CategoryResposnseModel.CATEGORY>) response.body().getCategories(), getContext());
                    recyclerView.setAdapter(adapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
                    GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
                    recyclerView.setLayoutManager(gridLayoutManager);
                    progressDialog.dismiss();
                }
            }

            @Override
            public void onFailure(Call<CategoryResposnseModel> call, Throwable t) {

            }

        });
        return root;

    }

    private ArrayList<CatModel> beverges() {

        ArrayList<CatModel> list = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            CatModel fruitModel = new CatModel();
            fruitModel.setName(myImageNameList[i]);
            fruitModel.setImage_drawable(myImageList[i]);
            list.add(fruitModel);
        }

        return list;
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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //imageModelArrayList=null;
    }
}