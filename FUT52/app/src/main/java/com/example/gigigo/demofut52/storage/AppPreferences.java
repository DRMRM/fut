package com.example.gigigo.demofut52.storage;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.gigigo.demofut52.beans.Player_Bean;
import com.example.gigigo.demofut52.utils.Constants;

/**
 * Created by Davis on 4/23/15.
 */
public class AppPreferences {

    Context context;

    public AppPreferences(Context context) {
        this.context = context;
    }


    public static final String PREFS_NAME = "APP_PREFS";

    public boolean addPreferences(int THEME) {
        boolean userResult;
        SharedPreferences settings;
        SharedPreferences.Editor editor;
        settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE); //1
        editor = settings.edit(); //2
        try {
            editor.putInt("theme", THEME);
            editor.apply(); //4
            userResult = true;
        } catch (Exception e) {
            userResult = false;
        }
        return userResult;
    }

    public int getTheme(int type) {

        SharedPreferences settings;
        int pref=0;
        settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);

        switch (type){
            case Constants.THEME:
                try {
                    pref=settings.getInt("theme",0);
                } catch (Exception ignore) {
                }
                break;

            case Constants.BACK:
                try {
                    pref=settings.getInt("back",0);
                } catch (Exception ignore) {
                }
                break;
        }
        return pref;
    }

    public boolean DeletePreferences(){
        boolean clear;
        try {
            SharedPreferences settings=context.getSharedPreferences(PREFS_NAME,Context.MODE_PRIVATE);

            settings.edit().remove("theme").apply();
//            settings.edit().clear().apply();
            clear=true;
        }catch (Exception e){
            e.printStackTrace();
            clear=false;
        }
        return clear;
    }
}