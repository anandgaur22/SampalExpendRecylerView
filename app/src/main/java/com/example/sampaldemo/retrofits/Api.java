package com.example.sampaldemo.retrofits;


import com.example.sampaldemo.CommentryModel.CommentryModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface Api {



    @Headers("X-API-TOKEN: SrbKOLYjtzRD")
    @POST("login/forgetpassword")
    Call<CommentryModel> forgotPassword(
            @Field("client_email") String client_email,
            @Field("api_token") String api_token);






}
