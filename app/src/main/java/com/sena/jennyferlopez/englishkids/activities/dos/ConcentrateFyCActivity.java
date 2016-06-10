package com.sena.jennyferlopez.englishkids.activities.dos;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.sena.jennyferlopez.englishkids.R;
import com.sena.jennyferlopez.englishkids.adapters.AdaptadorImagenes;
import com.sena.jennyferlopez.englishkids.utils.Preference;

import java.util.ArrayList;
import java.util.List;

public class ConcentrateFyCActivity extends AppCompatActivity {

    int fondo = R.drawable.img_voltear;
    int [] listadoImagenes = {
            R.drawable.con_banana,
            R.drawable.con_red,
            R.drawable.con_pear,
            R.drawable.con_yellow,
            R.drawable.con_pine,
            R.drawable.con_orange,
            R.drawable.con_mangou,
            R.drawable.con_blue
    };
    int cont_intentos=0, cont_good=0, cont_fail=0;

    int cantidadParejas = 8;
    int numeroParejas=8;
    int []imagenesFondo,imagenesSeleccionadasAleatorias;
    ArrayList<Integer> imagenSeleccionada;
    GridView gridView;
    AdaptadorImagenes adaptadorImagenes;
    ImageView img1,img2;
    int pos1=-1,pos2=-1;
    int cantImagenSeleccionada=0;
    String  userName, pantalla;
    TextView tv_puntos, tv_nombre, tv_pAcumulados;
    int puntos, puntosAcum, avatarSeleccionado;
    private SharedPreferences.Editor editor;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_concentrate_fy_c);

        tv_puntos=(TextView) findViewById(R.id.tv_puntos);
        tv_pAcumulados=(TextView) findViewById(R.id.tv_puntosac);
        tv_nombre=(TextView) findViewById(R.id.tv_nombre);
        gridView = (GridView) findViewById(R.id.gridImagenes);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                cantImagenSeleccionada++;

                ImageView imagen = (ImageView) view;
                if (pos1 == position || pos2 == position) {
                    cantImagenSeleccionada--;

                    return;
                }
                if (cantImagenSeleccionada == 1) {
                    pos1 = position;
                    img1 = imagen;
                }
                if (cantImagenSeleccionada == 2) {
                    pos2 = position;
                    img2 = imagen;
                }

                colocarImagen(position, imagen);
            }
        });
        inicializar();
        adaptadorImagenes =new AdaptadorImagenes(imagenesFondo, this);
        gridView.setAdapter(adaptadorImagenes);

        loadPreference();
    }

    private void loadPreference() {
        preferences = getSharedPreferences(Preference.PREFERENCE_NAME, Activity.MODE_PRIVATE);
        editor = preferences.edit();
        avatarSeleccionado = preferences.getInt(Preference.AVATAR_SEECCIONADO, 0);
        userName =preferences.getString(Preference.USER_NAME, "");
        puntosAcum =preferences.getInt(Preference.PUNTOSACUMULADOS, 0);
        puntos=preferences.getInt(Preference.PUNTOS,0);

        tv_puntos.setText(""+50);
        tv_nombre.setText(userName);
        tv_pAcumulados.setText(""+puntosAcum);
    }

    private void colocarImagen(int position, ImageView imagen) {
        imagen.setBackgroundResource(imagenesSeleccionadasAleatorias[position]);
        if (cantImagenSeleccionada==2){
            new Validar().execute();
        }
    }

    public void irnivelDos(View view) {
    }

    private class Validar extends AsyncTask<Void,Void,Void> {

        @Override
        protected void onPreExecute() {

            super.onPreExecute();
            gridView.setEnabled(false);
        }

        @Override
        protected Void doInBackground(Void... params) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;

        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            if (imagenesSeleccionadasAleatorias[pos1]==imagenesSeleccionadasAleatorias[pos2]){
                img1.setVisibility(View.INVISIBLE);
                img2.setVisibility(View.INVISIBLE);
                pos1=-1;
                pos2=-1;
                cantImagenSeleccionada=0;
                numeroParejas--;
                cont_good=cont_good+1;
                cont_intentos=cont_intentos+1;

                // Toast.makeText(getApplication(), "u",Toast.LENGTH_SHORT).show();
            }

            gridView.setEnabled(true);
            resetImagenes();

            if (numeroParejas==0){
                if (cont_good ==8) {
                    finish();
                }if (cont_good==8 && cont_intentos ==8){
                    editor.putInt(Preference.PUNTOS, 100);
                    editor.commit();
                }else if (cont_good==8 && (cont_intentos >8 || cont_intentos <11)){
                    editor.putInt(Preference.PUNTOS, 100);
                    editor.commit();
                }else if (cont_good==8 && (cont_intentos >=11 || cont_intentos <=16)){
                    editor.putInt(Preference.PUNTOS, 100);
                    editor.commit();
                }else if (cont_good<8 && cont_intentos >16){
                    editor.putInt(Preference.PUNTOS, 100);
                    editor.commit();
                }

            }
        }



    }

    // si las imagenes no coinciden se voltean
    private void resetImagenes() {
        if (img1!=null){
            img1.setBackgroundResource(fondo);
            img2.setBackgroundResource(fondo);
        }
        pos1=-1;
        pos2=-1;
        cantImagenSeleccionada=0;
        cont_fail=cont_fail+1;
        cont_intentos=cont_intentos+1;
        //Toast.makeText(this, "dos",Toast.LENGTH_SHORT).show();
    }

    // se inicia el juego
    private void inicializar() {
        getImagenesFondo();
        getImagenesSeleccionadas();
        getImagenesSeleccionadasAleatorias();
    }

    //se desordenan las imagenes del juego
    private void getImagenesSeleccionadasAleatorias() {
        imagenesSeleccionadasAleatorias=new  int[cantidadParejas*2];

        for (int i =0;i<cantidadParejas;i++) {
            int aux=0;
            do {
                int pos = (int) (Math.random() * (cantidadParejas * 2));
                if (imagenesSeleccionadasAleatorias[pos] == 0) {
                    imagenesSeleccionadasAleatorias[pos] = imagenSeleccionada.get(i);
                    aux++;
                }
            } while (aux < 2);
        }
    }

    // se seleccionan las imagenes que utilizaran en el juego
    private void getImagenesSeleccionadas() {
        imagenSeleccionada =new ArrayList<>();
        for (int i=0;i<cantidadParejas;i++){
            int aux= (int) (Math.random()*cantidadParejas);
            if (imagenSeleccionada.contains(listadoImagenes[aux])){
                i--;
            }else{
                imagenSeleccionada.add(listadoImagenes[aux]);
            }
        }
    }

    // se colocan las imagenes de fondo
    private void getImagenesFondo() {
        imagenesFondo=new int[cantidadParejas*2];
        for (int i=0;i<imagenesFondo.length;i++){
            imagenesFondo[i]=fondo;
        }
    }
}
