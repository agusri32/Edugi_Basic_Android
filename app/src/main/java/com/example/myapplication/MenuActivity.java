package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class MenuActivity extends AppCompatActivity {

    public void klikkembalihome(View view){
        Intent intent = new Intent(MenuActivity.this, WelcomeActivity.class);
        startActivityForResult(intent,0);
    }

    public void nextsample_satu(View view){
        Intent intent = new Intent(MenuActivity.this, SampleSatu.class);
        startActivityForResult(intent,0);
    }

    public void nextsample_dua(View view){
        Intent intent = new Intent(MenuActivity.this, SampleDua.class);
        startActivityForResult(intent,0);
    }

    public void nextsample_tiga(View view){
        Intent intent = new Intent(MenuActivity.this, SampleTiga.class);
        startActivityForResult(intent,0);
    }

    public void nextsample_empat(View view){
        Intent intent = new Intent(MenuActivity.this, SampleEmpat.class);
        startActivityForResult(intent,0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //menghilangkan action bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_menu);
    }
}