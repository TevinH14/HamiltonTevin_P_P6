package com.example.marvelgeek.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

public class FragmentSeries extends Fragment {
    public static FragmentSeries newInstance() {
        
        Bundle args = new Bundle();
        
        FragmentSeries fragment = new FragmentSeries();
        fragment.setArguments(args);
        return fragment;
    }
}
