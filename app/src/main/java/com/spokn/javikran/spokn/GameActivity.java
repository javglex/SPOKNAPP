package com.spokn.javikran.spokn;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

/**
 * Created by Javi G on 2/15/2017.
 */

public class GameActivity extends AppCompatActivity {
    private Handler mHandler = new Handler();
    private final int cntTimer=3;       //count down timer before game starts
    private final int remTime=5;        //remaining time until next category shows up
    TextView cnt;
    Animation a;
    WatsonSpeechTT newSpeech;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        cnt = (TextView)findViewById(R.id.txt_countdown);

        a = AnimationUtils.loadAnimation(this, R.anim.zoom_in);
        a.reset();
        countDown(cntTimer,cnt);
        newSpeech=new WatsonSpeechTT();
        newSpeech.SetActivity(this);
        newSpeech.Init();
    }

    private void countDown(final int start_time, TextView txt){
        if (start_time==0){
            txt.setText("TRUMP HANDSHAKES");
            newSpeech.BeginSTT();
            timer(remTime);
            return;
        }
        txt.clearAnimation();
        txt.startAnimation(a);
        txt.setText(Integer.toString(start_time));
        mHandler.postDelayed(new Runnable() {
            public void run() {
                countDown(start_time-1,cnt);
            }
        }, 1000);
    }


    private void timer(final int start_time){
        if (start_time==0){
            newSpeech.BeginSTT();
            return;
        }
        mHandler.postDelayed(new Runnable() {
            public void run() {
                timer(start_time-1);
            }
        }, 1000);
    }


}
