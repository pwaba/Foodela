package com.example.android.myapplication.users;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "userDb5";
    private static final String TABLE_CONTACTS = "users";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_USER_DATA = "data";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_USER_DATA + " TEXT" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);

        // Create tables again
        onCreate(db);
    }

    // code to add the new contact
    void addUserToDb(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(KEY_NAME, user.getName());
        values.put(KEY_USER_DATA, user.getBytes());

        // Inserting Row
        db.insert(TABLE_CONTACTS, null, values);
        db.close(); // Closing database connection
    }

    // code to get the single contact
    User getUser(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        byte[] blob = {'1'};
        String[] stra = new String[] { KEY_ID, KEY_NAME, KEY_USER_DATA};

        Cursor cursor = db.query(TABLE_CONTACTS, stra, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);

        if (cursor != null)
        {
            cursor.moveToFirst();
            blob = cursor.getBlob(2);
        }

        db.close(); // Closing database connection

        return User.createObjFromBytes(blob);
    }

   // code to get all contacts in a list view
    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<User>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_CONTACTS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                User contact = User.createObjFromBytes(cursor.getBlob(2));
                // Adding contact to list
                userList.add(contact);
            } while (cursor.moveToNext());
        }

        db.close(); // Closing database connection
        // return contact list
        return userList;
    }

    // code to update the single contact
    public int updateContact(User user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, user.getName());
        values.put(KEY_USER_DATA, user.getBytes());

        throw new UnsupportedOperationException();//Not finished
        // updating row
        //return db.update(TABLE_CONTACTS, values, KEY_ID + " = ?",
        //        new String[] { String.valueOf(user.getID()) });
    }

    // Deleting single contact
    public void deleteContact(User user) {
        SQLiteDatabase db = this.getWritableDatabase();

        throw new UnsupportedOperationException();//Not finished

        //db.delete(TABLE_CONTACTS, KEY_ID + " = ?",
        //        new String[] { String.valueOf(user.getID()) });
        //db.close();
    }

    // Getting contacts Count
    public int getUsersCount() {
        String countQuery = "SELECT  * FROM " + TABLE_CONTACTS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        db.close();

        return count;
    }



}