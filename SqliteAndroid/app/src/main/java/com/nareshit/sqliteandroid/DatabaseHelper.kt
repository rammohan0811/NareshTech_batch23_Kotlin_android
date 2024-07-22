package com.nareshit.sqliteandroid

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context):SQLiteOpenHelper(context, DATABASE_NAME,null, DATABASE_VERSION){

    companion object{
        val DATABASE_NAME = "myDb"
        val TABLE_NAME = "person"
        val COL_0 = "person_id"
        val COL_1 = "person_name"
        val COL_2 = "person_age"
        val DATABASE_VERSION = 1
    }

    override fun onCreate(db: SQLiteDatabase?) {
        // We can create the database table with the help of SQLiteDatabase Object
        // This runs only once. to run this method again, you need to call it explicitly.
        val createQuery = "create table $TABLE_NAME($COL_0 integer primary key autoincrement, $COL_1 text, $COL_2 integer);"
        db?.execSQL(createQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("drop table $TABLE_NAME")
        onCreate(db)
    }

    // to insert values into the database
    fun insertData(values:ContentValues){
        // First get the writable permission
        val db = this.writableDatabase
        db.insert(TABLE_NAME,null,values)
    }

    fun loadData():Cursor{
        val db = this.readableDatabase
        return db.rawQuery("select * from $TABLE_NAME",null)
    }

}