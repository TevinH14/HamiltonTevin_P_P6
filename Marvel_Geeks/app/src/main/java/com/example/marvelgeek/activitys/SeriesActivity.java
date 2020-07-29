package com.example.marvelgeek.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.marvelgeek.R;
import com.example.marvelgeek.fragment.FragmentEvents;
import com.example.marvelgeek.fragment.FragmentHome;
import com.example.marvelgeek.fragment.FragmentSeries;
import com.example.marvelgeek.fragment.FragmentUtils;
import com.example.marvelgeek.models.Marvel;
import com.example.marvelgeek.networkUtils.NetworkBaseTask;

import java.util.ArrayList;

public class SeriesActivity extends AppCompatActivity implements NetworkBaseTask.OnFinished {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_series);

        int selection = -1;

        if(getIntent() != null) {
            selection = getIntent().getIntExtra(FragmentUtils.HOME_SELECTION, -1);
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
                .add(R.id.fl_series, FragmentSeries.newInstance(marvelArrayList))
                .commit();
    }
}
