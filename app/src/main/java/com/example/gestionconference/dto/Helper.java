package com.example.gestionconference.dto;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public class Helper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 2;
    public static final String DATABASE_NAME = "conferencess.db";


    public Helper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public boolean checkUser(String trim, String trim1) {
        return true;
    }

    //column

    public static final String TABLE_NAME = "Userss";
    public static final String COLUMN_ID = "user_id";
    public static final String COLUMN_NAME = "nom";
    public static final String COLUMN_PRENOM = "prenom";
    public static final String COLUMN_Mail = "mail";
    public static final String COLUMN_Adress = "address";
    public static final String COLUMN_password = "password";

     String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + TABLE_NAME + " (" +
                      COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    COLUMN_PRENOM + " TEXT," +
                    COLUMN_NAME + " TEXT," +
                    COLUMN_Mail + "TEXT," +
                    COLUMN_Adress + "TEXT," +
                    COLUMN_password + "TEXT" + ")";

    private static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + TABLE_NAME;

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }



}
