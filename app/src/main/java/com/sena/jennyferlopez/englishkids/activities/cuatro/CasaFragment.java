package com.sena.jennyferlopez.englishkids.activities.cuatro;


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
public class CasaFragment extends Fragment implements View.OnClickListener{

    ImageView img_bedRoom, img_livRoom, img_kitchen, img_bathRoom;
    String  userName, pantalla;
    TextView tv_puntos, tv_nombre, tv_pAcumulados;
    int puntos, puntosAcum, avatarSeleccionado;
    private SharedPreferences.Editor editor;
    private SharedPreferences preferences;
    
    public CasaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_casa, container, false);
        tv_puntos=(TextView) view.findViewById(R.id.tv_puntos);
        tv_pAcumulados=(TextView) view.findViewById(R.id.tv_puntosac);
        tv_nombre=(TextView) view.findViewById(R.id.tv_nombre);
        img_bedRoom=(ImageView) view.findViewById(R.id.img_bedRoom);
        img_livRoom=(ImageView) view.findViewById(R.id.img_livRoom);
        img_kitchen=(ImageView) view.findViewById(R.id.img_kitchen);
        img_bathRoom=(ImageView) view.findViewById(R.id.img_bathRoom);

        img_bedRoom.setOnClickListener(this);
        img_livRoom.setOnClickListener(this);
        img_kitchen.setOnClickListener(this);
        img_bathRoom.setOnClickListener(this);

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

        tv_puntos.setText(""+50);
        tv_nombre.setText(userName);
        tv_pAcumulados.setText(""+puntosAcum);

    }

    @Override
    public void onClick(View v) {
        int id=v.getId();
        if (id==R.id.img_bedRoom){
            MediaPlayer mp = MediaPlayer.create(getActivity(), R.raw.bedroom);
            mp.start();
            editor.putInt(Preference.PUNTOS, 50);
            editor.commit();
        }else if (id==R.id.img_livRoom){
            MediaPlayer mp = MediaPlayer.create(getActivity(), R.raw.livingroom);
            mp.start();
        }else if (id==R.id.img_kitchen){
            MediaPlayer mp = MediaPlayer.create(getActivity(), R.raw.good_night);
            mp.start();
        }else if (id==R.id.img_bathRoom){
            MediaPlayer mp = MediaPlayer.create(getActivity(), R.raw.bathroom);
            mp.start();
        }
    }

}
