package com.geeks.homework34;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import com.geeks.homework34.databinding.ItemContinentBinding;

import java.util.ArrayList;

public class ContinentAdapter extends RecyclerView.Adapter<ContinentAdapter.ViewHolder> {

    private ArrayList<Continent> continentList;
    private OnItemClickListener onItemClickListener;

    public ContinentAdapter(ArrayList<Continent> continentList, OnItemClickListener onItemClickListener) {
        this.continentList = continentList;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemContinentBinding binding = ItemContinentBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding, onItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(continentList.get(position));
    }

    @Override
    public int getItemCount() {
        return continentList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private ItemContinentBinding binding;

        public ViewHolder(@NonNull ItemContinentBinding binding, OnItemClickListener onItemClickListener) {
            super(binding.getRoot());
            this.binding = binding;

            itemView.setOnClickListener(v -> {
                if (onItemClickListener != null) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        onItemClickListener.onItemClick(position);
                    }
                }
            });
        }

        public void onBind(Continent continent) {
            // Устанавливаем название континента в TextView
            binding.continentName.setText(continent.getName());

            // Загружаем изображение в ImageView с использованием Glide
            Glide.with(binding.getRoot())
                    .load(continent.getImageUrl())
                    .into(binding.continentImage);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }
}


