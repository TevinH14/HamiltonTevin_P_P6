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

import com.example.marvelgeek.CharactersActivity;
import com.example.marvelgeek.R;
import com.example.marvelgeek.adapters.HomeAdapter;
import com.squareup.picasso.Picasso;

public class FragmentHome extends Fragment {

  public static final String EXTRA_SELECTION = "EXTRA_SELECTION";

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
        if(pos == 0){
            Intent charactersIntent = new Intent(getContext(), CharactersActivity.class);
            charactersIntent.putExtra(EXTRA_SELECTION,0);
            startActivity(charactersIntent);
        }
    }
}
