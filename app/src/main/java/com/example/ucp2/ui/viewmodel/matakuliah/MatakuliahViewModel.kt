package com.example.ucp2.ui.viewmodel.matakuliah

import com.example.ucp2.data.entity.MataKuliah

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