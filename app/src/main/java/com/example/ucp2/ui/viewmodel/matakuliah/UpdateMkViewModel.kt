package com.example.ucp2.ui.viewmodel.matakuliah

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ucp2.data.entity.MataKuliah
import com.example.ucp2.repository.RepositoryMk
import com.example.ucp2.ui.navigation.DestinasiMKUpdate
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class UpdateMkViewModel (
    savedStateHandle: SavedStateHandle,
    private val repositoryMk: RepositoryMk
) : ViewModel() {

    var updateUIState by mutableStateOf(MkUIState())
        private set

    private val _kode: String = checkNotNull(savedStateHandle[DestinasiMKUpdate.KODE])

    init {
        viewModelScope.launch {
            updateUIState = repositoryMk.getMk(_kode)
                .filterNotNull()
                .first()
                .toUIStateMk()
        }
    }

    fun updateState(matakuliahEvent: MatakuliahEvent) {
        updateUIState = updateUIState.copy(
            matakuliahEvent = matakuliahEvent,
        )
    }

    fun validateFields(): Boolean {
        val event = updateUIState.matakuliahEvent
        val errorState = FormErrorState(
            kode = if (event.kode.isNotEmpty()) null else "Kode tidak boleh kosong",
            nama = if (event.nama.isNotEmpty()) null else "Nama tidak boleh kosong",
            sks = if (event.sks.isNotEmpty()) null else "SKS tidak boleh kosong",
            semester = if (event.semester.isNotEmpty()) null else "Semester tidak boleh Kosong",
            jenis = if (event.jenis.isNotEmpty()) null else "Jenis tidak boleh Kosong",
            dosenpengampu = if (event.dosenpengampu.isNotEmpty()) null else "Dosen Pengampu tidak boleh kosong",
        )

        updateUIState = updateUIState.copy(isEntryValid = errorState)
        return errorState.isValid()
    }

    fun updateData() {
        val currentEvent = updateUIState.matakuliahEvent

        if (validateFields()) {
            viewModelScope.launch {
                try {
                    repositoryMk.updateMk(currentEvent.toMatakuliahEntity())
                    updateUIState = updateUIState.copy(
                        snackBarMessage = "Data berhasil diupdate",
                        matakuliahEvent = MatakuliahEvent(),
                        isEntryValid = FormErrorState()
                    )
                    println(
                        "snackBarMessage diatur: ${
                            updateUIState.snackBarMessage
                        }"
                    )
                } catch (e: Exception) {
                    updateUIState = updateUIState.copy(
                        snackBarMessage = "Data gagal diupdate"
                    )
                }
            }
        } else {
            updateUIState = updateUIState.copy(
                snackBarMessage = "Data gagal diupdate"
            )
        }
    }

    fun resetSnackBarMessage() {
        updateUIState = updateUIState.copy(snackBarMessage = null)
    }
}


    fun MataKuliah. toUIStateMk () : MkUIState = MkUIState (
    matakuliahEvent = this. toDetailUiEvent (),
)