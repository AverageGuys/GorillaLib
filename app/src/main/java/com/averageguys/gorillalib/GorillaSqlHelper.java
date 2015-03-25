/*
 * DESCRIPTION: 	SQLITE DATABASE HELPER CLASS
 * AUTHOR: 			Marcial Paul Juztin Sagmit

 * DATE CREATED:	June 4, 2014
 * TIME CREATED:	10:00 AM
 * 
 * Version: 1.0
 * 
 */

package  com.averageguys.gorillalib;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;

import com.averageguys.gorillalib.utils.GlobalValues;

public class GorillaSqlHelper {

	// public static final String MYDATABASE_NAME = DatabaseTables.schemaName;
	public static final String MYDATABASE_NAME = GlobalValues.APP_DATABASE;
	public static final int MYDATABASE_VERSION = 1;

	// enum BindType {BLOB, DOUBLE, LONG, NULL, STRING};

	private SQLiteHelper sqLiteHelper;
	private SQLiteDatabase sqLiteDatabase;

	private SQLiteStatement insert;
	private Context context;
	private String errorMsg = "";

	// static BindType[] bt = BindType.values();

	public GorillaSqlHelper(Context c) {
		context = c;
	}

	public GorillaSqlHelper openToRead() throws android.database.SQLException {
		sqLiteHelper = new SQLiteHelper(context, MYDATABASE_NAME, null, MYDATABASE_VERSION);
		sqLiteDatabase = sqLiteHelper.getReadableDatabase();
		return this;
	}

	public GorillaSqlHelper openToWrite() throws android.database.SQLException {
		sqLiteHelper = new SQLiteHelper(context, MYDATABASE_NAME, null, MYDATABASE_VERSION);
		sqLiteDatabase = sqLiteHelper.getWritableDatabase();
		return this;
	}

	public void close() {
		sqLiteHelper.close();
	}

	// INSERT QUERY MODIFIED
	public boolean execQuery(String query) {

		boolean result = false;

		setErrorMsg("");

		try {
			
			sqLiteDatabase.execSQL(query);
			result = true;

		} catch (Exception e) {
			// TODO: handle exception
			Log.i("DBASE ERROR", e.getMessage() + "\r sql:" + query);
			setErrorMsg(e.getMessage());
			result = false;
		}
		return result;
	}

	public class SQLiteHelper extends SQLiteOpenHelper {

		public SQLiteHelper(Context context, String name, CursorFactory factory, int version) {
			super(context, name, factory, version);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			// db.execSQL(SCRIPT_CREATE_DATABASE);
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
		}
	}

	// SELECT QUERY MODIFIED
	public Cursor read(String query) {

		Cursor cursor = sqLiteDatabase.rawQuery(query, null);

		return cursor;
	}

	public String getValue(String query) {

		String myValue = "";
		Cursor cursor = sqLiteDatabase.rawQuery(query, null);

		while (cursor.moveToNext()) {

			myValue = cursor.getString(0);
		}

		return myValue;
	}

	public String getMultipleValue(String query, String delimiter, String fieldName) {

		String myValue = "";

		Cursor cursor = sqLiteDatabase.rawQuery(query, null);

		String[] myArray = fieldName.split("\\" + delimiter);
		Log.e("SQL", "" + myArray.length);
		while (cursor.moveToNext()) {

			for (int i = 0; i < myArray.length; i++) {

				if (i == (myArray.length - 1)) {
					myValue = myValue + cursor.getString(i);
				} else {
					myValue = myValue + cursor.getString(i) + delimiter;
				}

			}

		}

		return myValue;
	}

	public Boolean isRecordExists(String query) {

		Boolean result = false;

		Cursor cursor = sqLiteDatabase.rawQuery(query, null);

		while (cursor.moveToNext()) {

			result = true;

		}

		return result;

	}

	public int recordCount(String query) {

		int myValue = 0;

		Cursor cursor = sqLiteDatabase.rawQuery(query, null);

		myValue = cursor.getCount();

		return myValue;

	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public void beginTransaction() {

		sqLiteDatabase.beginTransaction();

	}

	public void endTransaction() {

		sqLiteDatabase.endTransaction();

	}

	public void compiledStatement(String sql) {

		// Log.i("COMPILED:", sql);
		insert = sqLiteDatabase.compileStatement(sql);

	}

	public void bindValues(int index, String strValue) {

		// STRING
		// Log.i("BIND:", strValue);
		insert.bindString(index, strValue);

	}

	public void bindNullValues(int index) {
		insert.bindNull(index);
	}

	public void executeBind() {

		insert.execute();

	}

	public void setTransactionSucessul() {
		sqLiteDatabase.setTransactionSuccessful();
	}

	public boolean insert(String tableName, ContentValues insertValues) {
		// TODO Auto-generated method stub
		boolean result = false;

		setErrorMsg("");

		try {
			sqLiteDatabase.insert(tableName, null, insertValues);
			result = true;

		} catch (Exception e) { 
			// TODO: handle exception
			Log.i("DBASE ERROR", e.getMessage() + "\r sql tableName:" + tableName.toString());
			Log.i("DBASE ERROR", e.getMessage() + "\r sql insertValues:" + insertValues.toString());
			setErrorMsg(e.getMessage());
			result = false;
		}
		return result;
	}

}
