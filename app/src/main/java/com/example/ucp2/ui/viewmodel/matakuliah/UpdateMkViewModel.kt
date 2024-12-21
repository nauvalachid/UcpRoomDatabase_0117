package com.example.ucp2.ui.viewmodel.matakuliah

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.ucp2.data.entity.MataKuliah
import com.example.ucp2.repository.RepositoryMk

class UpdateMkViewModel (
    savedStateHandle: SavedStateHandle,
    private val repositoryMk: RepositoryMk
) : ViewModel()

fun MataKuliah. toUIStateMk () : MkUIState = MkUIState (
    matakuliahEvent = this. toDetailUiEvent (),
)