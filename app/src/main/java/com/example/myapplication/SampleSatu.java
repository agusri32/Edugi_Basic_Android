package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import java.util.ArrayList;

public class SampleSatu extends AppCompatActivity {

    public void klikkembalisatu(View view){
        Intent intent = new Intent(SampleSatu.this, WelcomeActivity.class);
        startActivityForResult(intent,0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_samplesatu);

        //implementasi multimedia video
        VideoView viewvideo = (VideoView) findViewById(R.id.videoView);
        viewvideo.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.myvideo);
        MediaController mcontroller = new MediaController(this);
        mcontroller.setAnchorView(viewvideo);
        viewvideo.setMediaController(mcontroller);
        viewvideo.seekTo(15000);
        //viewvideo.start();

        //implementasi list view
        ListView myListView = (ListView) findViewById(R.id.ListViewRukunIslam);
        ArrayList<String> rukunIslam = new ArrayList<String>();
        rukunIslam.add("1.Mengucapkan Syahadat");
        rukunIslam.add("2.Mendirikan Sholat");
        rukunIslam.add("3.Membayarkan Zakat");
        rukunIslam.add("4.Mengerjakan Puasa");
        rukunIslam.add("5.Haji Bagi yang Mampu");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,rukunIslam);
        myListView.setAdapter(arrayAdapter);
    }
}