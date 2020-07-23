package com.example.marvelgeek;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.marvelgeek.fragment.FragmentCharacterDetail;
import com.example.marvelgeek.fragment.FragmentCharacters;
import com.example.marvelgeek.fragment.FragmentHome;
import com.example.marvelgeek.models.Characters;

public class CharacterDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_detail);
        Characters selectedCharacter = null;
        if(getIntent() != null) {
            selectedCharacter = (Characters) getIntent().getSerializableExtra(FragmentHome.EXTRA_SELECTION);
        }

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fl_characterDetail_container, FragmentCharacterDetail.newInstance(selectedCharacter))
                .commit();
    }
}
