package com.example.androidui;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    @GET("1")
    Call<Data> getData();
    @GET("posts")
    Call<ArrayList<Data>> getDataa();
}
