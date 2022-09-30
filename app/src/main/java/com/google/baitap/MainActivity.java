package com.google.baitap;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvCay;
    ArrayList<Cay> arrayCay;
    CayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvCay = (ListView) findViewById(R.id.listView);
        arrayCay = new ArrayList<>();

        arrayCay.add(new Cay("Cây Đa","đẹp", R.drawable.da));
        arrayCay.add(new Cay("Cây Dừa","đẹp", R.drawable.dua));
        arrayCay.add(new Cay("Cây Si","đẹp", R.drawable.si));

        adapter = new CayAdapter(MainActivity.this, R.layout.list, arrayCay);

        lvCay.setAdapter(adapter);

        lvCay.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                XacNhanXoa(i);
                return false;
            }
        });
    }

    public void XacNhanXoa(int position){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("Thông Báo!");
        alertDialog.setMessage("Bạn có muốn xóa cây này?");

        alertDialog.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                arrayCay.remove(position);
                adapter.notifyDataSetChanged();
            }
        });

        alertDialog.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        alertDialog.show();
    }
}