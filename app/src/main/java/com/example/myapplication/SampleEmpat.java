package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SampleEmpat extends AppCompatActivity {

    public void klikkembaliempat(View view){
        Intent intent = new Intent(SampleEmpat.this, MenuActivity.class);
        startActivityForResult(intent,0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_empat);
    }
}