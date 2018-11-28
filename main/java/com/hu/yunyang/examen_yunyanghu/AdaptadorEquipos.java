package com.hu.yunyang.examen_yunyanghu;

import android.content.Context;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class AdaptadorEquipos extends RecyclerView.Adapter<AdaptadorEquipos.mi_ViewHolder> implements View.OnClickListener {
    private Equipo[] equipos;
    private Context context;
    private View.OnClickListener listener;

    public AdaptadorEquipos(Context context,Equipo[] equipos) {
        this.context = context;
        this.equipos = equipos;
    }
    public mi_ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.listitem_listado,viewGroup,false);
        itemView.setOnClickListener(this);
        mi_ViewHolder vh = new mi_ViewHolder(itemView,context);
        return vh;

    }
    public void onBindViewHolder(mi_ViewHolder viewHolder,int pos) {
        Equipo item = equipos[pos];
        viewHolder.bindEquipos(item);
    }
    public int getItemCount() {
        return equipos.length;
    }
    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }
    public void onClick(View v) {
        if(listener != null) {
            listener.onClick(v);
        }
    }
    static class mi_ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvId;
        private TextView tvNombre;
        private TextView tvPuntos;
        private ImageView ivEscudo;
        public mi_ViewHolder(View itemView, Context context) {
            super(itemView);
            tvId = itemView.findViewById(R.id.tvId);
            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvPuntos = itemView.findViewById(R.id.tvPuntos);
            ivEscudo = itemView.findViewById(R.id.ivEscudo);
        }
        public void bindEquipos(Equipo e) {
            /* Me faltaba pasar el Integer de la posicion a String */
           /* -----> */ tvId.setText(String.valueOf(e.getStats().getPosicion())); /* <------ */
            tvNombre.setText(e.getNombre());
            tvPuntos.setText(String.valueOf(e.getPuntos()));
            String escudo = e.getEscudo();
            int res = itemView.getContext().getResources().getIdentifier(escudo, "drawable", itemView.getContext().getPackageName());
            if(res != 0) {
                ivEscudo.setImageResource(res);
            }
        }
    }


}
