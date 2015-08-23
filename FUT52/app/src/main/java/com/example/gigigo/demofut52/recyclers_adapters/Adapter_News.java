package com.example.gigigo.demofut52.recyclers_adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gigigo.demofut52.R;
import com.example.gigigo.demofut52.activities.Activity_Detail;
import com.example.gigigo.demofut52.beans.News_Beans;
import com.example.gigigo.demofut52.utils.Device;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.ArrayList;

/**
 * Created by Davis on 6/26/15.
 */
public class Adapter_News extends RecyclerView.Adapter<Adapter_News.ViewHolder> {

    ArrayList<News_Beans>items;
    public Adapter_News(ArrayList<News_Beans> items,Context context){

        if(!ImageLoader.getInstance().isInited()){
            ImageLoader.getInstance().init(ImageLoaderConfiguration.createDefault(context));
        }
        this.items=items;
    }

    @Override
    public Adapter_News.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLayout=LayoutInflater.from(parent.getContext()).inflate(R.layout.row_news,parent,false);
        return new ViewHolder(itemLayout);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        News_Beans news_beans=items.get(position);

       holder.tx_description.setText(news_beans.getTitle_new());
       String url_img=news_beans.getUrl_img_news();
        ImageLoader.getInstance().displayImage(url_img,holder.img_news);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tx_description;
        ImageView img_news;
        public ViewHolder(final View itemmView){
            super(itemmView);
            tx_description=(TextView)itemmView.findViewById(R.id.tx_description);
            img_news=(ImageView)itemmView.findViewById(R.id.img_news);

            itemmView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    Intent i=new Intent(itemmView.getContext(),Activity_Detail.class);
                    i.putExtra("url_img",items.get(getLayoutPosition()).getUrl_img_news());
                    i.putExtra("titulo",items.get(getLayoutPosition()).getTitle_new());
                    i.putExtra("description",items.get(getLayoutPosition()).getNews_description());

                    if(Device.isLollipop()){
                        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) itemmView.getContext(),
                                itemmView,   // The view which starts the transition
                                itemmView.getContext().getString(R.string.transition_album_cover)
                                // The transitionName of the view we’re transitioning to
                        );
                        ActivityCompat.startActivity((Activity) itemmView.getContext(), i, options.toBundle());
                    }else {
                        itemmView.getContext().startActivity(i);
                    }
                }
            });
        }
    }
}
