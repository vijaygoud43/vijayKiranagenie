package com.mbr.KiranaGenie.Api;

import android.content.Context;

import com.mbr.KiranaGenie.Model.CartResponseModel;
import com.mbr.KiranaGenie.Model.CategoryResposnseModel;
import com.mbr.KiranaGenie.Model.GetProductListResponseModule;
import com.mbr.KiranaGenie.Model.GetSessionIdResponse;
import com.mbr.KiranaGenie.Model.HomeResponseModel;
import com.mbr.KiranaGenie.Model.LoginResponseModel;
import com.mbr.KiranaGenie.Model.LogoutResponseModel;
import com.mbr.KiranaGenie.Model.ProductfullDetailsResponseModel;
import com.mbr.KiranaGenie.Model.RegisterResponseModel;
import com.mbr.KiranaGenie.data.request.AddCartRequest;
import com.mbr.KiranaGenie.data.request.CatgoryRequest;
import com.mbr.KiranaGenie.data.request.CustomerRequest;
import com.mbr.KiranaGenie.data.request.LoginRequestBody;
import com.mbr.KiranaGenie.data.request.LogoutRequestBoday;
import com.mbr.KiranaGenie.data.request.RegisterRequestBody;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;

import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryName;

public interface RetrofitApi {


@GET("rest/session")
Call<GetSessionIdResponse> getsessionId();

    @POST("rest/login")
    Call<LoginResponseModel> getLoginData(@Body LoginRequestBody body);

    @POST("rest/logout")
    Call<LogoutResponseModel>  getlogout(@Body LogoutRequestBoday body);

    @POST("rest/register")
    Call<RegisterResponseModel> registerDetails(@Body RegisterRequestBody body);

    @GET("home")
    Call<HomeResponseModel> home();

    @GET("rest//categories/extended/limit/3/")
    Call<CategoryResposnseModel> getcategories();

    @GET("rest/products/{category_id}")
    Call<GetProductListResponseModule> getproductlist(@Path("category_id") String category_id);

    @GET("rest/products/category/{category_id}/limit/100/page/0")
    Call<GetProductListResponseModule> getproductlistcat(@Path("category_id") String category_id);

   /* @GET("rest/products/category")
    Call<GetProductListResponseModule> getproductlist(@Path("id") String category_id);*/
//http://192.168.1.72/sskMart/api/rest/products/manufacturer/{50 product manufacture id}
    @GET("rest/products/manufacturer")
    Call<ProductfullDetailsResponseModel> getproductfulldetails();

@GET("rest/products/{product_id}")
    Call<ProductfullDetailsResponseModel> getproductfulldetails1(@Query("product_id") String product_id);
/*@POST("rest/cart")
    Call<CartResponseModel> addCart(@Body AddCartRequest body);*/

    @POST("auth/addCart")
    Call<CartResponseModel> addCart(
            @Field("product_id") String product_id,
            @Field("quantity") String quantity
    );

}
