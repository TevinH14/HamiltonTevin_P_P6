package com.example.marvelgeek;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.marvelgeek.fragment.FragmentHome;
import com.example.marvelgeek.fragment.FragmentSeries;
import com.example.marvelgeek.fragment.FragmentStories;
import com.example.marvelgeek.models.Marvel;
import com.example.marvelgeek.networkUtils.NetworkBaseTask;

import java.util.ArrayList;

public class StoriesActivity extends AppCompatActivity implements NetworkBaseTask.OnFinished {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stories);


        int selection = -1;

        if(getIntent() != null) {
            selection = getIntent().getIntExtra(FragmentHome.EXTRA_SELECTION, -1);
        }
        startTask(selection);
    }

    private void startTask(int taskNum){
        NetworkBaseTask task = new NetworkBaseTask(this);
        task.execute(taskNum);
    }

    @Override
    public void OnPost(ArrayList<Marvel> marvelArrayList) {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fl_stories, FragmentStories.newInstance(marvelArrayList))
                .commit();
    }
}
