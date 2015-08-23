package com.example.gigigo.demofut52;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.gigigo.demofut52.activities.Activity_Home;
import com.example.gigigo.demofut52.activities.Configuration_Team;
import com.example.gigigo.demofut52.beans.Player_Bean;
import com.example.gigigo.demofut52.storage.UserPreferences;
import com.example.gigigo.demofut52.utils.Utilities;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public class Splash_Activity extends AppCompatActivity {

    Player_Bean player;
    UserPreferences prefs;

    private static final String PROPERTY_REG_ID = "registration_id";
    private static final String PROPERTY_APP_VERSION = "appVersion";
    private static final String PROPERTY_EXPIRATION_TIME = "onServerExpirationTimeMs";
    private static final String PROPERTY_USER = "user";

    public static final long EXPIRATION_TIME_MS = 1000 * 3600 * 24 * 7;

    String SENDER_ID = "722723903581";

    private String regid;
    private GoogleCloudMessaging gcm;
    String TAG=getClass().getSimpleName();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_);

        if(!ImageLoader.getInstance().isInited()){
            ImageLoader.getInstance().init(ImageLoaderConfiguration.createDefault(this));

        }
//try {registrar();}catch (Exception e){}


        prefs=new UserPreferences(this);
        player=prefs.getPrefs();

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Intent intent=null;
                if(player.getNombre()==null){
                    intent =new Intent(Splash_Activity.this,Configuration_Team.class);
                }else {
                    intent =new Intent(Splash_Activity.this,Activity_Home.class);
                }
                startActivity(intent);
                finish();

            }
        };
        Timer timer = new Timer();
        timer.schedule(task,2000);
    }

    private void setRegistrationId(String user, String regId)
    {
        SharedPreferences prefs = getSharedPreferences(
                Splash_Activity.class.getSimpleName(),
                Context.MODE_PRIVATE);

        int appVersion = getAppVersion(this);

        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(PROPERTY_USER, user);
        editor.putString(PROPERTY_REG_ID, regId);
        editor.putInt(PROPERTY_APP_VERSION, appVersion);
        editor.putLong(PROPERTY_EXPIRATION_TIME,
                System.currentTimeMillis() + EXPIRATION_TIME_MS);

        editor.commit();
    }




    private boolean registroServidor(String usuario, String regId)
    {
        boolean reg = false;

        //final String NAMESPACE = "http://sgoliver.net/";
        final String URL="http://ipdaw.com/notificaciones_app/";
        final String METHOD_NAME = "registrar.php";
        final String SOAP_ACTION = URL+METHOD_NAME;


        try {
              Utilities.PostRegistroServer(SOAP_ACTION, regId);
        } catch (Exception e) {}
        return reg;
    }


    public void registrar() {
        gcm = GoogleCloudMessaging.getInstance(Splash_Activity.this);

        //Obtenemos el Registration ID guardado
        regid = getRegistrationId(this);

        //Si no disponemos de Registration ID comenzamos el registro
        if (regid.equals("")) {
            TareaRegistroGCM tarea = new TareaRegistroGCM();
            tarea.execute("");
        }
    }

    private String getRegistrationId(Context context)
    {
        SharedPreferences prefs = getSharedPreferences(
                Splash_Activity.class.getSimpleName(),
                Context.MODE_PRIVATE);

        String registrationId = prefs.getString(PROPERTY_REG_ID, "");

        if (registrationId.length() == 0)
        {
            Log.e(TAG, "Registro GCM no encontrado.");
            return "";
        }

        String registeredUser =
                prefs.getString(PROPERTY_USER, "user");

        int registeredVersion =
                prefs.getInt(PROPERTY_APP_VERSION, Integer.MIN_VALUE);

        long expirationTime =
                prefs.getLong(PROPERTY_EXPIRATION_TIME, -1);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault());
        String expirationDate = sdf.format(new Date(expirationTime));

        Log.e(TAG, "Registro GCM encontrado (usuario=" + registeredUser +
                ", version=" + registeredVersion +
                ", expira=" + expirationDate + ")");

        int currentVersion = getAppVersion(context);

        if (registeredVersion != currentVersion)
        {
            Log.e(TAG, "Nueva version de la aplicacion.");
            return "";
        }
        else if (System.currentTimeMillis() > expirationTime)
        {
            Log.e(TAG, "Registro GCM expirado.");
            return "";
        }


        return registrationId;
    }

    private static int getAppVersion(Context context)
    {
        try
        {
            PackageInfo packageInfo = context.getPackageManager()
                    .getPackageInfo(context.getPackageName(), 0);

            return packageInfo.versionCode;
        }
        catch (PackageManager.NameNotFoundException e)
        {
            throw new RuntimeException("Error al obtener version: " + e);
        }
    }



    private class TareaRegistroGCM extends AsyncTask<String,Integer,String>
    {
        @Override
        protected String doInBackground(String... params)
        {
            String msg = "";

            try
            {
                if (gcm == null)
                {
                    gcm = GoogleCloudMessaging.getInstance(Splash_Activity.this);
                }

                //Nos registramos en los servidores de GCM
                regid = gcm.register(SENDER_ID);

                Log.e(TAG, "Registrado en GCM: registration_id=" + regid);

                //Nos registramos en nuestro servidor
                boolean registrado = registroServidor(params[0], regid);

                //Guardamos los datos del registro
                if(registrado)
                {
                    setRegistrationId(params[0], regid);
                }
            }
            catch (IOException ex)
            {
                Log.e(TAG, "Error registro en GCM:" + ex.getMessage());
            }
            return msg;
        }

    }




}
