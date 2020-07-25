package com.example.marvelgeek.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

public class FragmentEvents extends Fragment {
    public static FragmentEvents newInstance() {

        Bundle args = new Bundle();

        FragmentEvents fragment = new FragmentEvents();
        fragment.setArguments(args);
        return fragment;
    }
}
