package com.hu.yunyang.examen_yunyanghu;

import java.io.Serializable;

public class Stats implements Serializable{
    private int posicion;
    private int jugados;
    private int ganados;
    private int empatados;
    private int perdidos;
    private int golesAFavor;
    private int golesEnContra;
   public Stats(int posicion,int jugados,int ganados,int empatados,int perdidos,
                int golesAFavor,int golesEnContra) {
       this.posicion = posicion;
       this.jugados = jugados;
       this.ganados = ganados;
       this.empatados = empatados;
       this.perdidos = perdidos;
       this.golesAFavor = golesAFavor;
       this.golesEnContra = golesEnContra;
   }

    public int getPosicion() {
        return posicion;
    }

    public int getJugados() {
        return jugados;
    }

    public int getEmpatados() {
        return empatados;
    }

    public int getGanados() {
        return ganados;
    }

    public int getGolesAFavor() {
        return golesAFavor;
    }

    public int getPerdidos() {
        return perdidos;
    }

    public int getGolesEnContra() {
        return golesEnContra;
    }
}
