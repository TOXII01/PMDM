package com.hu.yunyang.examen_yunyanghu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements IEquipoListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentListado listado = (FragmentListado)getFragmentManager().findFragmentById(R.id.FrgListado);
        listado.setEquiposListener(this);

    }
    public void onEquipoSeleccionado(Equipo equipo) {
        boolean hayDetalle = (getFragmentManager().findFragmentById(R.id.FrgDetalle) != null);
        if(hayDetalle) {
            ((FragmentDetalle) getFragmentManager().findFragmentById(R.id.FrgDetalle)).mostarDetalle(equipo);
        } else {
            Intent i = new Intent(this, DetalleActivity.class);
            i.putExtra(DetalleActivity.TEXTO_EXTRA,equipo);
            startActivity(i);
        }
    }
}
