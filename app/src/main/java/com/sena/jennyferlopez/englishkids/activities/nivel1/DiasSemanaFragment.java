package com.sena.jennyferlopez.englishkids.activities.nivel1;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sena.jennyferlopez.englishkids.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DiasSemanaFragment extends Fragment {


    public DiasSemanaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dias_semana, container, false);
    }

}
