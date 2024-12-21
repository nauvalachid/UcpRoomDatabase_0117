package com.example.ucp2.ui.viewmodel.matakuliah

import com.example.ucp2.data.entity.MataKuliah

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