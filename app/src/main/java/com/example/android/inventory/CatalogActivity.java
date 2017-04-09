package com.example.android.inventory;

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
        displayDatabaseInfo();
    }

    private void displayDatabaseInfo() {
        // Access the database
        DatabaseHelper mDbHelper = new DatabaseHelper(this);

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
                // Do nothing for now
                return true;
            // Respond to a click on the "Delete All Products" menu option
            case R.id.action_delete_products:
                // Do nothing for now
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
