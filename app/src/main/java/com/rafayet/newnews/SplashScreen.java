package com.rafayet.newnews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class SplashScreen extends AppCompatActivity {

    private Timer timer;
    private ProgressBar progressBar;
    private int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screem);
        progressBar=(ProgressBar)findViewById(R.id.progressBar);
        progressBar.setProgress(0);

        final long period = 10;
        timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (i < 100){
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                        }
                    });
                    progressBar.setProgress(i);
                    i++;
                }else{
                    timer.cancel();
                    Intent intent =new Intent(SplashScreen.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        }, 0, period);
    }

}