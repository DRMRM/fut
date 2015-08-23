package com.example.gigigo.demofut52.parserJSON;

import com.example.gigigo.demofut52.beans.News_Beans;
import com.example.gigigo.demofut52.beans.Teams;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by principal on 29/06/15.
 */
public class ParserJSON {


    public static ArrayList<Teams>getArrayTeams(String JSON){
        ArrayList<Teams>items=new ArrayList<>();
        JSONArray array;
        JSONObject object;
        Teams team=null;

        try {
            object=new JSONObject(JSON);

            array=object.getJSONArray("equipo");

            for (int i=0; i<array.length(); i++){
                team=new Teams(array.getJSONObject(i).getString("eq_id"),array.getJSONObject(i).getString("eq_nom"),array.getJSONObject(i).getString("u_img"));
                items.add(team);
                team=null;
            }

        }catch (Exception e){
        }


        return items;
    }

    public static ArrayList<Teams>getArrayTeamsPositions(String JSON){
        ArrayList<Teams>items=new ArrayList<>();
        JSONArray array;
        JSONObject object;
        Teams team=null;

        try {
            object=new JSONObject(JSON);

            array=object.getJSONArray("equipo");

            for (int i=0; i<array.length(); i++){
team=new Teams(array.getJSONObject(i).getString("eq_id"),array.getJSONObject(i).getString("eq_nom"),array.getJSONObject(i).getString("eq_jj"),array.getJSONObject(i).getString("eq_jg"),
        array.getJSONObject(i).getString("eq_je"),array.getJSONObject(i).getString("eq_jp"),array.getJSONObject(i).getString("eq_gf"),array.getJSONObject(i).getString("eq_gc"),array.getJSONObject(i).getString("eq_pts"));
                items.add(team);
                team=null;
            }

        }catch (Exception e){
        }
        return items;
    }

    public static ArrayList<News_Beans>getNews(String JSON){
        JSONArray array;
        JSONObject object;
        ArrayList<News_Beans>items=new ArrayList<>();
        News_Beans news_beans=null;

        try {
            object=new JSONObject(JSON);
            array=object.getJSONArray("News");
            //, , , ,
            for(int i=0; i<array.length(); i++){
                news_beans=new News_Beans(array.getJSONObject(i).getString("id_new"),
                        array.getJSONObject(i).getString("title_new"),
                        array.getJSONObject(i).getString("url_img_news"),
                        array.getJSONObject(i).getString("news_description"),
                        array.getJSONObject(i).getString("content_new"));
                items.add(news_beans);
                news_beans=null;
            }

        }catch (Exception e){}

        return  items;
    }



}
