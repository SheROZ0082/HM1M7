package com.example.hm1m7.Presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.hm1m7.domain.model.Note
import com.example.hm1m7.domain.model.Note.Companion.DEFAULT_ID
import com.example.hm1m7.domain.usecases.CreateNoteUseCase
import com.example.lesson01_month07.databinding.FragmentEditNoteBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class EditNoteFragment : Fragment() {

    private lateinit var binding: FragmentEditNoteBinding

    @Inject
    lateinit var createNoteUseCase: CreateNoteUseCase

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEditNoteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupRequest()
        setupSubscriber()
        initListeners()
    }

    private fun initListeners() {
        binding.sendBtn.setOnClickListener {
            createNoteUseCase.createNote(
                Note(
                     title = binding.etTitle.text.toString(),
                   description = binding.etDesc.text.toString()
                )
            )
        }
    }

    private fun setupSubscriber() {

    }

    private fun setupRequest() {

    }

    private fun initialize() {

    }

    companion object {
        const val NOTE_PAIR = "skjjsdfj"
        const val DESC_PAIR = "sdssdfjkf"
    }

}




