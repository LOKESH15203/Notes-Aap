package com.example.aa6notesaap

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NotesViewModel(application: Application) : AndroidViewModel(application){

    private val repository : NotesRepository
    val allNotes: LiveData<List<Notes>>

    init{
        val dao = NotesDatabase.getDatabase(application).getNoteDao()
        repository = NotesRepository(dao)
        allNotes = repository.allNotes
    }

    // Syntax bellow is different to keep delete function in background
    fun deleteNote(note : Notes) = viewModelScope.launch (Dispatchers.IO){
        repository.delete(note)
    }

    fun insertNote(note: Notes) = viewModelScope.launch (Dispatchers.IO){
        repository.insert(note)
    }
}