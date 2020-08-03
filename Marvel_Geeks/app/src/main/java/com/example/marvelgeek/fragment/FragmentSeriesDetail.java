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
import com.example.marvelgeek.adapters.SeriesExtraAdapter;
import com.example.marvelgeek.models.Series;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.HashMap;

public class FragmentSeriesDetail extends Fragment {

    private static Series mSeries;
    public static FragmentSeriesDetail newInstance(Series selectedSeries) {

        mSeries = selectedSeries;

        Bundle args = new Bundle();

        FragmentSeriesDetail fragment = new FragmentSeriesDetail();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_series_detail,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        View fragView = getView();
        if(fragView != null){
            ImageView iv_seriesImage = fragView.findViewById(R.id.iv_seriesDetail);
            TextView tv_name = fragView.findViewById(R.id.tv_name_seriesDetail);
            TextView tv_startYear = fragView.findViewById(R.id.tv_startYear);
            TextView tv_endYear = fragView.findViewById(R.id.tv_endYear);
            TextView tv_seriesUrl = fragView.findViewById(R.id.tv_link_seriesDetail);
            TextView tv_rating = fragView.findViewById(R.id.tv_rating);
            TextView tv_eventType = fragView.findViewById(R.id.tv_eventType);
            GridView gv_series = fragView.findViewById(R.id.gv_seriesExtra_display);

            tv_name.setText(mSeries.getName());
            String startYear = String.valueOf(mSeries.getStartYear());
            tv_startYear.setText(startYear);
            String endYear = String.valueOf(mSeries.getEndYear());
            tv_endYear.setText(endYear);
            tv_seriesUrl.setText(mSeries.getMarvelLink());
            tv_rating.setText(mSeries.getRating());
            tv_eventType.setText(mSeries.getEventType());


            Picasso
                    .get()
                    .load(mSeries.getImageUrl()+FragmentUtils.LARGE_IMAGE_ENDPOINT)
                    .resize(250,250)
                    .into(iv_seriesImage,new Callback() {
                        @Override
                        public void onSuccess() {
                        }
                        @Override
                        public void onError(Exception e) {
                            e.printStackTrace();
                        }
                    });

            SeriesExtraAdapter ea = new SeriesExtraAdapter(getContext(),mSeries,setUpGridViewNames());
            gv_series.setAdapter(ea);
        }
    }

    private HashMap<String, Integer> setUpGridViewNames(){
        HashMap<String, Integer> availableExtras = new HashMap<>();
        if(mSeries.getAvailableCharacter() > 0){
            availableExtras.put("Characters",R.drawable.iron_man);
        }
        if(mSeries.getAvailableCreators() > 0){
            availableExtras.put("Creators",R.drawable.arthur_adams);
        }
        if(mSeries.getAvailableStories() > 0){
            availableExtras.put("Stories",R.drawable.marvel_stories);
        }
        if(mSeries.getAvailableComic() > 0){
            availableExtras.put("Comics",R.drawable.hulk_1_cover);
        }
        return availableExtras;
    }
}
