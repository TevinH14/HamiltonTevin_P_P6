package com.example.marvelgeek.activates;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.marvelgeek.R;
import com.example.marvelgeek.fragment.FragmentEvents;
import com.example.marvelgeek.fragment.FragmentUtils;
import com.example.marvelgeek.models.Marvel;
import com.example.marvelgeek.networkUtils.NetworkBaseTask;

import java.util.ArrayList;

public class EventsActivity extends AppCompatActivity implements NetworkBaseTask.OnFinished {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
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
                .replace(R.id.fl_event, FragmentEvents.newInstance(marvelArrayList))
                .commit();
    }
}
