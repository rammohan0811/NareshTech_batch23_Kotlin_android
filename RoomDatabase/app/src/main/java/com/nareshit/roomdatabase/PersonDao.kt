package com.nareshit.roomdatabase

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PersonDao {

    @Insert
    fun insertData(p:Person):Unit

    @Query("select * from person")
    fun getAllData():List<Person>
}