package com.example.rough;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface apiclient {
    //https://api.themoviedb.org/3/search/movie?api_key=2147294b386ecadcb05cd19bcbbdddb9&query=mimi
    @GET("3/search/movie")
    Call<ResponseModel> getSearchedMovie(@Query("apiKey") String apikey, @Query("movieName") String movieName);
}
