package com.example.databases

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.databases.databinding.ActivityAddNoteBinding
import com.example.databases.db.Notes

class AddNoteActivity : AppCompatActivity() {
    private lateinit var binding:ActivityAddNoteBinding
    lateinit var viewModal: NotesViewModel
    var noteID = -1;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_add_note)

        viewModal = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        ).get(NotesViewModel::class.java)

        binding.btnAdd.setOnClickListener(View.OnClickListener {

            val noteType = intent.getStringExtra("noteType")

            val noteTitle = binding.etNote.text.toString()
            if (noteTitle.isNotEmpty()){
                viewModal.addNotes(Notes(0,noteTitle))
                Toast.makeText(this, "$noteTitle Added", Toast.LENGTH_LONG).show()
            }
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        })




    }
}