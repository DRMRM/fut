package com.example.gigigo.demofut52.fragments;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.gigigo.demofut52.R;
import com.example.gigigo.demofut52.bases.BaseFragment;
import com.example.gigigo.demofut52.beans.Teams;
import java.util.ArrayList;

public class Fragment_Home extends BaseFragment {


    public static Fragment_Home getInstance(boolean isLogin){
        Fragment_Home menuFragment = new Fragment_Home();
        // Bundle args = new Bundle();
        // args.putBoolean(ARG1,isLogin);
        // menuFragment.setArguments(args);
        return menuFragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return LayoutInflater.from(getActivity()).inflate(R.layout.fragment_home,container,false);

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ViewPager viewPager = (ViewPager) getActivity().findViewById(R.id.viewpager_home);


        Fragment_Adapter_Item_Header adaper = new Fragment_Adapter_Item_Header(getChildFragmentManager());

        for (int i = 0 ; i < 8 ; i++){
            adaper.addFragment(Fragment_Item_Header.newInstance());
        }

        viewPager.setAdapter(adaper);

        adaper.notifyDataSetChanged();

        Teams t=null;
        ArrayList<Teams>items=new ArrayList<>();


        for (int i = 0 ; i < 50 ; i++){

            t=new Teams("America "+i," Equipo"+i, " "+i,"","","","","","");
            items.add(t);


        }


      /*  LinearLayoutManager manager=new LinearLayoutManager(getActivity());

        /*manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return (3 - position % 3);
            }
        });


        recyclerView.setLayoutManager(manager);


        recyclerView.setAdapter(adapter);

        recyclerView.setItemAnimator(new DefaultItemAnimator());*/

    }

}
