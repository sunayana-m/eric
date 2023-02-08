package com.example.sql_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    private static final String dbname = "studentdb";
    private static final String tbname = "student";
    private static int dbVersion = 1;

    DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }



    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("Create table "+ tbname+" (uname VARCHAR(10),passw VARCHAR(10))"+ ";");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+tbname);
        onCreate(sqLiteDatabase);
    }

    public long addUser(String usname,String pass)
    {
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues cv= new ContentValues();
        cv.put("uname",usname);
        cv.put("passw",pass);
        long result = db.insert(tbname,null,cv);
        db.close();
        return result;
    }

    public void update(String usname,String newpass){
        SQLiteDatabase db= this.getWritableDatabase();
        db.execSQL("UPDATE "+tbname+" SET passw='"+newpass+"'"+"WHERE uname ='"+usname+"'"+";");
        db.close();
    }
    public void delete(String usname){
        SQLiteDatabase db= this.getWritableDatabase();
        db.execSQL("DELETE FROM "+tbname+" WHERE uname='"+usname+"';");
        db.close();
    }
    public String display() {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("Select * from " + tbname, null);
        String finalres = "";
        while (cursor.moveToNext()) {
            finalres += cursor.getString(0) + " :" + cursor.getString(1);
        }
        return finalres;
    }
}
