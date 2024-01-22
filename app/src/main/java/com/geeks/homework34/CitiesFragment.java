package com.geeks.homework34;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.geeks.homework34.databinding.FragmentCitiesBinding;

import java.util.ArrayList;

public class CitiesFragment extends Fragment {

    private FragmentCitiesBinding binding;
    private ArrayList<String> cityList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCitiesBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Continent selectedContinent = (Continent) getArguments().getSerializable(MainActivity.KEY_CONTINENT);

        if (selectedContinent != null) {
            cityList = selectedContinent.getCities(); // Используйте правильный метод для получения списка городов
            initRecyclerView();

        }
    }

    private void initRecyclerView() {
        binding.rvCities.setLayoutManager(new LinearLayoutManager(requireContext()));
        CitiesAdapter citiesAdapter = new CitiesAdapter(cityList);
        binding.rvCities.setAdapter(citiesAdapter);
    }
}
