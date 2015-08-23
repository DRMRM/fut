package com.example.gigigo.demofut52.activities;


import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.gigigo.demofut52.R;
import com.example.gigigo.demofut52.bases.BaseActivity;
import com.example.gigigo.demofut52.utils.Utilities;
import com.example.gigigo.demofut52.views.CircleImageView;
import com.nostra13.universalimageloader.core.ImageLoader;

public class Activity_Detail extends BaseActivity {


    FloatingActionButton id_fab_detail;
    ImageView backdrop;
    CircleImageView img_uniform_detail;
    CoordinatorLayout main_content;
    String titulo="Titulo de fragment";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detail);
        backdrop=(ImageView)findViewById(R.id.backdrop);
        Bundle bundle=getIntent().getExtras();
        img_uniform_detail=(CircleImageView)findViewById(R.id.img_uniform_detail);
        main_content=(CoordinatorLayout)findViewById(R.id.main_content);

        if(bundle!=null){
            img_uniform_detail.setVisibility(View.GONE);
            ImageLoader.getInstance().displayImage(bundle.getString("url_img"),backdrop, Utilities.initDownloadImage());
            titulo=bundle.getString("titulo");
        }

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(titulo);
        id_fab_detail=(FloatingActionButton)findViewById(R.id.id_fab_detail);
        ImageLoader.getInstance().displayImage("http://ramptors.net/fut52/uniforms/rojo_negro.jpg",img_uniform_detail);


        id_fab_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
                sendIntent.setType("text/plain");
                startActivity(sendIntent);

            }
        });
    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()==android.R.id.home){
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
