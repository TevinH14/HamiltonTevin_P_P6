package com.example.marvelgeek.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
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
import com.example.marvelgeek.adapters.CharacterExtraAdapter;
import com.example.marvelgeek.firebaseHelper.DatabaseHelper;
import com.example.marvelgeek.models.Characters;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;

public class FragmentCharacterDetail extends Fragment implements View.OnClickListener {
    private static final String IMAGE_ENDPOINT = "/standard_xlarge.jpg";

    private static Characters mCharacter;
    public static FragmentCharacterDetail newInstance(Characters selectedCharacter) {
        mCharacter = selectedCharacter;
        Bundle args = new Bundle();

        FragmentCharacterDetail fragment = new FragmentCharacterDetail();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_character_detail,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        View fragView = getView();
        TextView tv_name = fragView.findViewById(R.id.tv_name_character);
        TextView tv_description = fragView.findViewById(R.id.tv_description_characterDetail);
        Button btn_fav = fragView.findViewById(R.id.btn_favorite);
        ImageView iv_character = fragView.findViewById(R.id.iv_characterImage_characterDetail);
        GridView gv_extra_display =fragView.findViewById(R.id.gv_characterRelated_display);

        TextView tv_extraLink1 = fragView.findViewById(R.id.tv_LinkOne_cDetail);
        tv_extraLink1.setOnClickListener(this);
        TextView tv_extraLink2 = fragView.findViewById(R.id.tv_LinkTwo_cDetail);
        tv_extraLink2.setOnClickListener(this);

        String[] typeArray = mCharacter.getLinkType();
        String[] urlArray = mCharacter.getLinkUrls();

        if(typeArray[0] != null && urlArray[0] != null){
            if(!typeArray[0].matches("") && !urlArray[0].matches("")){
                tv_extraLink1.setText(urlArray[0]);
            }
        }
        if(typeArray[1] != null && urlArray[1] != null){
            if(!typeArray[1].matches("") && !urlArray[1].matches("")){
                tv_extraLink2.setText(urlArray[1]);
            }
        }
        CharacterExtraAdapter cea = new CharacterExtraAdapter(getContext(),
                mCharacter,setUpGridViewNames());
        gv_extra_display.setAdapter(cea);

        tv_name.setText(mCharacter.getName());
        if(mCharacter.getDescription() != null || !mCharacter.getDescription().matches("")) {
            tv_description.setText(mCharacter.getDescription());
        }
        else tv_description.setText(R.string.description_not_available);
        btn_fav.setOnClickListener(this);
        Picasso
                .get()
                .load(mCharacter.getImageUrl()+IMAGE_ENDPOINT)
                .resize(200,200)
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

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_favorite) {
            DatabaseHelper.saveCharacter(mCharacter.getName(),mCharacter.getId());
        }else if (v.getId() == R.id.tv_LinkOne_cDetail){
            Intent browserIntent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse(mCharacter.getLinkUrls()[0]));
            startActivity(browserIntent);
        } else if(v.getId() == R.id.tv_LinkTwo_cDetail){
            Intent browserIntent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse(mCharacter.getLinkUrls()[1]));
            startActivity(browserIntent);
        }
    }

    private HashMap<String, Integer> setUpGridViewNames(){
        HashMap<String, Integer> availableExtras = new HashMap<>();
        if(mCharacter.getAvailableComics() > 0){
            availableExtras.put("Comics",R.drawable.hulk_1_cover);
        }
        if(mCharacter.getAvailableEvents() > 0){
            availableExtras.put("Events",R.drawable.standard_incredible_event);
        }
        if(mCharacter.getAvailableSeries() > 0){
            availableExtras.put("Series's",R.drawable.series);
        }
        if(mCharacter.getAvailableStories() > 0){
            availableExtras.put("Stories",R.drawable.marvel_stories);
        }
        return availableExtras;
    }
}
