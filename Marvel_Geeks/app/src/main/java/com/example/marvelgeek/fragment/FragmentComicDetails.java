package com.example.marvelgeek.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.marvelgeek.R;
import com.example.marvelgeek.adapters.ComicExtraAdapter;
import com.example.marvelgeek.models.Comics;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.HashMap;

public class FragmentComicDetails extends Fragment implements View.OnClickListener{

    private static Comics mComics;
    public static FragmentComicDetails newInstance(Comics comics) {

        mComics = comics;
        Bundle args = new Bundle();

        FragmentComicDetails fragment = new FragmentComicDetails();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      return inflater.inflate(R.layout.fragment_comic_detail,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        View fragView = getView();
        if(fragView != null) {
            TextView tv_name = fragView.findViewById(R.id.tv_name_comicDetail);
            TextView tv_description = fragView.findViewById(R.id.tv_description_comicDetail);
            TextView tv_price = fragView.findViewById(R.id.tv_price);
            TextView tv_seriesName = fragView.findViewById(R.id.tv_seriesName_comicDetail);
            TextView tv_comicLink = fragView.findViewById(R.id.tv_link_comic);
            TextView tv_issueNum = fragView.findViewById(R.id.tv_issueNum);

            Button btn_fav = fragView.findViewById(R.id.btn_favorite_comicDetail);
            ImageView iv_character = fragView.findViewById(R.id.iv_comicImage_comicDetail);
            GridView gv_extra_display = fragView.findViewById(R.id.gv_comicRelated_display);

            tv_name.setText(mComics.getName());
            tv_comicLink.setText(mComics.getComicUrl());
            tv_seriesName.setText(mComics.getSeriesName());
            btn_fav.setOnClickListener(this);

            String issueNumString = String.valueOf(mComics.getIssueNum());

            tv_issueNum.setText(issueNumString);
            if(mComics.getDescription() != null) {
                tv_description.setText(mComics.getDescription());
            }
            else tv_description.setText(R.string.description_not_available);

            String priceString;
            priceString = String.valueOf(mComics.getPrice());
            if(!priceString.equals("")){
                tv_price.setText(priceString);
            }
            ComicExtraAdapter cea = new ComicExtraAdapter(
                    getContext()
                    ,mComics
                    ,setUpGridViewNames());

            gv_extra_display.setAdapter(cea);

            Picasso
                    .get()
                    .load(mComics.getImageUrl()+FragmentUtils.LARGE_IMAGE_ENDPOINT)
                    .resize(250,250)
                    .into(iv_character,new Callback() {
                        @Override
                        public void onSuccess() {
                        }
                        @Override
                        public void onError(Exception e) {
                            e.printStackTrace();
                        }
                    });


        }
    }

    @Override
    public void onClick(View v) {

    }

    private HashMap<String, Integer> setUpGridViewNames(){
        HashMap<String, Integer> availableExtras = new HashMap<>();
        if(mComics.getAvailableCharacters() > 0){
            availableExtras.put("Characters",R.drawable.iron_man);
        }
        if(mComics.getAvailableCreators() > 0){
            availableExtras.put("Creators",R.drawable.arthur_adams);
        }
        if(mComics.getAvailableStories() > 0){
            availableExtras.put("Stories",R.drawable.marvel_stories);
        }
        if(mComics.getAvailableEvents() > 0){
            availableExtras.put("Events",R.drawable.standard_incredible_event);
        }
        return availableExtras;
    }
}
