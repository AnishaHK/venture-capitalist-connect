package com.example.vc;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper1 extends SQLiteOpenHelper{
    public  static final String DBNAME="startupregister.db";
    public DBHelper1( Context context) {
        super(context, "startupregister.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table startupusers(name TEXT primary key, email TEXT, phone TEXT, website TEXT, about TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int oldVersion, int newVersion) {
        MyDB.execSQL("drop table if exists startupregister.db ");

    }

    public Boolean insertData(String name, String email,String phone, String website , String  about) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("email", email);
        contentValues.put("phone", phone);
        contentValues.put("website",website);
        contentValues.put("about",about);
        long result = MyDB.insert("startupusers", null, contentValues);

        if (result == -1) return false;
        else
            return true;
    }


}