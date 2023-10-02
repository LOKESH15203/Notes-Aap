package com.example.aa6notesaap

import android.accounts.AuthenticatorDescription
import android.icu.text.CaseMap.Title
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes_table")  // Annotated as a entity
class Notes(@ColumnInfo(name= "title")val noteTitle: String,
            @ColumnInfo(name= "Description")val noteDescription: String,
            @ColumnInfo(name = "TimeStamp")val TimeStamp: String
            ) {
    @PrimaryKey(autoGenerate = true)
    var id = 0
}