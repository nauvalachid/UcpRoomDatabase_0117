package com.example.ucp2.ui.viewmodel.matakuliah

import com.example.ucp2.data.entity.MataKuliah

fun MataKuliah. toUIStateMk () : MkUIState = MkUIState (
    matakuliahEvent = this. toDetailUiEvent (),
)