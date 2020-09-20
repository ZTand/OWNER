package com.teamcp.cleanpos.API;

import com.teamcp.cleanpos.API.Interface.Owner.OwnerAPI;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitManager {
    // BASE URL
    public static final String OWNER_BASE_URL = "http://ec2-13-124-71-149.ap-northeast-2.compute.amazonaws.com:3000/";

    // Retrofit <-> Interface <-> Model
    private static Retrofit retrofitOwner;
    private static OwnerAPI ownerAPI;

    // Singleton
    private static Retrofit getRetrofitOwner() {
        if(retrofitOwner == null) {
            OkHttpClient client = new OkHttpClient.Builder().connectTimeout(15000, TimeUnit.MILLISECONDS).readTimeout(15000, TimeUnit.MILLISECONDS).build();
            retrofitOwner = new Retrofit.Builder().baseUrl(OWNER_BASE_URL).client(client).addConverterFactory(GsonConverterFactory.create()).build();
        }

        return retrofitOwner;
    }

    // 실제 호출할 때 사용하는 녀석
    public static OwnerAPI OwnerAPI() {
        if (ownerAPI == null)
            ownerAPI = getRetrofitOwner().create(OwnerAPI.class);

        return ownerAPI;
    }
}
