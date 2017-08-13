package com.codelab.piruw.data.database;

import android.content.Context;

/**
 * Created by Bryam Soto on 12/08/2017.
 */

public class LocalData {

    private static SQliteManager db;

    public static void load(Context context) {

        db = new SQliteManager(context);

        db.insertPregunta(1, "A", "1", "2", "3", "4");
        db.insertPregunta(2, "B", "1", "2", "3", "4");
        db.insertPregunta(3, "C", "1", "2", "3", "4");
        db.insertPregunta(4, "D", "1", "2", "3", "4");
        db.insertPregunta(5, "E", "1", "2", "3", "4");
        db.insertPregunta(6, "F", "1", "2", "3", "4");
        db.insertPregunta(7, "G", "1", "2", "3", "4");
        db.insertPregunta(8, "H", "1", "2", "3", "4");
        db.insertPregunta(9, "I", "1", "2", "3", "4");
        db.insertPregunta(10, "J", "1", "2", "3", "4");
        db.insertPregunta(11, "K", "1", "2", "3", "4");
        db.insertPregunta(12, "L", "1", "2", "3", "4");
        db.insertPregunta(13, "M", "1", "2", "3", "4");
        db.insertPregunta(14, "N", "1", "2", "3", "4");
        db.insertPregunta(15, "Ñ", "1", "2", "3", "4");
        db.insertPregunta(16, "O", "1", "2", "3", "4");
        db.insertPregunta(17, "P", "1", "2", "3", "4");
        db.insertPregunta(18, "R", "1", "2", "3", "4");
        db.insertPregunta(19, "S", "1", "2", "3", "4");
        db.insertPregunta(20, "T", "1", "2", "3", "4");
        db.insertPregunta(21, "U", "1", "2", "3", "4");
        db.insertPregunta(22, "V", "1", "2", "3", "4");
        db.insertPregunta(23, "W", "1", "2", "3", "4");
        db.insertPregunta(24, "X", "1", "2", "3", "4");
        db.insertPregunta(25, "Y", "1", "2", "3", "4");
        db.insertPregunta(26, "Z", "1", "2", "3", "4");

    }
}
