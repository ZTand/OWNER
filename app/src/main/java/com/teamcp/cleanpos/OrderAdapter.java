package com.teamcp.cleanpos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class OrderAdapter extends ArrayAdapter<OrderVO> {
    Context context;
    int resId;
    ArrayList<OrderVO> datas;

    public OrderAdapter(Context context, int resId, ArrayList<OrderVO> datas) {
        super(context, resId);
        this.context = context;
        this.resId = resId;
        this.datas = datas;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(resId, null);
            OrderHolder holder = new OrderHolder(convertView);
            convertView.setTag(holder);
        }
        OrderHolder holder = (OrderHolder)convertView.getTag();

        TextView tableNumberTextView = holder.tableNumberTextView;
        TextView orderTextView = holder.orderTextView;
        Button orderTypeButton = holder.orderTypeButton;
        Button receiptTypeButton = holder.receiptTypeButton;
        TextView orderTimeTextView = holder.orderTimeTextView;

        final OrderVO vo = datas.get(position);

        tableNumberTextView.setText(vo.tableNumber);
        orderTextView.setText(vo.order);
        orderTypeButton.setText(vo.orderType);
        receiptTypeButton.setText(vo.receiptType);
        orderTimeTextView.setText(vo.orderTime);

        return convertView;
    }
}
