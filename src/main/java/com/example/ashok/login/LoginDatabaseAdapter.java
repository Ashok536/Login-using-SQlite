package com.example.ashok.login;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

public class LoginDatabaseAdapter
{
    static final String DATABASE_NAME = "login.db";
    static final int DATABASE_VERSION = 1;
   // public static final int NAME_COLUMN = 1;
    // SQL Statement to create a new database.
    static final String DATABASE_CREATE = "create table "+"LOGIN"+"( " +"ID"+" integer primary key autoincrement,"+ "USERNAME  text,PASSWORD text); ";

    // Variable to hold the database instance
    public SQLiteDatabase db;
    // Context of the application using the database.
    private final Context context;
    // Database open/upgrade helper
    private DataBaseHelper dbHelper;
    public LoginDatabaseAdapter(Context _context)
    {
        context = _context;
        dbHelper = new DataBaseHelper(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    // Method to open the Database
    public LoginDatabaseAdapter open() throws SQLException
    {
        db = dbHelper.getWritableDatabase();
        return this;
    }
    // method to insert a record in Table
    public void insertEntry(String userName,String password)
    {
        ContentValues newValues = new ContentValues();
        // Assign values
        newValues.put("USERNAME", userName);
        newValues.put("PASSWORD",password);
        // Insert a row into a database table
        db.insert("LOGIN", null, newValues);
        Toast.makeText(context, "User Info Saved", Toast.LENGTH_LONG).show();
    }
    // method to get the password  of userName
    public String getSingleEntry(String userName)
    {
        Cursor cursor=db.query("LOGIN", null, " USERNAME=?", new String[]{userName}, null, null, null);
        if(cursor.getCount()<1) // UserName Not Exist
            return "NOT EXIST";
        cursor.moveToFirst();
        String password= cursor.getString(cursor.getColumnIndex("PASSWORD"));
        return password;
    }
    public void close()
    {
        db.close();
    }
}
