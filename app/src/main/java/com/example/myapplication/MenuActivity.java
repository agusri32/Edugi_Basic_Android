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
        Intent intent = new Intent(MenuActivity.this, SampleVideo.class);
        startActivityForResult(intent,0);
    }

    public void nextsample_dua(View view){
        Intent intent = new Intent(MenuActivity.this, SampleAudio.class);
        startActivityForResult(intent,0);
    }

    public void nextsample_tiga(View view){
        Intent intent = new Intent(MenuActivity.this, SampleTimer.class);
        startActivityForResult(intent,0);
    }

    public void nextsample_empat(View view){
        Intent intent = new Intent(MenuActivity.this, SampleMap.class);
        startActivityForResult(intent,0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //menghilangkan action bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }
}