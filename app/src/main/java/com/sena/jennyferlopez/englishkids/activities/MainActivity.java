package com.sena.jennyferlopez.englishkids.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.sena.jennyferlopez.englishkids.R;
import com.sena.jennyferlopez.englishkids.activities.nivel1.Escalera1Activity;
import com.sena.jennyferlopez.englishkids.utils.Preference;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView img_mujer, img_hombre, img_aceptar, img_cancelar, img_cambiara;
    EditText txt_nickname;
    String nickname,  genero_avatar;
    int avatarSeleccionado;
    private SharedPreferences.Editor editor;
    private SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preferences = getSharedPreferences(Preference.PREFERENCE_NAME, Context.MODE_PRIVATE);
        editor = preferences.edit();

        img_mujer=(ImageView) findViewById(R.id.btnMujer);
        img_hombre=(ImageView) findViewById(R.id.btnHombre);
        img_aceptar=(ImageView) findViewById(R.id.btn_guardarAvatar);
        img_cambiara=(ImageView) findViewById(R.id.imgAvatar);
        img_cancelar=(ImageView) findViewById(R.id.btn_guardarCancelar);
        txt_nickname=(EditText)findViewById(R.id.et_nickname);

        img_mujer.setOnClickListener(this);
        img_hombre.setOnClickListener(this);
        img_cancelar.setOnClickListener(this);
        img_aceptar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id=v.getId();

        if (id==R.id.btnMujer){
            img_cambiara.setBackgroundResource(R.drawable.avatar_ninia);
            editor.putString(Preference.GENERO_AVATAR, "1");
            editor.commit();
        }else if (id==R.id.btnHombre){
            img_cambiara.setBackgroundResource(R.drawable.avatar_ninio);
            editor.putString(Preference.GENERO_AVATAR, "2");
            editor.commit();
        }
        genero_avatar =preferences.getString(Preference.GENERO_AVATAR, "");
        if  (id==R.id.btn_guardarAvatar){
            if (genero_avatar.equals("1")){
                avatarSeleccionado=R.drawable.avatar_ninia;
                editor.putInt(Preference.AVATAR_SEECCIONADO, avatarSeleccionado);
            }else if (genero_avatar.equals("2")){
                avatarSeleccionado=R.drawable.avatar_ninio;
                editor.putInt(Preference.AVATAR_SEECCIONADO, avatarSeleccionado);
            }
            nickname=txt_nickname.getText().toString();
            editor.putString(Preference.USER_NAME, nickname);
            editor.putInt(Preference.PUNTOS, 0);
            editor.commit();
            Intent ir= new Intent(this, Escalera1Activity.class);
            startActivity(ir);
            finish();
        }
       if (id==R.id.btn_guardarCancelar){
            System.runFinalization();
            System.exit(0);
            MainActivity.this.finish();
        }
    }


}
