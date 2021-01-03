package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

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

    public void tampilmenu(View view){
        Intent intent = new Intent(WelcomeActivity.this, MenuActivity.class);
        startActivityForResult(intent,0);
    }

    Button buttonLogout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //menghilangkan action bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        //perintah untuk mengakhiri aplikasi
        buttonLogout = (Button) findViewById(R.id.buttonLogout);
        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //jika logout berhasil
                Log.i("Info","Berhasil Logout");
                Toast.makeText(getApplicationContext(), "LOGOUT SUKSES", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
                startActivityForResult(intent,0);
            }
        });
    }
}