package com.example.studentapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.navigationBar);
        getSupportFragmentManager().beginTransaction().replace(R.id.main_container, new home_fragment()).commit();

        bottomNavigationView.setSelectedItemId(R.id.nav_home);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment fragment = null;

                switch (item.getItemId())
                {
                    case R.id.nav_home:
                        fragment = new home_fragment();
                        break;
                    case R.id.nav_cal:
                        fragment = new calender_fragment();
                        break;
                  //  case R.id.nav_profile:
                      //  fragment = new profile_fragment();
                     //   break;
                    case R.id.nav_club:
                        Toast.makeText(MainActivity.this, "enter", Toast.LENGTH_SHORT).show();
                        fragment=new club_fragment();
                        break;
//                    case R.id.nav_myclub:
//                        fragment=new myclub_fragment();
//                        break;

                }

                getSupportFragmentManager().beginTransaction().replace(R.id.main_container,fragment).commit();
                return true;
            }
        });
    }
}