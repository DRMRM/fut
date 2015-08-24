package com.example.gigigo.demofut52.activities;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.example.gigigo.demofut52.R;
import com.example.gigigo.demofut52.bases.BaseActivity;
import com.example.gigigo.demofut52.beans.AppData;
import com.example.gigigo.demofut52.beans.Player_Bean;
import com.example.gigigo.demofut52.fragments.Fragment_Gallery;
import com.example.gigigo.demofut52.fragments.Fragment_Home;
import com.example.gigigo.demofut52.fragments.Fragment_List_Teams;
import com.example.gigigo.demofut52.fragments.Fragment_Main;
import com.example.gigigo.demofut52.fragments.Fragment_News;
import com.example.gigigo.demofut52.fragments.Fragment_Results;
import com.example.gigigo.demofut52.fragments.Fragment_Table_Positions;
import com.example.gigigo.demofut52.storage.AppPreferences;
import com.example.gigigo.demofut52.storage.UserPreferences;
import com.example.gigigo.demofut52.utils.Constants;
import com.example.gigigo.demofut52.utils.Utils;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;


public class Activity_Home extends BaseActivity {

    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;
    NavigationView mNavigationView;
    FrameLayout mContentFrame;
    ActionBarDrawerToggle mDrawerToggle;
    ImageView img_headermenu_team;
    Player_Bean player;
    UserPreferences prefs;
    AppPreferences appPrefs;


    private static final String PREFERENCES_FILE = "mymaterialapp_settings";
    private static final String PREF_USER_LEARNED_DRAWER = "navigation_drawer_learned";
    private static final String STATE_SELECTED_POSITION = "selected_navigation_drawer_position";

    private boolean mUserLearnedDrawer;
    private boolean mFromSavedInstanceState;
    private int mCurrentSelectedPosition=0;
    boolean flagFinish=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Bundle b=getIntent().getExtras();

        if(!ImageLoader.getInstance().isInited()){
            ImageLoader.getInstance().init(ImageLoaderConfiguration.createDefault(this));
        }

        if(b!=null){
            flagFinish=b.getBoolean("finish");
        }
        mToolbar = (Toolbar) findViewById(R.id.toolbar);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.nav_drawer);
        img_headermenu_team=(ImageView)findViewById(R.id.img_headermenu_team);
        prefs=new UserPreferences(this);
        player=prefs.getPrefs();


        if (mToolbar != null) {
            setSupportActionBar(mToolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setCustomView(R.layout.header_toolbar);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setDisplayShowCustomEnabled(true);
            getSupportActionBar().setDisplayUseLogoEnabled(false);
            getSupportActionBar().setDisplayShowHomeEnabled(false);

        }

        mDrawerToggle =new ActionBarDrawerToggle(Activity_Home.this,mDrawerLayout,0,0){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();

        mUserLearnedDrawer = Boolean.valueOf(readSharedSetting(this, PREF_USER_LEARNED_DRAWER, "false"));

        if (savedInstanceState != null) {
            mCurrentSelectedPosition = savedInstanceState.getInt(STATE_SELECTED_POSITION);
            mFromSavedInstanceState = true;
        }


        mNavigationView = (NavigationView) findViewById(R.id.nav_view);

/*        mNavigationView.setItemTextColor(new ColorStateList(
                new int [] [] {
                        new int [] {android.R.attr.state_pressed},
                        new int [] {android.R.attr.state_focused},
                        new int [] {}
                },
                new int [] {
                        Color.rgb (255, 128, 192),
                        Color.rgb (100, 200, 192),
                        Color.WHITE
                }
        ));*/


        mContentFrame = (FrameLayout) findViewById(R.id.nav_contentframe);

        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                menuItem.setChecked(true);





                mDrawerLayout.closeDrawer(mNavigationView);
                switch (menuItem.getItemId()) {
                    case R.id.navigation_home:

                        Snackbar.make(mContentFrame, "Inicio", Snackbar.LENGTH_SHORT).show();
                        mCurrentSelectedPosition = 0;
                        changeFragment(0);

                        return true;

                    case R.id.navigation_teams:
                        Snackbar.make(mContentFrame, "Euipos", Snackbar.LENGTH_SHORT).show();
                        mCurrentSelectedPosition = 1;
                        changeFragment(1);
                        return true;

                    case R.id.navigation_table:
                        Snackbar.make(mContentFrame, "Tabla general", Snackbar.LENGTH_SHORT).show();
                        mCurrentSelectedPosition = 2;
                        changeFragment(2);
                        return true;
                    case R.id.navigation_result:
                        Snackbar.make(mContentFrame, "Resultados", Snackbar.LENGTH_SHORT).show();
                        mCurrentSelectedPosition = 3;
                        changeFragment(3);
                        return true;

                    case R.id.navigation_gallery:
                        Snackbar.make(mContentFrame, "Galerias", Snackbar.LENGTH_SHORT).show();
                        mCurrentSelectedPosition = 4;
                        changeFragment(4);

                        return  true;

                    case R.id.navigation_news:
                        Snackbar.make(mContentFrame, "Noticias", Snackbar.LENGTH_SHORT).show();
                        mCurrentSelectedPosition = 5;
                        changeFragment(5);
                        return  true;

                    case R.id.navigation_configuration:
                        Intent i=new Intent(Activity_Home.this,Configuration_Team.class);
                        i.putExtra("home",true);
                        startActivity(i);
                        finish();
                        return true;

                    default:
                        return true;
                }
            }
        });

        ImageLoader.getInstance().displayImage(player.getImg_team(),img_headermenu_team);


        changeFragment(-1);

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(STATE_SELECTED_POSITION, mCurrentSelectedPosition);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Utils.onActivityCreateSetTheme(this);
        Menu menu = mNavigationView.getMenu();
        menu.getItem(mCurrentSelectedPosition).setChecked(true);

        appPrefs =new AppPreferences(this);
        int theme=appPrefs.getTheme(Constants.THEME);

        if(theme!=0){
            setTheme(theme);
        }
    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mCurrentSelectedPosition = savedInstanceState.getInt(STATE_SELECTED_POSITION, 0);
        Menu menu = mNavigationView.getMenu();
        menu.getItem(mCurrentSelectedPosition).setChecked(true);
    }



    public static String readSharedSetting(Context ctx, String settingName, String defaultValue) {
        SharedPreferences sharedPref = ctx.getSharedPreferences(PREFERENCES_FILE, Context.MODE_PRIVATE);
        return sharedPref.getString(settingName, defaultValue);
    }

    public void changeFragment(int position){
        Fragment fragment = null;
        FragmentManager fragmentManager = getSupportFragmentManager();


        switch (position){
            case -1:
                try{fragment = Fragment_Main.getInstance();}catch (Exception e){}//
                break;
            case 0:
                try{fragment = Fragment_Home.getInstance(true);}catch (Exception e){}//
                break;
            case 1:
                try{fragment = Fragment_List_Teams.getInstance(true);}catch (Exception e){}
                break;
            case 2:
                try{fragment = Fragment_Table_Positions.getInstance(true);}catch (Exception e){}
                break;
            case 3:
                try{fragment =  Fragment_Results.getInstance(true);}catch (Exception e){}
                break;
            case 4:
                try{fragment= Fragment_Gallery.getInstace();}catch (Exception e){}//Galerias
                break;

            case 5:
                try{fragment = Fragment_News.getInstace();}catch (Exception e){}//Notas
                break;
        }

         FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
         fragmentTransaction.setCustomAnimations(R.anim.slide_in_up, R.anim.slide_out_up, R.anim.slide_in_down, R.anim.slide_out_down);
         fragmentTransaction.replace(R.id.nav_contentframe, fragment);
         fragmentTransaction.commit();
    }


    @Override
    public void onBackPressed() {
        if(mDrawerLayout.isDrawerOpen(mNavigationView)){
            mDrawerLayout.closeDrawer(mNavigationView);
        }else { super.onBackPressed();}
    }


    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }

}
