package com.example.gigigo.demofut52.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gigigo.demofut52.R;
import com.example.gigigo.demofut52.beans.Teams;
import com.example.gigigo.demofut52.utils.Utilities;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;

/**
 * Created by Davis on 6/30/15.
 */
public class Adapter_ListTeamsConfiguration extends BaseAdapter {

    ArrayList<Teams>items;
    Context context;
    public void setData(Context context, ArrayList<Teams>items){
        this.context=context;
        this.items=items;
    }


    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Teams getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView= LayoutInflater.from(context).inflate(R.layout.row_team,parent,false);

       TextView tx_team=(TextView)convertView.findViewById(R.id.tx_team);
        ImageView img_uniform=(ImageView)convertView.findViewById(R.id.img_uniform);

        try {tx_team.setText(items.get(position).getName());}catch (Exception e){}
        String url_uniform="";
        try {url_uniform="http://ramptors.net/fut52/uniforms/"+items.get(position).getU_img();}catch (Exception e){}
        ImageLoader.getInstance().displayImage(url_uniform,img_uniform, Utilities.initDownloadImage());

        return convertView;
    }
}
