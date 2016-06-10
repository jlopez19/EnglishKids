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
public class NumerosFragment extends Fragment implements View.OnClickListener{
    ImageView num_one, num_two, num_three, num_four, num_five, num_six, num_Seven, num_eight, num_nine, num_zero;
    String  userName, pantalla;
    TextView tv_puntos, tv_nombre, tv_pAcumulados;
    int puntos, puntosAcum, avatarSeleccionado;
    private SharedPreferences.Editor editor;
    private SharedPreferences preferences;

    public NumerosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_numeros, container, false);

        tv_puntos=(TextView) view.findViewById(R.id.tv_puntos);
        tv_pAcumulados=(TextView) view.findViewById(R.id.tv_puntosac);
        tv_nombre=(TextView) view.findViewById(R.id.tv_nombre);

        num_zero=(ImageView) view.findViewById(R.id.num_zero);
        num_one=(ImageView) view.findViewById(R.id.num_one);
        num_two=(ImageView) view.findViewById(R.id.num_two);
        num_three=(ImageView) view.findViewById(R.id.num_three);
        num_four=(ImageView) view.findViewById(R.id.num_four);
        num_five=(ImageView) view.findViewById(R.id.num_five);
        num_six=(ImageView) view.findViewById(R.id.num_six);
        num_Seven=(ImageView) view.findViewById(R.id.num_Seven);
        num_eight=(ImageView) view.findViewById(R.id.num_eight);
        num_nine=(ImageView) view.findViewById(R.id.num_nine);

        num_zero.setOnClickListener(this);
        num_one.setOnClickListener(this);
        num_two.setOnClickListener(this);
        num_three.setOnClickListener(this);
        num_four.setOnClickListener(this);
        num_five.setOnClickListener(this);
        num_six.setOnClickListener(this);
        num_Seven.setOnClickListener(this);
        num_eight.setOnClickListener(this);
        num_nine.setOnClickListener(this);

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
        if (id==R.id.num_zero){
            MediaPlayer mp = MediaPlayer.create(getActivity(), R.raw.ten);
            mp.start();
        }else if (id==R.id.num_one){
            MediaPlayer mp = MediaPlayer.create(getActivity(), R.raw.one);
            mp.start();
        }else if (id==R.id.num_two){
            MediaPlayer mp = MediaPlayer.create(getActivity(), R.raw.two);
            mp.start();
        }else if (id==R.id.num_three){
            MediaPlayer mp = MediaPlayer.create(getActivity(), R.raw.tree);
            mp.start();
        }else if (id==R.id.num_four){
            MediaPlayer mp = MediaPlayer.create(getActivity(), R.raw.four);
            mp.start();
        }else if (id==R.id.num_five){
            MediaPlayer mp = MediaPlayer.create(getActivity(), R.raw.five);
            mp.start();
        }else if (id==R.id.num_six){
            MediaPlayer mp = MediaPlayer.create(getActivity(), R.raw.six);
            mp.start();
        }else if (id==R.id.num_Seven){
            MediaPlayer mp = MediaPlayer.create(getActivity(), R.raw.seven);
            mp.start();
        }else if (id==R.id.num_eight){
            MediaPlayer mp = MediaPlayer.create(getActivity(), R.raw.eight);
            mp.start();
        }else if (id==R.id.num_nine){
            MediaPlayer mp = MediaPlayer.create(getActivity(), R.raw.nine);
            mp.start();
        }
    }
}
