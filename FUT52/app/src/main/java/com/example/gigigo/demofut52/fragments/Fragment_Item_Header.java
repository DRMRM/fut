package com.example.gigigo.demofut52.fragments;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gigigo.demofut52.R;

/**
 * Created by hectormaya on 22/06/15.
 */
public class Fragment_Item_Header extends Fragment {

    public static Fragment_Item_Header newInstance(){
        return new Fragment_Item_Header();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_item , container , false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
