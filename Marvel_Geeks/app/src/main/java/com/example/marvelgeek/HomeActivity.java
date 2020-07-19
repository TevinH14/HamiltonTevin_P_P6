package com.example.marvelgeek;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.marvelgeek.fragment.FragmentHome;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fl_home, FragmentHome.newInstance())
                .commit();
    }
}
