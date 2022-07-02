package com.example.studentapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity2 extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    FirebaseUser user;
    Bundle bundle =new Bundle();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //
      //  name=user.getDisplayName();
     //   bundle.putString("Club_name",name);
        //
        bottomNavigationView = findViewById(R.id.botttomNavigation);

      //
        bottomNavigationView.setSelectedItemId(R.id.home);
        Intent intent = getIntent();
        int  check = intent.getIntExtra("CALLED_FROM",0);
        String name = intent.getStringExtra("student");

        bundle.putString("Club_name",name);
        home Home=new home();
        Home.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.main_container,Home).commit();


        bottomNavigationView.setOnItemSelectedListener(item -> {

            Fragment fragment = null;

            switch (item.getItemId())
            {
                case R.id.home:
                    fragment = new home();
                    break;
                case R.id.members:
                    fragment = new fragment_mentor_board();
                    break;
                case R.id.events:
                    fragment = new fragment_event();
                    break;
                case R.id.services:
                    fragment = new fragment_service();
                    break;
                case R.id.more:
                  //  fragment = new fragment_more();
                    break;
            }

            assert fragment != null;
            fragment.setArguments(bundle);
            getSupportFragmentManager().beginTransaction().replace(R.id.main_container,fragment).commit();
            return true;
        });
    }
}