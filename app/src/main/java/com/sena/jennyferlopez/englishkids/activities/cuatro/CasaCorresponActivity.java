package com.sena.jennyferlopez.englishkids.activities.cuatro;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.sena.jennyferlopez.englishkids.R;
import com.sena.jennyferlopez.englishkids.activities.nivel1.SelectDias3Activity;
import com.sena.jennyferlopez.englishkids.utils.Preference;

public class CasaCorresponActivity extends AppCompatActivity implements View.OnClickListener{
    ImageView txt_completar, img_uno, img_tres, img_cinco, img_siete;
    int cont_intentos=0, cont_good=0, cont_fail=0, i =0, num;
    String  userName, pantalla;
    TextView tv_puntos, tv_nombre, tv_pAcumulados;
    int puntos, puntosAcum, avatarSeleccionado;
    private SharedPreferences.Editor editor;
    private SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_casa_correspon);
        tv_puntos = (TextView) findViewById(R.id.tv_puntos);
        tv_nombre = (TextView) findViewById(R.id.tv_nombre);
        tv_pAcumulados = (TextView) findViewById(R.id.tv_puntosac);

        txt_completar= (ImageView) findViewById(R.id.txt_completar);
        img_uno= (ImageView) findViewById(R.id.uno);
        img_tres= (ImageView) findViewById(R.id.tres);
        img_cinco= (ImageView) findViewById(R.id.cinco);
        img_siete= (ImageView) findViewById(R.id.siete);

        img_uno.setOnClickListener(this);
        img_tres.setOnClickListener(this);
        img_cinco.setOnClickListener(this);
        img_siete.setOnClickListener(this);


        loadPreference();
    }

    private void loadPreference() {
        preferences = getSharedPreferences(Preference.PREFERENCE_NAME, Activity.MODE_PRIVATE);
        editor = preferences.edit();
        avatarSeleccionado = preferences.getInt(Preference.AVATAR_SEECCIONADO, 0);
        userName =preferences.getString(Preference.USER_NAME, "");
        puntosAcum =preferences.getInt(Preference.PUNTOSACUMULADOS, 0);
        puntos=preferences.getInt(Preference.PUNTOS,0);

        tv_puntos.setText(""+puntos);
        tv_nombre.setText(userName);
        tv_pAcumulados.setText(""+puntosAcum);

    }

    @Override
    public void onClick(View v) {
        int id=v.getId();
        if (id==R.id.cinco){
            cont_good=cont_good+1;
            cont_intentos=cont_intentos+1;
            txt_completar.setBackgroundResource(R.drawable.txt_livingc);
            cargarPuntos();
            Thread timerThread = new Thread(){
                public void run(){
                    try{
                        sleep(5000);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }finally{
                        Intent ir=new Intent(getApplicationContext(), CasaCorrespon2Activity.class);
                        startActivity(ir);
                        finish();
                    }
                }
            };
            timerThread.start();
        }else {
            cont_fail=cont_fail+1;
            cont_intentos=cont_intentos+1;
        }

    }

    private void cargarPuntos() {
        if (cont_good==1 && cont_intentos ==1){
            int suma_puntos=puntos+35;
            int suma_puntosA=puntosAcum+35;
            editor.putInt(Preference.PUNTOS, suma_puntos);
            editor.putInt(Preference.PUNTOSACUMULADOS, suma_puntosA);
            editor.commit();
        }else if (cont_good==1 && (cont_intentos ==2)){
            int suma_puntos=puntos+25;
            int suma_puntosA=puntosAcum+25;
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
