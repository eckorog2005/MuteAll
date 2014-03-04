package com.rlamb1id.MuteAll;

import android.app.Activity;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RemoteViews;

/**
 * Created by rlamb on 2/21/14.
 */
public class MuteAllProvider extends AppWidgetProvider {

    public static String BUTTON_CLICKED_ACTION = "ButtonClickedAction";
    private boolean on = true;

    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);

        if(intent.getAction().equals(BUTTON_CLICKED_ACTION)){
            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.muteall_appwidget);
            Activity activity = (Activity) context.getApplicationContext();
            ImageButton ib = (ImageButton)activity.findViewById(R.id.button);
            if(on){
                ib.setImageResource(R.drawable.muted);
            }else{
                ib.setImageResource(R.drawable.unmuted);
            }
            on = !on;
        }

    }

    @Override
    public void onUpdate (Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds){
        super.onUpdate(context, appWidgetManager, appWidgetIds);
        final int N = appWidgetIds.length;

        // Perform this loop procedure for each App Widget that belongs to this
        // provider
        for (int i = 0; i < N; i++) {
            int appWidgetId = appWidgetIds[i];

            // Create an Intent to launch ExampleActivity
            Intent intent = new Intent(context, MuteAllProvider.class);
            intent.setAction(BUTTON_CLICKED_ACTION);
            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);

            // Get the layout for the App Widget and attach an on-click listener
            // to the button
            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.muteall_appwidget);
            views.setOnClickPendingIntent(R.id.imageButton, pendingIntent);

            // Tell the AppWidgetManager to perform an update on the current app
            // widget
            appWidgetManager.updateAppWidget(appWidgetId, views);
        }
    }

    @Override
    public void onEnabled (Context context){

    }

    @Override
    public void onDisabled (Context context){

    }
}
