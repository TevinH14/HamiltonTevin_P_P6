package com.example.marvelgeek.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.marvelgeek.R;
import com.example.marvelgeek.adapters.DisplayAdapter;
import com.example.marvelgeek.models.Marvel;

import java.util.ArrayList;

public class FragmentEvents extends Fragment {
    public static final String EXTRA_SELECTION = "EXTRA_SELECTION";

    private static ArrayList<Marvel> mMarvelsList;
    public static FragmentEvents newInstance(ArrayList<Marvel> _marvelsList) {
        mMarvelsList = _marvelsList;
        Bundle args = new Bundle();

        FragmentEvents fragment = new FragmentEvents();
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

        if(getView() != null && getContext() != null && getArguments() != null){
            GridView gv_character = getView().findViewById(R.id.gv_display);

//            gv_character.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                @Override
//                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                    Intent detailIntent = new Intent(getContext(), CharacterDetailActivity.class);
//                    detailIntent.putExtra(EXTRA_SELECTION,mMarvelsList.get(position));
//                    startActivity(detailIntent);
//                }
//            });
            DisplayAdapter ia = new DisplayAdapter(getContext(),mMarvelsList);
            gv_character.setAdapter(ia);
        }
    }
}
