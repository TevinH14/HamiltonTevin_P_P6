package com.example.marvelgeek.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import com.example.marvelgeek.models.Characters;

import java.util.ArrayList;

public class FragmentComics extends Fragment {

    public static FragmentComics newInstance(ArrayList<Characters> _charactersList) {
        
        Bundle args = new Bundle();
        
        FragmentComics fragment = new FragmentComics();
        fragment.setArguments(args);
        return fragment;
    }
}
