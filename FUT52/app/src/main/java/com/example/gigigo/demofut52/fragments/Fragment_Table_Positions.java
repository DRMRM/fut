package com.example.gigigo.demofut52.fragments;

import android.app.ProgressDialog;
import android.graphics.Point;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.gigigo.demofut52.R;
import com.example.gigigo.demofut52.bases.BaseFragment;
import com.example.gigigo.demofut52.beans.Teams;
import com.example.gigigo.demofut52.conection.HttpConnectionRamptors;
import com.example.gigigo.demofut52.parserJSON.ParserJSON;
import com.example.gigigo.demofut52.recyclers_adapters.Adapter_Position_Teams;
import com.example.gigigo.demofut52.utils.Constants;
import com.example.gigigo.demofut52.utils.Device;

import java.util.ArrayList;

/**
 * Created by Davis on 6/29/15.
 */
public class Fragment_Table_Positions extends BaseFragment {

    RecyclerView recycler_team_list;
    LinearLayout container_header_recyclerview;
    Adapter_Position_Teams adapter;
    ProgressDialog pDialog;
    LinearLayout.LayoutParams params_data, params_team;
    Point size;

    LinearLayout linear_p,linear_e, linear_pj, linear_pg, linear_pe, linear_pp, linear_gf, linear_gc, linear_pts;


    public static Fragment_Table_Positions getInstance(boolean isLogin){
        Fragment_Table_Positions tableFragment = new Fragment_Table_Positions();
        //  Bundle args = new Bundle();
        //  args.putBoolean(ARG1,isLogin);
        //  menuFragment.setArguments(args);
        return tableFragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return LayoutInflater.from(getActivity()).inflate(R.layout.fragment_team_list,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        container_header_recyclerview=(LinearLayout)findViewById(R.id.container_header_recyclerview);
        View header=LayoutInflater.from(getActivity()).inflate(R.layout.header_table_positions,null,false);
        container_header_recyclerview.addView(header);
        recycler_team_list=(RecyclerView)findViewById(R.id.recycler_team_list);
        size= Device.getSizeScreen(getActivity());
        params_data=new LinearLayout.LayoutParams(size.x/12, ViewGroup.LayoutParams.WRAP_CONTENT);
        params_team=new LinearLayout.LayoutParams((size.x/12*4), ViewGroup.LayoutParams.WRAP_CONTENT);

        linear_p =(LinearLayout)header.findViewById(R.id.linear_p);linear_p.setLayoutParams(params_data);
        linear_e=(LinearLayout)header.findViewById(R.id.linear_e);linear_e.setLayoutParams(params_team);
        linear_pj=(LinearLayout)header.findViewById(R.id.linear_pj);linear_pj.setLayoutParams(params_data);
        linear_pg=(LinearLayout)header.findViewById(R.id.linear_pg);linear_pg.setLayoutParams(params_data);
        linear_pe=(LinearLayout)header.findViewById(R.id.linear_pe);linear_pe.setLayoutParams(params_data);
        linear_pp=(LinearLayout)header.findViewById(R.id.linear_pp);linear_pp.setLayoutParams(params_data);
        linear_gf=(LinearLayout)header.findViewById(R.id.linear_gf);linear_gf.setLayoutParams(params_data);
        linear_gc=(LinearLayout)header.findViewById(R.id.linear_gc);linear_gc.setLayoutParams(params_data);
        linear_pts=(LinearLayout)header.findViewById(R.id.linear_pts);linear_pts.setLayoutParams(params_data);




        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        recycler_team_list.setLayoutManager(manager);
        new getTeamsPositions().execute();


    }

    private class getTeamsPositions extends AsyncTask<Void,Void,ArrayList<Teams>> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(getActivity());
            pDialog.setMessage("Cargando Equipos");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(false);
            pDialog.show();
        }

        @Override
        protected ArrayList<Teams> doInBackground(Void... params) {
            String JSON = HttpConnectionRamptors.getResponseRamptorsHttp(Constants.URL_TABLE_POSITIONS);
            return ParserJSON.getArrayTeamsPositions(JSON);
        }

        @Override
        protected void onPostExecute(ArrayList<Teams> teamses) {
            super.onPostExecute(teamses);
            pDialog.dismiss();
            if (teamses.size() > 0) {
                adapter=new Adapter_Position_Teams(teamses,getActivity());
                recycler_team_list.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                recycler_team_list.setItemAnimator(new DefaultItemAnimator());
            }

        }
    }

}
