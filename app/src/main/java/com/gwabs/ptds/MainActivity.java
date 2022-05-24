package com.gwabs.ptds;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.gwabs.ptds.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = mainBinding.getRoot();
        setContentView(view);

    }
}