/*
 * DESCRIPTION: 		Android Generic Libraries
 * AUTHOR: 				Marcial Paul Juztin Sagmit
 * 						Omar Matthew Reyes

 * DATE CREATED:		June 4, 2014
 * DATE LAST UPDATED:	April 2, 2015
 *
 * TIME CREATED:		10:00 AM
 *
 * Version: 1.0.1
 *
 */

package com.averageguys.gorillalib;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

/**
 * Created by Android Dev on 25/3/2015.
 */
public class GorillaNetwork {
    private static final String TAG = "GorillaNetwork";

    /**
     * Checks if device is connected in an active network.
     *
     * @param activity Activity's context
     * @return  boolean if device is connected in an active network
     * @see     android.net.ConnectivityManager
     * @see     android.net.NetworkInfo
     */
    public static boolean isNetworkConnected(Activity activity) {
        ConnectivityManager mConnectivityManager = (ConnectivityManager) activity.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = mConnectivityManager.getActiveNetworkInfo();
        return mConnectivityManager.getActiveNetworkInfo() != null && activeNetworkInfo.isConnected();
    }

    /**
     * Invokes AlertDialog if no active internet connection is available.
     *
     * @param activity Current Activity
     */
        public static void isConnected(Activity activity) {
        if (!isNetworkConnected(activity)) {
            Log.e(TAG, "IS CONNECTED? NO");
            GorillaDialog.showAlertDialog(activity, "", "No internet connection available.", "Ok");
        } else {
            Log.i(TAG, "IS CONNECTED? YES");
        }
    }
}
