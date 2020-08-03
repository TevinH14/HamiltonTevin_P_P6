package com.example.marvelgeek.activates;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.marvelgeek.R;
import com.example.marvelgeek.fragment.FragmentEventDetail;
import com.example.marvelgeek.fragment.FragmentUtils;
import com.example.marvelgeek.models.Events;

public class EventDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_detail);
        Events selectedEvent = null;
        if(getIntent() != null){
            selectedEvent = (Events) getIntent().getSerializableExtra(FragmentUtils.EVENT_DETAIL);
        }
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fl_eventDetail, FragmentEventDetail.newInstance(selectedEvent))
                .commit();
    }
}
