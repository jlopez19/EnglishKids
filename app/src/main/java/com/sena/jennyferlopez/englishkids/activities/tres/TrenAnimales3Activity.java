package com.sena.jennyferlopez.englishkids.activities.tres;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.sena.jennyferlopez.englishkids.R;
import com.sena.jennyferlopez.englishkids.utils.Preference;

public class TrenAnimales3Activity extends AppCompatActivity implements View.OnClickListener{

    ImageView reem_h, reem_o, reem_w, reem_c, cambiar_img;
    String  userName, pantalla;
    TextView tv_puntos, tv_nombre, tv_pAcumulados;
    int puntos, puntosAcum, avatarSeleccionado;
    int cont_intentos=0, cont_good=0, cont_fail=0, i =0, num;
    private SharedPreferences.Editor editor;
    private SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tren_animales3);
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
        if (id==R.id.img_o){
            cont_good = cont_good + 1;
            cont_intentos = cont_intentos + 1;
            cargarPuntos();
            cambiar_img.setBackgroundResource(R.drawable.tren_dogc);
            puntosAcum =preferences.getInt(Preference.PUNTOSACUMULADOS, 0);
            puntos=preferences.getInt(Preference.PUNTOS,0);

            if (puntos>=280){
                Thread timerThread = new Thread(){
                    public void run(){
                        try{
                            sleep(1200);
                        }catch(InterruptedException e){
                            e.printStackTrace();
                        }finally{
                            finish();
                        }
                    }
                };
                timerThread.start();
            }else {
                puntosAcum=puntosAcum-puntos;
                puntos=0;

                editor.putInt(Preference.PUNTOS, puntos);
                editor.putInt(Preference.PUNTOSACUMULADOS, puntosAcum);
                editor.commit();

            }
        }else {
            Toast.makeText(this, "intentalo de nuevo", Toast.LENGTH_SHORT).show();
            cont_fail=cont_fail+1;
            cont_intentos=cont_intentos+1;
        }
    }
    private void cargarPuntos() {
        if (cont_good==1 && cont_intentos ==1){
            int suma_puntos=puntos+30;
            int suma_puntosA=puntosAcum+30;
            editor.putInt(Preference.PUNTOS, suma_puntos);
            editor.putInt(Preference.PUNTOSACUMULADOS, suma_puntosA);
            editor.commit();
        }else if (cont_good==1 && (cont_intentos ==2)){
            int suma_puntos=puntos+15;
            int suma_puntosA=puntosAcum+15;
            editor.putInt(Preference.PUNTOS, suma_puntos);
            editor.putInt(Preference.PUNTOSACUMULADOS, suma_puntosA);
            editor.commit();
        }else if (cont_good==1 && (cont_intentos ==3)){
            int suma_puntos=puntos+10;
            int suma_puntosA=puntosAcum+10;
            editor.putInt(Preference.PUNTOS, suma_puntos);
            editor.putInt(Preference.PUNTOSACUMULADOS, suma_puntosA);
            editor.commit();
        }else if (cont_good<1 && cont_intentos >=4){
            int suma_puntos=puntos+0;
            int suma_puntosA=puntosAcum+0;
            editor.putInt(Preference.PUNTOS, suma_puntos);
            editor.putInt(Preference.PUNTOSACUMULADOS, suma_puntosA);
            editor.commit();
        }
    }
    }


