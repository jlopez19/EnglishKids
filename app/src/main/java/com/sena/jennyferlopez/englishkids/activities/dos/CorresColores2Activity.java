package com.sena.jennyferlopez.englishkids.activities.dos;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.sena.jennyferlopez.englishkids.R;
import com.sena.jennyferlopez.englishkids.utils.Preference;

public class CorresColores2Activity extends AppCompatActivity implements View.OnClickListener {

    ImageView col_pink,  col_blue, col_green, col_orange, col_yellow,col_red, col_black, col_white, cambiar_img;
    String  userName, pantalla;
    TextView tv_puntos, tv_nombre, tv_pAcumulados;
    int puntos, puntosAcum, avatarSeleccionado;
    private SharedPreferences.Editor editor;
    private SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_corres_colores2);

        tv_puntos=(TextView) findViewById(R.id.tv_puntos);
        tv_pAcumulados=(TextView) findViewById(R.id.tv_puntosac);
        tv_nombre=(TextView) findViewById(R.id.tv_nombre);
        col_pink=(ImageView) findViewById(R.id.cor_pink);
        col_blue=(ImageView) findViewById(R.id.cor_blue);
        col_green=(ImageView) findViewById(R.id.cor_green);
        col_orange=(ImageView) findViewById(R.id.cor_orange);
        col_yellow=(ImageView) findViewById(R.id.cor_yellow);
        col_red=(ImageView) findViewById(R.id.cor_red);
        col_black=(ImageView) findViewById(R.id.cor_black);
        col_white=(ImageView) findViewById(R.id.cor_white);
        cambiar_img=(ImageView) findViewById(R.id.cambiarColor);

        col_pink.setOnClickListener(this);
        col_blue.setOnClickListener(this);
        col_green.setOnClickListener(this);
        col_orange.setOnClickListener(this);
        col_yellow.setOnClickListener(this);
        col_red.setOnClickListener(this);
        col_black.setOnClickListener(this);
        col_white.setOnClickListener(this);

        loadPreference();
    }

    private void loadPreference() {
        preferences = getSharedPreferences(Preference.PREFERENCE_NAME, Activity.MODE_PRIVATE);
        editor = preferences.edit();
        avatarSeleccionado = preferences.getInt(Preference.AVATAR_SEECCIONADO, 0);
        userName =preferences.getString(Preference.USER_NAME, "");
        puntosAcum =preferences.getInt(Preference.PUNTOSACUMULADOS, 0);
        puntos=preferences.getInt(Preference.PUNTOS,0);

        tv_puntos.setText(""+50);
        tv_nombre.setText(userName);
        tv_pAcumulados.setText(""+puntosAcum);

    }

    @Override
    public void onClick(View v) {
        int id=v.getId();
        if (id==R.id.cor_black){
            cambiar_img.setBackgroundResource(R.drawable.negro_pintado);
            Thread timerThread = new Thread(){
                public void run(){
                    try{
                        sleep(1200);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }finally{
                        Intent ir=new Intent(getApplicationContext(), CorresColores3Activity.class);
                        startActivity(ir);
                        finish();
                    }
                }
            };
            timerThread.start();
        }else {
            Toast.makeText(this, "intentalo de nuevo", Toast.LENGTH_SHORT).show();
        }
    }
}
