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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * Created by Android Dev on 25/3/2015.
 */
public class GorillaTime {
    public static String getTimeZone() {
        return TimeZone.getDefault().toString();
    }

    public static String getTimeStamp() {
        return "" + System.currentTimeMillis() / 1000L;
    }

    public static enum DateStyle {databaseDateStyle, shortDateStyle};

    public static enum TimeStyle {militaryTimeStyle, shortTimeStyle};

    public static String timeConversion(long totalSeconds) {
        final int MINUTES_IN_AN_HOUR = 60;
        final int SECONDS_IN_A_MINUTE = 60;

        long seconds = totalSeconds % SECONDS_IN_A_MINUTE;
        long totalMinutes = totalSeconds / SECONDS_IN_A_MINUTE;
        long minutes = totalMinutes % MINUTES_IN_AN_HOUR;
        long hours = totalMinutes / MINUTES_IN_AN_HOUR;

//        return hours + " hours " + minutes + " minutes " + seconds + " seconds";
        return (minutes < 10 ? "0" : "")+minutes + ":" + (seconds < 10 ? "0" : "")+seconds;
    }

    public static String formatDate(String myDate, DateStyle formatStyle) {
        String myValue = "";

        //SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            Date testDate = null;

            try {
                testDate = sdf.parse(myDate);

            } catch (Exception ex) {

                ex.printStackTrace();

            }

            //SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
            //String newFormat = formatter.format(testDate);

            SimpleDateFormat fYear = new SimpleDateFormat("yyyy");
            SimpleDateFormat fMonth = new SimpleDateFormat("MM");
            SimpleDateFormat fDay = new SimpleDateFormat("dd");


            String tempVar = "";
            String tempVarDay = "";

            String year = fYear.format(testDate);
            String tMonth = fMonth.format(testDate);
            String day = fDay.format(testDate);

            int x = Integer.parseInt(tMonth);

            Log.i("-----", "" + x);

            tempVar = "" + (x);

            if (tempVar.length() < 2) {
                tempVar = "0" + x;
            }

            tempVarDay = "" + day;

            if (tempVarDay.length() < 2) {
                tempVarDay = "0" + day;
            }

            switch (formatStyle) {
                case databaseDateStyle:
                    myValue = year + "-" + tempVar + "-" + tempVarDay;
                    break;
                case shortDateStyle:
                    myValue = tempVar + "/" + tempVarDay + "/" + year;
                    break;
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return myValue;
    }

    public static String formatTime(String myTime, TimeStyle formatStyle) {

        String myValue = "";

        SimpleDateFormat formatter = new SimpleDateFormat("hh:mm:ss");
        try {

            Calendar c = Calendar.getInstance();

            if (myTime.length() != 0) {

                Date date = formatter.parse(myTime);
                c.setTime(date);

            }

            //int day = c.get(Calendar.DATE);
            //int month = c.get(Calendar.MONTH);
            //int year = c.get(Calendar.YEAR);
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);
            int seconds = c.get(Calendar.SECOND);
            //dateNow = year+"-"+month+"-"+day;
            //timeNow = hour+":"+minute+":"+seconds;

            String tempVarHour = "";
            String tempVarMin = "";
            String tempVarSec = "";

            tempVarHour = "" + hour;
            tempVarMin = "" + minute;
            tempVarSec = "" + seconds;

            if (tempVarHour.length() < 2) {

                tempVarHour = "0" + hour;

            }

            if (tempVarMin.length() < 2) {

                tempVarMin = "0" + minute;

            }

            if (tempVarSec.length() < 2) {

                tempVarSec = "0" + seconds;

            }

            switch (formatStyle) {

                case militaryTimeStyle:
                    myValue = tempVarHour + ":" + tempVarMin + ":" + tempVarSec;
                    break;
                case shortTimeStyle:
                    myValue = convertMilitaryToNormalTime(hour) + ":" + tempVarMin + ":" + tempVarSec;
                    break;

            }

        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return myValue;

    }

    public static long timeConversionToMinutes(long totalSeconds) {
        final int MINUTES_IN_AN_HOUR = 60;
        final int SECONDS_IN_A_MINUTE = 60;

        long seconds = totalSeconds % SECONDS_IN_A_MINUTE;
        long totalMinutes = totalSeconds / SECONDS_IN_A_MINUTE;
        long minutes = totalMinutes % MINUTES_IN_AN_HOUR;
        long hours = totalMinutes / MINUTES_IN_AN_HOUR;

//        return hours + " hours " + minutes + " minutes " + seconds + " seconds";
        return minutes;
    }

    public static String getCurrentDateTime(Boolean isDate, Boolean isMilitaryTime, String dateSeparator) {
        String result = "";

        int mil = 0;
        int second = 0;
        int min = 0;
        int hour = 0;

        int hour_24 = 0;

        int ampm = 0;

        int year = 0;
        int month = 0;
        int day = 0;
        //int dayOfWeek=0;

        Calendar cal = Calendar.getInstance();

        mil = cal.get(Calendar.MILLISECOND);
        second = cal.get(Calendar.SECOND);
        min = cal.get(Calendar.MINUTE);
        hour = cal.get(Calendar.HOUR);
        hour_24 = cal.get(Calendar.HOUR_OF_DAY);
        ampm = cal.get(Calendar.AM_PM);

        year = cal.get(Calendar.YEAR);
        month = cal.get(Calendar.MONTH);
        day = cal.get(Calendar.DAY_OF_MONTH);
        //dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);

        if (!isDate) {
            if (isMilitaryTime) {
                result = hour_24 + ":" + min + ":" + second;
            } else {
                if (ampm == 0) {
                    result = hour + ":" + min + ":" + second + " AM";
                } else {
                    result = hour + ":" + min + ":" + second + " PM";
                }
            }
        } else {
            result = year + dateSeparator + (month + 1) + dateSeparator + day;
        }

        return result;
    }

    public static int getNumberOfDaysInMonth(int year, int month) {
        int result = 0;

        Calendar myCal = new GregorianCalendar(year, month, 1);

        int daysInMonth = myCal.getActualMaximum(Calendar.DAY_OF_MONTH);

        result = daysInMonth;

        return result;
    }

    public static Date removeTime(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    public static Boolean fallsBetweenDate(String date1, String date2) {
        Log.i("date1", date1);
        Log.i("date2", date2);

        Boolean result = false;

        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        Calendar c3 = Calendar.getInstance();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        try {

            Date dateStart = (Date) formatter.parse(date1);
            Date dateEnd = (Date) formatter.parse(date2);
            Log.i("dateStart", "" + dateStart);
            Log.i("dateEnd", "" + dateEnd);
            c1.setTime(dateStart);
            c2.setTime(dateEnd);

            Log.i("V1:", "" + c1.before(c3));
            Log.i("V2:", "" + c2.after(c3));


            int day = c3.get(Calendar.DATE);
            int month = c3.get(Calendar.MONTH);
            int year = c3.get(Calendar.YEAR);

            int day1 = c2.get(Calendar.DATE);
            int month1 = c2.get(Calendar.MONTH);
            int year1 = c2.get(Calendar.YEAR);

            //c2.com
            //Log.i("TTTTT", year+"-"+month+"-"+day+"-------"+year1+"-"+month1+"-"+day1);

            Date d1 = new Date();
            Date d2 = new Date();

            d1.setYear(year);
            d1.setMonth(month);
            d1.setDate(day);

            d2.setYear(year1);
            d2.setMonth(month1);
            d2.setDate(day1);

            Log.i("V3:", "" + d2.compareTo(d1));

            if (c1.before(c3) && (c2.after(c3) || (d2.compareTo(d1) == 0))) {
                result = true;
            } else {
                result = false;
            }
        } catch (ParseException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return result;
    }

    public static String convertMilitaryToNormalTime(int time) {
        String myValue = "";

        int sVal = 0;

        if (time >= 13) {
            sVal = time - 12;
            myValue = "" + sVal;
        } else if (time == 0) {
            sVal = 12;
            myValue = "" + sVal;
        } else {
            myValue = "" + time;
        }

        if (myValue.length() < 2) {
            myValue = "0" + myValue;
        }
        return myValue;
    }

    public static long getUnixTime() {
        return (long) System.currentTimeMillis() / 1000L;
    }
}
