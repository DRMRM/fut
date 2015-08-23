package com.example.gigigo.demofut52.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gigigo.demofut52.R;
import com.example.gigigo.demofut52.adapters.Adapter_ListTeamsConfiguration;
import com.example.gigigo.demofut52.bases.BaseActivity;
import com.example.gigigo.demofut52.beans.Player_Bean;
import com.example.gigigo.demofut52.beans.Teams;
import com.example.gigigo.demofut52.conection.HttpConnectionRamptors;
import com.example.gigigo.demofut52.parserJSON.ParserJSON;
import com.example.gigigo.demofut52.storage.UserPreferences;
import com.example.gigigo.demofut52.utils.Constants;
import com.example.gigigo.demofut52.utils.Utils;

import java.util.ArrayList;

public class Configuration_Team extends BaseActivity {

    private Toolbar mToolbar;
    EditText nom_player,num_jersey;
    UserPreferences prefs;
    ListView list_teams;
    boolean home=false;
    ProgressDialog pDialog;
    TextView tx_team_selected;
    Player_Bean player;
    String id_team="";
    String url_img_team="http://cdn0.vox-cdn.com/assets/3101583/Roma_Logo.png";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_configuration);
        prefs=new UserPreferences(this);
        player=prefs.getPrefs();

        mToolbar = (Toolbar) findViewById(R.id.toolbar);

        if (mToolbar != null) {
            setSupportActionBar(mToolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        }

        nom_player=(EditText)findViewById(R.id.nom_player);
        num_jersey=(EditText)findViewById(R.id.num_jersey);
        tx_team_selected=(TextView)findViewById(R.id.tx_team_selected);

        list_teams=(ListView)findViewById(R.id.list_teams);

        Bundle b=getIntent().getExtras();
        if(b!=null){
            home=b.getBoolean("home");
        }

        new getTeams().execute();



        if(player.getNombre()!=null){
            nom_player.setText(player.getNombre());
            tx_team_selected.setText(player.getEquipo());
            num_jersey.setText(player.getNum_jersey());
        }

    }

    private class getTeams extends AsyncTask<Void,Void,ArrayList<Teams>>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog=new ProgressDialog(Configuration_Team.this);
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(false);
            pDialog.setMessage("Buscando Equipos");
            pDialog.show();
        }

        @Override
        protected void onPostExecute(final ArrayList<Teams> teamses) {
            super.onPostExecute(teamses);
            pDialog.dismiss();

            if(teamses.size()>0){

                Adapter_ListTeamsConfiguration adapter=new Adapter_ListTeamsConfiguration();
                adapter.setData(Configuration_Team.this,teamses);
                list_teams.setAdapter(adapter);
                adapter.notifyDataSetChanged();

                list_teams.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        tx_team_selected.setText(teamses.get(position).getName());
                        id_team=teamses.get(position).getTeam_id();

                    }
                });
            }

        }

        @Override
        protected ArrayList<Teams> doInBackground(Void... params) {
           String JSON= HttpConnectionRamptors.getResponseRamptorsHttp(Constants.URL_TEAMS_LIST);
            return ParserJSON.getArrayTeams(JSON);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_configuration, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id){
            case R.id.action_save:
                if(nom_player.getText().toString().equals("") || num_jersey.getText().toString().equals("")||tx_team_selected.getText().toString().equals("")){
                    Toast.makeText(this,"Los campos del jugador son obligatorios jugador",Toast.LENGTH_SHORT).show();
                }else {
                    Player_Bean player=new Player_Bean(id_team,nom_player.getText().toString().toUpperCase(),num_jersey.getText().toString(),tx_team_selected.getText().toString().toUpperCase(),url_img_team);

                    if(prefs.addPreferences(player)){

                        if(home){
                            onBackPressed();
                            Toast.makeText(this, "Jugador Actualizado", Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(this, "Jugador Registrado", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(this, Activity_Home.class);
                            startActivity(i);
                            finish();
                        }
                    }else{
                        Toast.makeText(this,"Error al intentar registrar jugador",Toast.LENGTH_SHORT).show();
                    }
                }
                return true;

            case android.R.id.home:
                onBackPressed();
                return true;

          case R.id.color_p:
                Utils.changeToTheme(this, Utils.THEME_PINK);
                return true;
            case R.id.color_t:
                Utils.changeToTheme(this, Utils.THEME_AQUA);
                return true;

            case R.id.color_b:
                Utils.changeToTheme(this, Utils.THEME_BLUE);
                return true;

            case R.id.color_y:
                Utils.changeToTheme(this, Utils.THEME_YELLOW);
                return true;

            case R.id.color_g:
                Utils.changeToTheme(this, Utils.THEME_GREEN);
                return true;

            case R.id.color_r:
                Utils.changeToTheme(this, Utils.THEME_RED);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {

        if(player.getNombre()==null){
            super.onBackPressed();
        }else {
            Intent intent=new Intent(this,Activity_Home.class);
            startActivity(intent);
            finish();
        }
    }
}