package com.tokosample.tokopediasample.responsemodel.sampleproduct;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class SampleProductResponse implements Serializable {
    @SerializedName("valid")
    public boolean valid;

    @SerializedName("message")
    public String message;

    @SerializedName("data")
    public ArrayList<SampleProductModel> data;
}
