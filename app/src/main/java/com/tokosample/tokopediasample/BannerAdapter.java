package com.tokosample.tokopediasample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class BannerAdapter extends RecyclerView.Adapter<BannerAdapter.BannerViewHolder> {
    Context ctx;
    Integer[] gambar;
    public BannerAdapter(){ }
    public BannerAdapter(Context ctx, Integer[] gambar){
        this.ctx = ctx;
        this.gambar = gambar;
    }
    @NonNull
    @Override
    public BannerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BannerViewHolder(LayoutInflater.from(ctx).inflate(R.layout.item_banner, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull BannerViewHolder holder, int position) {
        holder.imgBanner.setImageResource(gambar[position]);
        holder.cvBanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ctx, "item "+holder.getAdapterPosition(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return gambar.length;
    }

    public static class BannerViewHolder extends RecyclerView.ViewHolder{
        CardView cvBanner;
        ImageView imgBanner;
        BannerViewHolder(View itemView){
            super(itemView);
            cvBanner = itemView.findViewById(R.id.cvBanner);
            imgBanner = itemView.findViewById(R.id.imgBanner);
        }
    }
}
