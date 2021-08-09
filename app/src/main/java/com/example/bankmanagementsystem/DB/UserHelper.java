package com.example.bankmanagementsystem.DB;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.bankmanagementsystem.DB.UserContract.UserEntry;

public class UserHelper extends SQLiteOpenHelper {

    String TABLE_NAME = UserEntry.TABLE_NAME;

    /** Name of the database file */
    private static final String DATABASE_NAME = "User.db";

    /**
     * Database version. If you change the database schema, you must increment the database version.*/
    private static final int DATABASE_VERSION = 1;

    public UserHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the pets table
        String SQL_CREATE_USER_TABLE =  "CREATE TABLE " + UserEntry.TABLE_NAME + " ("
                + UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " INTEGER, "
                + UserEntry.COLUMN_USER_NAME + " VARCHAR, "
                + UserEntry.COLUMN_USER_EMAIL + " VARCHAR, "
                + UserEntry.COLUMN_USER_IFSC_CODE + " VARCHAR, "
                + UserEntry.COLUMN_USER_PHONE_NO + " VARCHAR, "
                + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " INTEGER NOT NULL);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_USER_TABLE);

        // Insert Into Table
        db.execSQL("insert into " + TABLE_NAME + " values(923001,'Sourav Kumar', 'sourav@gmail.com','IFSC7584','9234948917', 5000)");
        db.execSQL("insert into " + TABLE_NAME + " values(9230002,'Nikhil', 'nikhil@gmail.com','IFSC1258','6200549287', 4000)");
        db.execSQL("insert into " + TABLE_NAME + " values(9230006,'Shubham Kumar', 'shubham@gmail.com','IFSC9985','957153456', 7500)");
        db.execSQL("insert into " + TABLE_NAME + " values(9230005,'Ashlesha', 'ash@gmail.com','3669','IFSC1553759456', 4500)");
        db.execSQL("insert into " + TABLE_NAME + " values(9230004,'Puja', 'puja@gmail.com','IFSC7752','987654321', 8000)");
        db.execSQL("insert into " + TABLE_NAME + " values(9230003,' M.Akhilesh', 'akhilesh@gmail.com','IFSC8896','123456789', 5000)");
        db.execSQL("insert into " + TABLE_NAME + " values(9230007,'Jai Bahadur', 'jai@gmail.com','IFSC1207','753951123', 5800)");
        db.execSQL("insert into " + TABLE_NAME + " values(9230008,'Vishal', 'vishal@gmail.com','IFSC4522','357159987', 2500)");
        db.execSQL("insert into " + TABLE_NAME + " values(9230009,'Shivam Sharma', 'shivam@gmail.com','IFSC6582','741258963', 10500)");
        db.execSQL("insert into " + TABLE_NAME + " values(9230010,'Nishant', 'nishant@gmail.com','IFSC5450','308965424', 1000)");
        db.execSQL("insert into " + TABLE_NAME + " values(9230011,'Ritesh Ranjan', 'ritesh@gmail.com','IFSC2656','4529874236', 9800)");
        db.execSQL("insert into " + TABLE_NAME + " values(9230012,'Deepak Kumar', 'deepak@gmail.com','IFSC1203','919996735', 6000)");
        db.execSQL("insert into " + TABLE_NAME + " values(9230013,'Abhishek ', 'abhishek@gmail.com','IFSC5566','7654924180', 3000)");
        db.execSQL("insert into " + TABLE_NAME + " values(9230014,'Sita Kumari', 'sita@gmail.com','IFSC2236','6254642205', 3500)");
        db.execSQL("insert into " + TABLE_NAME + " values(9230015,'xyz ', 'xyz@gmail.com','IFSC6692','7654924180', 2500)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            // Simplest implementation is to drop all old tables and recreate them
            db.execSQL("DROP TABLE IF EXISTS " + UserEntry.TABLE_NAME);
            onCreate(db);
        }
    }

    public Cursor readAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME, null);
        return cursor;
    }

    public Cursor readParticularData (int accountNo) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME + " where " +
                                        UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo, null);
        return cursor;
    }

    public void updateAmount(int accountNo, int amount) {
        Log.d ("TAG", "update Amount");
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("update " + UserEntry.TABLE_NAME + " set " + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " = " + amount + " where " +
                UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo);
    }
}