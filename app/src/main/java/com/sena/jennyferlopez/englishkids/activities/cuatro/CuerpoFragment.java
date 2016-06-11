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
public class CuerpoFragment extends Fragment implements View.OnClickListener {

    ImageView img_head, img_should, img_hands, img_knee, img_feet;
    String  userName, pantalla;
    TextView tv_puntos, tv_nombre, tv_pAcumulados;
    int puntos, puntosAcum, avatarSeleccionado;
    private SharedPreferences.Editor editor;
    private SharedPreferences preferences;

    public CuerpoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_cuerpo, container, false);
        tv_puntos=(TextView) view.findViewById(R.id.tv_puntos);
        tv_pAcumulados=(TextView) view.findViewById(R.id.tv_puntosac);
        tv_nombre=(TextView) view.findViewById(R.id.tv_nombre);
        img_head=(ImageView) view.findViewById(R.id.cuer_head);
        img_should=(ImageView) view.findViewById(R.id.cuer_should);
        img_hands=(ImageView) view.findViewById(R.id.cuer_hands);
        img_knee=(ImageView) view.findViewById(R.id.cuer_knees);
        img_feet=(ImageView) view.findViewById(R.id.cuer_feet);

        img_head.setOnClickListener(this);
        img_should.setOnClickListener(this);
        img_hands.setOnClickListener(this);
        img_knee.setOnClickListener(this);
        img_feet.setOnClickListener(this);

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
        if (id==R.id.cuer_head){
            MediaPlayer mp = MediaPlayer.create(getActivity(), R.raw.head);
            mp.start();
        }else if (id==R.id.cuer_should){
            MediaPlayer mp = MediaPlayer.create(getActivity(), R.raw.shoulder);
            mp.start();
        }else if (id==R.id.cuer_hands){
            MediaPlayer mp = MediaPlayer.create(getActivity(), R.raw.hand);
            mp.start();
        }else if (id==R.id.cuer_knees){
            MediaPlayer mp = MediaPlayer.create(getActivity(), R.raw.knee);
            mp.start();
        }else if (id==R.id.cuer_feet){
            MediaPlayer mp = MediaPlayer.create(getActivity(), R.raw.foot);
            mp.start();
            getActivity().finish();
        }
    }

}
