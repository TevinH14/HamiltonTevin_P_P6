package com.example.marvelgeek.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.marvelgeek.HomeActivity;
import com.example.marvelgeek.R;
import com.example.marvelgeek.SignUpActivity;
import com.example.marvelgeek.firebaseHelper.DatabaseHelper;
import com.example.marvelgeek.firebaseHelper.UserAuthenticationHelper;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

public class FragmentSignUp extends Fragment implements View.OnClickListener {
    private String TAG = "MARVEL_GEEKS_TEST";
    private Context mContext;
    private static FirebaseAuth mAuth;
    public FragmentSignUp() {
    }

    public static FragmentSignUp newInstance() {

        mAuth = FirebaseAuth.getInstance();
        Bundle args = new Bundle();

        FragmentSignUp fragment = new FragmentSignUp();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sign_up,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        View currentView = getView();

        mAuth = FirebaseAuth.getInstance();

        if(getContext() != null) {
            mContext = getContext();
        }

        if(currentView != null){
            currentView.findViewById(R.id.btn_signUp_final).setOnClickListener(this);
            currentView.findViewById(R.id.btn_cancel_signUp).setOnClickListener(this);

        }
    }

    @Override
    public void onClick(View v) {
        View signUpView = getView();
        if(signUpView != null) {
            if (v.getId() == R.id.btn_signUp_final) {
                String verifiedEmail="";
                String verifiedPassword="";
                boolean emailStatus = false;
                boolean passwordStatus = false;
                String fullName = "";

                //get editText reference
                TextInputEditText et_fName = signUpView.findViewById(R.id.et_FirstName);
                TextInputEditText et_lName = signUpView.findViewById(R.id.et_LastName);
                TextInputEditText et_email_one = signUpView.findViewById(R.id.et_email_one);
                TextInputEditText et_email_two = signUpView.findViewById(R.id.et_email_two);
                TextInputEditText et_password_one = signUpView.findViewById(R.id.et_password_one);
                TextInputEditText et_password_two =signUpView.findViewById(R.id.et_password_two);

                //get user input
                String fName = et_fName.getText().toString();
                String lName = et_lName.getText().toString();
                String email_one = et_email_one.getText().toString();
                String email_two = et_email_two.getText().toString();
                String pass_one = et_password_one.getText().toString();
                String pass_two = et_password_two.getText().toString();



                if(!fName.matches("") && !lName.matches("")){
                    fullName = fName +" "+lName;
                } else {
                    Toast.makeText(mContext, R.string.blank_name, Toast.LENGTH_SHORT).show();
                }

                if(!email_one.matches("") && !email_two.matches("")) {
                    verifiedEmail = UserAuthenticationHelper.verifyUserEmail(email_one,email_two);
                    if(verifiedEmail != null){
                        emailStatus = true;
                    }
                }
                else{
                    Toast.makeText(mContext, R.string.blank_email,Toast.LENGTH_SHORT).show();
                }

                if(!email_one.matches("") && !email_two.matches("")) {
                    verifiedPassword = UserAuthenticationHelper.verifyUserPassword(pass_one, pass_two);
                    if(verifiedPassword != null){
                        passwordStatus = true;
                    }
                }else {
                    Toast.makeText(mContext, R.string.blank_password, Toast.LENGTH_SHORT).show();
                }

                if(emailStatus && passwordStatus && !fullName.matches("")){
                    createNewUser(verifiedEmail,verifiedPassword,fullName);
                }
            }
        }
    }

    //create new user and save user data to data base.
    private void createNewUser(String email, String password,String fullName) {
        if (email != null && password != null) {
            UserAuthenticationHelper.createNewUser(email, password);
            if (UserAuthenticationHelper.checkUserStatus()) {
                DatabaseHelper.saveUserEmail(email);
                DatabaseHelper.saveUserName(fullName);

                Intent homeIntent = new Intent(mContext, HomeActivity.class);
                startActivity(homeIntent);
            }
        }
    }

}
