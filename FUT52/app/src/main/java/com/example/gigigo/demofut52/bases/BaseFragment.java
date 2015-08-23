package com.example.gigigo.demofut52.bases;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.example.gigigo.demofut52.R;


public class BaseFragment extends Fragment {


    public View findViewById(int resource){
         try{return getView().findViewById(resource);}catch (Exception e){return null;}
    }


    public void addFragmentToBackStack(Fragment fragment, String tag, int container){
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.slide_in_up, R.anim.slide_out_up, R.anim.slide_in_down, R.anim.slide_out_down);//, R.anim.pop_enter, R.anim.pop_exit);
        transaction.addToBackStack(tag);
        transaction.replace(container, fragment, tag).commit();
    }

    public void addFragmentToBackStack(Fragment fragment, String tag){
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.slide_in_up, R.anim.slide_out_up, R.anim.slide_in_down, R.anim.slide_out_down);
        transaction.addToBackStack(tag);
        transaction.replace(R.id.nav_contentframe, fragment, tag).commit();
    }




    public void replaceFragment(Fragment fragment, int container){
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.slide_in_up, R.anim.slide_out_up, R.anim.slide_in_down, R.anim.slide_out_down);
        transaction.replace(container, fragment).commit();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }


}
