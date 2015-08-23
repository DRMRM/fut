package com.example.gigigo.demofut52.utils;

import android.app.Activity;
import android.content.Intent;

import com.example.gigigo.demofut52.R;
import com.example.gigigo.demofut52.beans.AppData;
import com.example.gigigo.demofut52.storage.AppPreferences;

/**
 * Created by DRM on 18/08/15.
 */
public class Utils
{
    private static int sTheme;

    public final static int THEME_AQUA = 0;
    public final static int THEME_PINK = 1;
    public final static int THEME_RED = 2;
    public final static int THEME_BLUE = 3;
    public final static int THEME_YELLOW= 4;
    public final static int THEME_GREEN = 5;

    /**
     * Set the theme of the Activity, and restart it by creating a new Activity of the same type.
     */
    public static void changeToTheme(Activity activity, int theme)
    {
        sTheme = theme;
        activity.startActivity(new Intent(activity, activity.getClass()).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
        activity.finish();
    }

    /** Set the theme of the activity, according to the configuration. */
    public static void onActivityCreateSetTheme(Activity activity)
    {
        AppPreferences prefs=new AppPreferences(activity);
        switch (sTheme)
        {
            default:
            case THEME_AQUA:
                activity.setTheme(R.style.DesignAqua);
                prefs.addPreferences( R.style.DesignAqua);

                break;
            case THEME_PINK:
                activity.setTheme(R.style.DesignPink);
                prefs.addPreferences( R.style.DesignPink);

                break;
            case THEME_BLUE:
                activity.setTheme(R.style.DesignBlue);
                prefs.addPreferences( R.style.DesignBlue);

                break;
            case THEME_RED:
                activity.setTheme(R.style.DesignRed);
                prefs.addPreferences( R.style.DesignRed);

                break;
            case THEME_YELLOW:
                activity.setTheme(R.style.DesignYellow);
                prefs.addPreferences( R.style.DesignYellow);

                break;
            case THEME_GREEN:
                activity.setTheme(R.style.DesignGreen);
                prefs.addPreferences( R.style.DesignGreen);

                break;
        }
    }
}