package com.example.hm1m7.domain.usecases

import com.example.hm1m7.data.repository.NoteRepositoryImpl
import com.example.hm1m7.domain.model.Note
import com.example.hm1m7.domain.repository.NoteRepository

class CreateNoteUseCase(private val noteRepository: NoteRepository ) {

    fun createNote(note: Note) = noteRepository.createNote(note)

}