/*
 * DESCRIPTION: 		Android Generic Libraries
 * AUTHOR: 				Marcial Paul Juztin Sagmit
 * 						Omar Matthew Reyes

 * DATE CREATED:		June 4, 2014
 * DATE LAST UPDATED:	March 30, 2015
 *
 * TIME CREATED:		10:00 AM
 *
 * Version: 1.0.1
 *
 */

package com.averageguys.gorillalib;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.widget.Toast;

/**
 * Created by Android Dev on 25/3/2015.
 */
public class GorillaDialog {
    /**
     * Invokes an AlertDialog popup on view.
     *
     * @param activity Current activity
     * @param title Title for the AlertDialog
     * @param msg Message content
     * @param dIcon Image for the icon beside the title
     * @param buttonPositiveTitle Text on the positive button
     * @param buttonNegativeTitle Text on the negative button
     *
     * @see     android.app.AlertDialog
     */
    public static void showAlertDialog(Activity activity, String title, String msg, int dIcon,
                                       String buttonPositiveTitle, String buttonNegativeTitle) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(activity);
        alertDialogBuilder.setTitle(title);
        alertDialogBuilder.setMessage(msg);
        alertDialogBuilder.setIcon(dIcon);
        alertDialogBuilder.setNegativeButton(buttonNegativeTitle, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        alertDialogBuilder.setPositiveButton(buttonPositiveTitle, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        AlertDialog alert = alertDialogBuilder.create();
        alert.show();
    }

    /**
     * Invokes an AlertDialog popup on view.
     *
     * @param activity Current activity
     * @param title Title for the AlertDialog
     * @param msg Message content
     * @param dIcon Image for the icon beside the title
     * @param buttonNegativeTitle Text on the negative button
     *
     * @see     android.app.AlertDialog
     */
    public static void showAlertDialog(Activity activity, String title, String msg, int dIcon, String buttonNegativeTitle) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(activity);
        alertDialogBuilder.setTitle(title);
        alertDialogBuilder.setMessage(msg);
        alertDialogBuilder.setIcon(dIcon);
        alertDialogBuilder.setNegativeButton(buttonNegativeTitle, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        AlertDialog alert = alertDialogBuilder.create();
        alert.show();
    }

    /**
     * Invokes an AlertDialog popup on view.
     *
     * @param activity Current activity
     * @param title Title for the AlertDialog
     * @param msg Message content
     * @param buttonNegativeTitle Text on the negative button
     *
     * @see     android.app.AlertDialog
     */
    public static void showAlertDialog(Activity activity, String title, String msg, String buttonNegativeTitle) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(activity);
        alertDialogBuilder.setTitle(title);
        alertDialogBuilder.setMessage(msg);
        alertDialogBuilder.setNegativeButton(buttonNegativeTitle, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        AlertDialog alert = alertDialogBuilder.create();
        alert.show();
    }

    /**
     * Invokes a toast.
     *
     * @param activity Current activity
     * @param msg Message content
     *
     * @see     android.widget.Toast
     */
    public static void showToast(Activity activity, String msg) {
        Toast.makeText(activity, msg, Toast.LENGTH_SHORT).show();
    }

    /**
     * Invokes a ProgressDialog.
     *
     * @param activity Current activity
     * @param title Title for the ProgressDialog
     * @param msg Message content
     *
     * @see     android.app.ProgressDialog
     */
    // [class].createProgressDialog(getActivity(), "Title", "Message").show;
    public static ProgressDialog createProgressDialog(Activity activity, String title, String msg) {
        return ProgressDialog.show(activity, title, msg, true);
    }
}
