package com.example.gigigo.demofut52.widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.RemoteViews;
import android.widget.Toast;
import com.example.gigigo.demofut52.R;
import com.example.gigigo.demofut52.activities.Activity_Home;


public class WidgetProvider extends AppWidgetProvider {

    public static final String ACTION_TOAST = "widgets.ACTION_TOAST";
    public static final String EXTRA_STRING = "widgets.EXTRA_STRING";

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(ACTION_TOAST)) {
            String item = intent.getExtras().getString(EXTRA_STRING);
            Toast.makeText(context, item, Toast.LENGTH_LONG).show();
        }
        super.onReceive(context, intent);
    }

    public void onUpdate(Context context, AppWidgetManager appWidgetManager,
                         int[] appWidgetIds) {


        for (int widgetId : appWidgetIds) {
            RemoteViews mView = initViews(context, appWidgetManager, widgetId);

            // Adding collection list item handler
            final Intent onItemClick = new Intent(context, WidgetProvider.class);
            onItemClick.setAction(ACTION_TOAST);
            onItemClick.setData(Uri.parse(onItemClick .toUri(Intent.URI_INTENT_SCHEME)));


            final PendingIntent onClickPendingIntent = PendingIntent.getBroadcast(context, 0, onItemClick, PendingIntent.FLAG_UPDATE_CURRENT);


            mView.setPendingIntentTemplate(R.id.widgetCollectionList,  onClickPendingIntent);

            appWidgetManager.updateAppWidget(widgetId, mView);


        }
        super.onUpdate(context, appWidgetManager, appWidgetIds);
    }

    private RemoteViews initViews(Context context,  AppWidgetManager widgetManager, int widgetId) {

        RemoteViews mView = new RemoteViews(context.getPackageName(), R.layout.widget_provider_layout);

        Intent intent = new Intent(context, WidgetService.class);

        intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, widgetId);

        intent.setData(Uri.parse(intent.toUri(Intent.URI_INTENT_SCHEME)));


        Intent goApp =new Intent(context, Activity_Home.class);

        goApp.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);

        PendingIntent pIntent=PendingIntent.getActivity(context,1,goApp,0);
        mView.setOnClickPendingIntent(R.id.widget_go_app_button,pIntent);
        mView.setRemoteAdapter(R.id.widgetCollectionList, intent);

        return mView;
    }
}
