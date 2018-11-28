package com.hu.yunyang.examen_yunyanghu;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentListado extends Fragment {

    private RecyclerView rvListado;
    private Equipo[] equipos;
    private IEquipoListener listener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        Parser parser = new Parser(getActivity());
        if(parser.parse()) {
            this.equipos = parser.getEquipos();
        }
        return inflater.inflate(R.layout.fragment_listado,container,false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        rvListado = getView().findViewById(R.id.rvListado);
        AdaptadorEquipos adaptador = new AdaptadorEquipos(getActivity(),equipos);
        adaptador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onEquipoSeleccionado(equipos[rvListado.getChildAdapterPosition(v)]);
            }
        });
        rvListado.setAdapter(adaptador);
        rvListado.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
    }
    public void setEquiposListener(IEquipoListener listener) {
        this.listener = listener;
    }
}
