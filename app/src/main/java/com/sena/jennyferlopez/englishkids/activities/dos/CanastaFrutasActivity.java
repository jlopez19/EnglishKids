package com.sena.jennyferlopez.englishkids.activities.dos;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.PointF;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.sena.jennyferlopez.englishkids.R;
import com.sena.jennyferlopez.englishkids.utils.Preference;

import java.util.List;

public class CanastaFrutasActivity extends AppCompatActivity {
    ImageView  vcg_e, vng_a, vng_i, v_uno, v_dos, v_tres, img_canasta;
    int cont_intentos=0, cont_good=0, cont_fail=0, id_user;

    private int modificarX=0;
    private int modificary=0;
    boolean detectView;
    float vca_x, vca_x1, vca_y, vca_y1, vca_h,  vca_l, vca_l1;
    float vce_x1, vce_y1, vce_l, vce_l1;
    float  vna_x1, vna_y1, vna_h, vna_l1;
    float  vni_x1, vni_y1, vni_h, vni_l1;
    float temp_x, temp_y;

    TextView tv_puntos, tv_nombre, tv_pAcumulados;
    int puntos, puntosAcum, avatarSeleccionado;
    private SharedPreferences.Editor editor;
    private SharedPreferences preferences;
    String userName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canasta_frutas);
        vcg_e= (ImageView) findViewById(R.id.orange_g);
        vng_a= (ImageView) findViewById(R.id.grapes_g);
        vng_i= (ImageView) findViewById(R.id.cherry_g);
        v_uno= (ImageView) findViewById(R.id.orange_b);
        v_dos= (ImageView) findViewById(R.id.grapes_b);
        v_tres= (ImageView) findViewById(R.id.cherry_b);
        img_canasta= (ImageView) findViewById(R.id.img_canasta);


        vcg_e.setOnTouchListener(handlerMover);
        vcg_e.setOnLongClickListener(detect);

        vng_a.setOnTouchListener(handlerMover);
        vng_a.setOnLongClickListener(detect);

        vng_i.setOnTouchListener(handlerMover);
        vng_i.setOnLongClickListener(detect);

        v_uno.setOnTouchListener(handlerMover);
        v_uno.setOnLongClickListener(detect);

        v_dos.setOnTouchListener(handlerMover);
        v_dos.setOnLongClickListener(detect);

        v_tres.setOnTouchListener(handlerMover);
        v_tres.setOnLongClickListener(detect);
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

        tv_puntos.setText(""+50);
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

            vca_x =img_canasta.getX();
            vca_y=img_canasta.getY();
            vca_h=img_canasta.getWidth();
            vca_l=img_canasta.getHeight();

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
                         if (id==R.id.orange_g){
                            temp_x = DownPT.x=vcg_e.getX();
                            temp_y = DownPT.y=vcg_e.getY();
                            contT=contT+1;
                        }else if (id==R.id.grapes_g){
                            temp_x = DownPT.x=vng_a.getX();
                            temp_y = DownPT.y=vng_a.getY();
                            contT=contT+1;
                        }else if (id==R.id.cherry_g){
                            temp_x = DownPT.x=vng_i.getX();
                            temp_y = DownPT.y=vng_i.getY();
                            contT=contT+1;
                        }else if (id==R.id.orange_b){
                            temp_x = DownPT.x=v_uno.getX();
                            temp_y = DownPT.y=v_uno.getY();
                            contT=contT+1;
                        }else if (id==R.id.grapes_b){
                            temp_x = DownPT.x=v_dos.getX();
                            temp_y = DownPT.y=v_dos.getY();
                            contT=contT+1;
                        }else if (id==R.id.cherry_b){
                            temp_x = DownPT.x=v_tres.getX();
                            temp_y = DownPT.y=v_tres.getY();
                            contT=contT+1;
                        }

                    }
                    break;
                case MotionEvent.ACTION_UP:

                    switch (v.getId()){


                        case R.id.orange_g:
                            vce_x1 =v.getX();
                            vce_y1=v.getY();
                            // vce_h1=v.getWidth();
                            vce_l1=v.getHeight();

                            if ((vca_x>=vce_x1 && vca_y >= vce_y1 && vca_y <= (vce_y1+vce_l1)) || ((vca_x+vca_h)>=vce_x1  && vca_y >= vce_y1 && vca_y <= (vce_y1+vce_l1))
                                    || (vca_x>=vce_x1 && (vca_y+vca_l) >= vce_y1 && (vca_y+vca_l) <= (vce_y1+vce_l1)) || ((vca_x+vca_h)>=vce_x1 && (vca_y+vca_l) >= vce_y1 && (vca_y+vca_l) <= (vce_y1+vce_l1))){
                                vcg_e.setVisibility(View.INVISIBLE);
                                cont_good=cont_good+1;
                                cont_intentos=cont_intentos+1;
                            }else{
                                vcg_e.setX(temp_x);
                                vcg_e.setY(temp_y);
                                cont_fail=cont_fail+1;
                                cont_intentos=cont_intentos+1;
                            }
                            break;

                        case R.id.grapes_g:
                            vna_x1 =v.getX();
                            vna_y1=v.getY();
                            // vca_h1=v.getWidth();
                            vna_l1=v.getHeight();

                            if ((vca_x>=vna_x1  && vca_y >= vna_y1 && vca_y <= (vna_y1+vna_l1)) || ((vca_x+vna_h)>=vna_x1  && vca_y >= vna_y1 && vca_y <= (vna_y1+vna_l1))
                                    || (vca_x>=vna_x1  && (vca_y+vca_l) >= vna_y1 && (vca_y+vca_l) <= (vna_y1+vna_l1)) || ((vca_x+vca_h)>=vna_x1  && (vca_y+vca_l) >= vna_y1 && (vca_y+vca_l) <= (vna_y1+vna_l1))){
                                vng_a.setVisibility(View.INVISIBLE);
                                cont_good=cont_good+1;
                                cont_intentos=cont_intentos+1;
                            }else{
                                vng_a.setX(temp_x);
                                vng_a.setY(temp_y);
                                cont_fail=cont_fail+1;
                                cont_intentos=cont_intentos+1;
                            }
                            break;

                        case R.id.cherry_g:
                            vni_x1 =v.getX();
                            vni_y1=v.getY();
                            //vci_h1=v.getWidth();
                            vni_l1=v.getHeight();

                            if ((vca_x>=vni_x1 && vca_y >= vni_y1 && vca_y <= (vni_y1+vni_l1)) || ((vca_x+vca_h)>=vni_x1  && vca_y >= vni_y1 && vca_y <= (vni_y1+vni_l1))
                                    || (vca_x>=vni_x1 && (vca_y+vca_l) >= vni_y1 && (vca_y+vca_l) <= (vni_y1+vni_l1)) || ((vca_x+vca_h)>=vni_x1 && (vca_y+vca_l) >= vni_y1 && (vca_y+vca_l) <= (vni_y1+vni_l1))){
                                vng_i.setVisibility(View.INVISIBLE);
                                cont_good=cont_good+1;
                                cont_intentos=cont_intentos+1;
                            }else{
                                vng_i.setX(temp_x);
                                vng_i.setY(temp_y);
                                cont_fail=cont_fail+1;
                                cont_intentos=cont_intentos+1;
                            }
                            break;

                        case R.id.orange_b:
                            v_uno.setX(temp_x);
                            v_uno.setY(temp_y);
                            cont_fail=cont_fail+1;
                            cont_intentos=cont_intentos+1;
                            break;
                        case R.id.grapes_b:
                            v_dos.setX(temp_x);
                            v_dos.setY(temp_y);
                            cont_fail=cont_fail+1;
                            cont_intentos=cont_intentos+1;
                            break;
                        case R.id.cherry_b:
                            v_tres.setX(temp_x);
                            v_tres.setY(temp_y);
                            cont_fail=cont_fail+1;
                            cont_intentos=cont_intentos+1;
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
        if (cont_good ==3) {
            finish();
        }if (cont_good==3 && cont_intentos ==3){
            editor.putInt(Preference.PUNTOS, 100);
            editor.commit();
        }else if (cont_good==3 && (cont_intentos >3 || cont_intentos <6)){
            editor.putInt(Preference.PUNTOS, 100);
            editor.commit();
        }else if (cont_good==3 && (cont_intentos >=6 || cont_intentos <=9)){
            editor.putInt(Preference.PUNTOS, 100);
            editor.commit();
        }else if (cont_good<3 && cont_intentos >9){
            editor.putInt(Preference.PUNTOS, 100);
            editor.commit();
        }
    }
};
}
