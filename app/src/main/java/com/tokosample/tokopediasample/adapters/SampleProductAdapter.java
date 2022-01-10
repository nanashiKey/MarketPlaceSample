package com.tokosample.tokopediasample.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.tokosample.tokopediasample.R;
import com.tokosample.tokopediasample.responsemodel.sampleproduct.SampleProductModel;

import java.util.ArrayList;

public class SampleProductAdapter extends RecyclerView.Adapter<SampleProductAdapter.SampleProductViewHolder>{
    private Context ctx;
    private ArrayList<SampleProductModel> listProdutModel;

    public SampleProductAdapter(){}
    public SampleProductAdapter(Context ctx, ArrayList<SampleProductModel> listProdutModel){
        this.ctx = ctx;
        this.listProdutModel = listProdutModel;
    }

    @NonNull
    @Override
    public SampleProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(ctx).inflate(R.layout.item_sampleproduct, parent, false);
        return new SampleProductViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull SampleProductViewHolder holder, int position) {
        SampleProductModel product = listProdutModel.get(position);
        Glide.with(ctx)
                .load(product.detailItem.gambar)
                .error(android.R.drawable.ic_menu_gallery)
                .into(holder.imgView);

        holder.tvNamaProduct.setText(product.namaItem);
        holder.tvHargaProduct.setText(product.detailItem.harga);
        holder.tvLokasiProduct.setText(product.detailItem.lokasi);
        holder.tvPenjualProduct.setText(product.detailItem.namaPenjual);
        holder.llayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ctx, product.namaItem, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listProdutModel.size();
    }

    public static class SampleProductViewHolder extends RecyclerView.ViewHolder{
        TextView tvNamaProduct, tvHargaProduct, tvLokasiProduct, tvPenjualProduct;
        ImageView imgView;
        LinearLayout llayout;
        SampleProductViewHolder(View itemView){
            super(itemView);
            tvNamaProduct = itemView.findViewById(R.id.tvNamaProduct);
            tvHargaProduct = itemView.findViewById(R.id.tvHargaProduct);
            tvLokasiProduct = itemView.findViewById(R.id.tvLokasiProduct);
            tvPenjualProduct = itemView.findViewById(R.id.tvPenjualProduct);
            imgView = itemView.findViewById(R.id.imgView);
            llayout= itemView.findViewById(R.id.llayout);
        }
    }
}
