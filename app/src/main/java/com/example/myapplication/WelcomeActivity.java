package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class WelcomeActivity extends AppCompatActivity {

    public void gantigambar(View view){
        ImageView gambar1 = (ImageView) findViewById(R.id.imageViewLogo);
        ImageView gambar2 = (ImageView) findViewById(R.id.imageViewLogo2);

        gambar1.setImageResource(R.drawable.logouser1);
        gambar2.setImageResource(R.drawable.logouser1);
        gambar1.animate().alpha(0f).setDuration(500);

        //basic animation on java
        gambar2.animate()
                .translationXBy(1000f)
                .translationYBy(500f)
                .rotationBy(600)
                .setDuration(1500);
    }

    public void nextsamplesatu(View view){
        Intent intent = new Intent(WelcomeActivity.this, SampleSatu.class);
        startActivityForResult(intent,0);
    }

    public void nextsampledua(View view){
        Intent intent = new Intent(WelcomeActivity.this, SampleDua.class);
        startActivityForResult(intent,0);
    }

    Button buttonLogout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        //perintah untuk mengakhiri aplikasi
        buttonLogout = (Button) findViewById(R.id.buttonLogout);
        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Info","Berhasil Logout");
                Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
                startActivityForResult(intent,0);
            }
        });
    }
}