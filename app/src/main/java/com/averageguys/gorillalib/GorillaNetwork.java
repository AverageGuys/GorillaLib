/*
 * DESCRIPTION: 		Android Generic Libraries
 * AUTHOR: 				Marcial Paul Juztin Sagmit
 * 						Omar Matthew Reyes

 * DATE CREATED:		June 4, 2014
 * DATE LAST UPDATED:	March 25, 2015
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
    public static boolean isNetworkConnected(Context context) {
        ConnectivityManager mConnectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = mConnectivityManager.getActiveNetworkInfo();
        return mConnectivityManager.getActiveNetworkInfo() != null && activeNetworkInfo.isConnected();
    }

    public static void isConnected(Context context, Activity activity) {
        if (!isNetworkConnected(context)) {
            Log.e(TAG, "IS CONNECTED? NO");
            GorillaDialog.showAlertDialog(activity, "", "No internet connection available.", "Ok");
        } else {
            Log.i(TAG, "IS CONNECTED? YES");
        }
    }
}
