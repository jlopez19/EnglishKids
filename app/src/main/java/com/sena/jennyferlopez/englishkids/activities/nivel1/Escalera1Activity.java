package com.sena.jennyferlopez.englishkids.activities.nivel1;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.sena.jennyferlopez.englishkids.R;
import com.sena.jennyferlopez.englishkids.activities.dos.CanastaFrutasActivity;
import com.sena.jennyferlopez.englishkids.activities.dos.ConcentrateFyCActivity;
import com.sena.jennyferlopez.englishkids.activities.dos.CorresColoresActivity;
import com.sena.jennyferlopez.englishkids.activities.dos.FruitsyColorsActivity;
import com.sena.jennyferlopez.englishkids.activities.tres.NumerosyAnimalesActivity;
import com.sena.jennyferlopez.englishkids.utils.Preference;

public class Escalera1Activity extends AppCompatActivity implements View.OnClickListener {

    TextView tv_puntos, tv_nombre;
    ImageView correAvatar,correAvatar2,correAvatar3,correAvatar4,correAvatar5,correAvatar6,correAvatar7,correAvatar8,correAvatar9,correAvatar10,correAvatar11,correAvatar12,correAvatar13,correAvatar14,correAvatar15,correAvatar16;
    SharedPreferences preferences;
    String  userName;
    int puntos, puntosAcum, idvatar,avatarSeleccionado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escalera1);
        tv_puntos=(TextView)findViewById(R.id.tv_puntos);
        tv_nombre=(TextView)findViewById(R.id.tv_nombre);

        correAvatar=(ImageView)findViewById(R.id.correAvatar1);
        correAvatar2=(ImageView)findViewById(R.id.correAvatar2);
        correAvatar3=(ImageView)findViewById(R.id.correAvatar3);
        correAvatar4=(ImageView)findViewById(R.id.correAvatar4);
        correAvatar5=(ImageView)findViewById(R.id.correAvatar5);
        correAvatar6=(ImageView)findViewById(R.id.correAvatar6);
        correAvatar7=(ImageView)findViewById(R.id.correAvatar7);
        correAvatar8=(ImageView)findViewById(R.id.correAvatar8);
        correAvatar9=(ImageView)findViewById(R.id.correAvatar9);
        correAvatar10=(ImageView)findViewById(R.id.correAvatar10);
        correAvatar11=(ImageView)findViewById(R.id.correAvatar11);
        correAvatar12=(ImageView)findViewById(R.id.correAvatar12);
        correAvatar13=(ImageView)findViewById(R.id.correAvatar13);
        correAvatar14=(ImageView)findViewById(R.id.correAvatar14);
        correAvatar15=(ImageView)findViewById(R.id.correAvatar15);
        correAvatar16=(ImageView)findViewById(R.id.correAvatar16);

        correAvatar.setOnClickListener(this);
        correAvatar2.setOnClickListener(this);
        correAvatar3.setOnClickListener(this);
        correAvatar4.setOnClickListener(this);
        correAvatar5.setOnClickListener(this);
        correAvatar6.setOnClickListener(this);
        correAvatar7.setOnClickListener(this);
        correAvatar8.setOnClickListener(this);
        correAvatar9.setOnClickListener(this);
        correAvatar10.setOnClickListener(this);
        correAvatar11.setOnClickListener(this);
        correAvatar12.setOnClickListener(this);
        correAvatar13.setOnClickListener(this);
        correAvatar14.setOnClickListener(this);
        correAvatar15.setOnClickListener(this);
        correAvatar16.setOnClickListener(this);

        loadDatos();

    }

    private void loadDatos() {
        preferences = getSharedPreferences(Preference.PREFERENCE_NAME, Activity.MODE_PRIVATE);
        avatarSeleccionado = preferences.getInt(Preference.AVATAR_SEECCIONADO, 0);
        userName =preferences.getString(Preference.USER_NAME, "");
        puntos=preferences.getInt(Preference.PUNTOS,0);
        tv_puntos.setText(""+puntos);
        tv_nombre.setText(userName);
        correAvatar.setBackgroundResource(avatarSeleccionado);
    }

    @Override
    public void onClick(View v) {
        int id=v.getId();
        Intent ir=null;
        if (id==R.id.correAvatar1){
            ir= new Intent(this, SaludosyDiasActivity.class);
            correAvatar.setVisibility(View.INVISIBLE);
            correAvatar2.setVisibility(View.VISIBLE);
            correAvatar2.setBackgroundResource(avatarSeleccionado);
        }else if (id==R.id.correAvatar2){
            ir= new Intent(this, ColisionarDiasActivity.class);
            correAvatar2.setVisibility(View.INVISIBLE);
            correAvatar3.setVisibility(View.VISIBLE);
            correAvatar3.setBackgroundResource(avatarSeleccionado);
        }else if (id==R.id.correAvatar3){
            ir= new Intent(this, SelectDiasActivity.class);
            correAvatar3.setVisibility(View.INVISIBLE);
            correAvatar4.setVisibility(View.VISIBLE);
            correAvatar4.setBackgroundResource(avatarSeleccionado);
        }else if (id==R.id.correAvatar4){
            ir= new Intent(this, CompletaDiasActivity.class);
            correAvatar4.setVisibility(View.INVISIBLE);
            correAvatar5.setVisibility(View.VISIBLE);
            correAvatar5.setBackgroundResource(avatarSeleccionado);
        }else if (id==R.id.correAvatar5){
            ir= new Intent(this, FruitsyColorsActivity.class);
            correAvatar5.setVisibility(View.INVISIBLE);
            correAvatar6.setVisibility(View.VISIBLE);
            correAvatar6.setBackgroundResource(avatarSeleccionado);
        }else if (id==R.id.correAvatar6){
            ir= new Intent(this, CanastaFrutasActivity.class);
            correAvatar6.setVisibility(View.INVISIBLE);
            correAvatar7.setVisibility(View.VISIBLE);
            correAvatar7.setBackgroundResource(avatarSeleccionado);
        }else if (id==R.id.correAvatar7){
            ir= new Intent(this, CorresColoresActivity.class);
            correAvatar7.setVisibility(View.INVISIBLE);
            correAvatar8.setVisibility(View.VISIBLE);
            correAvatar8.setBackgroundResource(avatarSeleccionado);
        }else if (id==R.id.correAvatar8){
            ir= new Intent(this, ConcentrateFyCActivity.class);
            correAvatar8.setVisibility(View.INVISIBLE);
            correAvatar9.setVisibility(View.VISIBLE);
            correAvatar9.setBackgroundResource(avatarSeleccionado);
        }else if (id==R.id.correAvatar9){
            ir= new Intent(this, NumerosyAnimalesActivity.class);
            correAvatar9.setVisibility(View.INVISIBLE);
            correAvatar10.setVisibility(View.VISIBLE);
            correAvatar10.setBackgroundResource(avatarSeleccionado);
        }else if (id==R.id.correAvatar10){
            ir= new Intent(this, SaludosyDiasActivity.class);
            correAvatar10.setVisibility(View.INVISIBLE);
            correAvatar11.setVisibility(View.VISIBLE);
            correAvatar11.setBackgroundResource(avatarSeleccionado);
        }else if (id==R.id.correAvatar11){
            ir= new Intent(this, SaludosyDiasActivity.class);
            correAvatar11.setVisibility(View.INVISIBLE);
            correAvatar12.setVisibility(View.VISIBLE);
            correAvatar12.setBackgroundResource(avatarSeleccionado);
        }else if (id==R.id.correAvatar12){
            ir= new Intent(this, SaludosyDiasActivity.class);
            correAvatar12.setVisibility(View.INVISIBLE);
            correAvatar13.setVisibility(View.VISIBLE);
            correAvatar13.setBackgroundResource(avatarSeleccionado);
        }else if (id==R.id.correAvatar13){
            ir= new Intent(this, SaludosyDiasActivity.class);
            correAvatar13.setVisibility(View.INVISIBLE);
            correAvatar14.setVisibility(View.VISIBLE);
            correAvatar14.setBackgroundResource(avatarSeleccionado);
        }else if (id==R.id.correAvatar14){
            ir= new Intent(this, SaludosyDiasActivity.class);
            correAvatar14.setVisibility(View.INVISIBLE);
            correAvatar15.setVisibility(View.VISIBLE);
            correAvatar15.setBackgroundResource(avatarSeleccionado);
        }else if (id==R.id.correAvatar15){
            ir= new Intent(this, SaludosyDiasActivity.class);
            correAvatar15.setVisibility(View.INVISIBLE);
            correAvatar16.setVisibility(View.VISIBLE);
            correAvatar16.setBackgroundResource(avatarSeleccionado);
        }else if (id==R.id.correAvatar16){
            ir= new Intent(this, SaludosyDiasActivity.class);
        }
        startActivity(ir);
    }
}
