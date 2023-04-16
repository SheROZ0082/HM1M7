package com.example.hm1m7.data.local

import androidx.room.*
import com.example.hm1m7.data.model.NoteEntity

@Dao

interface NoteDao {

    @Insert
    suspend fun createNote(noteEntity: NoteEntity)

    @Query("SELECT * FROM notes")
    suspend fun getAllNotes():List<NoteEntity>

    @Update
    suspend fun editNote(noteEntity: NoteEntity )

    @Delete
    suspend fun deleteNote(noteEntity: NoteEntity )

}