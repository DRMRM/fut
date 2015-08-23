package com.example.gigigo.demofut52;

import com.example.gigigo.demofut52.activities.Activity_Home;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

public class GCMIntentService extends IntentService 
{
	private static final int NOTIF_ALERTA_ID = 1;

	public GCMIntentService() {
        super("GCMIntentService");
    }
	
	@Override
    protected void onHandleIntent(Intent intent) 
	{
        GoogleCloudMessaging gcm = GoogleCloudMessaging.getInstance(this);
        
        String messageType = gcm.getMessageType(intent);
        Bundle extras = intent.getExtras();

        if (!extras.isEmpty()) 
        {  
            if (GoogleCloudMessaging.MESSAGE_TYPE_MESSAGE.equals(messageType)) 
            {
            	Vibrator v = (Vibrator) this.getSystemService(Context.VIBRATOR_SERVICE);
            	 // Vibrate for 500 milliseconds
            	 v.vibrate(1000);
            	String mensaje=extras.getString("message");  //String mensaje=extras.getString("mensaje");
            	
            	mostrarNotification(mensaje);
            	
            	Log.d("DRM",""+mensaje);
            	
            }
        }
        
        GCMBroadcastReceiver.completeWakefulIntent(intent);
    }
	
	private void mostrarNotification(String msg) 
	{
		NotificationManager mNotificationManager =    
				(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE); 
		Uri notificationsound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
		
		NotificationCompat.Builder mBuilder = 
			new NotificationCompat.Builder(this)  
		.setSmallIcon(R.mipmap.ic_launcher)
        .setLargeIcon((((BitmapDrawable)getResources()
            .getDrawable(R.mipmap.ic_launcher)).getBitmap()))
        .setContentTitle(getString(R.string.app_name))
        .setContentText(msg)
       // .setLights(Color.YELLOW, 1, 2) 
        .setAutoCancel(true)
        .setContentInfo("1")
        .setSound(notificationsound)
        .setTicker(msg.toString().toUpperCase());
		
		
		Intent notIntent = null;
		
		//Aqui llevaria la validacion despues de llegado el pushnotification            ..::NOTA::..
	   
		//if(msg.contains("prueba")){
		//	notIntent=	 new Intent(this, Splash_App.class); 
	//	}else {
			notIntent=	 new Intent(this, Activity_Home.class);
		//}
		
		notIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |
                Intent.FLAG_ACTIVITY_SINGLE_TOP);
        PendingIntent contIntent = PendingIntent.getActivity(this, 0, notIntent, 0);//Notification.FLAG_AUTO_CANCEL);
        mBuilder.setContentIntent(contIntent);
		mNotificationManager.notify(NOTIF_ALERTA_ID, mBuilder.build());

    }
}
