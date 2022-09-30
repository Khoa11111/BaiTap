package com.google.baitap;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CayAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Cay> CayList;

    public CayAdapter(Context context, int layout, List<Cay> cayList) {
        this.context = context;
        this.layout = layout;
        this.CayList = cayList;
    }

    @Override
    public int getCount() {
        return CayList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        view = inflater.inflate(layout, null);

        TextView txtTen = (TextView) view.findViewById(R.id.textviewTen);
        TextView txtMoTa = (TextView) view.findViewById(R.id.textviewMoTa);
        ImageView imgHinh = (ImageView) view.findViewById(R.id.imageviewHinh);

        Cay cay = CayList.get(i);
        txtTen.setText(cay.getTen());
        txtMoTa.setText(cay.getMoTa());
        imgHinh.setImageResource(cay.getHinh());

        return view;
    }
}
