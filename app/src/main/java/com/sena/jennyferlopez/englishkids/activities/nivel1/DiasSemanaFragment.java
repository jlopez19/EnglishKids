package com.sena.jennyferlopez.englishkids.activities.nivel1;


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sena.jennyferlopez.englishkids.R;
import com.sena.jennyferlopez.englishkids.models.Puntos;
import com.sena.jennyferlopez.englishkids.utils.Preference;

/**
 * A simple {@link Fragment} subclass.
 */
public class DiasSemanaFragment extends Fragment implements View.OnClickListener{

    TextView tv_puntos, tv_nombre, tv_pAcumulados;
    ImageView img_mon, img_tues, img_wedn, img_thur, img_frid, img_satur, img_sand;
    String  userName, pantalla;
    int puntos, puntosAcum, avatarSeleccionado;
    private SharedPreferences.Editor editor;
    private SharedPreferences preferences;

    public DiasSemanaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_dias_semana, container, false);
        tv_puntos=(TextView) view.findViewById(R.id.tv_puntos);
        tv_pAcumulados=(TextView) view.findViewById(R.id.tv_puntosac);
        tv_nombre=(TextView) view.findViewById(R.id.tv_nombre);
        img_mon=(ImageView) view.findViewById(R.id.img_monday);
        img_tues=(ImageView) view.findViewById(R.id.img_tuesday);
        img_wedn=(ImageView) view.findViewById(R.id.img_wednesday);
        img_thur=(ImageView) view.findViewById(R.id.img_thursday);
        img_frid=(ImageView) view.findViewById(R.id.img_friday);
        img_satur=(ImageView) view.findViewById(R.id.img_saturday);
        img_sand=(ImageView) view.findViewById(R.id.img_sunday);

        img_mon.setOnClickListener(this);
        img_tues.setOnClickListener(this);
        img_wedn.setOnClickListener(this);
        img_thur.setOnClickListener(this);
        img_frid.setOnClickListener(this);
        img_satur.setOnClickListener(this);
        img_sand.setOnClickListener(this);

        loadPreference();
        return view;
    }

    private void loadPreference() {
        preferences = getActivity().getSharedPreferences(Preference.PREFERENCE_NAME, Activity.MODE_PRIVATE);
        editor = preferences.edit();
        avatarSeleccionado = preferences.getInt(Preference.AVATAR_SEECCIONADO, 0);
        userName =preferences.getString(Preference.USER_NAME, "");
        puntosAcum =preferences.getInt(Preference.PUNTOSACUMULADOS, 0);
        puntos=preferences.getInt(Preference.PUNTOS,0);

        tv_puntos.setText(""+ puntos);
        tv_nombre.setText(userName);
        tv_pAcumulados.setText(""+puntosAcum);
        int suma_puntos=puntos+50;
        int suma_puntosA=puntosAcum+50;
        editor.putInt(Preference.PUNTOS,suma_puntos);
        editor.putInt(Preference.PUNTOSACUMULADOS, suma_puntosA);
        editor.commit();
    }

    @Override
    public void onClick(View v) {
        int id=v.getId();
        if (id==R.id.img_monday){
            MediaPlayer mp = MediaPlayer.create(getActivity(), R.raw.monday);
            mp.start();
        }else if (id==R.id.img_tuesday){
            MediaPlayer mp = MediaPlayer.create(getActivity(), R.raw.tuesday);
            mp.start();
        }else if (id==R.id.img_wednesday){
            MediaPlayer mp = MediaPlayer.create(getActivity(), R.raw.wednesday);
            mp.start();
        }else if (id==R.id.img_thursday){
            MediaPlayer mp = MediaPlayer.create(getActivity(), R.raw.thursday);
            mp.start();
        }else if (id==R.id.img_friday){
            MediaPlayer mp = MediaPlayer.create(getActivity(), R.raw.friday);
            mp.start();
        }else if (id==R.id.img_saturday){
            MediaPlayer mp = MediaPlayer.create(getActivity(), R.raw.saturday);
            mp.start();
        }else if (id==R.id.img_sunday){
            MediaPlayer mp = MediaPlayer.create(getActivity(), R.raw.sunday);
            mp.start();
            //Intent ir=new Intent(getActivity(), Escalera1Activity.class);
            //startActivity(ir);
            getActivity().finish();
        }
    }

}
