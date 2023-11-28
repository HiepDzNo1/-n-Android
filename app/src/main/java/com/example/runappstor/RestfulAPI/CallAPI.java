package com.example.runappstor.RestfulAPI;

import com.example.runappstor.Entity.ListStory;
import com.example.runappstor.Entity.Story;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class CallAPI {
    private static final String BASE_URL = "https://severchicken-savedata.000webhostapp.com/";

    public void CallListStory(Callback<List<ListStory>> callback) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Call<List<ListStory>> callListStory = apiService.getListStories();
        callListStory.enqueue(callback);
    }

    public void CallStory(Callback<List<Story>> callback) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Call<List<Story>> callStory = apiService.getInfoStory();
        callStory.enqueue(callback);
    }
}


