package com.example.finaltesttravel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences prefs;
    private static final String PREFERENCES_NAME = "SAMPLE-SP";
    String username="tutku";
    String password="tut123";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.prefs = this.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
    }

    public void loginButtonPressed(View view) {
        SharedPreferences.Editor prefsEditor = this.prefs.edit();



        EditText etUsername = findViewById(R.id.etUsername);
        EditText etPassword = findViewById(R.id.etPassword);
        String name=etUsername.getText().toString();
        String pass=etPassword.getText().toString();

        //put SP
        prefsEditor.putString("name",name);
        prefsEditor.apply();

        if(pass.equals(password) && name.equals(username) ){
            Intent i = new Intent(this, AttractionsListActivity.class);
            startActivity(i);
        }
        else{
            Toast t=Toast.makeText(this,"Wrong Info",Toast.LENGTH_LONG);
            t.show();
        }



    }
}