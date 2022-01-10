package com.tokosample.tokopediasample.responsemodel.sampleproduct;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class SampleProductModel implements Serializable {
    @SerializedName("namaItem")
    public String namaItem;

    @SerializedName("detailItem")
    public SampleDetailItem detailItem;

    public static class SampleDetailItem implements Serializable{
        @SerializedName("harga")
        public String harga;

        @SerializedName("lokasi")
        public String lokasi;

        @SerializedName("namaPenjual")
        public String namaPenjual;

        @SerializedName("gambar")
        public String gambar;
    }
}
