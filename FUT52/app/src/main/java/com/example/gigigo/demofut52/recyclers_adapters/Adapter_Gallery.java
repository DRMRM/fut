package com.example.gigigo.demofut52.recyclers_adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gigigo.demofut52.R;
import com.example.gigigo.demofut52.activities.GalleryPagerActivity;
import com.example.gigigo.demofut52.beans.Gallery_Bean;
import com.example.gigigo.demofut52.utils.Utilities;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.ArrayList;

/**
 * Created by Davis on 7/2/15.
 */
public class Adapter_Gallery extends RecyclerView.Adapter<Adapter_Gallery.ViewHolder>{

    ArrayList<Gallery_Bean>items;
    public Adapter_Gallery(ArrayList<Gallery_Bean>items,Context context) {
        this.items=items;
        if(!ImageLoader.getInstance().isInited()){
            ImageLoader.getInstance().init(ImageLoaderConfiguration.createDefault(context));
        }
    }

    @Override
    public Adapter_Gallery.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLayout=LayoutInflater.from(parent.getContext()).inflate(R.layout.row_gallery,parent,false);
        return new ViewHolder(itemLayout);
    }

    @Override
    public void onBindViewHolder(Adapter_Gallery.ViewHolder holder, int position) {
        Gallery_Bean gallery=items.get(position);
        ImageLoader.getInstance().displayImage(gallery.getUrl_img(),holder.img_galery, Utilities.initDownloadImage());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder{
        TextView tx_title_g;
        ImageView img_galery;


        public ViewHolder(final View itemView) {
            super(itemView);
            img_galery=(ImageView)itemView.findViewById(R.id.img_galery);
            tx_title_g=(TextView)itemView.findViewById(R.id.tx_title_g);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i=new Intent(itemView.getContext(), GalleryPagerActivity.class);
                    i.putExtra("position",getLayoutPosition());
                    itemView.getContext().startActivity(i);
                }
            });
        }
    }
}