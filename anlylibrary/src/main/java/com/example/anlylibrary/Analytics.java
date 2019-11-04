package com.example.anlylibrary;

import com.google.firebase.FirebaseOptions;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.FirebaseAnalytics;

public class Analytics {

    public static void initialiseAnalytics(android.content.Context context,String appID,String appName){
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setApplicationId(appID) // Required for Analytics.
                .build();
        FirebaseApp.initializeApp(context , options, appName);

        FirebaseAnalytics analytics = FirebaseAnalytics.getInstance(context);
        analytics.logEvent(FirebaseAnalytics.Event.APP_OPEN,null);
    }

}
