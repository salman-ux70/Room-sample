package com.example.databases

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.databases.databinding.ActivityMainBinding
import com.example.databases.db.Notes

class MainActivity : AppCompatActivity(), NoteClickInterface, NoteClickDeleteInterface  {
    private lateinit var binding: ActivityMainBinding
    lateinit var viewModal: NotesViewModel
    lateinit var notesRV: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.addUserFab.setOnClickListener(View.OnClickListener {
         val intent = Intent(this,AddNoteActivity::class.java)
          startActivity(intent)
        })
        /*viewModal.addNotes(Notes(0,"sadasdsad"))*/
        val noteRVAdapter = NotesRVAdapter(this, this, this)
        binding.userList.adapter = noteRVAdapter

        viewModal = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        ).get(NotesViewModel::class.java)

        viewModal.allNotes.observe(this, Observer {
            noteRVAdapter.updateList(it)
        })

    }

    override fun onDeleteIconClick(note: Notes) {

    }

    override fun onNoteClick(note: Notes) {

    }
}