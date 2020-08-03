package com.example.marvelgeek.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.marvelgeek.R;
import com.example.marvelgeek.adapters.CreatorAdapter;
import com.example.marvelgeek.models.Creators;
import com.example.marvelgeek.models.Marvel;

import java.util.ArrayList;

public class FragmentCreators extends Fragment {
    private static ArrayList<Marvel> mMarvelList;
    private ArrayList<Creators> mCreatorsArrayList;

    public static FragmentCreators newInstance(ArrayList<Marvel> _list) {
        mMarvelList = _list;
        Bundle args = new Bundle();
        
        FragmentCreators fragment = new FragmentCreators();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_creator,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mCreatorsArrayList = new ArrayList<>();
        if(mMarvelList != null) {
            for (Marvel m : mMarvelList) {
                if (m instanceof Creators) {
                    Creators c = (Creators) m;
                    mCreatorsArrayList.add(c);
                }
            }
            if (getView() != null) {
                View fragView = getView();
                ListView lv_creator = fragView.findViewById(R.id.lv_creator_display);
                CreatorAdapter ca = new CreatorAdapter(mCreatorsArrayList, getContext());
                lv_creator.setAdapter(ca);
                lv_creator.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW,
                                Uri.parse(mCreatorsArrayList.get(position).getMarvelLink()));
                        startActivity(browserIntent);

                    }
                });
            }
        }
    }
}
