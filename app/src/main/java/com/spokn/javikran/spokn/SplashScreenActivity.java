package com.spokn.javikran.spokn;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        startAnimations();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
                startActivity(intent);
                finish();

            }
        }, 1500);

    }

    private void startAnimations() {
        Animation anim;

        anim = AnimationUtils.loadAnimation(this, R.anim.translate_splash_in);
        anim.reset();
        ImageView iv = (ImageView) findViewById(R.id.splashlogo);
        iv.clearAnimation();
        iv.startAnimation(anim);

    }
}

