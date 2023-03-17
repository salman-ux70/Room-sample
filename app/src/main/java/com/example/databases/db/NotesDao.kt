package com.example.databases.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NotesDao {
    @Query("SELECT * FROM note_table")
    fun getUsers(): LiveData<List<Notes>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(notes:Notes)

    @Delete
    
    suspend fun deleteUser(notes:Notes)
}