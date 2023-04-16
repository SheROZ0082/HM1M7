package com.example.hm1m7.domain.usecases

import com.example.hm1m7.domain.repository.NoteRepository
import javax.inject.Inject

class GetAllNotesUseCase @Inject constructor(
    private val noteRepository: NoteRepository
) {

    fun getaAllNotes() = noteRepository.getAllNotes()
}