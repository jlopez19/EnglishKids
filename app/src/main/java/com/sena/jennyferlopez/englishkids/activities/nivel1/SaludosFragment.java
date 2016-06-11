package com.sena.jennyferlopez.englishkids.activities.nivel1;


import android.app.Activity;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sena.jennyferlopez.englishkids.R;
import com.sena.jennyferlopez.englishkids.utils.Preference;

/**
 * A simple {@link Fragment} subclass.
 */
public class SaludosFragment extends Fragment implements OnClickListener{

    ImageView img_gMorning, img_gAfternnon, img_gNigth, img_gevening;
    String  userName, pantalla;
    TextView tv_puntos, tv_nombre, tv_pAcumulados;
    int puntos, puntosAcum, avatarSeleccionado;
    private SharedPreferences.Editor editor;
    private SharedPreferences preferences;
    public SaludosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_saludos, container, false);
        tv_puntos=(TextView) view.findViewById(R.id.tv_puntos);
        tv_pAcumulados=(TextView) view.findViewById(R.id.tv_puntosac);
        tv_nombre=(TextView) view.findViewById(R.id.tv_nombre);
        img_gMorning=(ImageView) view.findViewById(R.id.img_gMorning);
        img_gAfternnon=(ImageView) view.findViewById(R.id.img_gAfternoon);
        img_gNigth=(ImageView) view.findViewById(R.id.img_gNigth);
        img_gevening=(ImageView) view.findViewById(R.id.img_gEvening);

        img_gMorning.setOnClickListener(this);
        img_gAfternnon.setOnClickListener(this);
        img_gNigth.setOnClickListener(this);
        img_gevening.setOnClickListener(this);

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

        tv_puntos.setText(""+0);
        tv_nombre.setText(userName);
        tv_pAcumulados.setText(""+puntosAcum);

        editor.putInt(Preference.PUNTOS, 50);
        editor.putInt(Preference.PUNTOSACUMULADOS, 50);
        editor.commit();

    }

    @Override
    public void onClick(View v) {
        int id=v.getId();
        if (id==R.id.img_gMorning){
            MediaPlayer mp = MediaPlayer.create(getActivity(), R.raw.good_morning);
            mp.start();
            editor.putInt(Preference.PUNTOS, 50);
            editor.commit();
        }else if (id==R.id.img_gAfternoon){
            MediaPlayer mp = MediaPlayer.create(getActivity(), R.raw.good_afternoon);
            mp.start();
        }else if (id==R.id.img_gNigth){
            MediaPlayer mp = MediaPlayer.create(getActivity(), R.raw.good_night);
            mp.start();
        }else if (id==R.id.img_gEvening){
            MediaPlayer mp = MediaPlayer.create(getActivity(), R.raw.good_evening);
            mp.start();
        }
    }
}
