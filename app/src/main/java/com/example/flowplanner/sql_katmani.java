package com.example.flowplanner;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class sql_katmani extends SQLiteOpenHelper {

    public sql_katmani(Context c)
    {
        super(c,"akis",null,1);
    }


    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("create table akis(id integer primary key autoincrement ,name text,dead_yil integer,dead_ay integer, dead_gun integer)");

    }

    public void onUpgrade(SQLiteDatabase db,int eski,int yeni)
    {
        db.execSQL("drop table if exists akis");

    }

}
