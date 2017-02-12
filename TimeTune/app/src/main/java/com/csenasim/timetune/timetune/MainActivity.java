package com.csenasim.timetune.timetune;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void User_Login(View view){
        Intent intent=new Intent(MainActivity.this,Login.class);
        startActivity(intent);

    }
    public void Admin_Login(View view){
        Intent intent=new Intent(MainActivity.this,Admin_Login.class);
        startActivity(intent);
    }

    /*public void Admin_RegestrationActivity(View view){
        Intent intent=new Intent(MainActivity.this,Admin_RegestrationActivity.class);
        startActivity(intent);

    }*/

}
