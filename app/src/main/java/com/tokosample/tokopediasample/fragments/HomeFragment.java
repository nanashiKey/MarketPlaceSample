package com.tokosample.tokopediasample.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tokosample.tokopediasample.MainActivity;
import com.tokosample.tokopediasample.R;
import com.tokosample.tokopediasample.adapters.BannerAdapter;
import com.tokosample.tokopediasample.adapters.SampleProductAdapter;
import com.tokosample.tokopediasample.helpers.ApiServices;
import com.tokosample.tokopediasample.helpers.Const;
import com.tokosample.tokopediasample.responsemodel.banner.ImagesResponse;
import com.tokosample.tokopediasample.responsemodel.sampleproduct.SampleProductResponse;

import java.io.IOException;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeFragment extends Fragment {

    BannerAdapter bannerAdapter;
    SampleProductAdapter sampleProductAdapter;
    ArrayList<String> listUrl;
    RecyclerView rcView, rcView2;
    ProgressBar probar;
    Retrofit retro;
    ApiServices apidata;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        rcView = v.findViewById(R.id.rcView);
        rcView2 = v.findViewById(R.id.rcView2);
        probar = v.findViewById(R.id.progresBar);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false);
        rcView.setLayoutManager(layoutManager);
        rcView2.setLayoutManager(layoutManager2);
        bannerAdapter = new BannerAdapter();
        sampleProductAdapter = new SampleProductAdapter();
        listUrl = new ArrayList<>();
        retro = new Retrofit.Builder()
                .baseUrl(Const.getUrl())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apidata = retro.create(ApiServices.class);
        loadSampleProduct();
        loadImages();
    }

    private void loadSampleProduct() {
        apidata.getProduct().enqueue(new Callback<SampleProductResponse>() {
            @Override
            public void onResponse(Call<SampleProductResponse> call, Response<SampleProductResponse> response) {
                if(response.isSuccessful()){
                    SampleProductResponse data = response.body();
                    if(data != null){
                        sampleProductAdapter = new SampleProductAdapter(requireContext(), data.data);
                        rcView2.setAdapter(sampleProductAdapter);
                    }

                }else{
                    Log.e("ERROR", "Koneksi gagal");
                }
            }

            @Override
            public void onFailure(Call<SampleProductResponse> call, Throwable t) {
                t.getLocalizedMessage();
            }
        });
    }

    private void loadImages(){
        apidata.getImages().enqueue(new Callback<ImagesResponse>() {
            @Override
            public void onResponse(Call<ImagesResponse> call, Response<ImagesResponse> response) {
                if(response.isSuccessful()){
                    ImagesResponse imageResponse = response.body();
                    if(imageResponse != null){
                        for(int x = 0; x < imageResponse.images.size(); x++){
                            listUrl.add(imageResponse.images.get(x).imageUrl);
                        }
                        bannerAdapter = new BannerAdapter(requireContext(), listUrl);
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
