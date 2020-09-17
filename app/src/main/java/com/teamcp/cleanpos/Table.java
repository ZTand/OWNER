package com.teamcp.cleanpos;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.logging.LogRecord;

public class Table extends LinearLayout {

    LinearLayout table;
    TextView tableItemName;
    TextView tableItemOrder;
    GridLayout tableLayout;

    public Table(Context context) {
        super(context);
        initView();
    }
    public Table(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
        getAttrs(attrs);
    }
    public Table(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
        getAttrs(attrs, defStyleAttr);
    }

    public Table(Context context, int tableNumber, String order, final int C, final int W, final int layoutWidth, final int layoutHeight) {
        this(context);
        tableItemName.setText("" + tableNumber);
        tableItemOrder.setText(order);
        table.setMinimumWidth(layoutWidth / C);
        table.setMinimumHeight(layoutHeight / W);
    }

    private void initView() {
        String infService = Context.LAYOUT_INFLATER_SERVICE;
        LayoutInflater li = (LayoutInflater)getContext().getSystemService(infService);
        View v = li.inflate(R.layout.table, this, false);
        addView(v);

        table = findViewById(R.id.table);
        tableItemName = findViewById(R.id.table_item_name);
        tableItemOrder = findViewById(R.id.table_item_order);
        tableLayout = findViewById(R.id.table_layout);
    }

    private void getAttrs(AttributeSet attrs) {
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.Table);
        setTypeArray(typedArray);
    }

    private void getAttrs(AttributeSet attrs, int defStyle) {
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.Table, defStyle, 0);
        setTypeArray(typedArray);
    }

    private void setTypeArray(TypedArray typeArray) {
        Integer itemName = typeArray.getInteger(R.styleable.Table_table_item_name, 0);
        tableItemName.setText(itemName.toString());
        tableItemOrder.setText(typeArray.getString(R.styleable.Table_table_item_order));
        typeArray.recycle();
    }
}
