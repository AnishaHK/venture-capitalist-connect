package com.example.vc;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper{
    public  static final String DBNAME="vcregister.db";
    public DBHelper( Context context) {
        super(context, "vcregister.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table vcusers(name TEXT primary key, email TEXT, phone TEXT, password TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int oldVersion, int newVersion) {
        MyDB.execSQL("drop table if exists vcusers ");

    }

    public Boolean insertData(String name, String email,String phone, String password ) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("email", email);
        contentValues.put("phone", phone);
        contentValues.put("password", password);
        long result = MyDB.insert("vcusers", null, contentValues);

        if (result == -1) return false;
        else
            return true;
    }

    public Boolean checkusernamepassword(String email, String password) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("SELECT * FROM vcusers WHERE email = ? AND password = ?", new String[]{email, password});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }
}