package com.example.aa6notesaap

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes_table")  // Annotated as a entity
class Notes(@ColumnInfo(name= "text")val text: String) {
    @PrimaryKey(autoGenerate = true) var id = 0
}