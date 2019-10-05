package com.example.libreriamusica;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Environment;
import android.os.IBinder;
import android.provider.Settings;
import android.widget.Toast;

import java.io.IOException;

public class Servicio extends Service {
    private MediaPlayer player;
    public Servicio() {

    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //TODO write your own code
        player = MediaPlayer.create(this, R.raw.musica2);
        //player.setLooping(true);
        // start the player
        player.start();
        Toast.makeText(this, "Service Started :) ", Toast.LENGTH_LONG).show();
        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // Stopping the player when service is destroyed
        player.stop();
        Toast.makeText(this, " :( Service Stopped!!!", Toast.LENGTH_LONG).show();
    }
}
