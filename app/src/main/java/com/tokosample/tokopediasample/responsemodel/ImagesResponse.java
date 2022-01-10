package com.tokosample.tokopediasample.responsemodel;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class ImagesResponse implements Serializable {
    @SerializedName("valid")
    public boolean valid;
    @SerializedName("images")
    public ArrayList<ImageModel> images;
}
