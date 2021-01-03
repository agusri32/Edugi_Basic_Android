package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import java.util.ArrayList;

import static java.util.Arrays.asList;

public class SampleSatu extends AppCompatActivity {

    public void klikkembalimenu(View view){
        Intent intent = new Intent(SampleSatu.this, MenuActivity.class);
        startActivityForResult(intent,0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //menghilangkan action bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_satu);

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
        //final ArrayList<String> rukunIslam = new ArrayList<String>(asList("Syahadat","Sholat","Zakat","Puasa","Haji"));

        //Alternatif untuk pendeklarasian list array
        final ArrayList<String> rukunIslam = new ArrayList<String>();
        rukunIslam.add("1.Mengucapkan Syahadat");
        rukunIslam.add("2.Mendirikan Sholat");
        rukunIslam.add("3.Membayarkan Zakat");
        rukunIslam.add("4.Mengerjakan Puasa");
        rukunIslam.add("5.Haji Bagi yang Mampu");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,rukunIslam);
        myListView.setAdapter(arrayAdapter);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view,int position, long id){
                Log.i("Rukun Islam : ",rukunIslam.get(position));
                Toast.makeText(getApplicationContext(), "Rukun Islam : "+rukunIslam.get(position) , Toast.LENGTH_SHORT).show();
            }
        });
    }
}