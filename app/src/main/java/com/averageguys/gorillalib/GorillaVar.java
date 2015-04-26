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

/**
 * Created by Android Dev on 25/3/2015.
 */
public class GorillaVar {
    // Check if string is number
    public static boolean isNumeric(String string) {
        if (string == null || string.length() == 0) {
            return false;
        }

        int l = string.length();

        String f = "";
        int dotCount = 0;

        for (int i = 0; i < l; i++) {
            if (!Character.isDigit(string.codePointAt((i)))) {
                f = string.substring(i, i + 1);

                if (!f.equals(".")) {
                    return false;
                } else {
                    dotCount++;
                    if (dotCount >= 2) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    // Convert float to string
    public static String getIntegerValueFromFloat(float myValue) {
        String strTemp1 = "";

        strTemp1 = "" + myValue;
        int pos = strTemp1.indexOf(".");
        String ee = strTemp1.substring(pos + 1);

        strTemp1 = ee;

        return strTemp1;
    }

    // Convert string into proper format
    public static String formatString(String dString) {
        String temp = "";

        temp = dString;
        temp = temp.replace("0X22", "'");
        temp = temp.replace("0X26", "&");
        temp = temp.replace("0X24", "$");
        temp = temp.replace("{amp}", "&");

        return temp;
    }

    // Convert string into proper format
    public static String handleString(String value) {
        String result = "";
        result = value.replace("'", "0x22");
        return result;
    }

    // Remove last character separator
    public static String removeLastCharSeparator(String data, String delimiter) {
        String result = "";
        if (data.length() > 0) {
            if (data.substring(data.length() - 1, data.length()).equals(delimiter)) {
                result = data.substring(0, data.length() - 1);
            }
        }
        return result;
    }
}
