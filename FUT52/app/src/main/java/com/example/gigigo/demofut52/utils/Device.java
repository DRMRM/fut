package com.example.gigigo.demofut52.utils;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.Log;

/**
 * Created by Davis on 6/30/15.
 */
public class Device {
    public static boolean isPhone(Context context){
        TelephonyManager manager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        if (manager.getPhoneType() == TelephonyManager.PHONE_TYPE_NONE) {
            return true;
        } else {
            return false;
        }
    }

    public static Point getSizeScreen(Context context) {
        Point point = new Point();
        try {DisplayMetrics display = context.getResources().getDisplayMetrics();
            point.x = display.widthPixels;;
            point.y = display.heightPixels;
            Log.e("SIZE", "Size  X:  " + point.x + "Size  Y:  " + point.y);
        } catch (Exception e) {}
        return point;
    }

    public static boolean isConnected(Context ctx) {
        boolean bConectado = false;
        ConnectivityManager connec = (ConnectivityManager) ctx .getSystemService(Context.CONNECTIVITY_SERVICE);
        //
        NetworkInfo[] redes = connec.getAllNetworkInfo();

        for (int i = 0; i < redes.length; i++) {

            if (redes[i].getState() == NetworkInfo.State.CONNECTED) {
                bConectado = true;
            }
        }
        return bConectado;
    }
    public static boolean isLollipop(){
        boolean lollipop;
        if(Build.VERSION.SDK_INT >=21){
            lollipop=true;
        }else { lollipop=false;}
        return lollipop;
    }

    public static boolean isTablet(Context context) {
        return (context.getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) >= Configuration.SCREENLAYOUT_SIZE_LARGE;
    }


}
