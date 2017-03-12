package com.fithubtechnologies.cover;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText mEmail;
    private EditText mPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();

        mEmail = (EditText)findViewById(R.id.editText_email);
        mPassword = (EditText)findViewById(R.id.editText_password);
    }

    public void handleLogin(View view){
        String email = null, password = null;

        if (mEmail.getText().toString() != ""){
            email = mEmail.getText().toString();
        }
        if (mPassword.getText().toString() != ""){
            password = mPassword.getText().toString();
        }
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                finish();
            }
        });

    }
}
