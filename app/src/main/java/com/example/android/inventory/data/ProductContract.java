package com.example.android.inventory.data;

import android.provider.BaseColumns;

/**
 * API Contract for the Inventory app.
 */

public final class ProductContract {

    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor
    private ProductContract() {}

    public static final class ProductEntry implements BaseColumns{

        // Name for the products table in the database
        public static final String TABLE_NAME = "products";

        // Column names for each of the columns in the products table
        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_PRODUCT_NAME = "product_name";
        public static final String COLUMN_PRODUCT_PRICE = "price";
        public static final String COLUMN_PRODUCT_QUANTITY = "quantity";
        public static final String COLUMN_PRODUCT_SUPPLIER_NAME = "supplier_name";
        public static final String COLUMN_PRODUCT_SUPPLIER_EMAIL = "supplier_email";
    }
}
