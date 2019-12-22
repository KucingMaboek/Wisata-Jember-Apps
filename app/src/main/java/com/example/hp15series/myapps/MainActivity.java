package com.example.hp15series.myapps;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{
    private ArrayList<wisata> list = new ArrayList<>();
    private RecyclerView rvWisata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Wisata Jember");
        rvWisata = findViewById(R.id.rv_wisata);
        rvWisata.setHasFixedSize(true);
        list.addAll(datawisata.getListData());
        showRecyclerList();
    }

    private void showRecyclerList(){
        rvWisata.setLayoutManager(new LinearLayoutManager(this));
        RecycleViewAdapter recycleViewAdapter = new RecycleViewAdapter(list);
        rvWisata.setAdapter(recycleViewAdapter);
    }

//    @Override
    public void onClick(View v) {
        Intent moveIntent = new Intent(MainActivity.this, DetailActivity.class);
        startActivity(moveIntent);
    }
}