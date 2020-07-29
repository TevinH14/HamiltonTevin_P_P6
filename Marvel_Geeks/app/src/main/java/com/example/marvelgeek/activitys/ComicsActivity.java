package com.example.marvelgeek.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.marvelgeek.R;
import com.example.marvelgeek.fragment.FragmentCharacters;
import com.example.marvelgeek.fragment.FragmentComics;
import com.example.marvelgeek.fragment.FragmentHome;
import com.example.marvelgeek.fragment.FragmentUtils;
import com.example.marvelgeek.models.Comics;
import com.example.marvelgeek.models.Marvel;
import com.example.marvelgeek.networkUtils.NetworkBaseTask;

import java.util.ArrayList;

public class ComicsActivity extends AppCompatActivity implements NetworkBaseTask.OnFinished {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comics);
        int selection = -1;

        if(getIntent() != null) {
            selection = getIntent().getIntExtra(FragmentUtils.HOME_SELECTION, -1);
        }

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fl_comic_container, FragmentComics.newInstance(null))
                .commit();

        startTask(selection);
    }
    private void startTask(int taskNum){
        NetworkBaseTask task = new NetworkBaseTask(this);
        task.execute(taskNum);
    }


    @Override
    public void OnPost(ArrayList<Marvel> marvelArrayList) {
//        ArrayList<Comics> comicsArrayList = new ArrayList<>();
//        for(Marvel m:marvelArrayList){
//            if(m instanceof Comics){
//                Comics c = (Comics)m;
//                comicsArrayList.add(c);
//            }
//        }
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fl_comic_container, FragmentComics.newInstance(marvelArrayList))
                .commit();
    }
}
