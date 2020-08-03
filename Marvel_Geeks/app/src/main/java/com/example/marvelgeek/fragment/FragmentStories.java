package com.example.marvelgeek.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.marvelgeek.R;
import com.example.marvelgeek.adapters.DisplayAdapter;
import com.example.marvelgeek.adapters.StoriesAdapter;
import com.example.marvelgeek.models.Marvel;
import com.example.marvelgeek.models.Stories;

import java.util.ArrayList;

public class FragmentStories extends Fragment {
    private static ArrayList<Marvel> mMarvelList;

    public static FragmentStories newInstance(ArrayList<Marvel> _marvelList) {
        mMarvelList = _marvelList;
        Bundle args = new Bundle();

        FragmentStories fragment = new FragmentStories();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_display,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(getView() != null && getContext() != null && mMarvelList != null ){
            View fragView = getView();

            ListView lv_stories = fragView.findViewById(R.id.lv_stories);
            ArrayAdapter<String> aa = new ArrayAdapter<>(getContext(),android.R.layout.simple_list_item_1,getStoriesName());
            lv_stories.setAdapter(aa);

        }
    }

    private String[] getStoriesName(){
       String[] storiesName = new String[mMarvelList.size()];
        for (int i = 0; i < mMarvelList.size(); i++) {
            storiesName[i] = mMarvelList.get(i).getName();
        }
        return storiesName;
    }
}
