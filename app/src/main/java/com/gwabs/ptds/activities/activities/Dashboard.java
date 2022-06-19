package com.gwabs.ptds.activities.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.gwabs.ptds.R;

public class Dashboard extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboad);

        /*

        NavHostFragment navHostFragment = (NavHostFragment) this.getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        assert navHostFragment != null;
        NavController navController = navHostFragment.getNavController();
        NavigationView navView = findViewById(R.id.nav_view);
        Toolbar toolbar = findViewById(R.id.toolbar);
        NavigationUI.setupWithNavController(navView, navController);
        DrawerLayout drawerLayout = findViewById(R.id.drawerLayout);
        setSupportActionBar(toolbar);

        assert navHostFragment != null;
        AppBarConfiguration appBarConfiguration =
                new AppBarConfiguration.Builder(navController.getGraph())
                        .setDrawerLayout(drawerLayout)
                        .build();

        NavigationUI.setupWithNavController(
                toolbar, navController, appBarConfiguration);



         */
    }


}