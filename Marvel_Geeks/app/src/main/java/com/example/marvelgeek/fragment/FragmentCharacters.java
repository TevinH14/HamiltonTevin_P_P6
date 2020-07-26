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

import com.example.marvelgeek.CharacterDetailActivity;
import com.example.marvelgeek.R;
import com.example.marvelgeek.adapters.DisplayAdapter;
import com.example.marvelgeek.models.Characters;
import com.example.marvelgeek.models.Marvel;

import java.util.ArrayList;

public class FragmentCharacters extends Fragment {
    private static ArrayList<Marvel> mCharacterList;

    public static final String EXTRA_SELECTION = "EXTRA_SELECTION";


    public static FragmentCharacters newInstance(ArrayList<Marvel> _charactersList) {
        mCharacterList = _charactersList;
        Bundle args = new Bundle();

        FragmentCharacters fragment = new FragmentCharacters();
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

            gv_character.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent detailIntent = new Intent(getContext(), CharacterDetailActivity.class);
                    detailIntent.putExtra(EXTRA_SELECTION,mCharacterList.get(position));
                    startActivity(detailIntent);
                }
            });
            DisplayAdapter ia = new DisplayAdapter(getContext(),mCharacterList);
            gv_character.setAdapter(ia);
        }
    }
}
