package com.example.gigigo.demofut52.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gigigo.demofut52.R;
import com.example.gigigo.demofut52.bases.BaseFragment;
import com.example.gigigo.demofut52.beans.Gallery_Bean;
import com.example.gigigo.demofut52.beans.GetArraysDummys;
import com.example.gigigo.demofut52.recyclers_adapters.Adapter_Gallery;

import java.util.ArrayList;

/**
 * Created by Davis on 7/2/15.
 */
public class Fragment_Gallery  extends BaseFragment{

    RecyclerView recycler_team_list;
    ArrayList<Gallery_Bean>items;
    Adapter_Gallery adapter;
    public static Fragment_Gallery getInstace(){
        Fragment_Gallery fragment=new Fragment_Gallery();

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
        items= GetArraysDummys.getGallerys();
        recycler_team_list=(RecyclerView)findViewById(R.id.recycler_team_list);

        adapter=new Adapter_Gallery(items,getActivity());
        GridLayoutManager manager=new GridLayoutManager(getActivity(),2);
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if(position%3==0){
                    return 2;
                }else {return 1;}
            }
        });

        recycler_team_list.setLayoutManager(manager);
        recycler_team_list.setAdapter(adapter);
        recycler_team_list.setItemAnimator(new DefaultItemAnimator());
    }
}