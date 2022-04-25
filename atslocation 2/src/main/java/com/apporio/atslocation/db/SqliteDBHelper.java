package com.apporio.atslocation.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class SqliteDBHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "locationaldatabase";
    private static final String TABLE_OFFLINE_STATS = "offlinedatatable";
    private static final String KEY_ID = "id";
    private static final String KEY_LATITUDE = "latitude";
    private static final String KEY_LONGITUDE = "longitude";
    private static final String KEY_ACCURACY = "accuracy";
    private static final String KEY_BEARING = "bearing";
    private static final String KEY_SPEED = "speed";
    private static final String KEY_BATTERY = "battery";
    private static final String KEY_ISCHARGING = "ischarging";
    private static final String KEY_DEVICE_TIME = "devicetime";

    public SqliteDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        //3rd argument to be passed is CursorFactory instance
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_OFFLINE_STATS + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_LATITUDE + " TEXT,"
                + KEY_LONGITUDE + " TEXT,"
                + KEY_ACCURACY + " TEXT,"
                + KEY_BEARING + " TEXT,"
                + KEY_SPEED + " TEXT,"
                + KEY_BATTERY + " TEXT,"
                + KEY_DEVICE_TIME + " TEXT,"
                + KEY_ISCHARGING + " TEXT"
                + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_OFFLINE_STATS);
        onCreate(db);
    }

    // code to add the new offlineDataTable
    public void addOfflineEntery(OfflineDataTable offlineDataTable) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_LATITUDE, offlineDataTable.get_latitude());
        values.put(KEY_LONGITUDE, offlineDataTable.get_longitude());
        values.put(KEY_ACCURACY, offlineDataTable.get_accuracy());
        values.put(KEY_BEARING, offlineDataTable.get_bearing());
        values.put(KEY_SPEED, offlineDataTable.get_speed());
        values.put(KEY_BATTERY, offlineDataTable.get_battery());
        values.put(KEY_DEVICE_TIME, offlineDataTable.get_devicetime());
        values.put(KEY_ISCHARGING, offlineDataTable.get_ischarging());

        // Inserting Row
        db.insert(TABLE_OFFLINE_STATS, null, values);
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }

    // code to get the single contact
    OfflineDataTable getLocation(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_OFFLINE_STATS, new String[] { KEY_ID, KEY_LATITUDE, KEY_LONGITUDE, KEY_ACCURACY, KEY_BEARING, KEY_SPEED }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        OfflineDataTable offlineDataTable = new OfflineDataTable(Integer.parseInt(cursor.getString(0))
                ,Double.parseDouble(cursor.getString(1))
                ,Double.parseDouble(cursor.getString(2))
                ,Double.parseDouble(cursor.getString(3))
                ,Float.parseFloat(cursor.getString(4))
                ,Float.parseFloat(cursor.getString(5))
                ,cursor.getString(6)
                ,cursor.getString(7)
                ,cursor.getString(8)
        );
        // return offlineDataTable
        return offlineDataTable;
    }

    // code to get all contacts in a list view
    public List<OfflineDataTable> getAllOfflineStats() {
        List<OfflineDataTable> offlineDataTableList = new ArrayList<OfflineDataTable>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_OFFLINE_STATS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                OfflineDataTable offlineDataTable = new OfflineDataTable();
                offlineDataTable.setID(Integer.parseInt(cursor.getString(0)));
                offlineDataTable.set_latitude(Double.parseDouble(cursor.getString(1)));
                offlineDataTable.set_longitude(Double.parseDouble(cursor.getString(2)));
                offlineDataTable.set_accuracy(Double.parseDouble(cursor.getString(3)));
                offlineDataTable.set_bearing(Float.parseFloat(cursor.getString(4)));
                offlineDataTable.set_speed(Float.parseFloat(cursor.getString(5)));
                offlineDataTable.set_battery(cursor.getString(6));
                offlineDataTable.set_devicetime(cursor.getString(7));
                offlineDataTable.set_ischarging(cursor.getString(8));

                // Adding offlineDataTable to list
                offlineDataTableList.add(offlineDataTable);
            } while (cursor.moveToNext());
        }

        // return contact list
        return offlineDataTableList;
    }

    // code to update the single offlineDataTable
    public int updateLocation(OfflineDataTable offlineDataTable) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_LATITUDE, offlineDataTable.get_latitude());
        values.put(KEY_LONGITUDE, offlineDataTable.get_longitude());
        values.put(KEY_ACCURACY, offlineDataTable.get_accuracy());
        values.put(KEY_BEARING, offlineDataTable.get_bearing());
        values.put(KEY_SPEED, offlineDataTable.get_speed());
        // updating row
        return db.update(TABLE_OFFLINE_STATS, values, KEY_ID + " = ?",
                new String[] { String.valueOf(offlineDataTable.getID()) });
    }

    // Deleting single offlineDataTable
    public void deleteLocationById(OfflineDataTable offlineDataTable) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_OFFLINE_STATS, KEY_ID + " = ?",
                new String[] { String.valueOf(offlineDataTable.getID()) });
        db.close();
    }


    public void clearOfflineStats (){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from "+ TABLE_OFFLINE_STATS);
        db.close();
    }

    // Getting contacts Count
    public int getOfflieStatsCount() {
        String countQuery = "SELECT  * FROM " + TABLE_OFFLINE_STATS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }

}