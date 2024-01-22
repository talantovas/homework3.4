package com.geeks.homework34;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.geeks.homework34.databinding.FragmentFirstBinding;

import java.io.Serializable;
import java.util.ArrayList;

public class FirstFragment extends Fragment implements ContinentAdapter.OnItemClickListener {

    private FragmentFirstBinding binding;
    private ArrayList<Continent> continentList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentFirstBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadData();
        ContinentAdapter adapter = new ContinentAdapter(continentList, this);
        binding.rvContinents.setAdapter(adapter);
        createCitiesForContinents();

    }

    @Override
    public void onItemClick(int position) {
        // Обработка клика на континенте
        Continent selectedContinent = continentList.get(position);

        // Создаем фрагмент для отображения городов
        CitiesFragment citiesFragment = new CitiesFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(MainActivity.KEY_CONTINENT, (Serializable) selectedContinent);
        citiesFragment.setArguments(bundle);

        // Заменяем текущий фрагмент на фрагмент с городами
        requireActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, citiesFragment)
                .addToBackStack(null)
                .commit();
    }


    private void loadData() {
        continentList.add(new Continent("Asia", "https://upload.wikimedia.org/wikipedia/commons/thumb/8/80/Asia_%28orthographic_projection%29.svg/800px-Asia_%28orthographic_projection%29.svg.png"));
        continentList.add(new Continent("Europe", "https://upload.wikimedia.org/wikipedia/commons/thumb/4/44/Europe_orthographic_Caucasus_Urals_boundary_%28with_borders%29.svg/220px-Europe_orthographic_Caucasus_Urals_boundary_%28with_borders%29.svg.png"));
        continentList.add(new Continent("Africa", "https://upload.wikimedia.org/wikipedia/commons/thumb/8/86/Africa_%28orthographic_projection%29.svg/800px-Africa_%28orthographic_projection%29.svg.png"));
        continentList.add(new Continent("North America", "https://upload.wikimedia.org/wikipedia/commons/thumb/4/43/Location_North_America.svg/1200px-Location_North_America.svg.png"));
        continentList.add(new Continent("Australia", "https://upload.wikimedia.org/wikipedia/commons/thumb/d/da/Australia_with_AAT_%28orthographic_projection%29.svg/250px-Australia_with_AAT_%28orthographic_projection%29.svg.png"));
        continentList.add(new Continent("South America", "https://upload.wikimedia.org/wikipedia/commons/thumb/0/0f/South_America_%28orthographic_projection%29.svg/800px-South_America_%28orthographic_projection%29.svg.png"));
    }

    private void createCitiesForContinents() {
        for (Continent continent : continentList) {
            ArrayList<String> cities = new ArrayList<>();

            switch (continent.getName()) {
                case "Asia":
                    cities.add("Beijing");
                    cities.add("Tokyo");
                    cities.add("Seoul");
                    cities.add("Bishkek");
                    cities.add("Tashkent");
                    break;
                case "Europe":
                    cities.add("Paris");
                    cities.add("Berlin");
                    cities.add("Rome");
                    cities.add("Barcelona");
                    cities.add("Amsterdam");
                    break;
                case "Africa ":
                    cities.add("Lagos");
                    cities.add("Cairo");
                    cities.add("Luanda");
                    cities.add("Nairobi");
                    cities.add("Alexandria");
                    break;
                case "South America":
                    cities.add("Buenos Aires");
                    cities.add("Rio de Janeiro");
                    cities.add("Lima");
                    cities.add("Santiago");
                    cities.add("Bogota");
                    break;
                case "North America":
                    cities.add("New York");
                    cities.add("Toronto");
                    cities.add("Mexico");
                    cities.add("Los Angeles");
                    cities.add("Vancouver");
                    break;
                case "Australia":
                    cities.add("Sydney");
                    cities.add("Melbourne");
                    cities.add("Brisbane");
                    cities.add("Perth");
                    cities.add("Adelaide");
                    break;

            }

            continent.setCities(cities);
        }
    }
}
