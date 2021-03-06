package org.bom.india_hackaton.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.tbruyelle.rxpermissions.RxPermissions;

import org.bom.india_hackaton.App;
import org.bom.india_hackaton.R;

import rx.functions.Action1;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;

public class SplashActivity extends Activity {
    private static final int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //Required permission granting for Android >= 6.0
        RxPermissions.getInstance(SplashActivity.this)
                .request(android.Manifest.permission.READ_PHONE_STATE,
                        android.Manifest.permission.INTERNET,
                        android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .subscribe(new Action1<Boolean>() {
                    @Override
                    public void call(Boolean initialized) {
                        SplashActivity.this.initialize();
                    }
                });
    }

    private void initialize() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                App.getInstance().initializeClientContainer();
                Intent i = new Intent(SplashActivity.this, SelectLanguage.class);
                startActivity(i);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}
