package com.spokn.javikran.spokn;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Javi G on 2/15/2017.
 */

public class GameActivity extends AppCompatActivity {
    private Handler mHandler = new Handler();
    private int start_time=3;
    TextView cnt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        cnt = (TextView)findViewById(R.id.txt_countdown);
        countDown(start_time,cnt);
    }

    private void countDown(final int start_time, TextView txt){
        if (start_time==0){
            txt.setText("TRUMP HANDSHAKES");
            return;
        }
        txt.setText(Integer.toString(start_time));
        mHandler.postDelayed(new Runnable() {
            public void run() {
                countDown(start_time-1,cnt);
            }
        }, 1000);
    }


}
