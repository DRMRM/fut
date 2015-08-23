package com.example.gigigo.demofut52.fragments;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hectormaya on 22/06/15.
 */
public class Fragment_Adapter_Item_Header extends FragmentPagerAdapter {

    List <Fragment> fragments = new ArrayList<>();

    public Fragment_Adapter_Item_Header(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return fragments.get(i);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    public void addFragment(Fragment fragment){
        fragments.add(fragment);
    }
}
