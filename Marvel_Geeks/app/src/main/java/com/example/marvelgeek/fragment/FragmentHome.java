package com.example.marvelgeek.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.marvelgeek.activitys.CharactersActivity;
import com.example.marvelgeek.activitys.ComicsActivity;
import com.example.marvelgeek.activitys.CreatorsActivity;
import com.example.marvelgeek.activitys.EventsActivity;
import com.example.marvelgeek.R;
import com.example.marvelgeek.activitys.SeriesActivity;
import com.example.marvelgeek.activitys.StoriesActivity;
import com.example.marvelgeek.adapters.HomeAdapter;

public class FragmentHome extends Fragment {

    public static FragmentHome newInstance() {

        Bundle args = new Bundle();

        FragmentHome fragment = new FragmentHome();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if(getView() != null && getContext() != null && getArguments() != null){
            GridView gvHome = getView().findViewById(R.id.gv_home_display);

            gvHome.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    activitySelection(position);
                }
            });

            HomeAdapter ia = new HomeAdapter(getContext());
            gvHome.setAdapter(ia);
        }
    }

    private void activitySelection(int pos){
        Intent selectionIntent;
        if(pos == 0){
            selectionIntent = new Intent(getContext(), CharactersActivity.class);
            selectionIntent.putExtra(FragmentUtils.HOME_SELECTION,0);
            startActivity(selectionIntent);
        }else if(pos == 1){
            selectionIntent = new Intent(getContext(), ComicsActivity.class);
            selectionIntent.putExtra(FragmentUtils.HOME_SELECTION,1);
            startActivity(selectionIntent);

        }else if(pos == 2){
            selectionIntent = new Intent(getContext(), CreatorsActivity.class);
            selectionIntent.putExtra(FragmentUtils.HOME_SELECTION,2);
            startActivity(selectionIntent);

        }else if(pos == 3){
            selectionIntent = new Intent(getContext(), EventsActivity.class);
            selectionIntent.putExtra(FragmentUtils.HOME_SELECTION,3);
            startActivity(selectionIntent);

        }else if(pos == 4){
            selectionIntent = new Intent(getContext(), SeriesActivity.class);
            selectionIntent.putExtra(FragmentUtils.HOME_SELECTION,4);
            startActivity(selectionIntent);

        }else if(pos == 5){
            selectionIntent = new Intent(getContext(), StoriesActivity.class);
            selectionIntent.putExtra(FragmentUtils.HOME_SELECTION,5);
            startActivity(selectionIntent);
        }
    }
}
