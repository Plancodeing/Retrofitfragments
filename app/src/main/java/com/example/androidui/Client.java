package com.example.androidui;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Client {
 private  static Retrofit retrofit = null;

    static Retrofit getclient(){
        retrofit = new Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/posts/").addConverterFactory(GsonConverterFactory.create()).build();
                return retrofit;

    }
}
