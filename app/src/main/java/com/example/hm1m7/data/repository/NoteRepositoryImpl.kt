package com.example.hm1m7.data.repository

import com.example.hm1m7.data.base.BaseRepository
import com.example.hm1m7.data.local.NoteDao
import com.example.hm1m7.data.mapper.toEntity
import com.example.hm1m7.data.mapper.toNote
import com.example.hm1m7.domain.model.Note
import com.example.hm1m7.domain.repository.NoteRepository
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(
    private val noteDAo: NoteDao
) : NoteRepository, BaseRepository() {

    override fun createNote(note: Note) = doRequest {
        noteDAo.createNote(note.toEntity())
    }

    override fun getAllNotes() = doRequest {
        noteDAo.getAllNotes().map {
            it.toNote()
        }
    }


    override fun editNote(note: Note) = doRequest {
        noteDAo.editNote(note.toEntity())
    }

    override fun deleteNote(note: Note) = doRequest {
        noteDAo.deleteNote(note.toEntity())
    }
}