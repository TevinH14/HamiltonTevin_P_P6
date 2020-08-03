package com.example.marvelgeek.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.marvelgeek.activates.HomeActivity;
import com.example.marvelgeek.R;
import com.example.marvelgeek.firebaseHelper.UserAuthenticationHelper;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class FragmentSignIn extends Fragment implements View.OnClickListener {
    private String TAG = "MARVEL_GEEKS_TEST";
    private Context mContext;

    public FragmentSignIn() {
    }

    public static FragmentSignIn newInstance() {

        Bundle args = new Bundle();

        FragmentSignIn fragment = new FragmentSignIn();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sign_in,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        View signInView = getView();
        if(signInView != null) {
            signInView.findViewById(R.id.btn_signin_SignIn).setOnClickListener(this);
        }
        if(getContext() != null) {
            mContext = getContext();
        }
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_signin_SignIn){
            View signInView = getView();
            if(signInView != null) {
                TextInputEditText et_email = Objects.requireNonNull(signInView).findViewById(R.id.et_email_signIn);
                TextInputEditText et_password = signInView.findViewById(R.id.et_password_signIn);

                String emailString = Objects.requireNonNull(Objects.requireNonNull(et_email.getText())).toString();
                String passwordString = Objects.requireNonNull(Objects.requireNonNull(et_password.getText())).toString();

                boolean userStatus = UserAuthenticationHelper.signInUser(emailString, passwordString);
                if (userStatus) {
                    Intent intent = new Intent(mContext, HomeActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(mContext, R.string.incorrect_email_or_password,
                            Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
