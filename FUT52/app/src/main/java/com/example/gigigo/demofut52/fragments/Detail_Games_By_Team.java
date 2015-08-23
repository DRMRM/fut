package com.example.gigigo.demofut52.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gigigo.demofut52.R;
import com.example.gigigo.demofut52.bases.BaseFragment;

/**
 * Created by Davis on 6/30/15.
 */
public class Detail_Games_By_Team extends BaseFragment {

   public static final String ID_TEAM="id_team";

    public static Detail_Games_By_Team getInstance(String id_team){
        Detail_Games_By_Team fragment=new Detail_Games_By_Team();
        Bundle args=new Bundle();
        args.putString(ID_TEAM,id_team);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return LayoutInflater.from(getActivity()).inflate(R.layout.fragment_games_by_team,container,false);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
