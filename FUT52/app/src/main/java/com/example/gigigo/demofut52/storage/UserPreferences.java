package com.example.gigigo.demofut52.storage;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.gigigo.demofut52.beans.Player_Bean;

/**
 * Created by Davis on 4/23/15.
 */
public class UserPreferences {

    Context context;

    public UserPreferences(Context context) {
        this.context = context;
    }


    public static final String PREFS_NAME = "PLAYER_PREFS";

    public boolean addPreferences(Player_Bean user) {
        boolean userResult;

        SharedPreferences settings;
        SharedPreferences.Editor editor;
        settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE); //1
        editor = settings.edit(); //2
        try {

            editor.putString("id_team", user.getId_equipo());
            editor.putString("nombre", user.getNombre());
            editor.putString("jersey", user.getNum_jersey());
            editor.putString("equipo", user.getEquipo());
            editor.putString("img_team",user.getImg_team());



            editor.apply(); //4
            userResult = true;


        } catch (Exception e) {
            userResult = false;
        }
        return userResult;

    }

    public Player_Bean getPrefs() {
        Player_Bean prefs = new Player_Bean();
        SharedPreferences settings;


        settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);

        try {
            prefs.setId_equipo(settings.getString("id_team", null));
        } catch (Exception ignore) {
        }

        try {
            prefs.setNombre(settings.getString("nombre", null));
        } catch (Exception ignore) {
        }

        try {
            prefs.setNum_jersey(settings.getString("jersey", null));
        } catch (Exception ignore) {
        }

        try {
            prefs.setEquipo(settings.getString("equipo", null));
        } catch (Exception ignore) {
        }

        try{
            prefs.setImg_team(settings.getString("img_team",null));
        }catch (Exception e){

        }




        return prefs;
    }

    public boolean DeletePreferences(){
        boolean clear;
        try {
            SharedPreferences settings=context.getSharedPreferences(PREFS_NAME,Context.MODE_PRIVATE);

            settings.edit().remove("nombre").apply();
//            settings.edit().clear().apply();
            clear=true;
        }catch (Exception e){
            e.printStackTrace();
            clear=false;
        }
        return clear;
    }
}