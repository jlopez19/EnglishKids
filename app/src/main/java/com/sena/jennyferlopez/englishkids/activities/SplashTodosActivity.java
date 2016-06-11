package com.sena.jennyferlopez.englishkids.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.sena.jennyferlopez.englishkids.R;
import com.sena.jennyferlopez.englishkids.activities.nivel1.SelectDias3Activity;

public class SplashTodosActivity extends AppCompatActivity {

    String msj;
    TextView men;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_todos);
men = (TextView) findViewById(R.id.tv_splash);
        msj=getIntent().getExtras().getString("mensaje");
        men.setText(msj);
        Thread timerThread = new Thread(){
            public void run(){
                try{
                    sleep(5000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally{
                    finish();
                }
            }
        };
        timerThread.start();
    }
}
