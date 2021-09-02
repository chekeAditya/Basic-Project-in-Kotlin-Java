package com.example.rough;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Network {

//
//    public static retrofit2.Retrofit getRetrofitInstance(final Context context) {
//        OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                .cache(new Cache(context.getCacheDir(), 10 * 1024 * 1024))
//                .addInterceptor(httpLoggingInterceptor)
//                .addNetworkInterceptor(networkInterceptor())
//                .addInterceptor(offlineInterceptor(context))
//                .build();
//
//        Retrofit.Builder builder = new Retrofit.Builder().baseUrl(BASE_URL)
//                //In most cases requests to a server, and the responses from the server, are not Java objects. They’re mapped to some language neutral format like JSON
//                .addConverterFactory(GsonConverterFactory.create())
//                //this client will help you to print the API call logs in the Logcat
//                .client(okHttpClient);
//        return builder.build();
//    }

    private static final HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
    public static Retrofit getInstance() {
        return new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build())
                .build();
    }
    /*

https://api.themoviedb.org/3/search/movie?api_key=2147294b386ecadcb05cd19bcbbdddb9&query=mimi
     */
}
