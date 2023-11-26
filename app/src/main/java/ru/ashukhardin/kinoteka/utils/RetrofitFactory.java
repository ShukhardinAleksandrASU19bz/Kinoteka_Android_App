package ru.ashukhardin.kinoteka.utils;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitFactory {
    static final String BASE_URL="https://api.kinopoisk.dev/v1.4/";
private static Retrofit retrofit = null;
public static ApiInterface getRetrofit() {
    if (retrofit == null) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder client = new OkHttpClient.Builder()
                .addInterceptor(interceptor);
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client.build())
                .build();
    }
    ApiInterface kinoapi = retrofit.create(ApiInterface.class);
    return kinoapi;
}
}
