package com.example.databases.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note_table")
data class Notes(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    @ColumnInfo(name = "notes")  val note:String

    )
