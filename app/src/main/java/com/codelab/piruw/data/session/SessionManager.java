package com.codelab.piruw.data.session;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManager {

    private static final String PREFERENCE_NAME = "piruw_preference";
    private int PRIVATE_MODE = 0;

    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    private Context context;
    private static SessionManager sessionManager;

    /**
     * DECLARACION DE VARIABLES ESTATICAS
     */

    public static final String APP_CREATED = "appCreated";

    public static SessionManager getInstance(Context context){
        if(sessionManager == null){
            sessionManager = new SessionManager(context);
        }
        return sessionManager;
    }

    private SessionManager(Context context) {
        this.context = context;
        preferences = context.getSharedPreferences(PREFERENCE_NAME, PRIVATE_MODE);
        editor = preferences.edit();
    }

    /**
     * METODOS GET Y SET DE LAS VARIABLES ESTATICAS
     */

    public void setAppCreated(boolean appCreated) {
        editor.putBoolean(APP_CREATED, appCreated);
        editor.commit();
    }

    public boolean getAppCreated() {
        return preferences.getBoolean(APP_CREATED, false);
    }

}
