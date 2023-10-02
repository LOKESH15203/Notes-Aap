package com.example.aa6notesaap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aa6notesaap.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), INotesRVadapter {

    private lateinit var binding: ActivityMainBinding
    lateinit var viewModel : NotesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(binding.root)
        binding = ActivityMainBinding.inflate(layoutInflater)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = NotesRVadapter(this, this)
        binding.recyclerView.adapter = adapter

        viewModel = ViewModelProvider(this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(NotesViewModel::class.java)
        viewModel.allNotes.observe(this, Observer {list ->
            list ?. let { // To check Nullability
                adapter.updataList(it)
            }
        })
    }

    fun toAdd(view: View) {
        val noteText = binding.editText.text.toString()
        if(noteText.isNotEmpty()){
            viewModel.insertNote(Notes(noteText))
            Toast.makeText(this, "$noteText Added", Toast.LENGTH_SHORT).show()
            binding.editText.text.clear()
        }
        else{
            Toast.makeText(this, "Please Enter Something", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onItemClicked(notes: Notes) {
        viewModel.deleteNote(notes)
        Toast.makeText(this, "${notes.text} Deleted", Toast.LENGTH_SHORT).show()
    }
}