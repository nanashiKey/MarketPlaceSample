package com.tokosample.tokopediasample.helpers;

import com.tokosample.tokopediasample.responsemodel.banner.ImagesResponse;
import com.tokosample.tokopediasample.responsemodel.sampleproduct.SampleProductResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiServices {
    @GET("getimages")
    public Call<ImagesResponse> getImages();

    @GET("getproduct")
    public Call<SampleProductResponse> getProduct();
}
