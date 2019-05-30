package com.example.labwork3.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;

import com.example.labwork3.R;

public class Intro extends AppCompatActivity {

    static final String IsResumed = "is resumed";
    static final String IsOnBackPressed = "is on back pressed";

    private boolean isResumed = false;
    private volatile boolean isOnBackPressed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (!isResumed) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(2000);

                        if (!isOnBackPressed) {
                            Intent intent = new Intent(Intro.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.start();
            isResumed = true;
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putBoolean(IsResumed, isResumed);
        savedInstanceState.putBoolean(IsOnBackPressed, isOnBackPressed);
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        isResumed = savedInstanceState.getBoolean(IsResumed);
        isOnBackPressed = savedInstanceState.getBoolean(IsOnBackPressed);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        isOnBackPressed = true;
    }
}