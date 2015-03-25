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

import android.os.Environment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

/**
 * Created by Android Dev on 25/3/2015.
 */
public class GorillaDB {


    public static String createInsertStatment(String tableName, String fields) {
        String result = "";

        String[] arr_my = fields.toString().trim().split("\\,");

        int fieldCount = arr_my.length;
        int i = 0;
        String temp = "";

        for (i = 0; i < fieldCount; i++) {
            if ((i + 1) == fieldCount) {
                temp = temp + "?";
            } else {
                temp = temp + "?,";
            }
        }

        if (temp.length() <= 0) {
            result = "";
        } else {
            result = "INSERT INTO " + tableName + " (" + fields + ") VALUES (" + temp + ");";
        }

        return result;
    }

    public static String createInsertStatment2(String tableName, String fields) {
        String result = "";

        String[] arr_my = fields.toString().trim().split("\\,");

        int fieldCount = arr_my.length;
        int i = 0;
        String temp = "";

        for (i = 0; i < fieldCount; i++) {
            if ((i + 1) == fieldCount) {
                temp = temp + "?";
            } else {
                temp = temp + "?,";
            }
        }

        if (temp.length() <= 0) {
            result = "";
        } else {
            result = "INSERT OR IGNORE INTO " + tableName + " (" + fields + ") VALUES (" + temp + ");";
        }

        return result;
    }

    public static void extractDatabase(String packageName, String projectName, String databaseName) {
        try {
            File sd = Environment.getExternalStorageDirectory();
            File data = Environment.getDataDirectory();

            if (sd.canWrite()) {

                String currentDBPath = "//data//" + packageName + "//databases//" + databaseName;
                String backupDBPath = databaseName;
                File currentDB = new File(data, currentDBPath);
                File backupDB = new File(sd, backupDBPath);

                if (currentDB.exists()) {
                    FileChannel src = new FileInputStream(currentDB).getChannel();
                    FileChannel dst = new FileOutputStream(backupDB).getChannel();
                    dst.transferFrom(src, 0, src.size());
                    src.close();
                    dst.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
