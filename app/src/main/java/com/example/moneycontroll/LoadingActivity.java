package com.example.moneycontroll;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;

import java.util.concurrent.TimeUnit;

public class LoadingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        LoadingActivity currentLoadingActivity = this;
        new CountDownTimer(3000, 1000)
        {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(currentLoadingActivity, MainActivity.class);
                startActivity(intent);
            }

        }.start();

    }
}