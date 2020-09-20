package com.teamcp.cleanpos;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RetrofitAPI {
    @FormUrlEncoded
    @POST("/")
    Call<Count> postData(@FieldMap HashMap<String, String> param);
}
