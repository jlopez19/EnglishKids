package com.sena.jennyferlopez.englishkids.activities.cuatro;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.PointF;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.sena.jennyferlopez.englishkids.R;
import com.sena.jennyferlopez.englishkids.utils.Preference;

public class ColPartesCuerpoActivity extends AppCompatActivity implements View.OnClickListener{

    private int modificarX=0;
    private int modificary=0;
    boolean detectView;
    float x, x1, y, y1, h,h1, l, l1;
    float xi, xi1, yi, yi1, hi,hi1, li, li1;
    float xm, xm1, ym, ym1, hm,hm1, lm, lm1;
    float xg, xg1, yg, yg1, hg,hg1, lg, lg1;

    ImageView col_viernes, col_martes, col_sabado, col_jueves, col_friday, col_tuesday, col_saturday, col_thursday;
    int cont_intentos=0, cont_good=0, cont_fail=0, id_user;
    float temp_x, temp_y;
    String  userName, pantalla;
    TextView tv_puntos, tv_nombre, tv_pAcumulados;
    int puntos, puntosAcum, avatarSeleccionado;
    private SharedPreferences.Editor editor;
    private SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_col_partes_cuerpo);
        col_viernes= (ImageView) findViewById(R.id.col_viernes);
        col_martes= (ImageView) findViewById(R.id.col_martes);
        col_sabado= (ImageView) findViewById(R.id.col_sabado);
        col_jueves= (ImageView) findViewById(R.id.col_jueves);
        col_friday= (ImageView) findViewById(R.id.col_friday);
        col_tuesday= (ImageView) findViewById(R.id.col_tues);
        col_saturday= (ImageView) findViewById(R.id.col_saturday);
        col_thursday= (ImageView) findViewById(R.id.col_thurs);

        col_viernes.setOnClickListener(this);
        col_martes.setOnClickListener(this);
        col_sabado.setOnClickListener(this);
        col_jueves.setOnClickListener(this);

        col_friday.setOnTouchListener(handlerMover);
        col_friday.setOnLongClickListener(detect);

        col_tuesday.setOnTouchListener(handlerMover);
        col_tuesday.setOnLongClickListener(detect);

        col_saturday.setOnTouchListener(handlerMover);
        col_saturday.setOnLongClickListener(detect);

        col_thursday.setOnTouchListener(handlerMover);
        col_thursday.setOnLongClickListener(detect);


        tv_puntos = (TextView) findViewById(R.id.tv_puntos);
        tv_nombre = (TextView) findViewById(R.id.tv_nombre);
        tv_pAcumulados = (TextView) findViewById(R.id.tv_puntosac);
        loadPreference();
    }



    private void loadPreference() {
        preferences = getSharedPreferences(Preference.PREFERENCE_NAME, Activity.MODE_PRIVATE);
        editor = preferences.edit();
        avatarSeleccionado = preferences.getInt(Preference.AVATAR_SEECCIONADO, 0);
        userName =preferences.getString(Preference.USER_NAME, "");
        puntosAcum =preferences.getInt(Preference.PUNTOSACUMULADOS, 0);
        puntos=preferences.getInt(Preference.PUNTOS,0);

        tv_puntos.setText(""+puntos);
        tv_nombre.setText(userName);
        tv_pAcumulados.setText(""+puntosAcum);

    }

    View.OnLongClickListener detect= new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            detectView=true;
            return false;
        }
    };
    View.OnTouchListener handlerMover=new View.OnTouchListener(){
        @Override
        public boolean onTouch(View v, MotionEvent motionEvent) {
            PointF DownPT= new PointF();
            PointF StartPT= new PointF();

            x=col_viernes.getX();
            y=col_viernes.getY();
            h=col_viernes.getWidth();
            l=col_viernes.getHeight();

            xi=col_martes.getX();
            yi=col_martes.getY();
            hi=col_martes.getWidth();
            li=col_martes.getHeight();

            xm=col_sabado.getX();
            ym=col_sabado.getY();
            hm=col_sabado.getWidth();
            lm=col_sabado.getHeight();

            xg=col_jueves.getX();
            yg=col_jueves.getY();
            hg=col_jueves.getWidth();
            lg=col_jueves.getHeight();

            int eid= motionEvent.getAction();

            switch (eid){
                case MotionEvent.ACTION_MOVE:
                    if (detectView){
                        StartPT = new PointF(v.getX(), v.getY());
                        PointF mv=new PointF(motionEvent.getX()-DownPT.x, motionEvent.getY()-DownPT.y);
                        v.setX((StartPT.x+mv.x)-modificarX);
                        v.setY((StartPT.y+mv.y)-modificary);
                    }

                    break;
                case MotionEvent.ACTION_DOWN:
                    DownPT.x=motionEvent.getX();
                    DownPT.y=motionEvent.getY();
                    int contT=0;
                    if (contT==0) {
                        int id=v.getId();
                        if (id==R.id.col_friday){
                            temp_x = DownPT.x=col_friday.getX();
                            temp_y = DownPT.y=col_friday.getY();
                            contT=contT+1;
                        }else if (id==R.id.col_tues){
                            temp_x = DownPT.x=col_tuesday.getX();
                            temp_y = DownPT.y=col_tuesday.getY();
                            contT=contT+1;
                        }else if (id==R.id.col_saturday){
                            temp_x = DownPT.x=col_saturday.getX();
                            temp_y = DownPT.y=col_saturday.getY();
                            contT=contT+1;
                        }else if (id==R.id.col_thurs){
                            temp_x = DownPT.x=col_thursday.getX();
                            temp_y = DownPT.y=col_thursday.getY();
                            contT=contT+1;
                        }
                    }
                    break;
                case MotionEvent.ACTION_UP:

                    switch (v.getId()){
                        case R.id.col_friday:
                            x1=v.getX();
                            y1=v.getY();
                            h1=v.getWidth();
                            l1=v.getHeight();

                            if ((x>=x1 && x<=(x1+h1) && y >= y1 && y <= (y1+l1)) || ((x+h)>=x1 && x<=(x1+h1) && y >= y1 && y <= (y1+l1))
                                    || (x>=x1 && x<=(x1+h1) && (y+l) >= y1 && (y+l) <= (y1+l1)) || ((x+h)>=x1 && (x+h)<=(x1+h1) && (y+l) >= y1 && (y+l) <= (y1+l1))){

                                col_viernes.setImageResource(R.drawable.choc_friday);
                                col_friday.setVisibility(View.INVISIBLE);
                                cont_good=cont_good+1;
                                cont_intentos=cont_intentos+1;
                            }else{
                                col_friday.setX(temp_x);
                                col_friday.setY(temp_y);
                                cont_fail=cont_fail+1;
                                cont_intentos=cont_intentos+1;
                            }
                            break;

                    }
                    switch (v.getId()){
                        case R.id.col_tues:
                            xi1=v.getX();
                            yi1=v.getY();
                            hi1=v.getWidth();
                            li1=v.getHeight();

                            if ((xi>=xi1 && xi<=(xi1+hi1) && yi >= yi1 && yi <= (yi1+li1)) || ((xi+hi)>=xi1 && xi<=(xi1+hi1) && yi >= yi1 && yi <= (yi1+li1))
                                    || (xi>=xi1 && xi<=(xi1+hi1) && (yi+li) >= yi1 && (yi+li) <= (yi1+li1)) || ((xi+hi)>=xi1 && (xi+hi)<=(xi1+hi1) && (yi+li) >= yi1 && (yi+li) <= (yi1+li1))){
                                col_martes.setImageResource(R.drawable.choc_tuesday);
                                col_tuesday.setVisibility(View.INVISIBLE);
                                cont_good=cont_good+1;
                                cont_intentos=cont_intentos+1;
                            }else{
                                col_tuesday.setX(temp_x);
                                col_tuesday.setY(temp_y);
                                cont_fail=cont_fail+1;
                                cont_intentos=cont_intentos+1;
                            }
                            break;

                    }
                    switch (v.getId()){
                        case R.id.col_saturday:
                            xm1=v.getX();
                            ym1=v.getY();
                            hm1=v.getWidth();
                            lm1=v.getHeight();

                            if ((xm>=xm1 && xm<=(xm1+hm1) && ym >= ym1 && ym <= (ym1+lm1)) || ((xm+hm)>=xm1 && xm<=(xm1+hm1) && ym >= ym1 && ym <= (ym1+lm1))
                                    || (xm>=xm1 && xm<=(xm1+hm1) && (ym+lm) >= ym1 && (ym+lm) <= (ym1+lm1)) || ((xm+hm)>=xm1 && (xm+hm)<=(xm1+hm1) && (ym+lm) >= ym1 && (ym+lm) <= (ym1+lm1))){

                                col_sabado.setImageResource(R.drawable.choc_saturday);
                                col_saturday.setVisibility(View.INVISIBLE);
                                cont_good=cont_good+1;
                                cont_intentos=cont_intentos+1;
                            }else{
                                col_saturday.setX(temp_x);
                                col_saturday.setY(temp_y);
                                cont_fail=cont_fail+1;
                                cont_intentos=cont_intentos+1;
                            }
                            break;

                    }
                    switch (v.getId()){
                        case R.id.col_thurs:
                            xg1=v.getX();
                            yg1=v.getY();
                            hg1=v.getWidth();
                            lg1=v.getHeight();

                            if ((xg>=xg1 && xg<=(xg1+hg1) && yg >= yg1 && yg <= (yg1+lg1)) || ((xg+hg)>=xg1 && xg<=(xg1+hg1) && yg >= yg1 && yg <= (yg1+lg1))
                                    || (xg>=xg1 && xg<=(xg1+hg1) && (yg+lg) >= yg1 && (yg+lg) <= (yg1+lg1)) || ((xg+hg)>=xg1 && (xg+hg)<=(xg1+hg1) && (yg+lg) >= yg1 && (yg+lg) <= (yg1+lg1))){

                                col_jueves.setImageResource(R.drawable.choc_thursday);
                                col_thursday.setVisibility(View.INVISIBLE);
                                cont_good=cont_good+1;
                                cont_intentos=cont_intentos+1;
                            }else{
                                col_thursday.setX(temp_x);
                                col_thursday.setY(temp_y);
                                cont_fail=cont_fail+1;
                                cont_intentos=cont_intentos+1;
                            }
                            break;
                    }
                    detectView=false;
                    break;

                default:
                    break;

            }
            cargarPuntos();
            return false;
        }

        private void cargarPuntos() {
            if (cont_good ==4) {
                finish();
            }if (cont_good==4 && cont_intentos ==4){
                int suma_puntos=puntos+100;
                int suma_puntosA=puntosAcum+100;
                editor.putInt(Preference.PUNTOS, suma_puntos);
                editor.putInt(Preference.PUNTOSACUMULADOS, suma_puntosA);
                editor.commit();
            }else if (cont_good==4 && (cont_intentos >4 || cont_intentos <7)){
                int suma_puntos=puntos+70;
                int suma_puntosA=puntosAcum+70;
                editor.putInt(Preference.PUNTOS, suma_puntos);
                editor.putInt(Preference.PUNTOSACUMULADOS, suma_puntosA);
                editor.commit();
            }else if (cont_good==4 && (cont_intentos >=7 || cont_intentos <=10)){
                int suma_puntos=puntos+50;
                int suma_puntosA=puntosAcum+50;
                editor.putInt(Preference.PUNTOS, suma_puntos);
                editor.putInt(Preference.PUNTOSACUMULADOS, suma_puntosA);
                editor.commit();
            }else if (cont_good<4 && cont_intentos >10){
                int suma_puntos=puntos+0;
                int suma_puntosA=puntosAcum+0;
                editor.putInt(Preference.PUNTOS, suma_puntos);
                editor.putInt(Preference.PUNTOSACUMULADOS, suma_puntosA);
                editor.commit();
            }
        }
    };


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.col_martes) {
            MediaPlayer mp = MediaPlayer.create(this, R.raw.tuesday);
            mp.start();
        }else if (v.getId() == R.id.col_jueves) {
            MediaPlayer mp = MediaPlayer.create(this, R.raw.thursday);
            mp.start();
        }else if (v.getId() == R.id.col_sabado) {
            MediaPlayer mp = MediaPlayer.create(this, R.raw.saturday);
            mp.start();
        }else if (v.getId() == R.id.col_viernes) {
            MediaPlayer mp = MediaPlayer.create(this, R.raw.friday);
            mp.start();
        }
    }

}
