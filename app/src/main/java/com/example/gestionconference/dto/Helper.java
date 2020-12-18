package com.example.gestionconference.dto;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class Helper extends SQLiteOpenHelper {
    private static String _DatabaseName = "clientDatabase";
    // Database Version
    private static final int DATABASE_VERSION = 1;

    public Helper(Context context) {
        super(context, _DatabaseName, null, DATABASE_VERSION);
    }
    private static final String TABLE_USER = "user";
    // User Table Columns names
    private static final String COLUMN_USER_ID = "user_id";
    private static final String COLUMN_USER_NOM = "user_nom";
    private static final String COLUMN_USER_PRENOM = "user_prenom";
    private static final String COLUMN_USER_EMAIL = "user_email";
    private static final String COLUMN_USER_ADRESS = "user_adress";
    private static final String COLUMN_USER_PROFESSION = "user_profession";
    private static final String COLUMN_USER_PASSWORD = "user_password";

    // create table sql query
    private String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USER + "("
            + COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_USER_NOM + " TEXT,"+COLUMN_USER_PRENOM+" TEXT,"
            + COLUMN_USER_EMAIL + " TEXT,"+COLUMN_USER_ADRESS +" TEXT," +COLUMN_USER_PROFESSION  +" TEXT," + COLUMN_USER_PASSWORD + " TEXT" + ")";
    // drop table sql query
    private String DROP_USER_TABLE = "DROP TABLE IF EXISTS " + TABLE_USER;

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Drop User Table if exist
        db.execSQL(DROP_USER_TABLE);
        // Create tables again
        onCreate(db);
    }

    //
    public void addUser(UserDetails user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_NOM, user.getNom());
        values.put(COLUMN_USER_PRENOM,user.getPrenom());
        values.put(COLUMN_USER_EMAIL, user.getEmail());
        values.put(COLUMN_USER_ADRESS,user.getAdress());
        values.put(COLUMN_USER_PROFESSION,user.getProfessioon());
        values.put(COLUMN_USER_PASSWORD, user.getPassword());
        // Inserting Row
        db.insert(TABLE_USER, null, values);
        db.close();
    }

    public List<UserDetails> getAllUser() {
        // array of columns to fetch
        String[] columns = {
                COLUMN_USER_ID,
                COLUMN_USER_NOM,
                COLUMN_USER_PRENOM,
                COLUMN_USER_EMAIL,
                COLUMN_USER_ADRESS,
                COLUMN_USER_PROFESSION,
                COLUMN_USER_PASSWORD
        };
      // sorting orders
        String sortOrder =
                COLUMN_USER_NOM+ " ASC";
        List<UserDetails> userList = new ArrayList<UserDetails>();
        SQLiteDatabase db = this.getReadableDatabase();


        Cursor cursor = db.query(TABLE_USER, //Table to query
                columns,    //columns to return
                null,        //columns for the WHERE clause
                null,        //The values for the WHERE clause
                null,       //group the rows
                null,       //filter by row groups
                sortOrder); //The sort order
        // Traversing through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                UserDetails user = new UserDetails();
                user.setID(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_USER_ID))));
                user.setNom(cursor.getString(cursor.getColumnIndex(COLUMN_USER_NOM)));
                user.setPrenom(cursor.getString(cursor.getColumnIndex(COLUMN_USER_PRENOM)));
                user.setEmail(cursor.getString(cursor.getColumnIndex(COLUMN_USER_EMAIL)));
                user.setAdress(cursor.getString(cursor.getColumnIndex(COLUMN_USER_ADRESS)));
                user.setProfessioon(cursor.getString(cursor.getColumnIndex(COLUMN_USER_PROFESSION)));
                user.setPassword(cursor.getString(cursor.getColumnIndex(COLUMN_USER_PASSWORD)));
                // Adding user record to list
                userList.add(user);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        // return user list
        return userList;
    }
}
