package com.example.marvelgeek.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.marvelgeek.R;
import com.example.marvelgeek.fragment.FragmentCharacters;
import com.example.marvelgeek.fragment.FragmentHome;
import com.example.marvelgeek.fragment.FragmentUtils;
import com.example.marvelgeek.models.Characters;
import com.example.marvelgeek.models.Marvel;
import com.example.marvelgeek.networkUtils.NetworkBaseTask;

import java.util.ArrayList;

public class CharactersActivity extends AppCompatActivity implements NetworkBaseTask.OnFinished{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_characters);
        int selection = -1;

        if(getIntent() != null) {
             selection = getIntent().getIntExtra(FragmentUtils.HOME_SELECTION, -1);
        }

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fl_Characters, FragmentCharacters.newInstance(null))
                .commit();

        startTask(selection);
    }

    private void startTask(int taskNum){
        NetworkBaseTask task = new NetworkBaseTask(this);
        task.execute(taskNum);
    }

    @Override
    public void OnPost(ArrayList<Marvel> marvelArrayList) {
//        ArrayList<Characters> charactersArrayList = new ArrayList<>();
//        for(Marvel chara :marvelArrayList) {
//            if(chara instanceof Characters){
//                Characters c = (Characters)chara;
//                charactersArrayList.add(c);
//            }
//        }
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fl_Characters, FragmentCharacters.newInstance(marvelArrayList))
                .commit();
    }
}
