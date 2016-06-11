package com.sena.jennyferlopez.englishkids.activities.nivel1;

import android.app.Activity;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.sena.jennyferlopez.englishkids.R;
import com.sena.jennyferlopez.englishkids.utils.Preference;

public class SelectDiasActivity extends AppCompatActivity implements View.OnClickListener{

    ImageView sel_play, sel_gmorning, sel_gafternoon, sel_gnight, sel_gevening;
    int cont_intentos=0, cont_good=0, cont_fail=0, i =0, num;
    String  userName, pantalla;
    TextView tv_puntos, tv_nombre, tv_pAcumulados;
    int puntos, puntosAcum, avatarSeleccionado;
    private SharedPreferences.Editor editor;
    private SharedPreferences preferences;
    int sonidos[]= new int[4];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_dias);
        tv_puntos = (TextView) findViewById(R.id.tv_puntos);
        tv_nombre = (TextView) findViewById(R.id.tv_nombre);
        tv_pAcumulados = (TextView) findViewById(R.id.tv_puntosac);

        sel_play= (ImageView) findViewById(R.id.img_play);
        sel_gmorning= (ImageView) findViewById(R.id.sel_gmorning);
        sel_gafternoon= (ImageView) findViewById(R.id.sel_gafternoon);
        sel_gnight= (ImageView) findViewById(R.id.sel_gnight);
        sel_gevening= (ImageView) findViewById(R.id.sel_gevening);

        sonidos[0]= R.raw.good_afternoon;
        sonidos[1]= R.raw.good_night;
        sonidos[2]= R.raw.good_morning;
        sonidos[3]= R.raw.good_evening;


        sel_play.setOnClickListener(this);
        sel_gmorning.setOnClickListener(this);
        sel_gafternoon.setOnClickListener(this);
        sel_gnight.setOnClickListener(this);
        sel_gevening.setOnClickListener(this);
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
        if (id == R.id.img_play) {
            MediaPlayer mp = MediaPlayer.create(this, sonidos[i]);
            mp.start();
            num=1;
            if (i==4){
                Toast.makeText(this, "final", Toast.LENGTH_SHORT).show();
            }
         }else if (id == R.id.sel_gafternoon){
            if (num==1 && i==0){
                i=i+1;
                sel_gafternoon.setVisibility(View.INVISIBLE);
                cont_good=cont_good+1;
                cont_intentos=cont_intentos+1;
            }else {
                cont_fail=cont_fail+1;
                cont_intentos=cont_intentos+1;
            }
        }else if (id == R.id.sel_gnight){
            if (i==1){
                i=i+1;
                sel_gnight.setVisibility(View.INVISIBLE);
                cont_good=cont_good+1;
                cont_intentos=cont_intentos+1;
            }else {
                cont_fail=cont_fail+1;
                cont_intentos=cont_intentos+1;
            }
        }else if (id == R.id.sel_gmorning){
            if (i==2){
                i=i+1;
                sel_gmorning.setVisibility(View.INVISIBLE);
                cont_good=cont_good+1;
                cont_intentos=cont_intentos+1;
            }else {
                cont_fail=cont_fail+1;
                cont_intentos=cont_intentos+1;
            }
        }else if (id == R.id.sel_gevening){
            if (i==3){
                i=i+1;
                sel_gevening.setVisibility(View.INVISIBLE);
                cont_good=cont_good+1;
                cont_intentos=cont_intentos+1;
                cargarPuntos();
            }else {
                cont_fail=cont_fail+1;
                cont_intentos=cont_intentos+1;
            }
        }

    }
    private void cargarPuntos() {
        if (cont_good ==4) {
            finish();
        }if (cont_good==4 && cont_intentos ==4){
            int suma_puntos=puntos+100;
            int suma_puntosA=puntosAcum+100;
            editor.putInt(Preference.PUNTOS, suma_puntos);
            editor.putInt(Preference.PUNTOSACUMULADOS, suma_puntosA);
            editor.commit();
        }else if (cont_good==4 && (cont_intentos >4 || cont_intentos <7)){
            int suma_puntos=puntos+70;
            int suma_puntosA=puntosAcum+70;
            editor.putInt(Preference.PUNTOS, suma_puntos);
            editor.putInt(Preference.PUNTOSACUMULADOS, suma_puntosA);
            editor.commit();
        }else if (cont_good==4 && (cont_intentos >=7 || cont_intentos <=10)){
            int suma_puntos=puntos+50;
            int suma_puntosA=puntosAcum+50;
            editor.putInt(Preference.PUNTOS, suma_puntos);
            editor.putInt(Preference.PUNTOSACUMULADOS, suma_puntosA);
            editor.commit();
        }else if (cont_good<4 && cont_intentos >10){
            int suma_puntos=puntos+0;
            int suma_puntosA=puntosAcum+0;
            editor.putInt(Preference.PUNTOS, suma_puntos);
            editor.putInt(Preference.PUNTOSACUMULADOS, suma_puntosA);
            editor.commit();
        }
    }


}
