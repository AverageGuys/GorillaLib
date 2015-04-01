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
    private static final String TAG = "GorillaGeneral";
    /**
     * Returns device ID.
     *
     * @param context Activity's context
     * @return  Device ID
     * @see     android.telephony.TelephonyManager
     */
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

    /**
     * Returns device model if param boolean isModel is TRUE or device
     * manufacturer if FALSE.
     *
     * @param isModel if TRUE - return device model, if FALSE - return device manufacturer
     * @return  Device model or device manufacture
     * @see     android.os.Build
     */
    public static String getDeviceNameModel(Boolean isModel) {
        String result;

        if (isModel) {
            result = Build.MODEL.toUpperCase();
        } else {
            result = Build.MANUFACTURER.toUpperCase();
        }

        return result;
    }

    /**
     * Returns device OS version
     *
     * @return  Device OS version
     * @see     android.os.Build
     */
    public static String getOSVersion() {
        return Build.VERSION.RELEASE;
    }

    /**
     * Returns app version
     *
     * @return  App version
     * @see     android.content.pm.PackageManager
     * @see     android.content.pm.PackageInfo
     */
    public static String getAppVersion(Context context) {
        String result = "";
        try {
            PackageManager manager = context.getPackageManager();
            PackageInfo info = manager.getPackageInfo(
                    context.getPackageName(), 0);
            result = info.versionName;
        } catch (Exception e) {
            Log.e(TAG, "Error getting version");
        }
        return result;
    }

    /**
     * Returns device default language settings
     *
     * @return  Device default language
     * @see     java.util.Locale
     */
    public static String getLanguage() {
        return Locale.getDefault().getLanguage();
    }
}
