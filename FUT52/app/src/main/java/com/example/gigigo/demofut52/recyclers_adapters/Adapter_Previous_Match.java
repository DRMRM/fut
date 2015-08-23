package com.example.gigigo.demofut52.recyclers_adapters;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gigigo.demofut52.R;
import com.example.gigigo.demofut52.beans.Teams;

import java.util.ArrayList;

/**
 * Created by Davis on 6/26/15.
 */
public class Adapter_Previous_Match extends RecyclerView.Adapter<Adapter_Previous_Match.ViewHolder>{

    ArrayList<Teams>items;

    public Adapter_Previous_Match( ArrayList<Teams>items){
        this.items=items;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.row_previous_match,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Teams team=items.get(position);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }

}
