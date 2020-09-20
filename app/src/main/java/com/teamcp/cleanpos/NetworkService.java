package com.teamcp.cleanpos;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface NetworkService {
    @POST("/POST/1")
    Call<Void> joinAccount(@Body Count count);
}
