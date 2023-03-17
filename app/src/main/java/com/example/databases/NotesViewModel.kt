package com.example.databases

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.databases.db.NoteDatabase
import com.example.databases.db.Notes
import com.example.databases.db.NotesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NotesViewModel(application: Application) : AndroidViewModel(application) {

   val allNotes : LiveData<List<Notes>>
   val repository : NotesRepository
  init {
      val dao = NoteDatabase.getDatabase(application).getNotesDao()
      repository = NotesRepository(dao)
      allNotes = repository.notesLiveData
  }

    fun addNotes(notes:Notes) = viewModelScope.launch (Dispatchers.IO){
        repository.addNotes(notes)
    }

    fun deleteNote(notes: Notes) = viewModelScope.launch(Dispatchers.IO) {
        repository.deleteUser(notes)
    }
}