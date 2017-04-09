package com.example.android.inventory;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.android.inventory.data.DatabaseHelper;
import com.example.android.inventory.data.ProductContract.ProductEntry;

public class CatalogActivity extends AppCompatActivity {

    private DatabaseHelper mDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);

        // Find a reference to the FloatingActionButton
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_button);

        // Set a OnClickListener for the FloatingActionButton
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // When the FloatingActionButton is clicked, open the EditorActivity
                Intent editIntent = new Intent(CatalogActivity.this, EditorActivity.class);

                // Start the intent to open the activity
                startActivity(editIntent);
            }
        });

        mDbHelper = new DatabaseHelper(this);

        displayDatabaseInfo();
    }

    private void displayDatabaseInfo() {

        // Create and/or open a database to read from it
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        // Perform this raw SQL query "SELECT * FROM products"
        // to get a Cursor that contains all rows from the products table
        Cursor cursor = db.rawQuery("SELECT * FROM " + ProductEntry.TABLE_NAME, null);
        try {
            // Display the number of rows in the Cursor
            TextView displayView = (TextView) findViewById(R.id.database_info);
            displayView.setText("Number of rows in the products table: " + cursor.getCount());
        } finally {
            cursor.close();
        }
    }

    private void insertProduct() {
        // Gets the database in write mode
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        // Create a new ContentValues object where column names are the keys
        // and product attributes are the values
        ContentValues values = new ContentValues();
        values.put(ProductEntry.COLUMN_PRODUCT_NAME, "340ml Coke");
        values.put(ProductEntry.COLUMN_PRODUCT_PRICE, 7.50);
        values.put(ProductEntry.COLUMN_PRODUCT_QUANTITY, 24);
        values.put(ProductEntry.COLUMN_PRODUCT_SUPPLIER_NAME, "Makro Centurion");
        values.put(ProductEntry.COLUMN_PRODUCT_SUPPLIER_EMAIL, "jvh@afrihost.co.za");

        // Insert a new row for the product in the database, returning the ID of that new row.
        long newRowId = db.insert(ProductEntry.TABLE_NAME, null, values);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_catalog, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // User clicked on a menu option in the app bar overflow menu
        switch (item.getItemId()) {
            // Respond to a click on the "Insert Dummy Data" menu option
            case R.id.action_insert_dummy_data:
                insertProduct();
                displayDatabaseInfo();
                return true;
            // Respond to a click on the "Delete All Products" menu option
            case R.id.action_delete_products:
                // Do nothing for now
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
