package com.hu.yunyang.examen_yunyanghu;

import java.io.Serializable;

public class Equipo implements Serializable {
    private int id;
    private String nombre;
    private String escudo;
    private Stats stats;

    public Equipo(int id, String nombre,String escudo, Stats stats) {
        this.id = id;
        this.nombre = nombre;
        this.escudo = escudo;
        this.stats = stats;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEscudo() {
        return escudo;
    }

    public Stats getStats() {
        return stats;
    }
    public int getPosicion() {
        return this.stats.getPosicion();
    }
    public int getPuntos() {
        int ganados = this.stats.getGanados() * 3;
        int empatados = this.stats.getEmpatados();
        int total = ganados + empatados;
        return total;
    }

}
