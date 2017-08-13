package com.codelab.piruw.data.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQliteHelper extends SQLiteOpenHelper {

    private String sqlCreatePreguntas =
            "CREATE TABLE PREGUNTAS (" +
                    "ID INTEGER PRIMARY KEY, " +
                    "PREGUNTA TEXT, " +
                    "ALT1 TEXT, " +
                    "ALT2 TEXT," +
                    "ALT3 TEXT," +
                    "ALT4 TEXT)";

    public SQliteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlCreatePreguntas);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS PREGUNTAS");
        db.execSQL(sqlCreatePreguntas);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onDowngrade(db, oldVersion, newVersion);
        db.execSQL("DROP TABLE IF EXISTS PREGUNTAS");
        db.execSQL(sqlCreatePreguntas);
    }
}
