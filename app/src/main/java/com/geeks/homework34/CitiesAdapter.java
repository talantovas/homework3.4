package com.geeks.homework34;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.geeks.homework34.databinding.ItemCitiesBinding;

import java.util.ArrayList;

public class CitiesAdapter extends RecyclerView.Adapter<CitiesAdapter.ViewHolder> {

    private ArrayList<String> cityList;

    public CitiesAdapter(ArrayList<String> cityList) {
        this.cityList = cityList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ItemCitiesBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(cityList.get(position));
    }

    @Override
    public int getItemCount() {
        return cityList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ItemCitiesBinding binding;

        public ViewHolder(@NonNull ItemCitiesBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(String cityName) {
            binding.tvCityName.setText(cityName);
        }
    }
}
