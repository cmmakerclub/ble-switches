package com.nat.ble.hm10.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;

import com.crashlytics.android.Crashlytics;
import com.nat.ble.hm10.R;

import io.fabric.sdk.android.Fabric;


public class Splash extends Activity {
    Handler handler;
    Runnable runnable;
    Long delay_time;
    Long time = 1000L;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Fabric.with(this, new Crashlytics());
        // Hide the Title bar of this activity screen
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_splash);

        handler = new Handler();

        runnable = new Runnable() {
            public void run() {
                Intent intent = new Intent(Splash.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        };
    }

    public void onResume() {
        super.onResume();
        delay_time = time;
        handler.postDelayed(runnable, delay_time);
        time = System.currentTimeMillis();
    }

    public void onStop() {
        super.onStop();
        handler.removeCallbacks(runnable);
        time = delay_time - (System.currentTimeMillis() - time);
    }
}
