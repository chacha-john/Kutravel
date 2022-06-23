package com.chachaup.kutravel.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.chachaup.kutravel.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CreateAccountActivity extends AppCompatActivity implements View.OnClickListener{
    @BindView(R.id.textViewSignIn)
    TextView mSignInTextView;
    @BindView(R.id.editTextEmailSignup)
    EditText mEmail;
    @BindView(R.id.editTextNameSignup) EditText mName;
    @BindView(R.id.editTextPasswordSignup) EditText mPassword;
    @BindView(R.id.editTextConfirmPasswordSignup) EditText mConfirmPassword;
    @BindView(R.id.buttonSignup)
    Button mSignUp;
    @BindView(R.id.progressBarCreateAccount)
    ProgressBar mProgressBar;

    private FirebaseAuth.AuthStateListener mAuthListener;
    private FirebaseAuth mAuth;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        ButterKnife.bind(this);

        mSignInTextView.setOnClickListener(this);
        mSignUp.setOnClickListener(this);

        mAuth = FirebaseAuth.getInstance();
        createAuthStateListener();
    }

    @Override
    public void onClick(View v) {
        if (v == mSignInTextView){
            Intent intent = new Intent(CreateAccountActivity.this,LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            Toast.makeText(getApplicationContext(),"Taking you to sign in page", Toast.LENGTH_SHORT).show();
            finish();
        }
        if (v == mSignUp){
            createNewUser();
        }

    }

    private void createNewUser(){
        name = mName.getText().toString().trim();
        final String email = mEmail.getText().toString().trim();
        final String password = mPassword.getText().toString().trim();
        final String confirmPassword = mConfirmPassword.getText().toString().trim();

        boolean validEmail = isValidEmail(email);
        boolean validName = isValidName(name);
        boolean validPassword = isValidPassword(password, confirmPassword);

        if (!validEmail || !validName || !validPassword) return;

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        hideProgressBar();

                        if (task.isSuccessful()){
                            createFirebaseUserProfile(Objects.requireNonNull(task.getResult().getUser()));
                            Toast.makeText(CreateAccountActivity.this,"Account created successfully",Toast.LENGTH_SHORT).show();

                        } else {
                            Toast.makeText(CreateAccountActivity.this,"Authentication failed",Toast.LENGTH_SHORT).show();
                        }
                    }

                });
    }

    private void createAuthStateListener(){
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                final FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null){
                    Intent intent = new Intent(CreateAccountActivity.this, MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    finish();
                }
            }
        };
    }

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mAuthListener != null){
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

    private boolean isValidEmail(String email){
        boolean isGoodEmail = (email != null && Patterns.EMAIL_ADDRESS.matcher(email).matches());
        if (!isGoodEmail){
            mEmail.setError("Please enter a valid email address");
            return false;
        }
        return true;
    }
    private boolean isValidName(String name){
        if (name.equals("")){
            mName.setError("Please enter your name");
            return false;
        }
        return true;
    }
    private boolean isValidPassword(String password, String confirmPassword){
        if (password.length() < 6){
            mPassword.setError("Password must contain at least 6 characters");
            return false;
        } else if(!password.equals(confirmPassword)){
            mPassword.setError("Passwords do not match");
            mConfirmPassword.setError("Passwords do not match");
            return false;
        }
        return true;
    }
    private void showProgressBar(){
        mProgressBar.setVisibility(View.VISIBLE);
        mSignInTextView.setVisibility(View.GONE);
        mPassword.setVisibility(View.GONE);
        mConfirmPassword.setVisibility(View.GONE);
        mName.setVisibility(View.GONE);
        mEmail.setVisibility(View.GONE);
        mSignUp.setVisibility(View.GONE);
    }

    private void hideProgressBar(){
        mProgressBar.setVisibility(View.GONE);
        mSignInTextView.setVisibility(View.VISIBLE);
        mPassword.setVisibility(View.VISIBLE);
        mConfirmPassword.setVisibility(View.VISIBLE);
        mName.setVisibility(View.VISIBLE);
        mEmail.setVisibility(View.VISIBLE);
        mSignUp.setVisibility(View.VISIBLE);
    }

    private void createFirebaseUserProfile(final FirebaseUser user){
        UserProfileChangeRequest addName = new UserProfileChangeRequest.Builder()
                .setDisplayName(name)
                .build();

        user.updateProfile(addName);
    }
}