package com.example.android.inventory;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class EditorActivity extends AppCompatActivity {

    private EditText mNameEditText;

    private EditText mPriceEditText;

    private EditText mQuantityEditText;

    private EditText mSupplierNameEditText;

    private EditText mSupplierEmailEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);

        // Find all the relevant views to read user input from
        mNameEditText = (EditText) findViewById(R.id.product_name);
        mPriceEditText = (EditText) findViewById(R.id.product_price);
        mQuantityEditText = (EditText) findViewById(R.id.product_quantity);
        mSupplierNameEditText = (EditText) findViewById(R.id.supplier_name);
        mSupplierEmailEditText = (EditText) findViewById(R.id.supplier_email);
    }
}
