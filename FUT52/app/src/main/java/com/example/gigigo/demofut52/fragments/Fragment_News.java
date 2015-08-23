package com.example.gigigo.demofut52.fragments;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.gigigo.demofut52.R;
import com.example.gigigo.demofut52.bases.BaseFragment;
import com.example.gigigo.demofut52.beans.News_Beans;
import com.example.gigigo.demofut52.conection.HttpConnectionRamptors;
import com.example.gigigo.demofut52.parserJSON.ParserJSON;
import com.example.gigigo.demofut52.recyclers_adapters.Adapter_News;
import com.example.gigigo.demofut52.utils.Constants;

import java.util.ArrayList;

/**
 * Created by Davis on 6/30/15.
 */
public class Fragment_News extends BaseFragment {


    RecyclerView recycler_team_list;
    ProgressDialog pDialog;
    Adapter_News adapter_news;

    public static Fragment_News getInstace(){
        Fragment_News fragment=new Fragment_News();

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return LayoutInflater.from(getActivity()).inflate(R.layout.fragment_team_list,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        new getNews().execute();
        recycler_team_list=(RecyclerView)findViewById(R.id.recycler_team_list);
        LinearLayoutManager manager=new LinearLayoutManager(getActivity());
        recycler_team_list.setLayoutManager(manager);
    }

    private class getNews extends AsyncTask<Void, Void, ArrayList<News_Beans>>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog=new ProgressDialog(getActivity());
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(false);
            pDialog.setMessage("Cargando noticias");
            pDialog.show();
        }

        @Override
        protected void onPostExecute(ArrayList<News_Beans> news_beanses) {
            super.onPostExecute(news_beanses);
           pDialog.dismiss();
            if(news_beanses.size()>0){
                adapter_news=new Adapter_News(news_beanses,getActivity());
                recycler_team_list.setAdapter(adapter_news);
                adapter_news.notifyDataSetChanged();
                recycler_team_list.setItemAnimator(new DefaultItemAnimator());
            }
        }

        @Override
        protected ArrayList<News_Beans> doInBackground(Void... params) {
            String JSON= HttpConnectionRamptors.getResponseRamptorsHttp(Constants.URL_NEWS);
            return ParserJSON.getNews(JSON);
        }
    }

}
