package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    public void klikkembalimenu(View view){
        Intent intent = new Intent(MenuActivity.this, WelcomeActivity.class);
        startActivityForResult(intent,0);
    }

    public void nextsamplesatu(View view){
        Intent intent = new Intent(MenuActivity.this, SampleSatu.class);
        startActivityForResult(intent,0);
    }

    public void nextsampledua(View view){
        Intent intent = new Intent(MenuActivity.this, SampleDua.class);
        startActivityForResult(intent,0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }
}