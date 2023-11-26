package ru.ashukhardin.kinoteka.utils;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import ru.ashukhardin.kinoteka.Movie.Movie;

public interface ApiInterface {
       @Headers({"accept: application/json","X-API-KEY: 8NM326T-N1F4YK5-J644Y4B-94E73RB"})
       @GET("movie/search?page=1&limit=1") Call<Movie> getMovie(@Query("name") String name);
    //@GET("movie")Call<String> getMovie(@Header("X-API-KEY") String token, @Query("name") String film_name);
}
