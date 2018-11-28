package com.hu.yunyang.examen_yunyanghu;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class DetalleActivity extends AppCompatActivity {
    public static final String TEXTO_EXTRA = "com.yunyang.hu.fragments.EXTRA_TEXTO";
    private Equipo e;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        FragmentDetalle detalle = ((FragmentDetalle)getFragmentManager().findFragmentById(R.id.FrgDetalle));
        e = (Equipo) getIntent().getSerializableExtra(TEXTO_EXTRA);
        detalle.mostarDetalle(e);
    }
}
