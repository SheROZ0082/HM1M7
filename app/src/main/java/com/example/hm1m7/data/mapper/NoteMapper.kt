package com.example.hm1m7.data.mapper

import com.example.hm1m7.data.model.NoteEntity
import com.example.hm1m7.domain.model.Note

fun Note.toEntity()=NoteEntity(
    id, title, description
)
fun NoteEntity.toNote()=Note(
    id, title, description
)
