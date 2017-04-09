package com.example.android.inventory.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.android.inventory.data.ProductContract.ProductEntry;

/**
 * Created by jvh on 4/9/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper{

    // Tag for logging messages, mostly used for debugging purpose
    public static final String LOG_TAG = DatabaseHelper.class.getSimpleName();

    /** Name of the database file */
    public static final String DATABASE_NAME = "inventory.db";

    /** Database version. If the database is changed, increment the database version */
    public static final int DATABASE_VERSION = 1;

    /**
     * Constructs a new instance of {@link DatabaseHelper}.
     * @param context of the app
     */
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * This is called when the database is created for the first time.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the products table
        String SQL_CREATE_ENTRIES = "CREATE TABLE " + ProductEntry.TABLE_NAME + " ("
                + ProductEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + ProductEntry.COLUMN_PRODUCT_NAME + " TEXT NOT NULL, "
                + ProductEntry.COLUMN_PRODUCT_PRICE + " FLOAT NOT NULL, "
                + ProductEntry.COLUMN_PRODUCT_QUANTITY + " INTEGER NOT NULL DEFAULT 0, "
                + ProductEntry.COLUMN_PRODUCT_SUPPLIER_NAME + " TEXT NOT NULL, "
                + ProductEntry.COLUMN_PRODUCT_SUPPLIER_EMAIL + " TEXT NOT NULL);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_ENTRIES);
        Log.v(LOG_TAG, SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
