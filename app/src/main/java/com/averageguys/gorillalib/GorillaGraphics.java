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
import android.graphics.Point;
import android.os.Build;
import android.view.Display;

/**
 * Created by Android Dev on 25/3/2015.
 */
public class GorillaGraphics {
    public static String screenRes(Activity activity) {
        String res = "";

        if (Build.VERSION.SDK_INT >= 13) {
            Display display = activity.getWindowManager().getDefaultDisplay();
            Point size = new Point();
            display.getSize(size);
            int width = size.x;
            int height = size.y;

            res = "tBackgroundSmart_" + width + "_" + height;

        } else {
            Display display = activity.getWindowManager().getDefaultDisplay();
            int width = display.getWidth();  // deprecated
            int height = display.getHeight();  // deprecated

            res = "tBackgroundSmart_" + width + "_" + height;
        }


        return res;
    }

    public static int display(Activity activity, int loc) {
        String res = screenRes(activity);
        int width;

        // split screenRes String return
        // [1] width
        // [2] height
        res = res.split("_")[loc];
        width = Integer.parseInt(res);

        return width;
    }

    public static int dispWidth(Activity activity) {
        int dispWidth = display(activity, 1);
        return dispWidth;
    }

    public static int dispHeight(Activity activity) {
        int dispHeight = display(activity, 2);
        return dispHeight;
    }
}
