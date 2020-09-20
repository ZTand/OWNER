package com.teamcp.cleanpos.API.Interface.Owner;

import com.teamcp.cleanpos.API.Model.Login.OwnerLoginRes;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface OwnerAPI {
    @FormUrlEncoded // 인코딩
    @POST("user/login") // API 대상
    Call<OwnerLoginRes> postOwnerLogin(@Field("userId") String userId, @Field("userPwd") String userPwd); // Call<{response}> functionName(@Field({parameter} argument))
}
