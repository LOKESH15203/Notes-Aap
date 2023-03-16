package com.example.aa6notesaap

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface NotesDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE) // here onConflict is used to not allow repeated entries.
    suspend fun insert(note: Notes) // SUSPEND used to run Insert & delete in Background and not on the main thread making the aap faster

    @Delete
    suspend fun delete(note: Notes)

    @Query("Select * from notes_table order by id ASC")
    fun getNotes(): LiveData<List<Notes>> // Live data for real time changes
}