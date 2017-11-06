package com.martinomburajr.concepts.notifications;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;

import com.martinomburajr.concepts.MainActivity;
import com.martinomburajr.concepts.R;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

/**
 * Created by Martin Ombura Jr. on 11/2/2017.
 */

public class NotificationTutorial {
    private Context mContext;
    private NotificationManager mNotificationManager;

    public NotificationTutorial(Context context) {
        mContext = context;
        mNotificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
    }


    /**
     * Shows a simple notification with no alert, no action, no customized style
     * NOTE: This does not contain a notification channel so it will not appear on devices running API26 (Oreo)
     */
    public void simpleNotification() {
        String channelId1 = "channel_id1";
        int notificationId = 1234;
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(mContext,channelId1);
        notificationBuilder
                .setContentTitle("Notification Title")
                .setContentText("This is some Simple Notification text")
                .setSmallIcon(android.support.v4.R.drawable.notification_icon_background);

        mNotificationManager.notify(notificationId,notificationBuilder.build());
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void simpleNotificationWChannelWAlerts() {
        NotificationManager notificationManager = (NotificationManager)mContext.getSystemService(Context.NOTIFICATION_SERVICE);
        String notifChannelId1 = "id1";
        String notifChannelName1 = "name1";
        String notifChannelId2 = "id2";
        String notifChannelName2 ="name2";
        String notifChannelId3 = "id3";
        String notifChannelName3 = "name3";

        NotificationChannel notificationChannel1 = new NotificationChannel(notifChannelId1,notifChannelName1, NotificationManager.IMPORTANCE_HIGH);
        notificationChannel1.setDescription("This is the Notification Channel 1 Description");
        notificationChannel1.setLightColor(Color.CYAN);
        notificationChannel1.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
        notificationManager.createNotificationChannel(notificationChannel1);

        NotificationChannel notificationChannel2 = new NotificationChannel(notifChannelId2,notifChannelName2,NotificationManager.IMPORTANCE_LOW);
        notificationChannel2.setDescription("This is the Notification Channel 2 Description");
        notificationChannel2.setLightColor(Color.GRAY);
        notificationChannel2.setImportance(NotificationManager.IMPORTANCE_LOW);
        notificationManager.createNotificationChannel(notificationChannel2);

        NotificationChannel notificationChannel3 = new NotificationChannel(notifChannelId3, notifChannelName3,NotificationManager.IMPORTANCE_NONE);

        NotificationCompat.Builder notification1 = new NotificationCompat.Builder(mContext,notifChannelId1);
        notification1
                .setSmallIcon(android.support.v4.R.drawable.notification_template_icon_bg)
                .setContentText("Notification 1")
                .setContentText("Notification 1 Body");

        NotificationCompat.Builder notification2 = new NotificationCompat.Builder(mContext,notifChannelId2);
        notification2
                .setSmallIcon(android.support.v4.R.drawable.notification_template_icon_bg)
                .setContentText("Notification 2")
                .setContentText("Notification 2 Body");

        NotificationCompat.Builder notification3 = new NotificationCompat.Builder(mContext,notifChannelId3);
        notification3
                .setSmallIcon(android.support.v4.R.drawable.notification_template_icon_bg)
                .setContentText("Notification 3")
                .setContentText("Notification 3 Body");

        notificationManager.notify(1, notification1.build());
        notificationManager.notify(2, notification2.build());
        notificationManager.notify(3, notification3.build());
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void notificationWChannelWAlertsWStyleO(){
        NotificationManager notificationManager = (NotificationManager)mContext.getSystemService(Context.NOTIFICATION_SERVICE);

        String channelId1 = "id1";
        String channelId2 = "id2";
        String channelName1 = "channel_1";
        String channelName2 = "channel_2";
        NotificationChannel notificationChannel1 = new NotificationChannel(channelId1,channelName1,NotificationManager.IMPORTANCE_HIGH);
        notificationChannel1.setDescription("This is a description for notificationWChannelWAlertsWStyleO");
        notificationChannel1.setLightColor(Color.GREEN);
        notificationChannel1.setShowBadge(true);
        notificationChannel1.setVibrationPattern(new long[]{100,4000,100});

        NotificationCompat.BigTextStyle bigTextStyle = new NotificationCompat.BigTextStyle().bigText("This is the text for this notificationWChannelWAlertsWStyleO, it should be big enough for you to expand, cause I'm using big styles");

        NotificationCompat.Builder notifBuilder = new NotificationCompat.Builder(mContext,channelId1)
                .setContentText("This is the text for this notificationWChannelWAlertsWStyleO, it should be big enough for you to expand, cause I'm using big styles")
                .setContentTitle("BigStyles")
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setStyle(bigTextStyle);

        NotificationChannel notificationChannel2 = new NotificationChannel(channelId2,channelName2,NotificationManager.IMPORTANCE_HIGH);
        notificationChannel2.setDescription("This is a description for notificationWChannelWAlertsWStyleO channel 2");
        notificationChannel2.setLightColor(Color.RED);
        notificationChannel2.setShowBadge(true);
        notificationChannel2.setVibrationPattern(new long[]{400});
        notificationManager.createNotificationChannel(notificationChannel2);

        NotificationCompat.BigTextStyle bigTextStyle2 = new NotificationCompat.BigTextStyle().bigText("This is the text for this notificationWChannelWAlertsWStyleO channel2, it should be big enough for you to expand, cause I'm using big styles");

        NotificationCompat.Builder notifBuilder2 = new NotificationCompat.Builder(mContext,channelId1)
                .setContentText("This is the text for this notificationWChannelWAlertsWStyleO channel2")
                .setContentTitle("BigStyles2")
                .setSmallIcon(R.drawable.ic_menu_gallery)
                .setStyle(bigTextStyle2);

        notificationManager.notify(1,notifBuilder.build());
        notificationManager.notify(2,notifBuilder2.build());
    }

    public void notificationWChannelWAlertsWStyle(){
        NotificationManager notificationManager = (NotificationManager)mContext.getSystemService(Context.NOTIFICATION_SERVICE);

        NotificationCompat.BigTextStyle bigTextStyle = new NotificationCompat.BigTextStyle().bigText("This is the text for this notificationWChannelWAlertsWStyle, it should be big enough for you to expand, cause I'm using big styles");

        NotificationCompat.Builder notifBuilder = new NotificationCompat.Builder(mContext)
                .setContentText("This is the text for this notificationWChannelWAlertsWStyleO, it should be big enough for you to expand, cause I'm using big styles")
                .setContentTitle("BigStyles")
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setVibrate(new long[]{100,4000,100})
                .setLights(244,40,300)
                .setStyle(bigTextStyle);

        NotificationCompat.BigTextStyle bigTextStyle2 = new NotificationCompat.BigTextStyle().bigText("This is the text for this notificationWChannelWAlertsWStyleO channel2, it should be big enough for you to expand, cause I'm using big styles");

        NotificationCompat.Builder notifBuilder2 = new NotificationCompat.Builder(mContext)
                .setContentText("This is the text for this notificationWChannelWAlertsWStyleO channel2")
                .setContentTitle("BigStyles2")
                .setSmallIcon(R.drawable.ic_menu_gallery)
                .setLights(3,40,300)
                .setStyle(bigTextStyle2);

        notificationManager.notify(1,notifBuilder.build());
        notificationManager.notify(2,notifBuilder2.build());
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void notificationWIntentsO(){
        NotificationManager notificationManager = (NotificationManager)mContext.getSystemService(Context.NOTIFICATION_SERVICE);
        String notifChannelId1 = "notifChannelId1WIntent";
        String notifChannelName1 ="notifChannelName1WIntent";
        NotificationChannel notificationChannel1 = new NotificationChannel(notifChannelId1,notifChannelName1,NotificationManager.IMPORTANCE_DEFAULT);

        Intent intent = new Intent(mContext, NotificationActivity.class);

        TaskStackBuilder stackBuilder = TaskStackBuilder.create(mContext);
        stackBuilder.addParentStack(NotificationActivity.class);
        stackBuilder.addNextIntent(intent);

        PendingIntent pendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder notification = new NotificationCompat.Builder(mContext, notifChannelId1)
                .setSmallIcon(R.drawable.ic_menu_camera)
                .setContentTitle("Notification with Intent")
                .setContentText("Redirect to the specified activity set by the intent")
                .setContentIntent(pendingIntent);


        notificationManager.notify(123, notification.build());
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void notificationWIntents(){
        NotificationManager notificationManager = (NotificationManager)mContext.getSystemService(Context.NOTIFICATION_SERVICE);
        Intent intent = new Intent(mContext, NotificationActivity.class);

        TaskStackBuilder stackBuilder = TaskStackBuilder.create(mContext);
        stackBuilder.addParentStack(NotificationActivity.class);
        stackBuilder.addNextIntent(intent);

        PendingIntent pendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder notification = new NotificationCompat.Builder(mContext)
                .setSmallIcon(R.drawable.ic_menu_camera)
                .setContentTitle("Notification with Intent")
                .setContentText("Redirect to the specified activity set by the intent")
                .setContentIntent(pendingIntent);

        notificationManager.notify(123, notification.build());
    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void notificationWInboxStyle() {
        NotificationManager notificationManager = (NotificationManager)mContext.getSystemService(Context.NOTIFICATION_SERVICE);
        Intent intent = new Intent(mContext, NotificationActivity.class);
        Intent intent2 = new Intent(mContext, MainActivity.class);

        TaskStackBuilder stackBuilder = TaskStackBuilder.create(mContext);
        stackBuilder.addParentStack(NotificationActivity.class);
        stackBuilder.addNextIntent(intent);
        stackBuilder.addNextIntent(intent2);

        NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle()
                .addLine("Line 1")
                .addLine("Line 2")
                .addLine("Line 3")
                .addLine("Line 4")
                .setBigContentTitle("All my lines");

        PendingIntent pendingIntent = stackBuilder.getPendingIntent(1, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder notification = new NotificationCompat.Builder(mContext)
                .setSmallIcon(R.drawable.ic_menu_share)
                .setContentText("This should display an inbox style")
                .setContentTitle("InboxStyle")
                .setStyle(inboxStyle)
                .setContentIntent(pendingIntent);

        notificationManager.notify(143, notification.build());
    }


    public Observable<Integer> notificationWUpdate(){
        final NotificationManager notificationManager = (NotificationManager)mContext.getSystemService(Context.NOTIFICATION_SERVICE);
        int id = 1234;
        int count = 0;
        NotificationCompat.Builder notification = new NotificationCompat.Builder(mContext)
                .setSmallIcon(R.drawable.ic_menu_slideshow)
                .setContentTitle("I will be updated")
                .setContentText("I have been updated " + count + "times");

        notificationManager.notify(1234, notification.build());

        return Observable.interval(2000, TimeUnit.MILLISECONDS)
                .map((time) -> {
            NotificationCompat.Builder notification2 = new NotificationCompat.Builder(mContext)
                        .setSmallIcon(R.drawable.ic_menu_slideshow)
                        .setContentTitle("I will be updated")
                        .setContentText("I have been updated " + time + "times");
            notificationManager.notify(1234, notification2.build());
            return 0;
        });
    }


    public void notificationWIntentsWActions(){

    }

    public void complexNotificationWBroadcastReceiver(){

    }

    public void complexNotificationWStacking(){

    }

    public void notificationWBigImages(){

    }

    public void updateComplexNotificationWTimer(){

    }

    public void deleteComplexNotificationWTimer(){

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void createNotificationO(Context context, String title, String text) {
        String notificationChannelName = "notifChannelName";
        String notificationChannelId = "notifChannelId";
        int notificationId = 1234;
        NotificationManager notificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationChannel notificationChannel = new NotificationChannel(notificationChannelId, notificationChannelName, NotificationManager.IMPORTANCE_DEFAULT);

        NotificationCompat.Builder notif = new NotificationCompat.Builder(context, notificationChannelId);
        notif.setContentText(text)
                .setContentTitle(title)
                .setSmallIcon(R.drawable.ic_menu_manage)
                .setVibrate(new long[]{100,200,50,50});

        notificationManager.createNotificationChannel(notificationChannel);
        notificationManager.notify(notificationId,notif.build());
    }

    public void createNotification(Context context, String title, String text) {
        int notificationId = 1234;
        NotificationManager notificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);

        NotificationCompat.Builder notif = new NotificationCompat.Builder(context);
        notif.setContentText(text)
                .setContentTitle(title)
                .setSmallIcon(R.drawable.ic_menu_manage)
                .setVibrate(new long[]{100,200,50,50});

        notificationManager.notify(notificationId,notif.build());
    }
}
