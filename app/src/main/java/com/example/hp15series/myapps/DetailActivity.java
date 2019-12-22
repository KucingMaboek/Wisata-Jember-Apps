package com.example.hp15series.myapps;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {
    public static String title;
    public static String desc;
    public static String city;
    public static String pic;
    public static String maps;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);
        getSupportActionBar().setTitle("Detail");
        getIncomingIntent();
        Button butpic = findViewById(R.id.petabut);
        butpic.setOnClickListener(this);
    }

    private void getIncomingIntent() {
        title = getIntent().getStringExtra("Judul");
        desc = getIntent().getStringExtra("Deskripsi");
        city = getIntent().getStringExtra("Kota");
        pic = getIntent().getStringExtra("link");
        maps = getIntent().getStringExtra("Maps");
        SetContent(title, desc, city);
    }

    private void SetContent(String title, String desc, String city) {
        TextView judul = findViewById(R.id.judul);
        judul.setText(title);
        TextView deskripsi = findViewById(R.id.deskripsi);
        deskripsi.setText(desc);
        TextView kota = findViewById(R.id.kota);
        kota.setText(city);
        ImageView foto = findViewById(R.id.pic);
        Glide.with(this)
                .load(pic)
                .into(foto);
    }


    public void onClick(View v) {
        Uri uri = Uri.parse(maps);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
}
