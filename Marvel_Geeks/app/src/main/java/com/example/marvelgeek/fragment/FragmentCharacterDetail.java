package com.example.marvelgeek.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.marvelgeek.R;
import com.example.marvelgeek.models.Characters;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class FragmentCharacterDetail extends Fragment implements View.OnClickListener {
    private static final String IMAGE_ENDPOINT = "/portrait_small.jpg";
    private static DatabaseReference mDatabase;

    private static Characters mCharacter;
    public static FragmentCharacterDetail newInstance(Characters selectedCharacter) {
        mCharacter = selectedCharacter;
        mDatabase = FirebaseDatabase.getInstance().getReference();
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

        tv_name.setText(mCharacter.getName());
        tv_description.setText(mCharacter.getDescription());
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
        String currentUser = FirebaseAuth.getInstance().getCurrentUser().getUid();
        mDatabase
                .child("users")
                .child(currentUser)
                .child("favorites")
                .child(mCharacter.getName())
                .setValue(mCharacter.getId());
    }
}
