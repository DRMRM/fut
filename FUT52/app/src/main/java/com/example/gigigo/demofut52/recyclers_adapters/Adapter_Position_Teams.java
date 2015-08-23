package com.example.gigigo.demofut52.recyclers_adapters;

import android.content.Context;
import android.graphics.Point;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.gigigo.demofut52.R;
import com.example.gigigo.demofut52.beans.Teams;
import com.example.gigigo.demofut52.utils.Device;

import java.util.ArrayList;

/**
 * Created by Davis on 6/29/15.
 */
public class Adapter_Position_Teams extends RecyclerView.Adapter<Adapter_Position_Teams.ViewHolder> {

    Context context;
    Point size;
    LinearLayout.LayoutParams params_data, params_team;

        ArrayList<Teams> items;
public Adapter_Position_Teams(ArrayList<Teams> items,Context context){
        this.items=items;
    this.context=context;
    size= Device.getSizeScreen(context);
        }

@Override
public Adapter_Position_Teams.ViewHolder  onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLayout= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_table_teams,parent,false);
        return new ViewHolder(itemLayout);
        }

@Override
public void onBindViewHolder(ViewHolder holder, int position) {

        Teams team=items.get(position);

    holder.tx_position.setText(position+1+"");
    holder.tx_name.setText(team.getName());
    holder.tx_pj.setText(team.getTeam_pj());
    holder.tx_pg.setText(team.getTeam_pg());
    holder.tx_pe.setText(team.getTeam_pe());
    holder.tx_pp.setText(team.getTeam_pp());
    holder.tx_gf.setText(team.getTeam_gf());
    holder.tx_gc.setText(team.getTeam_gc());
    holder.tx_pts.setText(team.getTeam_pts());

    if(position%2==0){
        holder.layou_1.setBackgroundColor(context.getResources().getColor(R.color.color_claro));
    }
        }

@Override
public int getItemCount() {

        return items.size();
        }


public class ViewHolder extends RecyclerView.ViewHolder{

    TextView tx_position,tx_name,tx_pj,tx_pg,tx_pe,tx_pp,tx_gf,tx_gc,tx_pts;
    LinearLayout layou_1;

    LinearLayout linear_p,linear_e, linear_pj, linear_pg, linear_pe, linear_pp, linear_gf, linear_gc, linear_pts;


    public ViewHolder(View itemmView){
        super(itemmView);
        params_data=new LinearLayout.LayoutParams(size.x/12, ViewGroup.LayoutParams.WRAP_CONTENT);
        params_team=new LinearLayout.LayoutParams((size.x/12*4), ViewGroup.LayoutParams.WRAP_CONTENT);

        linear_p =(LinearLayout)itemmView.findViewById(R.id.linear_p);linear_p.setLayoutParams(params_data);
        linear_e=(LinearLayout)itemmView.findViewById(R.id.linear_e);linear_e.setLayoutParams(params_team);
        linear_pj=(LinearLayout)itemmView.findViewById(R.id.linear_pj);linear_pj.setLayoutParams(params_data);
        linear_pg=(LinearLayout)itemmView.findViewById(R.id.linear_pg);linear_pg.setLayoutParams(params_data);
        linear_pe=(LinearLayout)itemmView.findViewById(R.id.linear_pe);linear_pe.setLayoutParams(params_data);
        linear_pp=(LinearLayout)itemmView.findViewById(R.id.linear_pp);linear_pp.setLayoutParams(params_data);
        linear_gf=(LinearLayout)itemmView.findViewById(R.id.linear_gf);linear_gf.setLayoutParams(params_data);
        linear_gc=(LinearLayout)itemmView.findViewById(R.id.linear_gc);linear_gc.setLayoutParams(params_data);
        linear_pts=(LinearLayout)itemmView.findViewById(R.id.linear_pts);linear_pts.setLayoutParams(params_data);



        layou_1=(LinearLayout)itemmView.findViewById(R.id.layou_1);
        tx_position=(TextView)itemmView.findViewById(R.id.tx_position);
        tx_name=(TextView)itemmView.findViewById(R.id.tx_name);
        tx_pj=(TextView)itemmView.findViewById(R.id.tx_pj);
        tx_pg=(TextView)itemmView.findViewById(R.id.tx_pg);
        tx_pe=(TextView)itemmView.findViewById(R.id.tx_pe);
        tx_pp=(TextView)itemmView.findViewById(R.id.tx_pp);
        tx_gf=(TextView)itemmView.findViewById(R.id.tx_gf);
        tx_gc=(TextView)itemmView.findViewById(R.id.tx_gc);
        tx_pts=(TextView)itemmView.findViewById(R.id.tx_pts);


        }
    }
}