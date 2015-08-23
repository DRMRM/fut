package com.example.gigigo.demofut52.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.view.ContextThemeWrapper;

import com.example.gigigo.demofut52.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Davis on 6/30/15.
 */
public class Utilities {

    public static DisplayImageOptions initDownloadImage() {
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.drawable.espanola)
                .showImageForEmptyUri(R.drawable.espanola)
                .showImageOnFail(R.drawable.espanola)
                .cacheInMemory(true)
                .cacheOnDisc(true)
                .considerExifParams(true)
                .bitmapConfig(Bitmap.Config.RGB_565)
                .build();

        return options;
    }

    public static void createAlert(final Activity activity, String mensaje) {
        Utilities.createAlert(activity, null, mensaje);
    }

    public static void createAlert(final Activity activity, String mensaje, DialogInterface.OnClickListener ocl) {
        Utilities.createAlert(activity, null, mensaje, ocl);
    }

    public static void createAlert(final Activity activity, String titulo, String mensaje) {
        Utilities.createAlert(activity, titulo, mensaje, null);
    }

    public static void createAlert(final Activity activity, String titulo, String mensaje, DialogInterface.OnClickListener ocl) {
        Utilities.createAlert(activity, titulo, mensaje, false, ocl);
    }

    public static void createAlert(final Activity activity, String titulo, String mensaje, boolean cancelButton, DialogInterface.OnClickListener ocl) {
        AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(activity, R.style.Theme_AppCompat_Light_DarkActionBar
        ));
        builder.setTitle(titulo)
                .setMessage(mensaje)
                .setCancelable(true)
                        //.setIcon(R.drawable.ic_launcher)
                .setPositiveButton("Aceptar", ocl);

        if (cancelButton) {
            builder.setNegativeButton("Cancelar", null);
        }
        AlertDialog alert = builder.create();
        alert.show();
    }


    public static String PostRegistroServer(String URL,String iddevice){
        String text="";
        try {
            HttpClient httpclient = new DefaultHttpClient();
		/*Creamos el objeto de HttpClient que nos permitira conectarnos mediante peticiones http*/
            HttpPost httppost = new HttpPost(URL);
		/*El objeto HttpPost permite que enviemos una peticion de tipo POST a una URL especificada*/
            //AnADIR PARAMETROS

            List<NameValuePair> params = new ArrayList<NameValuePair>();

            params.add(new BasicNameValuePair("iddevice",iddevice));
            httppost.setEntity(new UrlEncodedFormEntity(params));

		                  /*Finalmente ejecutamos enviando la info al server*/
            HttpResponse resp = httpclient.execute(httppost);
            HttpEntity ent = resp.getEntity();/*y obtenemos una respuesta*/

            text = EntityUtils.toString(ent);

        }catch (Exception e){

        }
        return text;
    }

}
