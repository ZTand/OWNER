package com.teamcp.cleanpos;

import android.view.View;
import android.widget.TextView;

public class OrderHolder {
    public TextView tableNumberTextView;
    public TextView orderTextView;
    public TextView orderTypeButton;
    public TextView receiptTypeButton;
    public TextView orderTimeTextView;

    public OrderHolder(View root) {
        tableNumberTextView = root.findViewById(R.id.table_number);
        orderTextView = root.findViewById(R.id.order);
        orderTypeButton = root.findViewById(R.id.order_type);
        receiptTypeButton = root.findViewById(R.id.receipt_type);
        orderTimeTextView = root.findViewById(R.id.order_time);
    }
}
