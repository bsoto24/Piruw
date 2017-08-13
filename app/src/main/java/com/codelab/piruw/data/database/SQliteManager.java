package com.codelab.piruw.data.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.codelab.piruw.data.entity.PreguntaTO;

import java.util.ArrayList;

public class SQliteManager {

    private String TAG = getClass().getSimpleName();
    private SQLiteDatabase db;
    private SQliteHelper helper;


    public SQliteManager(Context context) {
        helper = new SQliteHelper(context, "Piruw", null, 1);
        db = helper.getWritableDatabase();
    }

    public void insertPregunta(int id, String pregunta, String alt1, String alt2, String alt3, String alt4) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("ID", id);
        contentValues.put("PREGUNTA", pregunta);
        contentValues.put("ALT1", alt1);
        contentValues.put("ALT2", alt2);
        contentValues.put("ALT3", alt3);
        contentValues.put("ALT4", alt4);
        db.insert("PREGUNTAS", null, contentValues);
    }

    public ArrayList<PreguntaTO> getPreguntas() {
        ArrayList<PreguntaTO> preguntas = new ArrayList<>();
        Cursor c = db.rawQuery("SELECT * FROM PREGUNTAS ORDER BY RANDOM() LIMIT 10", null);
        if (c.moveToFirst()) {
            do {
                PreguntaTO preguntaTO = new PreguntaTO(c.getInt(0), c.getString(1), c.getString(2), c.getString(3), c.getString(4), c.getString(5));
                preguntas.add(preguntaTO);
            } while (c.moveToNext());
        }
        return preguntas;
    }

}
