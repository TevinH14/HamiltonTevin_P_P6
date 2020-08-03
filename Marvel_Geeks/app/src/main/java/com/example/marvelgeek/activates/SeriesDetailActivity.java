package com.example.marvelgeek.activates;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.marvelgeek.R;
import com.example.marvelgeek.fragment.FragmentSeriesDetail;
import com.example.marvelgeek.fragment.FragmentUtils;
import com.example.marvelgeek.models.Series;

public class SeriesDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_series_detail);
        Series selectedSeries = null;
        if(getIntent() != null){
            selectedSeries = (Series) getIntent().getSerializableExtra(FragmentUtils.SERIES_DETAIL);
        }

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fl_seriesDetail_container, FragmentSeriesDetail.newInstance(selectedSeries))
                .commit();
    }
}
