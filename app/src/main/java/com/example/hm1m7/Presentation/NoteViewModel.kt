package com.example.hm1m7.Presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hm1m7.domain.model.Note
import com.example.hm1m7.domain.usecases.DeleteNoteUseCase
import com.example.hm1m7.domain.usecases.GetAllNotesUseCase
import com.example.hm1m7.domain.utils.Resource
import com.example.hm1m7.domain.utils.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotesViewModel  @Inject constructor(
    private val getAllNoteUseCase: GetAllNotesUseCase,
    private val deleteAllNotesUseCase: DeleteNoteUseCase
): ViewModel() {

    private val _getAllNotesState = MutableStateFlow<UIState<List<Note>>>(UIState.Empty())
    val getAllNotesState =_getAllNotesState.asStateFlow()

    private val _deleteNote = MutableStateFlow<UIState<Unit>>(UIState.Empty())
    val deleteNoteState =_deleteNote

    fun getAllNotes(){
        viewModelScope.launch {
            getAllNoteUseCase.getaAllNotes().collect{
                when(it){
                    is Resource.Error -> {
                        _getAllNotesState.value=UIState.Error(it.message!!)
                    }
                    is Resource.Loading -> {
                        _getAllNotesState.value=UIState.Loading()
                    }
                    is Resource.Success -> {
                        if (it.data!=null){
                            _getAllNotesState.value= UIState.Success(it.data)
                        }
                    }
                }
            }
        }
    }
    fun deleteNote(nOte: Note){
        viewModelScope.launch {
            deleteAllNotesUseCase.deleteNOte(nOte).collect{
                when(it){
                    is Resource.Error -> {
                        _deleteNote.value=UIState.Error(it.message.toString())
                    }
                    is Resource.Loading -> {
                        _deleteNote.value=UIState.Loading()
                    }
                    is Resource.Success -> {
                        if (it.data!=null){
                            _deleteNote.value=UIState.Success(it.data)
                        }
                    }
                }
            }
        }
    }
}