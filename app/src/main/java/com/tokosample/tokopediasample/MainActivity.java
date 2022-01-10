package com.tokosample.tokopediasample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.tokosample.tokopediasample.helpers.ApiServices;
import com.tokosample.tokopediasample.helpers.Const;
import com.tokosample.tokopediasample.responsemodel.ImagesResponse;

import java.io.IOException;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private final Integer[] gambar = {
     R.drawable.banner1,
     R.drawable.banner2,
     R.drawable.banner3,
     R.drawable.banner4,
     R.drawable.banner5
    };
    BannerAdapter bannerAdapter;
    ArrayList<String> listUrl;
    RecyclerView rcView;
    ProgressBar probar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rcView = findViewById(R.id.rcView);
        probar= findViewById(R.id.progresBar);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        rcView.setLayoutManager(layoutManager);
        bannerAdapter = new BannerAdapter();
        listUrl = new ArrayList<>();
        loadImages();
    }

    private void loadImages(){
        Retrofit retro = new Retrofit.Builder()
                .baseUrl(Const.getUrl())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiServices apidata = retro.create(ApiServices.class);
        apidata.getImages().enqueue(new Callback<ImagesResponse>() {
            @Override
            public void onResponse(Call<ImagesResponse> call, Response<ImagesResponse> response) {
                if(response.isSuccessful()){
                    ImagesResponse imageResponse = response.body();
                    if(imageResponse != null){
                        for(int x = 0; x < imageResponse.images.size(); x++){
                            listUrl.add(imageResponse.images.get(x).imageUrl);
                        }
                        bannerAdapter = new BannerAdapter(MainActivity.this, listUrl);
                        rcView.setAdapter(bannerAdapter);
                        probar.setVisibility(View.GONE);
                    }else{
                        try {
                            Log.e("ERROR", response.errorBody().string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }else{
                    Log.e("ERROR", "Koneksi gagal");
                }
            }

            @Override
            public void onFailure(Call<ImagesResponse> call, Throwable t) {
                t.getLocalizedMessage();
            }
        });
    }
}