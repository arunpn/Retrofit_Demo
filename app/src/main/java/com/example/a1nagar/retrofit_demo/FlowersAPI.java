package com.example.a1nagar.retrofit_demo;

import com.example.a1nagar.retrofit_demo.model.Flower;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by a1nagar on 6/11/15.
 */
public interface FlowersAPI {

    @GET("/feeds/flowers.json")
    public  void getFeed( Callback<List<Flower>> callback);
}
