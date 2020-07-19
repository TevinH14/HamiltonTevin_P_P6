package com.example.marvelgeek.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.marvelgeek.HomeActivity;
import com.example.marvelgeek.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class FragmentSignIn extends Fragment implements View.OnClickListener, OnCompleteListener {
    private String TAG = "MARVEL_GEEKS_TEST";
    private Context mContext;


    private FirebaseAuth mAuth;
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
        mAuth = FirebaseAuth.getInstance();
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
            TextInputEditText et_email = signInView.findViewById(R.id.et_email_signIn);
            TextInputEditText et_password = signInView.findViewById(R.id.et_password_signIn);

            String emailString = et_email.getText().toString();
            String passwordString = et_password.getText().toString();
            mAuth.signInWithEmailAndPassword(emailString,passwordString)
                    .addOnCompleteListener(this);

        }
    }

    @Override
    public void onComplete(@NonNull Task task) {
        if (task.isSuccessful()) {
            // Sign in success, update UI with the signed-in user's information
            Log.i(TAG, "Signin user With Email:success");
            FirebaseUser user = mAuth.getCurrentUser();
            Intent intent = new Intent (mContext, HomeActivity.class);
            startActivity(intent);
        } else {
            // If sign in fails, display a message to the user.
            Log.i(TAG, "SighInUserWithEmail:failure", task.getException());
            Toast.makeText(mContext, "Authentication failed.",
                    Toast.LENGTH_SHORT).show();

        }
    }
}
