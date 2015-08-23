package com.example.gigigo.demofut52.recyclers_adapters;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gigigo.demofut52.R;
import com.example.gigigo.demofut52.activities.Activity_Detail;
import com.example.gigigo.demofut52.beans.Teams;
import com.example.gigigo.demofut52.utils.Utilities;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;

/**
 * Created by Davis on 6/29/15.
 */
public class Adapter_Teams_List extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;
    ArrayList<Teams>items;

    public Adapter_Teams_List(ArrayList<Teams>items) {
        this.items = items;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view=null;
        if (viewType == TYPE_ITEM) {
            view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_team,parent,false);
            //inflate your layout and pass it to view holder
            return new VHItem(view);
        } else if (viewType == TYPE_HEADER) {
            //inflate your layout and pass it to view holder
            view= LayoutInflater.from(parent.getContext()).inflate(R.layout.header_list_teams,parent,false);
            return new VHHeader(view);
        }

        throw new RuntimeException("there is no type that matches the type " + viewType + " + make sure your using types correctly");
    }



    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof VHItem) {
                Teams team=items.get(position - 1);
            String url_uniform="http://ramptors.net/fut52/uniforms/"+team.getU_img();
            String name_team=team.getName();

            ((VHItem) holder).tx_team.setText(name_team);
            ImageLoader.getInstance().displayImage(url_uniform,((VHItem) holder).img_uniform, Utilities.initDownloadImage());
        } else if (holder instanceof VHHeader) {
       //     Teams teams=items.get(position);
            //cast holder to VHHeader and set data for header.
        }
    }

    @Override
    public int getItemCount() {
        return items.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (isPositionHeader(position))
            return TYPE_HEADER;

        return TYPE_ITEM;
    }

    private boolean isPositionHeader(int position) {
        return position == 0;
    }

    private Teams getItem(int position) {
        return items.get(position-1);
    }

    class VHItem extends RecyclerView.ViewHolder{
        TextView tx_team;
        ImageView img_uniform;

        public VHItem(final View itemView) {
            super(itemView);

            img_uniform=(ImageView)itemView.findViewById(R.id.img_uniform);
            tx_team=(TextView)itemView.findViewById(R.id.tx_team);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(itemView.getContext(), Activity_Detail.class);
                    itemView.getContext().startActivity(intent);
                }
            });
        }
    }


    class VHHeader extends RecyclerView.ViewHolder {
        public VHHeader(View itemView) {
            super(itemView);
        }
    }

}