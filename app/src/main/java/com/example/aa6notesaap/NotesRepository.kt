package com.example.aa6notesaap

import androidx.lifecycle.LiveData

class NotesRepository(private val noteDao: NotesDao) {

    val allNotes : LiveData<List<Notes>> = noteDao.getNotes()

    suspend fun insert(note : Notes){
        noteDao.insert(note)
    }
    suspend fun delete(note: Notes){
        noteDao.delete(note)
    }

}
