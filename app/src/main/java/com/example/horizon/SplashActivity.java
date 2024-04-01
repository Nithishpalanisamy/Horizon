package com.example.horizon;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

@SuppressLint("CustomSplashScreen")
public class SplashActivity extends AppCompatActivity {
    private Handler handler=new Handler();
    private Runnable runnable;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitysplash);
        runnable = new Runnable() {
            @Override
            public void run() {
                Intent k = new Intent(SplashActivity.this,MainActivity.class);
                startActivity(k);
                finish();
            }
        };
        handler.postDelayed(runnable,3000);
    }
    @Override
    protected  void onDestroy(){
        super.onDestroy();
        handler.removeCallbacks(runnable);
    }
}
