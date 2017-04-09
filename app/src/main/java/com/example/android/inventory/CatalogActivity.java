package com.example.android.inventory;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

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
    }
}
