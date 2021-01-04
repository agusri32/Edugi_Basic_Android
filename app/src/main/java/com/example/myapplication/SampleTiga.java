package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.Window;
import android.widget.SeekBar;
import android.widget.TextView;

public class SampleTiga extends AppCompatActivity {
    SeekBar timerSeekBar;
    TextView timerTextView;

    public void updateTimer(int secondLeft){
        int minutes = (int) secondLeft / 60;
        int seconds = secondLeft-minutes*60;

        String secondString = Integer.toString(seconds);
        if(secondString=="0"){
            secondString = "00";
        }

        timerTextView.setText(Integer.toString(minutes) + ":" + secondString);
    }

    public void controltimer(View view){
        new CountDownTimer(timerSeekBar.getProgress()*1000,1000){

            @Override
            public void onTick(long millisUntilFinished) {
                updateTimer((int)millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {

            }
        };
    }

    public void klikkembalimenu(View view){
        Intent intent = new Intent(SampleTiga.this, MenuActivity.class);
        startActivityForResult(intent,0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //menghilangkan action bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_tiga);

        timerSeekBar = (SeekBar) findViewById(R.id.timerSeekBar);
        timerTextView = (TextView) findViewById(R.id.timerTextView);

        timerSeekBar.setMax(600);
        timerSeekBar.setProgress(30);

        timerSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                updateTimer(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}