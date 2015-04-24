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
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/**
 * Created by Android Dev on 25/3/2015.
 */
public class GorillaUtils {
    /**
     * Hide visible softKeyboard if any view from the screen is touched/clicked
     *
     * @param view View in Activity
     * @param activity Activity's context
     * @see     android.view.View;
     * @see     android.view.ViewGroup;
     */
    public static void hideKeyboard(View view, final Activity activity) {
        if (!(view instanceof EditText)) {
            view.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    try {
                        hideSoftKeyboard(activity);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return false;
                }
            });
        }

        if (view instanceof ViewGroup) {

            for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
                View innerView = ((ViewGroup) view).getChildAt(i);
                hideKeyboard(innerView, activity);
            }
        }
    }

    /**
     * Hide visible softKeyboard if any view from the screen is touched/clicked
     *
     * @param activity Activity's context
     * @see     android.view.inputmethod.InputMethodManager
     */
    public static void hideSoftKeyboard(Activity activity) {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Hide visible softKeyboard if any view from the screen is touched/clicked
     *
     * @param mgr AssetManager
     * @param isBold boolean true if bold
     * @see     android.graphics.Typeface;
     */
    public static Typeface setFont(AssetManager mgr, Boolean isBold) {
        String fontPath = "";

        if (isBold) {
            fontPath = "fonts/Helvetica-Condensed-Bold.otf";
        } else {
            fontPath = "fonts/Helvetica-Condensed.otf";
        }

        Typeface tf = Typeface.createFromAsset(mgr, fontPath);

        return tf;
    }
}
