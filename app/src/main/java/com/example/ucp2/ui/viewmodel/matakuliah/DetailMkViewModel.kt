package com.example.ucp2.ui.viewmodel.matakuliah

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ucp2.data.entity.MataKuliah
import com.example.ucp2.repository.RepositoryMk
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailMkViewModel (
    savedStateHandle: SavedStateHandle,
    private val repositoryMk: RepositoryMk,

    ) : ViewModel() {
    private val kode: String = checkNotNull(savedStateHandle[DestinasiMKDetail.KODE])

    val detailUiState: StateFlow<DetailUiState> = repositoryMk.getMk(kode)
        .filterNotNull()
        .map {
            DetailUiState(
                detailUiEvent = it.toDetailUiEvent(),
                isLoading = false,
            )
        }
        .onStart {
            emit(DetailUiState(isLoading = true))
            kotlinx.coroutines.delay(600)
        }
        .catch {
            emit(
                DetailUiState(
                    isLoading = false,
                    isError = true,
                    errorMessage = it.message ?: "Terjadi kesalahan",
                )
            )
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(2000),
            initialValue = DetailUiState(
                isLoading = true,
            ),
        )

    fun deleteMk() {
        detailUiState.value.detailUiEvent.toMatakuliahEntity().let {
            viewModelScope.launch {
                repositoryMk.deleteMk(it)
            }
        }
    }
}

data class DetailUiState(
    val detailUiEvent: MatakuliahEvent = MatakuliahEvent (),
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val errorMessage: String = ""
) {
    val isUiEventEmpty: Boolean
        get() = detailUiEvent == MatakuliahEvent()

    val isUiEventNotEmpty: Boolean
        get() = detailUiEvent != MatakuliahEvent ()
}

fun MataKuliah.toDetailUiEvent () : MatakuliahEvent {
    return MatakuliahEvent(
        kode = kode,
        nama = nama,
        sks = sks,
        semester = semester,
        jenis = jenis,
        dosenpengampu = dosenpengampu
    )
}