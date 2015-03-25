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

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.Log;

import java.util.Locale;

/**
 * Created by Android Dev on 25/3/2015.
 */
public class GorillaGeneral {

    // Requires
    // <uses-permission android:name="android.permission.READ_PHONE_STATE"/>
    public static String getDeviceID(Context context) {
        String devID;

        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        devID = telephonyManager.getDeviceId();
        if (devID == null) {
            devID = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
        }
        return devID;
    }

    public static String getDeviceNameModel(Boolean isModel) {
        String result;

        if (isModel) {
            result = Build.MODEL.toUpperCase();
        } else {
            result = Build.MANUFACTURER.toUpperCase();
        }

        return result;
    }

    public static String getOSVersion() {
        return Build.VERSION.RELEASE;
    }

    public static String getAppVersion(Context context) {
        String result = "";
        try {
            PackageManager manager = context.getPackageManager();
            PackageInfo info = manager.getPackageInfo(
                    context.getPackageName(), 0);
            result = info.versionName;
        } catch (Exception e) {
            Log.e("YourActivity", "Error getting version");
        }
        return result;
    }

    public static String getLanguage(Context context) {
        return Locale.getDefault().getLanguage();
    }
}
