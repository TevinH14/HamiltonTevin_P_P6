package com.example.marvelgeek.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.marvelgeek.R;
import com.example.marvelgeek.fragment.FragmentComicDetails;
import com.example.marvelgeek.fragment.FragmentUtils;
import com.example.marvelgeek.models.Characters;
import com.example.marvelgeek.models.Comics;

public class ComicDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comic_detail);

        Comics selectedComic = null;
        if(getIntent() != null) {
            selectedComic = (Comics) getIntent().getSerializableExtra(FragmentUtils.COMIC_DETAILS);
        }

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fl_comicDetail_container, FragmentComicDetails.newInstance(selectedComic))
                .commit();
    }
}
