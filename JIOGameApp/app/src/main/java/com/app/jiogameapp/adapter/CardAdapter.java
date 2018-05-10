package com.app.jiogameapp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.app.jiogameapp.R;
import com.bumptech.glide.Glide;




public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {

    int arr_img[];

    public CardAdapter(int arr_img[]) {
        this.arr_img = arr_img;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.item_card_game, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.image.setBackgroundResource(0);
        Glide.with(holder.itemView.getContext())
                .load(arr_img[position])
                .into(holder.image);

    }

    @Override
    public int getItemCount() {
        return arr_img.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.image);
        }
    }
}
