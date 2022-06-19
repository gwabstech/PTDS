package com.gwabs.ptds.activities.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

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




        mainBinding.btnGetStarted.setOnClickListener(view1 -> {
            Toast.makeText(this, "you clicked me", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(this,Dashboard.class);
            startActivity(intent);
        });

    }
}