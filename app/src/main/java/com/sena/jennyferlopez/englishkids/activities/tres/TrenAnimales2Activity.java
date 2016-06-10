package com.sena.jennyferlopez.englishkids.activities.tres;

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

public class TrenAnimales2Activity extends AppCompatActivity implements View.OnClickListener {

    ImageView reem_h, reem_o, reem_w, reem_c, cambiar_img;
    String  userName, pantalla;
    TextView tv_puntos, tv_nombre, tv_pAcumulados;
    int puntos, puntosAcum, avatarSeleccionado;
    private SharedPreferences.Editor editor;
    private SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tren_animales2);
        tv_puntos=(TextView) findViewById(R.id.tv_puntos);
        tv_pAcumulados=(TextView) findViewById(R.id.tv_puntosac);
        tv_nombre=(TextView) findViewById(R.id.tv_nombre);
        reem_h=(ImageView) findViewById(R.id.img_h);
        reem_o=(ImageView) findViewById(R.id.img_o);
        reem_c=(ImageView) findViewById(R.id.img_c);
        reem_w=(ImageView) findViewById(R.id.img_w);
        cambiar_img=(ImageView) findViewById(R.id.img_tren);

        reem_h.setOnClickListener(this);
        reem_o.setOnClickListener(this);
        reem_c.setOnClickListener(this);
        reem_w.setOnClickListener(this);

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
        if (id==R.id.img_c){
            cambiar_img.setBackgroundResource(R.drawable.tren_catc);
            Thread timerThread = new Thread(){
                public void run(){
                    try{
                        sleep(1200);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }finally{
                         Intent ir=new Intent(getApplicationContext(), TrenAnimales3Activity.class);
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
