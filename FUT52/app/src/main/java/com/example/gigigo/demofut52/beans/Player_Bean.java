package com.example.gigigo.demofut52.beans;

/**
 * Created by Davis on 6/29/15.
 */
public class Player_Bean {

    private String nombre;
    private String equipo;
    private String id_equipo;
    private String img_team;


    public Player_Bean() {
    }

    public String getImg_team() {
        return img_team;
    }

    public void setImg_team(String img_team) {
        this.img_team = img_team;
    }

    public Player_Bean(String id_equipo, String nombre, String num_jersey,  String equipo ,String img_team) {
        this.nombre = nombre;
        this.equipo = equipo;
        this.id_equipo = id_equipo;
        this.num_jersey = num_jersey;
        this.img_team=img_team;

    }

    public String getId_equipo() {

        return id_equipo;
    }

    public void setId_equipo(String id_equipo) {
        this.id_equipo = id_equipo;
    }

    private String num_jersey;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public String getNum_jersey() {
        return num_jersey;
    }

    public void setNum_jersey(String num_jersey) {
        this.num_jersey = num_jersey;
    }
}
