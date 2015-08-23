package com.example.gigigo.demofut52.bases;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;

import com.example.gigigo.demofut52.R;
import com.example.gigigo.demofut52.beans.AppData;
import com.example.gigigo.demofut52.storage.AppPreferences;
import com.example.gigigo.demofut52.utils.Constants;

public abstract class BaseActivity extends AppCompatActivity {

    int Appdata;
    AppPreferences prefs;
    protected int getActionBarSize() {
        TypedValue typedValue = new TypedValue();
        int[] textSizeAttr = new int[]{R.attr.actionBarSize};
        int indexOfAttrTextSize = 0;
        TypedArray a = obtainStyledAttributes(typedValue.data, textSizeAttr);
        int actionBarSize = a.getDimensionPixelSize(indexOfAttrTextSize, -1);
        a.recycle();
        return actionBarSize;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        prefs =new AppPreferences(this);
        Appdata=prefs.getTheme(Constants.THEME);
        if(Appdata!=0){
            setTheme(Appdata);
        }
    }
}
