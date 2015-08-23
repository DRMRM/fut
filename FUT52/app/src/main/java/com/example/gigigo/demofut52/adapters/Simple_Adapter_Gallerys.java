package com.example.gigigo.demofut52.adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.gigigo.demofut52.beans.Gallery_Bean;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.ArrayList;

import uk.co.senab.photoview.PhotoView;

/**
 * Created by Davis on 5/19/15.
 */
public class Simple_Adapter_Gallerys extends PagerAdapter {

    ArrayList<Gallery_Bean>items;
    Context context;
    public void setData(ArrayList<Gallery_Bean>items,Context context){
        this.context=context;
        this.items=items;
        if(!ImageLoader.getInstance().isInited()){
            ImageLoader.getInstance().init(ImageLoaderConfiguration.createDefault(context));
        }
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public View instantiateItem(ViewGroup container, int position) {

        Gallery_Bean imageEvent=items.get(position);

        String titulo=imageEvent.getTitle_g();



        PhotoView photoView = new PhotoView(container.getContext());
        try {
            ImageLoader.getInstance().displayImage(imageEvent.getUrl_img(), photoView);

        }catch (Exception e){e.printStackTrace();}


        LinearLayout layout=new LinearLayout(context);
        LinearLayout layout_text=new LinearLayout(context);
        layout_text.setOrientation(LinearLayout.VERTICAL);

        LinearLayout.LayoutParams params_text=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params_text.setMargins(0,-200,0,0);

        layout_text.setLayoutParams(params_text);


        TextView tx_titulo=new TextView(container.getContext());
       // tx_titulo.setPadding(150, 0, 0, 0);
        tx_titulo.setText(titulo);
        tx_titulo.setTextSize(25);
        tx_titulo.setTextColor(container.getContext().getResources().getColor(android.R.color.white));
        layout_text.addView(tx_titulo);

        TextView tx_descripcion=new TextView(container.getContext());
        //tx_descripcion.setPadding(150,0,0,0);

        layout_text.addView(tx_descripcion);
        tx_descripcion.setTextSize(20);
        tx_descripcion.setTextColor(container.getContext().getResources().getColor(android.R.color.white));

        layout.setOrientation(LinearLayout.VERTICAL);


        layout.addView(photoView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT );

        layout_text.bringToFront();
        layout.addView(layout_text);

        container.addView(layout);


        return layout;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
