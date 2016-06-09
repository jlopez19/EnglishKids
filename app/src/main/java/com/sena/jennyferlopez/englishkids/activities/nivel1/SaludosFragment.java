package com.sena.jennyferlopez.englishkids.activities.nivel1;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sena.jennyferlopez.englishkids.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SaludosFragment extends Fragment {

    TextView tv_puntos, tv_nombre;
    ImageView correAvatar;
    SharedPreferences preferences;
    String  userName;
    int puntos, puntosAcum, avatarSeleccionado;
    public SaludosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_saludos, container, false);
    }

}
