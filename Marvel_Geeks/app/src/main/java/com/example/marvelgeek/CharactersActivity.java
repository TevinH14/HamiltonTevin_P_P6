package com.example.marvelgeek;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;

import com.example.marvelgeek.fragment.FragmentCharacters;
import com.example.marvelgeek.fragment.FragmentHome;
import com.example.marvelgeek.models.Characters;
import com.example.marvelgeek.models.Marvel;
import com.example.marvelgeek.networkUtils.NetworkTask;

import java.util.ArrayList;

public class CharactersActivity extends AppCompatActivity implements NetworkTask.OnFinished{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_characters);
        int selection = -1;

        if(getIntent() != null) {
             selection = getIntent().getIntExtra(FragmentHome.EXTRA_SELECTION, -1);
        }

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fl_Characters, FragmentCharacters.newInstance(null))
                .commit();

        startTask(selection);
    }

    private void startTask(int url){
        NetworkTask task = new NetworkTask(this);
        task.execute(url);
    }

    @Override
    public void OnPost(ArrayList<Marvel> charactersArrayList) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fl_Characters, FragmentCharacters.newInstance(charactersArrayList))
                .commit();
    }
}
