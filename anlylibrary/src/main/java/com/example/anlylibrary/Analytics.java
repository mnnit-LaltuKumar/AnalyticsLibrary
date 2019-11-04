package com.example.anlylibrary;

import com.google.firebase.FirebaseOptions;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.FirebaseAnalytics;
import android.content.Context;
import android.util.Log;

public class Analytics {

    private static FirebaseAnalytics mFirebaseAnalytics;

    public static void initialiseAnalytics(Context context,String appID,String appName){
        Log.d("AnalyticsLib App ID= ",appID);
        Log.d("AnalyticsLib App Name= ",appName);
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setApplicationId(appID) // Required for Analytics.
                .build();
        Log.d("Firebase Apps= ",FirebaseApp.getApps(context).toString());
        Log.d("AnalyticsLib","AnalyticsLib Initialise= ");
        FirebaseApp.initializeApp(context, options, appName);
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(context);
    }

    public static void logAppOpenEvent(){
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.APP_OPEN,null);
    }

    public static void logCustomAppEvent(android.os.Bundle bundle){
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.APP_OPEN,bundle);
    }

}
