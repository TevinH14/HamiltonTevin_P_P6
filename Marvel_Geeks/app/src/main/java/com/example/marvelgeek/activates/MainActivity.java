package com.example.marvelgeek.activates;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.marvelgeek.R;
import com.example.marvelgeek.firebaseHelper.UserAuthenticationHelper;
import com.example.marvelgeek.fragment.FragmentMain;
public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //use auth helper class to check if user is signed in.
        if(UserAuthenticationHelper.checkUserStatus()){
            //send user to home screen is if user is signed in.
            Intent homeIntent = new Intent(this, HomeActivity.class);
            startActivity(homeIntent);
        }
        else{
            setContentView(R.layout.activity_main);
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fl_mainContainer, FragmentMain.newInstance())
                    .commit();
            //set app name in the middle of action bar
            if(getSupportActionBar() != null) {
                getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
                getSupportActionBar().setCustomView(R.layout.action_bar_layout);
            }
        }
    }
}
