package com.hu.yunyang.examen_yunyanghu;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;

public class Parser {
    private Equipo[] equipos;
    private Stats[] estadisticas;
    private InputStream  equiposFile;

    public Parser(Context c) {
        this.equiposFile = c.getResources().openRawResource(R.raw.equipos);
    }
    public boolean parse() {
        boolean parsed = false;
        String jsonEquipos = null;
        equipos = null;
        try {
            int equiposSize = equiposFile.available();
            byte[] buffer = new byte[equiposSize];
            equiposFile.read(buffer);
            equiposFile.close();
            jsonEquipos = new String(buffer, "UTF-8");
            JSONTokener tokener = new JSONTokener(jsonEquipos);
            JSONArray array = new JSONArray(tokener);
            equipos = new Equipo[array.length()];
            estadisticas = new Stats[array.length()];
            for(int i = 0; i < array.length();i++) {
                JSONObject equipo = array.getJSONObject(i);
                int id = equipo.getInt("id");
                String nombre = equipo.getString("nombre");
                String escudo = equipo.getString("escudo");
                Stats s = null;
                JSONObject stats = equipo.getJSONObject("stats");
                int posicion = stats.getInt("posicion");
                int jugados = stats.getInt("jugados");
                int ganados = stats.getInt("ganados");
                int empatados = stats.getInt("empatados");
                int perdidos = stats.getInt("perdidos");
                int golesAFavor = stats.getInt("golesAFavor");
                int golesEnContra = stats.getInt("golesEnContra");
                //s = new Stats();
                estadisticas[posicion - 1] = new Stats(posicion,jugados,ganados,empatados,perdidos,golesAFavor,golesEnContra);
                equipos[posicion - 1] = new Equipo(id,nombre,escudo,estadisticas[posicion - 1]);
            }
            parsed = true;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return parsed;
    }
    public Equipo[] getEquipos() {
        return this.equipos;
    }


}
