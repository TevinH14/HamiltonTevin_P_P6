package com.example.marvelgeek.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

public class FragmentStories extends Fragment {
    public static FragmentStories newInstance() {
        
        Bundle args = new Bundle();
        
        FragmentStories fragment = new FragmentStories();
        fragment.setArguments(args);
        return fragment;
    }
}
