package com.example.marvelgeek.activitys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;

import com.example.marvelgeek.R;
import com.example.marvelgeek.fragment.FragmentHome;

public class HomeActivity extends AppCompatActivity {

    private static final int CONNECTIVITY_REQUEST = 0X0001;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.INTERNET) == PackageManager.PERMISSION_GRANTED) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fl_home, FragmentHome.newInstance())
                    .commit();
        } else {
            ActivityCompat.requestPermissions(HomeActivity.this,
                    new String[]{Manifest.permission.INTERNET},
                    CONNECTIVITY_REQUEST);
        }
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar_layout);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == CONNECTIVITY_REQUEST){
        }
    }
}
