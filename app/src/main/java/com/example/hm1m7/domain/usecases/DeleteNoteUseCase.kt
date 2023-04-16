package com.example.hm1m7.domain.usecases

import com.example.hm1m7.domain.model.Note
import com.example.hm1m7.domain.repository.NoteRepository
import javax.inject.Inject

class DeleteNoteUseCase @Inject constructor(
    private val noteRepository: NoteRepository
) {

    fun deleteNOte(nOte: Note) = noteRepository.deleteNote(nOte)
}