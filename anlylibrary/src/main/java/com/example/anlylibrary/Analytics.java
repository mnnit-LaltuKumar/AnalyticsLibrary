package com.example.anlylibrary;

import com.google.firebase.FirebaseOptions;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.FirebaseAnalytics;

public class Analytics {

    public static void initialiseAnalytics(android.content.Context context,String appID,String appName){
        android.util.Log.d("AnalyticsLib App ID= ",appID);
        android.util.Log.d("AnalyticsLib App Name= ",appName);
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setApplicationId(appID) // Required for Analytics.
                .build();
        if(FirebaseApp.getApps(context).isEmpty()) {
            android.util.Log.d("AnalyticsLib","AnalyticsLib Initialise= ");
            FirebaseApp.initializeApp(context, options, appName);
        }

        FirebaseAnalytics analytics = FirebaseAnalytics.getInstance(context);
        analytics.logEvent(FirebaseAnalytics.Event.APP_OPEN,null);
        analytics.logEvent(FirebaseAnalytics.Event.LOGIN,null);
    }

}
