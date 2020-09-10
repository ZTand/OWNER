package com.teamcp.cleanpos;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;


public class RestaurantView extends LinearLayout {
    ImageView restaurantThumbnail;
    TextView restaurantName, restaurantPhone, restaurantRate;

    public RestaurantView(Context context) {
        super(context);
        init(context);
    }

    public RestaurantView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    private void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.restaurant_list, this, true);
        restaurantThumbnail = findViewById(R.id.restaurant_thumbnail);
        restaurantName = findViewById(R.id.restaurant_name);
        restaurantPhone = findViewById(R.id.restaurant_phone);
        restaurantRate = findViewById(R.id.restaurant_rate);
    }

    public void setThumbnail(int thumbnailId) {
        restaurantThumbnail.setImageResource(thumbnailId);
    }

    public void setName(String name) {
        restaurantName.setText(name);
    }

    public void setPhone(String phone) {
        restaurantPhone.setText(phone);
    }

    public void setRate(String rate) {
        restaurantRate.setText(rate);
    }
}
