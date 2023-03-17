package com.example.databases.db

import androidx.lifecycle.LiveData

class NotesRepository(private val notesDao:NotesDao) {
    val notesLiveData : LiveData<List<Notes>> = notesDao.getUsers()

    suspend fun addNotes(note:Notes){
        notesDao.insertUser(note)
    }
    suspend fun deleteUser(note: Notes){
        notesDao.deleteUser(note)
    }
}