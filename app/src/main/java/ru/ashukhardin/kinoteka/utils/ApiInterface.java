package ru.ashukhardin.kinoteka.utils;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;
import ru.ashukhardin.kinoteka.Movie.Movie;

public interface ApiInterface {
       @Headers({"accept: application/json","X-API-KEY: 8NM326T-N1F4YK5-J644Y4B-94E73RB"})
       @GET("movie/search?page=1&limit=1") Call<Movie> getMovieName(@Query("query") String name);
       @Headers({"accept: application/json","X-API-KEY: 8NM326T-N1F4YK5-J644Y4B-94E73RB"})
       @GET("movie/{id}") Call<Movie> getMovieId(@Path("id") int movie_id);
       @Headers({"accept: application/json","X-API-KEY: 8NM326T-N1F4YK5-J644Y4B-94E73RB"})
       @GET("movie/random?notNullFields=name") Call<Movie> getMovieRandom();
}
