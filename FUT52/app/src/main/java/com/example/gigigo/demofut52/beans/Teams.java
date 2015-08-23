package com.example.gigigo.demofut52.beans;

/**
 * Created by Davis on 6/23/15.
 */
public class Teams {

    private String name;
    //private String category;
    private String position;

    private String team_id;

    public String getTeam_id() {
        return team_id;
    }

    public void setTeam_id(String team_id) {
        this.team_id = team_id;
    }

    private String team_pj;
    private String team_pg;
    private String team_pe;
    private String team_pp;
    private String team_gf;
    private String team_gc;
    private String team_pts;

    public String getU_img() {
        return u_img;
    }

    public void setU_img(String u_img) {
        this.u_img = u_img;
    }

    private String u_img;

    public String getTeam_pj() {
        return team_pj;
    }

    public void setTeam_pj(String team_pj) {
        this.team_pj = team_pj;
    }

    public String getTeam_pg() {
        return team_pg;
    }

    public void setTeam_pg(String team_pg) {
        this.team_pg = team_pg;
    }

    public String getTeam_pe() {
        return team_pe;
    }

    public void setTeam_pe(String team_pe) {
        this.team_pe = team_pe;
    }

    public String getTeam_pp() {
        return team_pp;
    }

    public void setTeam_pp(String team_pp) {
        this.team_pp = team_pp;
    }

    public String getTeam_gf() {
        return team_gf;
    }

    public void setTeam_gf(String team_gf) {
        this.team_gf = team_gf;
    }

    public String getTeam_gc() {
        return team_gc;
    }

    public void setTeam_gc(String team_gc) {
        this.team_gc = team_gc;
    }

    public String getTeam_pts() {
        return team_pts;
    }

    public void setTeam_pts(String team_pts) {
        this.team_pts = team_pts;
    }



    public Teams(String team_id, String name,String u_img) {
        this.name = name;
        this.team_id=team_id;
        this.u_img=u_img;
    }

    /*
    * "eq_id":"22",
         "eq_nom":"REAL CATALUNA",
         "eq_jj":"3",
         "eq_jg":"3",
         "eq_je":"0",
         "eq_jp":"0",
         "eq_gf":"13",
         "eq_gc":"3",
         "eq_pts":"9"*/


    public Teams(String team_id, String name, String team_pj, String team_pg, String team_pe, String team_pp, String team_gf, String team_gc, String team_pts){

        this.team_id=team_id;
        this.name=name;
        this.team_pj=team_pj;
        this.team_pg=team_pg;
        this.team_pe=team_pe;
        this.team_pp=team_pp;
        this.team_gf=team_gf;
        this.team_gc=team_gc;
        this.team_pts=team_pts;
    }












    public Teams(String team_id, String name, String position, String team_pj, String team_pg, String team_pe, String team_pp, String team_gf, String team_gc, String team_pts) {
        this.name = name;
        this.team_id=team_id;
        this.position = position;
        this.team_pj = team_pj;
        this.team_pg = team_pg;
        this.team_pe = team_pe;
        this.team_pp = team_pp;
        this.team_gf = team_gf;
        this.team_gc = team_gc;
        this.team_pts = team_pts;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
