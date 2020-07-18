package com.example.marvelgeek.fragment;

import android.content.Context;
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

import com.example.marvelgeek.R;
import com.example.marvelgeek.SignUpActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

public class FragmentSignUp extends Fragment implements View.OnClickListener, OnCompleteListener {
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

                TextInputEditText et_fName = signUpView.findViewById(R.id.et_FirstName);
                TextInputEditText et_lName = signUpView.findViewById(R.id.et_LastName);
                TextInputEditText et_email_one = signUpView.findViewById(R.id.et_email_one);
                TextInputEditText et_email_two = signUpView.findViewById(R.id.et_email_two);
                TextInputEditText et_password_one = signUpView.findViewById(R.id.et_password_one);
                TextInputEditText et_password_two =signUpView.findViewById(R.id.et_password_two);


                String email_one = et_email_one.getText().toString();
                String email_two = et_email_two.getText().toString();
                if(!email_one.matches("") && !email_two.matches("")) {
                    verifiedEmail = verifyUserEmail(email_one,email_two);
                }
                String pass_one = et_password_one.getText().toString();
                String pass_two = et_password_two.getText().toString();
                if(!email_one.matches("") && !email_two.matches("")) {
                    verifiedPassword = verifyUserPassword(pass_one, pass_two);
                }

                if(verifiedEmail != null && verifiedPassword != null){
                mAuth.createUserWithEmailAndPassword(verifiedEmail,verifiedPassword);
                }
            }
        }
    }

    @Override
    public void onComplete(@NonNull Task task) {
        if (task.isSuccessful()) {
            // Sign in success, update UI with the signed-in user's information
            Log.d(TAG, "createUserWithEmail:success");
            FirebaseUser user = mAuth.getCurrentUser();
        } else {
            // If sign in fails, display a message to the user.
            Log.w(TAG, "createUserWithEmail:failure", task.getException());
            Toast.makeText(mContext, "Authentication failed.",
                    Toast.LENGTH_SHORT).show();

        }
    }

    private String verifyUserEmail(String email_one,String email_two){
        ArrayList<String> userData = new ArrayList<>();
        boolean verifyEmailError = false;
        //check user email matches
        if(email_one.equals(email_two)){
            return email_two;
        }else{
            return null;
        }
    }
    private String verifyUserPassword(String password_one,String password_two){
        ArrayList<String> userData = new ArrayList<>();
        boolean verifyEmailError = false;
        //check user email matches
        if(password_one.equals(password_two)){
            return password_two;
        }else{
            return null;
        }
    }
}
