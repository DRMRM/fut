package com.example.gigigo.demofut52.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.gigigo.demofut52.R;
import com.example.gigigo.demofut52.bases.BaseFragment;
import com.example.gigigo.demofut52.beans.GetArraysDummys;
import com.example.gigigo.demofut52.beans.Teams;
import com.example.gigigo.demofut52.recyclers_adapters.Adapter_Next_Match;
import com.example.gigigo.demofut52.recyclers_adapters.Adapter_Previous_Match;
import com.example.gigigo.demofut52.utils.Constants;

import java.util.ArrayList;

/**
 * Created by Davis on 6/29/15.
 */
public class Fragment_Result_Pager extends BaseFragment {


    ArrayList<Teams>items1,items2;
    static String STYPE;
    RecyclerView recycler_team_list;


    public static Fragment_Result_Pager getInstance(String type){
        Fragment_Result_Pager menuFragment = new Fragment_Result_Pager();
         Bundle args = new Bundle();
         args.putString(STYPE, type);
         menuFragment.setArguments(args);
        return menuFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return LayoutInflater.from(getActivity()).inflate(R.layout.fragment_team_list,container,false);
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        items1= GetArraysDummys.getPrev();
        items2= GetArraysDummys.getProx();


        Adapter_Previous_Match adapter_previous_match=new Adapter_Previous_Match(items1);
        Adapter_Next_Match adapter_next_match=new Adapter_Next_Match(items2);

        recycler_team_list=(RecyclerView)findViewById(R.id.recycler_team_list);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        recycler_team_list.setLayoutManager(manager);

            if(getArguments().getString(STYPE).equals(Constants.PREVIOUS)){
            recycler_team_list.setAdapter(adapter_previous_match);
            }else {
            recycler_team_list.setAdapter(adapter_next_match);
        }



    }
}
