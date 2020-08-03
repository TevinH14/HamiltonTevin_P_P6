package com.example.marvelgeek.activates;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.marvelgeek.R;
import com.example.marvelgeek.fragment.FragmentHome;

import java.util.Objects;

public class HomeActivity extends AppCompatActivity {

    private static final int CONNECTIVITY_REQUEST = 0X0001;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fl_home, FragmentHome.newInstance())
                    .commit();

        Objects.requireNonNull(getSupportActionBar()).setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar_layout);
    }


}
