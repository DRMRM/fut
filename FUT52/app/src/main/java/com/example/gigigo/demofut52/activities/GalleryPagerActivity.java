package com.example.gigigo.demofut52.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;

import com.example.gigigo.demofut52.R;
import com.example.gigigo.demofut52.adapters.Simple_Adapter_Gallerys;
import com.example.gigigo.demofut52.beans.Gallery_Bean;
import com.example.gigigo.demofut52.beans.GetArraysDummys;
import com.example.gigigo.demofut52.views.HackyViewPager;

import java.util.ArrayList;

public class GalleryPagerActivity extends Activity {

//	private static final String ISLOCKED_ARG = "isLocked";
	
	private ViewPager mViewPager;
	ArrayList<Gallery_Bean>gallerys;
	int position=0;

	
    @Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        mViewPager = (HackyViewPager) findViewById(R.id.view_pager);
		setContentView(mViewPager);
		
		Bundle b=getIntent().getExtras();
		if(b!=null){
			position=b.getInt("position");
		}
		Simple_Adapter_Gallerys adapterGallerys =new Simple_Adapter_Gallerys();
		try {
			gallerys = GetArraysDummys.getGallerys();
			if(gallerys.size()>0){
				adapterGallerys.setData(gallerys, GalleryPagerActivity.this);
				mViewPager.setAdapter(adapterGallerys);
				mViewPager.setCurrentItem(position);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (savedInstanceState != null) {
			//boolean isLocked = savedInstanceState.getBoolean(ISLOCKED_ARG, false);

			((HackyViewPager) mViewPager).setLocked(false);
		}
	}



	private boolean isViewPagerActive() {
    	return (mViewPager != null && mViewPager instanceof HackyViewPager);
    }
    
	@Override
	protected void onSaveInstanceState(@NonNull Bundle outState) {
		if (isViewPagerActive()) {
			outState.putBoolean("isLocked", ((HackyViewPager) mViewPager).isLocked());
    	}
		super.onSaveInstanceState(outState);
	}
    
}
