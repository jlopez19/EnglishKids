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
public class ColoresFragment extends Fragment implements View.OnClickListener {

    ImageView col_pink,  col_blue, col_green, col_orange, col_yellow,col_red, col_black, col_white;
    String  userName, pantalla;
    TextView tv_puntos, tv_nombre, tv_pAcumulados;
    int puntos, puntosAcum, avatarSeleccionado;
    private SharedPreferences.Editor editor;
    private SharedPreferences preferences;

    public ColoresFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=  inflater.inflate(R.layout.fragment_colores, container, false);

        tv_puntos=(TextView) view.findViewById(R.id.tv_puntos);
        tv_pAcumulados=(TextView) view.findViewById(R.id.tv_puntosAc);
        tv_nombre=(TextView) view.findViewById(R.id.tv_nombre);
        col_pink=(ImageView) view.findViewById(R.id.col_pink);
        col_blue=(ImageView) view.findViewById(R.id.col_blue);
        col_green=(ImageView) view.findViewById(R.id.col_green);
        col_orange=(ImageView) view.findViewById(R.id.col_orange);
        col_yellow=(ImageView) view.findViewById(R.id.col_yellow);
        col_red=(ImageView) view.findViewById(R.id.col_red);
        col_black=(ImageView) view.findViewById(R.id.col_black);
        col_white=(ImageView) view.findViewById(R.id.col_white);

        col_pink.setOnClickListener(this);
        col_blue.setOnClickListener(this);
        col_green.setOnClickListener(this);
        col_orange.setOnClickListener(this);
        col_yellow.setOnClickListener(this);
        col_red.setOnClickListener(this);
        col_black.setOnClickListener(this);
        col_white.setOnClickListener(this);

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
        if (id==R.id.col_pink){
            MediaPlayer mp = MediaPlayer.create(getActivity(), R.raw.pink);
            mp.start();
            editor.putInt(Preference.PUNTOS, 50);
            editor.commit();
        }else if (id==R.id.col_blue){
            MediaPlayer mp = MediaPlayer.create(getActivity(), R.raw.blue);
            mp.start();
        }else if (id==R.id.col_green){
            MediaPlayer mp = MediaPlayer.create(getActivity(), R.raw.green);
            mp.start();
        }else if (id==R.id.col_orange){
            MediaPlayer mp = MediaPlayer.create(getActivity(), R.raw.orange);
            mp.start();
        }else if (id==R.id.col_yellow){
            MediaPlayer mp = MediaPlayer.create(getActivity(), R.raw.yellow);
            mp.start();
        }else if (id==R.id.col_red){
            MediaPlayer mp = MediaPlayer.create(getActivity(), R.raw.red);
            mp.start();
        }else if (id==R.id.col_black){
            MediaPlayer mp = MediaPlayer.create(getActivity(), R.raw.black);
            mp.start();
        }else if (id==R.id.col_white){
            MediaPlayer mp = MediaPlayer.create(getActivity(), R.raw.white);
            mp.start();
            getActivity().finish();
        }
    }

}
