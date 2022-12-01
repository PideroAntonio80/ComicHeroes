package com.example.comicheroes.data.network.webService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitApiClientGenerator {

    private static Retrofit retrofit;

    private static final String BASE_URL = "https://akabab.github.io/superhero-api/api/";

    public static Retrofit getRetrofitInstance() {

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)   // TODO: Tratar de conseguir esto --> BuildConfig.URL_SERVER en vez de BASE_URL
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
