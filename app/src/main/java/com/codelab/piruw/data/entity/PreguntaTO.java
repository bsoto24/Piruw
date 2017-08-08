package com.codelab.piruw.data.entity;

import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Bryam Soto on 07/08/2017.
 */

public class PreguntaTO implements Serializable{

    private String pregunta;
    private String[] alternativas;
    private String respuesta;
    private String correcta;
    private int imagen;
    private boolean mezcla = false;

    public PreguntaTO(String pregunta, String alt1, String alt2, String alt3, String alt4, int imagen) {
        this.pregunta = pregunta;
        this.imagen = imagen;
        this.alternativas = new String[4];
        this.correcta = alt1;
        this.respuesta = "";
        this.alternativas[0] = alt1;
        this.alternativas[1] = alt2;
        this.alternativas[2] = alt3;
        this.alternativas[3] = alt4;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
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
}
