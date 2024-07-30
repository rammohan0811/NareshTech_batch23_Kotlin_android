package com.nareshit.roomdatabase

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Person::class], version = 1)
abstract class PersonRoomDatabase:RoomDatabase() {
    abstract fun personDao():PersonDao
}