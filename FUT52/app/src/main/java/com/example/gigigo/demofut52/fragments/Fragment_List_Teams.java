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

import com.example.gigigo.demofut52.R;
import com.example.gigigo.demofut52.bases.BaseFragment;
import com.example.gigigo.demofut52.beans.Teams;
import com.example.gigigo.demofut52.conection.HttpConnectionRamptors;
import com.example.gigigo.demofut52.parserJSON.ParserJSON;
import com.example.gigigo.demofut52.recyclers_adapters.Adapter_Teams_List;

import java.util.ArrayList;

/**
 * Created by Davis on 6/29/15.
 */
public class Fragment_List_Teams extends BaseFragment{

    RecyclerView recycler_team_list;
    ProgressDialog pDialog;

    public static Fragment_List_Teams getInstance(boolean isLogin){
        Fragment_List_Teams menuFragment = new Fragment_List_Teams();
        // Bundle args = new Bundle();
        // args.putBoolean(ARG1,isLogin);
        // menuFragment.setArguments(args);
        return menuFragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_team_list,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        recycler_team_list=(RecyclerView)findViewById(R.id.recycler_team_list);

        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        recycler_team_list.setLayoutManager(manager);
        new getTeams().execute();
    }





    private class getTeams extends AsyncTask<Void,Void,ArrayList<Teams>>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog=new ProgressDialog(getActivity());
            pDialog.setMessage("Cargando...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(false);
            pDialog.show();
        }

        @Override
        protected ArrayList<Teams> doInBackground(Void... params) {
            String JSON= HttpConnectionRamptors.getResponseRamptorsHttp("http://ramptors.net/fut52/services/teams/teams_list.php");
            return ParserJSON.getArrayTeams(JSON);
        }

        @Override
        protected void onPostExecute(ArrayList<Teams> teamses) {
            super.onPostExecute(teamses);
            pDialog.dismiss();
            if(teamses.size()>0){
                Adapter_Teams_List adapter =new Adapter_Teams_List(teamses);
                recycler_team_list.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                recycler_team_list.setItemAnimator(new DefaultItemAnimator());
            }
        }
    }
}