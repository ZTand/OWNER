package com.teamcp.cleanpos;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            TextView date = findViewById(R.id.date);
            SimpleDateFormat format2 = new SimpleDateFormat ( "M월 d일  H:m a");
            @Override
            public void run() {
                Date time = new Date();
                date.setText(format2.format(time));
            }
        };
        timer.schedule(task, 1000, 1000);

        ListView listView = findViewById(R.id.order_list);
        ArrayList<OrderVO> datas = new ArrayList<>();
        OrderVO vo = new OrderVO();
        vo.tableNumber = "4번 테이블";
        vo.order = "짜장면 1 \n짬뽕 1 \n탕수육 1";
        vo.orderType = "매장 내 식사";
        vo.receiptType = "영수증 X";
        vo.orderTime = "5분 전";
        datas.add(vo);

        vo = new OrderVO();
        vo.tableNumber = "12번 테이블";
        vo.order = "짜장면 3 \n탕수육 1 \n사이다 1";
        vo.orderType = "테이크아웃";
        vo.receiptType = "영수증 O";
        vo.orderTime = "3분 전";
        datas.add(vo);

        OrderAdapter adapter = new OrderAdapter(this, R.layout.order, datas);
        listView.setAdapter(adapter);
    }
}
