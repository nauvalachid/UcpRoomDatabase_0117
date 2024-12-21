package com.example.ucp2.ui.viewmodel.dosen

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.ucp2.KrsApp

object PenyediaDsnViewModel{

    val Factory = viewModelFactory {
        initializer {
            HomeDsnViewModel(
                krsApp().containerApp.repositoryDsn
            )
        }

        initializer {
            DosenViewModel(
                krsApp().containerApp.repositoryDsn
            )
        }

    }
}

fun CreationExtras.krsApp(): KrsApp =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as KrsApp)