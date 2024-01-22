package com.geeks.homework34;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.geeks.homework34.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    public static final String KEY_CONTINENT = "key1";
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new FirstFragment()).commit();
        }
    }
}