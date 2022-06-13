package com.example.studentapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity2 extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        bottomNavigationView = findViewById(R.id.botttomNavigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.main_container, new home()).commit();

        bottomNavigationView.setSelectedItemId(R.id.home);
        Intent intent = getIntent();
        int  check = intent.getIntExtra("CALLED_FROM",0);

        bottomNavigationView.setOnItemSelectedListener(item -> {

            Fragment fragment = null;

            switch (item.getItemId())
            {
                case R.id.home:
                    fragment = new home();
                    break;
                case R.id.members:
                    fragment = new fragments_members();
                    break;
                case R.id.events:
                    fragment = new fragment_event();
                    break;
                case R.id.services:
                  //  fragment = new fragment_service();
                    break;
                case R.id.more:
                  //  fragment = new fragment_more();
                    break;
            }

            assert fragment != null;
            getSupportFragmentManager().beginTransaction().replace(R.id.main_container,fragment).commit();
            return true;
        });
    }
}