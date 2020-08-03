package com.example.marvelgeek.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.marvelgeek.R;
import com.example.marvelgeek.adapters.EventAdapter;
import com.example.marvelgeek.models.Events;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.HashMap;

public class FragmentEventDetail extends Fragment {

    private static Events mEvent;
    public static FragmentEventDetail newInstance(Events events) {

        mEvent = events;
        Bundle args = new Bundle();

        FragmentEventDetail fragment = new FragmentEventDetail();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_event_detail,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        View fragView = getView();
        if(fragView != null){
            ImageView iv_eventImage = fragView.findViewById(R.id.iv_eventDetail);
            TextView tv_name = fragView.findViewById(R.id.tv_eventName_ed);
            TextView tv_startDate = fragView.findViewById(R.id.tv_startDate_ed);
            TextView tv_endDate = fragView.findViewById(R.id.tv_endDate_ed);
            TextView tv_eventUrl = fragView.findViewById(R.id.tv_link_ed);
            GridView gv_event = fragView.findViewById(R.id.gv_extraInfo_eventDetail);

            tv_name.setText(mEvent.getName());
            tv_startDate.setText(mEvent.getStartDate());
            tv_endDate.setText(mEvent.getEndDate());
            tv_eventUrl.setText(mEvent.getMarvelUrl());

            Picasso
                    .get()
                    .load(mEvent.getImageUrl()+FragmentUtils.LARGE_IMAGE_ENDPOINT)
                    .resize(250,250)
                    .into(iv_eventImage,new Callback() {
                        @Override
                        public void onSuccess() {
                        }
                        @Override
                        public void onError(Exception e) {
                            e.printStackTrace();
                        }
                    });

            EventAdapter ea = new EventAdapter(getContext(),mEvent,setUpGridViewNames());
            gv_event.setAdapter(ea);
        }
    }
    private HashMap<String, Integer> setUpGridViewNames(){
        HashMap<String, Integer> availableExtras = new HashMap<>();
        if(mEvent.getAvailableCharacter() > 0){
            availableExtras.put("Characters",R.drawable.iron_man);
        }
        if(mEvent.getAvailableCreators() > 0){
            availableExtras.put("Creators",R.drawable.arthur_adams);
        }
        if(mEvent.getAvailableStories() > 0){
            availableExtras.put("Stories",R.drawable.marvel_stories);
        }
        if(mEvent.getAvailableComic() > 0){
            availableExtras.put("Comics",R.drawable.hulk_1_cover);
        }
        return availableExtras;
    }
}
