package com.example.studentrecord;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.studentrecord.AboutUs.AboutUsFragment;
import com.example.studentrecord.AddStudent.AddStudentFragment;
import com.example.studentrecord.Home.HomeFragment;
import com.example.studentrecord.Model.Students;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    public static List<Students> stList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getSupportActionBar().hide();

        BottomNavigationView bottomNav = findViewById(R.id.nav_button);
        bottomNav.setOnNavigationItemSelectedListener(navListner);

        getSupportFragmentManager().beginTransaction().replace(R.id.navigation_container,
                new HomeFragment()).commit();


        stList = new ArrayList<>();
        stList.add(new Students("Lily gonjalish","Usa","Female",22,R.drawable.girl));
        stList.add(new Students("Nick Germain","Germany","Male",21,R.drawable.boy));


    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListner =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectFragment = null;
                    switch (item.getItemId()){

                        case R.id.navigation_home:
                            selectFragment = new HomeFragment();
                            break;
                        case R.id.navigation_add:
                            selectFragment = new AddStudentFragment();
                            break;
                        case R.id.navigation_about:
                            selectFragment = new AboutUsFragment();
                            break;

                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.navigation_container,
                            selectFragment).commit();
                    return true;
                }
            };
}
