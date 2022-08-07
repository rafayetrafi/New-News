package com.rafayet.newnews.DAO;

import com.rafayet.newnews.Model.NewsData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    String BASE_URL = "https://newsapi.org/v2/";

    @GET("top-headlines")
    Call<NewsData> getNews(
            @Query("country") String country,
            @Query("pageSize") String pagesize,
            @Query("apiKey") String apikey
    );

    @GET("top-headlines")
    Call<NewsData> getCategoryNews(
            @Query("country") String country,
            @Query("category") String category,
            @Query("pageSize") String pagesize,
            @Query("apiKey") String apikey
    );


}
