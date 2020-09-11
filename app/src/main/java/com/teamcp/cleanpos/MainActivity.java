package com.teamcp.cleanpos;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button tableSettingButton;
    GridLayout tableLayout;
    AlertDialog tableSettingDialog;

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

        tableSettingButton = findViewById(R.id.table_setting_btn);
        tableSettingButton.setOnClickListener(this);

        tableLayout = findViewById(R.id.table_layout);
    }

    DialogInterface.OnClickListener dialogListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            if(dialog==tableSettingDialog && which == DialogInterface.BUTTON_POSITIVE) {
                EditText column = tableSettingDialog.findViewById(R.id.column_count_EditText);
                tableLayout.removeAllViews();
                tableLayout.setColumnCount(Integer.parseInt(column.getText().toString()));

                EditText num = tableSettingDialog.findViewById(R.id.table_count_EditText);
                int N = Integer.parseInt(num.getText().toString());
                LayoutInflater inflater = (LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
                GridLayout tableLayout = findViewById(R.id.table_layout);
                for(int i=0; i<N; i++) {
                    tableLayout.addView(new Button(MainActivity.this));
                }
            }
        }
    };

    @Override
    public void onClick(View v) {
        if(v==tableSettingButton) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            LayoutInflater inflater = (LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.dialog_table_setting, null);
            builder.setView(view);

            builder.setPositiveButton("확인", dialogListener);
            builder.setNegativeButton("취소", null);

            tableSettingDialog = builder.create();
            tableSettingDialog.show();
        }
    }
}
