package com.chachaup.kutravel.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.textViewSignUp)
    TextView mSignUpTextView;
    @BindView(R.id.editTextEmailLogin)
    EditText mEmail;
    @BindView(R.id.editTextPasswordLogin) EditText mPassword;
    @BindView(R.id.buttonLogin)
    Button mLogin;
    @BindView(R.id.progressBarLogin)
    ProgressBar mProgressBar;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        mSignUpTextView.setOnClickListener(this);
        mLogin.setOnClickListener(this);

        mAuth = FirebaseAuth.getInstance();

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null){
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    finish();
                }
            }
        };
    }

    @Override
    public void onClick(View v) {
        if (v == mSignUpTextView){
            Intent intent = new Intent(LoginActivity.this,CreateAccountActivity.class);
            startActivity(intent);
            Toast.makeText(getApplicationContext(),"Taking you to sign up",Toast.LENGTH_SHORT).show();
        }
        if (v == mLogin){
            loginWithPassword();
        }
    }

    private void loginWithPassword(){
        String email = mEmail.getText().toString().trim();
        String password = mPassword.getText().toString().trim();
        if (email.equals("")){
            mEmail.setError("Please enter your email address");
            return;
        }
        if (password.equals("")){
            mPassword.setError("Password must be at least six characters");
            return;
        }

        showProgressBar();

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        hideProgressBar();
                        if (task.isSuccessful()){
                            Toast.makeText(LoginActivity.this, "Authentication successful",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
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

    private void showProgressBar(){
        mProgressBar.setVisibility(View.VISIBLE);
        mPassword.setVisibility(View.GONE);
        mLogin.setVisibility(View.GONE);
        mEmail.setVisibility(View.GONE);
        mSignUpTextView.setVisibility(View.GONE);
    }

    private void hideProgressBar(){
        mProgressBar.setVisibility(View.GONE);
        mPassword.setVisibility(View.VISIBLE);
        mLogin.setVisibility(View.VISIBLE);
        mEmail.setVisibility(View.VISIBLE);
        mSignUpTextView.setVisibility(View.VISIBLE);
    }
}