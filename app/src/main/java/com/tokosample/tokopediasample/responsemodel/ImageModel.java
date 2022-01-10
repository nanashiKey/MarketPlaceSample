package com.tokosample.tokopediasample.responsemodel;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ImageModel implements Serializable {
    @SerializedName("imagename")
    public String imageName;

    @SerializedName("imageurl")
    public String imageUrl;
}
