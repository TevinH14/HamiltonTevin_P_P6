package com.example.marvelgeek.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.marvelgeek.activates.HomeActivity;
import com.example.marvelgeek.R;
import com.example.marvelgeek.activates.SignInActivity;
import com.example.marvelgeek.activates.SignUpActivity;
import com.google.firebase.auth.FirebaseAuth;

public class FragmentMain extends Fragment implements View.OnClickListener{
    private FirebaseAuth mAuth;

    public static FragmentMain newInstance() {
        return new FragmentMain();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        View currentView = getView();
        if(currentView != null) {
            currentView.findViewById(R.id.btn_signUp_main).setOnClickListener(this);
            currentView.findViewById(R.id.btn_signIn_main).setOnClickListener(this);
            currentView.findViewById(R.id.btn_skip_main).setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        Intent userChoiceIntent = null;
        if(v.getId() == R.id.btn_signUp_main){
            userChoiceIntent= new Intent(getContext(),SignUpActivity.class);
        }else if(v.getId() == R.id.btn_signIn_main){
            userChoiceIntent = new Intent(getContext(), SignInActivity.class);
        }else if(v.getId() ==R.id.btn_skip_main){
            userChoiceIntent = new Intent(getContext(), HomeActivity.class);
        }
        startActivity(userChoiceIntent);
    }
}
