package com.hu.yunyang.examen_yunyanghu;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.widget.TextView;

public class FragmentDetalle extends Fragment {
    private TextView tvJugados;
    private TextView tvGanados;
    private TextView tvPerdidos;
    private TextView tvEmpatados;
    private TextView tvAFavor;
    private TextView tvEnContra;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_detalle,container,false);

        tvJugados = layout.findViewById(R.id.tvJugados);
        tvGanados = layout.findViewById(R.id.tvGanados);
        tvPerdidos = layout.findViewById(R.id.tvPerdidos);
        tvEmpatados = layout.findViewById(R.id.tvEmpatados);
        tvAFavor = layout.findViewById(R.id.tvAFavor);
        tvEnContra = layout.findViewById(R.id.tvEnContra);
        return layout;
    }
    public void mostarDetalle(Equipo e) {
        /* Faltaba la conversión de Integer a String, EN TODOS */
        tvJugados.setText(String.valueOf(e.getStats().getJugados()));
        tvGanados.setText(String.valueOf(e.getStats().getGanados()));
        tvEmpatados.setText(String.valueOf(e.getStats().getEmpatados()));
        tvPerdidos.setText(String.valueOf(e.getStats().getPerdidos()));
        tvAFavor.setText(String.valueOf(e.getStats().getGolesAFavor()));
        tvEnContra.setText(String.valueOf(e.getStats().getGolesEnContra()));
    }
}
