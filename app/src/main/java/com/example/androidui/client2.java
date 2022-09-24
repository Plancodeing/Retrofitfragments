package com.example.androidui;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class client2 {
    private  static Retrofit retrofit = null;

    static Retrofit getclient(){
        retrofit = new Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/").addConverterFactory(GsonConverterFactory.create()).build();
        return retrofit;

    }
}
