package com.example.ucp2.ui.viewmodel.matakuliah

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.ucp2.data.entity.MataKuliah
import com.example.ucp2.repository.RepositoryMk

class MatakuliahViewModel(private val repositoryMk: RepositoryMk) : ViewModel() {

    var uiState by mutableStateOf(MkUIState())

    //Memperbarui state berdasarkan input pengguna
    fun updateState(matakuliahEvent: MatakuliahEvent) {
        uiState = uiState.copy(
            matakuliahEvent = matakuliahEvent,
        )
    }

data class MkUIState(
    val matakuliahEvent: MatakuliahEvent = MatakuliahEvent(),
    val isEntryValid: FormErrorState = FormErrorState(),
    val snackBarMessage: String? = null,
)

data class FormErrorState(
    val kode: String? = null,
    val nama: String? = null,
    val sks: String? = null,
    val semester: String? = null,
    val jenis: String? = null,
    val dosenpengampu: String? = null,
){
    fun isValid(): Boolean {
        return kode == null && nama == null && sks == null &&
                semester == null && jenis == null && dosenpengampu == null
    }
}

fun MatakuliahEvent.toMatakuliahEntity(): MataKuliah = MataKuliah(
    kode = kode,
    nama = nama,
    sks = sks,
    semester = semester,
    jenis = jenis,
    dosenpengampu = dosenpengampu
)

data class MatakuliahEvent(
    val kode: String = "",
    val nama: String ="",
    val sks: String ="",
    val semester: String ="",
    val jenis: String ="",
    val dosenpengampu: String ="",
)