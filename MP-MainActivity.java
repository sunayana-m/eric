



package com.example.player;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int starttime = 0;
    int stoptime = 0;
    int forwardTime = 5000;
    int backwardTime = 5000;
    MediaPlayer mediaPlayer, mediaPlayerNew;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaPlayer = MediaPlayer.create(this,R.raw.song);
        mediaPlayerNew = MediaPlayer.create(this,R.raw.song);

        Button play = findViewById(R.id.btn1);
        Button pause = findViewById(R.id.btn2);
        Button forward = findViewById(R.id.btn3);
        Button rewind = findViewById(R.id.btn4);
        Button stop = findViewById(R.id.btn5);
        Button restart = findViewById(R.id.btn6);


        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Song Playing",Toast.LENGTH_LONG).show();
                mediaPlayer.start();
            }
        });

        pause.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Song Paused",Toast.LENGTH_LONG).show();
                mediaPlayer.pause();
            }
        });

        forward.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                int currentpos = mediaPlayer.getCurrentPosition() ;
                if((currentpos+forwardTime) <= (stoptime=mediaPlayer.getDuration())){
                    mediaPlayer.seekTo(currentpos+forwardTime);
                }
                Toast.makeText(getApplicationContext(),"Song forwarded",Toast.LENGTH_LONG).show();
            }
        });

        rewind.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                int currentpos = mediaPlayer.getCurrentPosition() ;
                if((currentpos-backwardTime) <= (starttime=mediaPlayer.getDuration())){
                    mediaPlayer.seekTo(currentpos-backwardTime);
                }
                Toast.makeText(getApplicationContext(),"Song rewinded",Toast.LENGTH_LONG).show();

            }
        });

        stop.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Song stopped",Toast.LENGTH_LONG).show();
                mediaPlayer.stop();
            }
        });

        restart.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Song restarted",Toast.LENGTH_LONG).show();
                mediaPlayer.seekTo(starttime);
            }
        });
    }
}
