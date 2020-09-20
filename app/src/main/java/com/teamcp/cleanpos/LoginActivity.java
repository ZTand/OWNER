package com.teamcp.cleanpos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.teamcp.cleanpos.API.Model.Login.OwnerLoginRes;
import com.teamcp.cleanpos.API.RetrofitManager;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

import static com.teamcp.cleanpos.API.RetrofitManager.OWNER_BASE_URL;

public class LoginActivity extends AppCompatActivity {

    private EditText edtUserId;
    private EditText edtUserPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtUserId = findViewById(R.id.id_editText);
        edtUserPwd = findViewById(R.id.password_editText);

        Button loginButton = findViewById(R.id.login_btn);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RetrofitManager.OwnerAPI().postOwnerLogin(edtUserId.getText().toString(), edtUserPwd.getText().toString()).enqueue(new Callback<OwnerLoginRes>() {
                    @Override
                    public void onResponse(Call<OwnerLoginRes> call, Response<OwnerLoginRes> response) {
                        if(response.isSuccessful()) {
                            switch (response.body().getCode()) {
                                case 200:
                                    Toast.makeText(getApplicationContext(), "로그인 성공!", Toast.LENGTH_SHORT).show();
                                    break;

                                case 204:
                                    Toast.makeText(getApplicationContext(), "아이디 혹은 비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show();
                                    break;

                                case 404:
                                    Toast.makeText(getApplicationContext(), "알 수 없는 오류가 발생하였습니다.", Toast.LENGTH_SHORT).show();
                                    break;
                            }
                        } else {
                            Toast.makeText(getApplicationContext(), "서버 오류가 발생하였습니다.", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<OwnerLoginRes> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                        Log.e("LoginActivity", t.getMessage());
                    }
                });
//                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//                startActivity(intent);
            }
        });

//        Count count = new Count("1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1");
//        final Call<Void> joinContentCall = networkService.joinAccount(count);
//        joinContentCall.enqueue(new Callback<Void>() {
//            @Override
//            public void onResponse(Call<Void> call, Response<Void> response) {
//                if (response.isSuccessful()) {
//                    Log.d("TEST", "연동 성공");
//                } else {
//                    Log.d("TEST", "연동 선공, 데이터 전송 실패");
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Void> call, Throwable t) {
//                Log.d("TEST", "연동 실패");
//            }
//        });
    }

    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.register:
//                intent = new Intent(getApplicationContext(), )
                break;
        }
    }
}
