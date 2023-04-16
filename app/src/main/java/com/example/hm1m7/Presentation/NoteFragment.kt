package com.example.hm1m7.Presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.example.hm1m7.domain.utils.UIState
import com.example.lesson01_month07.R
import com.example.lesson01_month07.databinding.FragmentNoteBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class NoteFragment : Fragment() {

    private val viewModel: NotesViewModel by viewModels()
    private val adapterNotes by lazy {
        AdapterNotes()
    }
    private lateinit var binding: FragmentNoteBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNoteBinding.inflate(inflater, container, false)
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
        binding.goFab.setOnClickListener{
            findNavController().navigate(R.id.noteFragment)
        }

    }

    private fun setupRequest() {
        viewModel.getAllNotes()
    }

    private fun setupSubscriber() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.getAllNotesState.collect {
                    when (it) {
                        is UIState.Empty -> {}
                        is UIState.Error -> {
                            Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                        }
                        is UIState.Loading -> {
                            //show progress bar dz3
                        }
                        is UIState.Success -> {
                            //отправка списка в адаптер dz3
                            binding.rv.apply {
                                adapter=adapterNotes
                                adapterNotes.addNotes(it.data)
                            }
                        }

                    }
                }
            }
        }
    }

    private fun initialize() {

    }
    companion object {
        const val NOTE_PAIR = "skjjsdfj"
        const val DESC_PAIR = "sdssdfjkf"
    }

}