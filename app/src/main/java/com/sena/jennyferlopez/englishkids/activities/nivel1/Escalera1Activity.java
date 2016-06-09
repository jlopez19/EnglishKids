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
import com.sena.jennyferlopez.englishkids.utils.Preference;

public class Escalera1Activity extends AppCompatActivity implements View.OnClickListener {

    TextView tv_puntos, tv_nombre;
    ImageView correAvatar;
    SharedPreferences preferences;
    String  userName;
    int puntos, puntosAcum, avatarSeleccionado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escalera1);
        tv_puntos=(TextView)findViewById(R.id.tv_puntos);
        tv_nombre=(TextView)findViewById(R.id.tv_nombre);
        correAvatar=(ImageView)findViewById(R.id.correAvatar);
        correAvatar.setOnClickListener(this);

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
        if (id==R.id.correAvatar){
            Intent ir= new Intent(this, SaludosyDiasActivity.class);
            startActivity(ir);
            finish();
        }
    }
}
