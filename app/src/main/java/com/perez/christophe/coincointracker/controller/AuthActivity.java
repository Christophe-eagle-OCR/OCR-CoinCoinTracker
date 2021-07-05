package com.perez.christophe.coincointracker.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.perez.christophe.coincointracker.R;

public class AuthActivity extends AppCompatActivity {

    // cette activity permet d'authentifier un utilisateur

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
    }


    /*
    methode qui permet d'authentifier un utiliateur
    pour info : token = jeton
     */
    public String getUserToken() {
        SharedPreferences prefs = getSharedPreferences("UserToken", MODE_PRIVATE);

        // A lot of things done in the methode ...

        return "IncredibleToken";
    }


}