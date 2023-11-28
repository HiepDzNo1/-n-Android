package com.example.runappstor.RestfulAPI;
import com.example.runappstor.Entity.ListStory;
import com.example.runappstor.Entity.Story;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("API_ListStory.php")
    Call<List<ListStory>> getListStories();

    @GET("API_Story.php")
    Call<List<Story>> getInfoStory();
}
