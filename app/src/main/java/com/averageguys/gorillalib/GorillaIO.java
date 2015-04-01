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

import android.util.Log;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Android Dev on 25/3/2015.
 */
public class GorillaIO {
    private static final String TAG = "GorillaIO";

    /**
     * Verifies if email has a valid format.
     *
     * @param email Email String
     * @return  boolean if email is valid
     * @see     java.util.regex.Matcher
     * @see     java.util.regex.Pattern
     */
    public static boolean isEmailValid(String email) {
        boolean emailValid = false;

        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        CharSequence inputStr = email;

        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        if (matcher.matches()) {
            emailValid = true;
        }
        return emailValid;
    }

    /**
     * Verifies if password length is valid.
     *
     * @param password Password String
     * @return  boolean if password length is valid
     */
    // modify password length as needed
    public static boolean isPasswordValid(String password) {
        Log.e(TAG, "Password Length" + password.length());
        boolean passwordValid = false;

        if (password.length() >= 6) {
            passwordValid = true;
            Log.e(TAG, "Password Valid");
        }
        return passwordValid;
    }
}
