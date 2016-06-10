package com.sena.jennyferlopez.englishkids.activities.tres;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.sena.jennyferlopez.englishkids.R;
import com.sena.jennyferlopez.englishkids.utils.Preference;

import java.util.List;

public class SonidoCorrNumActivity extends AppCompatActivity implements View.OnClickListener{

    ImageView img_uno, img_dos, img_tres,img_cuatro, img_cinco, img_seis, img_siete, img_ocho, img_nueve, img_diez, ic_play;
    int sonidos[]= new int[10];
    int cont_intentos=0, cont_good=0, cont_fail=0, i =0, num;
    String  userName, pantalla;
    TextView tv_puntos, tv_nombre, tv_pAcumulados;
    int puntos, puntosAcum, avatarSeleccionado;
    private SharedPreferences.Editor editor;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sonido_corr_num);
        ic_play =(ImageView) findViewById(R.id.img_play);
        img_uno =(ImageView) findViewById(R.id.img_uno);
        img_dos =(ImageView) findViewById(R.id.img_dos);
        img_tres =(ImageView) findViewById(R.id.img_tres);
        img_cuatro =(ImageView) findViewById(R.id.img_cuatro);
        img_cinco =(ImageView) findViewById(R.id.img_cinco);
        img_seis =(ImageView) findViewById(R.id.img_seis);
        img_siete =(ImageView) findViewById(R.id.img_siete);
        img_ocho =(ImageView) findViewById(R.id.img_ocho);
        img_nueve =(ImageView) findViewById(R.id.img_nueve);
        img_diez =(ImageView) findViewById(R.id.img_diez);

        tv_puntos = (TextView) findViewById(R.id.tv_puntos);
        tv_nombre = (TextView) findViewById(R.id.tv_nombre);
        tv_pAcumulados = (TextView) findViewById(R.id.tv_puntosac);


        sonidos[0]= R.raw.nine;
        sonidos[1]= R.raw.tree;
        sonidos[2]= R.raw.seven;
        sonidos[3]= R.raw.ten;
        sonidos[4]= R.raw.six;
        sonidos[5]= R.raw.eight;
        sonidos[6]= R.raw.one;
        sonidos[7]= R.raw.five;
        sonidos[8]= R.raw.two;
        sonidos[9]= R.raw.four;

        ic_play.setOnClickListener(this);
        img_uno.setOnClickListener(this);
        img_dos.setOnClickListener(this);
        img_tres.setOnClickListener(this);
        img_cuatro.setOnClickListener(this);
        img_cinco.setOnClickListener(this);
        img_seis.setOnClickListener(this);
        img_siete.setOnClickListener(this);
        img_ocho.setOnClickListener(this);
        img_nueve.setOnClickListener(this);
        img_diez.setOnClickListener(this);
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
        if (v.getId() == R.id.img_play) {
            MediaPlayer mp = MediaPlayer.create(this, sonidos[i]);
            mp.start();
            num=1;
            if (i==10){
                Toast.makeText(this, "final", Toast.LENGTH_SHORT).show();
            }
        }else if (v.getId() == R.id.img_nueve){
            if (num==1 && i==0){
                i=i+1;
                img_nueve.setVisibility(View.INVISIBLE);
                cont_good=cont_good+1;
                cont_intentos=cont_intentos+1;
            }else {
                cont_fail=cont_fail+1;
                cont_intentos=cont_intentos+1;
            }
        }else if (v.getId() == R.id.img_tres){
            if (i==1){
                i=i+1;
                img_tres.setVisibility(View.INVISIBLE);
                cont_good=cont_good+1;
                cont_intentos=cont_intentos+1;
            }else {
                cont_fail=cont_fail+1;
                cont_intentos=cont_intentos+1;
            }
        }else if (v.getId() == R.id.img_siete){
            if (i==2){
                i=i+1;
                img_siete.setVisibility(View.INVISIBLE);
                cont_good=cont_good+1;
                cont_intentos=cont_intentos+1;
            }else {
                cont_fail=cont_fail+1;
                cont_intentos=cont_intentos+1;
            }
        }else if (v.getId() == R.id.img_diez){
            if (i==3){
                i=i+1;
                img_diez.setVisibility(View.INVISIBLE);
                cont_good=cont_good+1;
                cont_intentos=cont_intentos+1;
            }else {
                cont_fail=cont_fail+1;
                cont_intentos=cont_intentos+1;
            }
        }else if (v.getId() == R.id.img_seis){
            if (i==4){
                i=i+1;
                img_seis.setVisibility(View.INVISIBLE);
                cont_good=cont_good+1;
                cont_intentos=cont_intentos+1;
            }else {
                cont_fail=cont_fail+1;
                cont_intentos=cont_intentos+1;
            }
        }else if (v.getId() == R.id.img_ocho){
            if (i==5){
                i=i+1;
                img_ocho.setVisibility(View.INVISIBLE);
                cont_good=cont_good+1;
                cont_intentos=cont_intentos+1;
            }else {
                cont_fail=cont_fail+1;
                cont_intentos=cont_intentos+1;
            }
        }else if (v.getId() == R.id.img_uno){
            if (i==6){
                i=i+1;
                img_uno.setVisibility(View.INVISIBLE);
                cont_good=cont_good+1;
                cont_intentos=cont_intentos+1;
            }else {
                cont_fail=cont_fail+1;
                cont_intentos=cont_intentos+1;
            }
        }else if (v.getId() == R.id.img_cinco){
            if (i==7){
                i=i+1;
                img_cinco.setVisibility(View.INVISIBLE);
                cont_good=cont_good+1;
                cont_intentos=cont_intentos+1;
            }else {
                cont_fail=cont_fail+1;
                cont_intentos=cont_intentos+1;
            }
        }else if (v.getId() == R.id.img_dos){
            if (i==8){
                i=i+1;
                img_dos.setVisibility(View.INVISIBLE);
                cont_good=cont_good+1;
                cont_intentos=cont_intentos+1;
            }else {
                cont_fail=cont_fail+1;
                cont_intentos=cont_intentos+1;
            }
        }else if (v.getId() == R.id.img_cuatro){
            if (i==9){
                i=i+1;
                img_cuatro.setVisibility(View.INVISIBLE);
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
        if (cont_good ==10) {
            finish();
        }if (cont_good==10 && cont_intentos ==10){
            editor.putInt(Preference.PUNTOS, 100);
            editor.commit();
        }else if (cont_good==10 && (cont_intentos >10 || cont_intentos <13)){
            editor.putInt(Preference.PUNTOS, 100);
            editor.commit();
        }else if (cont_good==10 && (cont_intentos >=13 || cont_intentos <=16)){
            editor.putInt(Preference.PUNTOS, 100);
            editor.commit();
        }else if (cont_good<10 && cont_intentos >20){
            editor.putInt(Preference.PUNTOS, 100);
            editor.commit();
        }
    }
}
