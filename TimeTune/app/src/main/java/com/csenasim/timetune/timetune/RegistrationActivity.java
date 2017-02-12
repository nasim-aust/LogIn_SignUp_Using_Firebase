package com.csenasim.timetune.timetune;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegistrationActivity extends AppCompatActivity {

    private EditText username;
    private EditText etpassword;
    private FirebaseAuth firebaseauth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        username=(EditText)findViewById(R.id.etusername);
        etpassword=(EditText)findViewById(R.id.etpassword);

        firebaseauth=FirebaseAuth.getInstance();

    }

    public void register(View view) {
        final ProgressDialog progressDialog = ProgressDialog.show(RegistrationActivity.this, "Please Wait...", "Processing...", true);
        (firebaseauth.createUserWithEmailAndPassword(username.getText().toString(), etpassword.getText().toString())).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                                                                                                                                @Override
                                                                                                                                                public void onComplete(@NonNull Task<AuthResult> task) {
                                                                                                                                                    progressDialog.dismiss();

                                                                                                                                                    if (task.isSuccessful()) {
                                                                                                                                                        Toast.makeText(RegistrationActivity.this, "Registration Successful", Toast.LENGTH_LONG).show();
                                                                                                                                                        Intent i = new Intent(RegistrationActivity.this, Login.class);
                                                                                                                                                        startActivity(i);
                                                                                                                                                    } else {
                                                                                                                                                        Log.e("Error", task.getException().toString());

                                                                                                                                                        Toast.makeText(RegistrationActivity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();

                                                                                                                                                    }

                                                                                                                                                }
                                                                                                                                            }
        );
    }
}
