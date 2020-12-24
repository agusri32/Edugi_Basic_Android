package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void loginFunction(View view){

        EditText myUsername = (EditText) findViewById(R.id.editTextUsername);
        EditText myPassword = (EditText) findViewById(R.id.editTextPassword);

        String cekUsername = myUsername.getText().toString();
        String cekPassword = myPassword.getText().toString();

        if(cekUsername.equals("kangagus") && cekPassword.equals("bismillah")) {
            //jika login berhasil
            Log.i("Info","Berhasil Login : "+cekUsername);
            Toast.makeText(getApplicationContext(), "LOGIN SUKSES", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(MainActivity.this, WelcomeActivity.class);
            MainActivity.this.startActivity(intent);
            finish();
        }else{
            //jika login gagal
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setMessage("Username atau Password Anda salah!").setNegativeButton("Retry", null).create().show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}