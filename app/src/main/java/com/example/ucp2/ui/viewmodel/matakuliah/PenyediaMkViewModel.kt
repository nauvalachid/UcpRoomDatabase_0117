package com.example.ucp2.ui.viewmodel.matakuliah

import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.ucp2.ui.viewmodel.dosen.krsApp

object PenyediaMkViewModel{

    val Factory = viewModelFactory {
        initializer {
            MatakuliahViewModel(
                krsApp().containerApp.repositoryMk
            )
        }

        initializer {
            HomeMkViewModel(
                krsApp().containerApp.repositoryMk
            )
        }

        initializer {
            DetailMkViewModel(
                createSavedStateHandle(),
                krsApp().containerApp.repositoryMk,
            )
        }

        initializer {
            UpdateMkViewModel(
                createSavedStateHandle(),
                krsApp().containerApp.repositoryMk,
            )
        }
    }
}