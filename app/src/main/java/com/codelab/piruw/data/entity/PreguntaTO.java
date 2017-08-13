package com.codelab.piruw.data.entity;

import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Bryam Soto on 07/08/2017.
 */

public class PreguntaTO implements Serializable{

    private int id;
    private String pregunta;
    private String[] alternativas;
    private String respuesta;
    private int putaje;
    private String correcta;
    private boolean mezcla = false;

    public PreguntaTO(int id, String pregunta, String alt1, String alt2, String alt3, String alt4) {
        this.id = id;
        this.pregunta = pregunta;
        this.alternativas = new String[4];
        this.correcta = alt1;
        this.putaje = 0;
        this.respuesta = "";
        this.alternativas[0] = alt1;
        this.alternativas[1] = alt2;
        this.alternativas[2] = alt3;
        this.alternativas[3] = alt4;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public String[] getAlternativas() {
        return alternativas;
    }

    public void setAlternativas(String[] alternativas) {
        this.alternativas = alternativas;
    }

    public String getCorrecta() {
        return correcta;
    }

    public void setCorrecta(String correcta) {
        this.correcta = correcta;
    }

    public boolean isMezcla() {
        return mezcla;
    }

    public void setMezcla(boolean mezcla) {
        this.mezcla = mezcla;
    }

    public int getPutaje() {
        return putaje;
    }

    public void setPutaje(int putaje) {
        this.putaje = putaje;
    }
}