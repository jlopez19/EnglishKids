package com.sena.jennyferlopez.englishkids.activities.nivel1;

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

public class SelectDias2Activity extends AppCompatActivity implements View.OnClickListener{
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
        setContentView(R.layout.activity_select_dias2);

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

        tv_puntos.setText(""+50);
        tv_nombre.setText(userName);
        tv_pAcumulados.setText(""+puntosAcum);

    }

    @Override
    public void onClick(View v) {
        int id=v.getId();
        if (id==R.id.uno){
            txt_completar.setBackgroundResource(R.drawable.txt_mondayc);
            Thread timerThread = new Thread(){
                public void run(){
                    try{
                        sleep(1200);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }finally{
                        Intent ir=new Intent(getApplicationContext(), SelectDias3Activity.class);
                        startActivity(ir);
                        finish();
                    }
                }
            };
            timerThread.start();
        }else {
            Toast.makeText(this, "Intentelo de nuevo!", Toast.LENGTH_SHORT).show();
        }


    }
    private void cargarPuntos() {
        if (cont_good ==4) {
            finish();
        }if (cont_good==4 && cont_intentos ==4){
            editor.putInt(Preference.PUNTOS, 100);
            editor.commit();
        }else if (cont_good==4 && (cont_intentos >4 || cont_intentos <7)){
            editor.putInt(Preference.PUNTOS, 100);
            editor.commit();
        }else if (cont_good==4 && (cont_intentos >=7 || cont_intentos <=10)){
            editor.putInt(Preference.PUNTOS, 100);
            editor.commit();
        }else if (cont_good<4 && cont_intentos >10){
            editor.putInt(Preference.PUNTOS, 100);
            editor.commit();
        }
    }
}
