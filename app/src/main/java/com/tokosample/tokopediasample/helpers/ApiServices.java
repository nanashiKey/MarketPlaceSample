package com.tokosample.tokopediasample.helpers;

import com.tokosample.tokopediasample.responsemodel.ImagesResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiServices {
    @GET("getimages")
    public Call<ImagesResponse> getImages();
}
