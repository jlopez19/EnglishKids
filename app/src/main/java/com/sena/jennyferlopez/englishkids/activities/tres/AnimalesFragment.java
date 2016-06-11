package com.sena.jennyferlopez.englishkids.activities.tres;


import android.app.Activity;
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
import com.sena.jennyferlopez.englishkids.utils.Preference;

/**
 * A simple {@link Fragment} subclass.
 */
public class AnimalesFragment extends Fragment implements View.OnClickListener{

    ImageView anim_dog, anim_chicken, anim_rabbit, anim_cow, anim_cat, anim_horse;
    String  userName, pantalla;
    TextView tv_puntos, tv_nombre, tv_pAcumulados;
    int puntos, puntosAcum, avatarSeleccionado;
    private SharedPreferences.Editor editor;
    private SharedPreferences preferences;

    public AnimalesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_animales, container, false);
        tv_puntos=(TextView) view.findViewById(R.id.tv_puntos);
        tv_pAcumulados=(TextView) view.findViewById(R.id.tv_puntosac);
        tv_nombre=(TextView) view.findViewById(R.id.tv_nombre);

        anim_dog=(ImageView) view.findViewById(R.id.ani_dog);
        anim_chicken=(ImageView) view.findViewById(R.id.ani_chicken);
        anim_rabbit=(ImageView) view.findViewById(R.id.ani_rabbit);
        anim_cow=(ImageView) view.findViewById(R.id.ani_cow);
        anim_cat=(ImageView) view.findViewById(R.id.ani_cat);
        anim_horse=(ImageView) view.findViewById(R.id.ani_horse);

        anim_dog.setOnClickListener(this);
        anim_chicken.setOnClickListener(this);
        anim_rabbit.setOnClickListener(this);
        anim_cow.setOnClickListener(this);
        anim_cat.setOnClickListener(this);
        anim_horse.setOnClickListener(this);

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

        tv_puntos.setText(""+puntos);
        tv_nombre.setText(userName);
        tv_pAcumulados.setText(""+puntosAcum);

        editor.putInt(Preference.PUNTOS, 50);
        editor.putInt(Preference.PUNTOSACUMULADOS, 50);
        editor.commit();
    }

    @Override
    public void onClick(View v) {
        int id=v.getId();
        if (id==R.id.ani_dog){
            MediaPlayer mp = MediaPlayer.create(getActivity(), R.raw.dog);
            mp.start();
        }else if (id==R.id.ani_chicken){
            MediaPlayer mp = MediaPlayer.create(getActivity(), R.raw.chiken);
            mp.start();
        }else if (id==R.id.ani_rabbit){
            MediaPlayer mp = MediaPlayer.create(getActivity(), R.raw.rabbit);
            mp.start();
            getActivity().finish();
        }else if (id==R.id.ani_cow){
            MediaPlayer mp = MediaPlayer.create(getActivity(), R.raw.cow);
            mp.start();
        }else if (id==R.id.ani_cat){
            MediaPlayer mp = MediaPlayer.create(getActivity(), R.raw.cat);
            mp.start();
        }else if (id==R.id.ani_horse){
            MediaPlayer mp = MediaPlayer.create(getActivity(), R.raw.horse);
            mp.start();
        }
    }

}
