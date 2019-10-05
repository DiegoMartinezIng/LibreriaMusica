package com.example.libreriamusica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.AssetManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public int posicionActual = 0;
    MediaPlayer player;
    MediaPlayer vector[] = new MediaPlayer[3];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vector[0] = MediaPlayer.create(this,R.raw.musica1);
        vector[1] = MediaPlayer.create(this,R.raw.musica2);
        vector[2] = MediaPlayer.create(this,R.raw.musica3);
    }
    public void encenderServicio(View view){
        vector[posicionActual].start();
    }
    public void apagarServicio(View view){
        vector[posicionActual].stop();
    }
    public void siguiente(View view){
        if (posicionActual==2){
            Toast.makeText(getApplicationContext(), "no hay cancion siguiente", Toast.LENGTH_LONG).show();
        }
        else {
            vector[posicionActual].stop();
            vector[0] = MediaPlayer.create(this,R.raw.musica1);
            vector[1] = MediaPlayer.create(this,R.raw.musica2);
            vector[2] = MediaPlayer.create(this,R.raw.musica3);
            posicionActual = posicionActual + 1;
            vector[posicionActual].start();
        }
    }
    public void anterior(View view){
        if (posicionActual<=0){
            Toast.makeText(getApplicationContext(), "no hay cancion anterior", Toast.LENGTH_SHORT).show();
        }
        else {
            vector[posicionActual].stop();
            vector[0] = MediaPlayer.create(this,R.raw.musica1);
            vector[1] = MediaPlayer.create(this,R.raw.musica2);
            vector[2] = MediaPlayer.create(this,R.raw.musica3);
            posicionActual = posicionActual - 1;
            vector[posicionActual].start();
        }
    }
}
