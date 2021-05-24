package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class SampleTimer extends AppCompatActivity {
    SeekBar timerSeekBar;
    TextView timerTextView;
    Button timerButton;
    MediaPlayer mplayer;
    Boolean counterIsActive = false;
    CountDownTimer countDownTimer;

    public void resetTimer(){
        timerTextView.setText("0:30");
        timerSeekBar.setProgress(30);
        timerButton.setText("Go!");
        timerSeekBar.setEnabled(true);
        counterIsActive = false;
        countDownTimer.cancel();
        mplayer.stop();
    }

    public void updateTimer(int secondLeft){
        int minutes = (int) secondLeft / 60;
        int seconds = secondLeft-minutes*60;

        String secondString;
        if(seconds==0){
            secondString = "00";
        }else{
            secondString = Integer.toString(seconds);
        }

        timerTextView.setText(Integer.toString(minutes) + ":" + secondString);
    }

    public void controltimer(View view){

        if(counterIsActive==false) {

            counterIsActive = true;
            timerSeekBar.setEnabled(false);
            timerButton.setText("Stop");

            countDownTimer = new CountDownTimer(timerSeekBar.getProgress()*1000+100, 1000) {

                @Override
                public void onTick(long millisUntilFinished) {
                    updateTimer((int) millisUntilFinished/1000);
                }

                @Override
                public void onFinish() {
                    timerTextView.setText("0:00");
                    Log.i("finished", "timer done");

                    mplayer = MediaPlayer.create(getApplicationContext(), R.raw.adzan);
                    mplayer.start();
                }
            }.start();

        }else{
            resetTimer();
        }
    }

    public void klikkembalimenu(View view){
        Intent intent = new Intent(SampleTimer.this, MenuActivity.class);
        startActivityForResult(intent,0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //menghilangkan action bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_timer);

        timerSeekBar = (SeekBar) findViewById(R.id.timerSeekBar);
        timerTextView = (TextView) findViewById(R.id.timerTextView);
        timerButton = (Button) findViewById(R.id.timerButton);

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