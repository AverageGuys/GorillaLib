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
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.widget.Toast;

/**
 * Created by Android Dev on 25/3/2015.
 */
public class GorillaDialog {
    public static void showAlertDialog(Activity activity, String title, String msg, int dIcon, String buttonTitle) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(activity);
        alertDialogBuilder.setTitle(title);
        alertDialogBuilder.setMessage(msg);
        alertDialogBuilder.setIcon(dIcon);
        alertDialogBuilder.setNegativeButton(buttonTitle, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        AlertDialog alert = alertDialogBuilder.create();
        alert.show();
    }

    public static void showAlertDialog(Activity activity, String title, String msg, String buttonTitle) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(activity);
        alertDialogBuilder.setTitle(title);
        alertDialogBuilder.setMessage(msg);
        alertDialogBuilder.setNegativeButton(buttonTitle, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        AlertDialog alert = alertDialogBuilder.create();
        alert.show();
    }

    public static void showToast(Activity activity, String msg) {
        Toast.makeText(activity, msg, Toast.LENGTH_SHORT).show();
    }

    // [class].createProgressDialog(getActivity(), "Title", "Message").show;
    public static ProgressDialog createProgressDialog(Activity activity, String title,String msg) {
        ProgressDialog mProgressDialog = ProgressDialog.show(activity, title, msg, true);

        return mProgressDialog;
    }
}
