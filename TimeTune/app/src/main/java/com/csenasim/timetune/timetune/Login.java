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

public class Login extends AppCompatActivity {

    private EditText username;
    private EditText etpassword;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username=(EditText)findViewById(R.id.etusername);
        etpassword=(EditText)findViewById(R.id.etpassword);

        firebaseAuth=FirebaseAuth.getInstance();


    }
    public void registation(View view){
        Intent intent=new Intent(Login.this,RegistrationActivity.class);
        startActivity(intent);
    }
    public void login(View view){
        final ProgressDialog progressDialog=ProgressDialog.show(Login.this,"Please Wait...","Processing...",true);

        (firebaseAuth.signInWithEmailAndPassword(username.getText().toString(),etpassword.getText().toString()))
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();

                        if(task.isSuccessful()){
                            Toast.makeText(Login.this,"Login Successful",Toast.LENGTH_LONG).show();
                            Intent i=new Intent(Login.this,UserProfile.class);
                            i.putExtra("Email",firebaseAuth.getCurrentUser().getEmail());
                            startActivity(i);
                        }
                        else{
                            Log.e("Error",task.getException().toString());

                            Toast.makeText(Login.this,task.getException().getMessage(),Toast.LENGTH_LONG).show();


                        }

                    }
                });

    }

}
