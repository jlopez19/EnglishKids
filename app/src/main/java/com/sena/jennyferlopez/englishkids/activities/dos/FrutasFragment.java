package com.sena.jennyferlopez.englishkids.activities.dos;


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
public class FrutasFragment extends Fragment implements View.OnClickListener {
    ImageView fru_apple,  fru_pear, fru_banana, fru_pine, fru_mangou, fru_grape, fru_cherry, fru_orange;
    String  userName, pantalla;
    TextView tv_puntos, tv_nombre, tv_pAcumulados;
    int puntos, puntosAcum, avatarSeleccionado;
    private SharedPreferences.Editor editor;
    private SharedPreferences preferences;

    public FrutasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_frutas, container, false);

        tv_puntos=(TextView) view.findViewById(R.id.tv_puntos);
        tv_pAcumulados=(TextView) view.findViewById(R.id.tv_puntosacum);
        tv_nombre=(TextView) view.findViewById(R.id.tv_nombre);
        fru_apple=(ImageView) view.findViewById(R.id.fru_apple);
        fru_pear=(ImageView) view.findViewById(R.id.fru_pear);
        fru_banana=(ImageView) view.findViewById(R.id.fru_banana);
        fru_pine=(ImageView) view.findViewById(R.id.fru_pine);
        fru_mangou=(ImageView) view.findViewById(R.id.fru_mangou);
        fru_grape=(ImageView) view.findViewById(R.id.fru_grapes);
        fru_cherry=(ImageView) view.findViewById(R.id.fru_cherries);
        fru_orange=(ImageView) view.findViewById(R.id.fru_orange);

        fru_apple.setOnClickListener(this);
        fru_pear.setOnClickListener(this);
        fru_banana.setOnClickListener(this);
        fru_pine.setOnClickListener(this);
        fru_mangou.setOnClickListener(this);
        fru_grape.setOnClickListener(this);
        fru_cherry.setOnClickListener(this);
        fru_orange.setOnClickListener(this);

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
        if (id==R.id.fru_apple){
            MediaPlayer mp = MediaPlayer.create(getActivity(), R.raw.apple);
            mp.start();
        }else if (id==R.id.fru_pear){
            MediaPlayer mp = MediaPlayer.create(getActivity(), R.raw.pear);
            mp.start();
        }else if (id==R.id.fru_banana){
            MediaPlayer mp = MediaPlayer.create(getActivity(), R.raw.banana);
            mp.start();
        }else if (id==R.id.fru_pine){
            MediaPlayer mp = MediaPlayer.create(getActivity(), R.raw.pineapple);
            mp.start();
        }else if (id==R.id.fru_mangou){
            MediaPlayer mp = MediaPlayer.create(getActivity(), R.raw.mango);
            mp.start();
        }else if (id==R.id.fru_grapes){
            MediaPlayer mp = MediaPlayer.create(getActivity(), R.raw.greaps);
            mp.start();
        }else if (id==R.id.fru_cherries){
            MediaPlayer mp = MediaPlayer.create(getActivity(), R.raw.cherry);
            mp.start();
        }else if (id==R.id.fru_orange){
            MediaPlayer mp = MediaPlayer.create(getActivity(), R.raw.orange);
            mp.start();
        }
    }
}
