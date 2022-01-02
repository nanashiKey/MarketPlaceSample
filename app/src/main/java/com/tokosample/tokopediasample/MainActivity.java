package com.tokosample.tokopediasample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private final Integer[] gambar = {
     R.drawable.banner1,
     R.drawable.banner2,
     R.drawable.banner3,
     R.drawable.banner4,
     R.drawable.banner5
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView rcView = findViewById(R.id.rcView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        rcView.setLayoutManager(layoutManager);
        BannerAdapter bannerAdapter = new BannerAdapter(this, gambar);
        rcView.setAdapter(bannerAdapter);
    }
}