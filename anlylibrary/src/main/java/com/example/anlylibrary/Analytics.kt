package com.example.anlylibrary

import com.google.firebase.FirebaseOptions
import com.google.firebase.FirebaseApp
import com.google.firebase.analytics.FirebaseAnalytics
import android.content.Context
import android.util.Log
import android.os.Bundle

object Analytics {

    private var mFirebaseAnalytics: FirebaseAnalytics? = null

    fun initialiseAnalytics(context: Context, appID: String, appName: String) {
        Log.d("AnalyticsLib App ID= ", appID)
        Log.d("AnalyticsLib App Name= ", appName)
        val options = FirebaseOptions.Builder()
                .setApplicationId(appID) // Required for Analytics.
                .build()
        Log.d("AnalyticsLib", "AnalyticsLib Initialise= ")
        FirebaseApp.initializeApp(context, options, appName)
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(context)
    }

    fun logAppOpenEvent(bundle: Bundle) {
        mFirebaseAnalytics!!.logEvent(FirebaseAnalytics.Event.APP_OPEN, null)
    }

    fun logCustomAppEvent(key: String, bundle: Bundle) {
        mFirebaseAnalytics!!.logEvent(key, bundle)
    }

    fun trackTapEvent(vararg pair: Pair<String, String>) {
        mFirebaseAnalytics!!.logEvent("EVENT_TAP", prepareBundle(*pair))
    }

    /**
     * Function to prepare the bundle using the pair of data.
     */
    internal fun prepareBundle(vararg pair: Pair<String, String>) = Bundle().also { bundle ->
        pair.forEach {
            bundle.putString(it.first, it.second)
        }
    }
}
