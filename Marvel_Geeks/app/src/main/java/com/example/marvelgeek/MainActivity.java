package com.example.marvelgeek;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.marvelgeek.fragment.FragmentMain;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Intent homeIntent = new Intent(this, HomeActivity.class);
            startActivity(homeIntent);
        }
        else{
            setContentView(R.layout.activity_main);
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fl_mainContainer, FragmentMain.newInstance())
                    .commit();

            getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
            getSupportActionBar().setCustomView(R.layout.action_bar_layout);

        }
    }
}
