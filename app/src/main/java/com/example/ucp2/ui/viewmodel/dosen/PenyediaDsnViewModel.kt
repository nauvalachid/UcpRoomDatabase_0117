package com.example.ucp2.ui.viewmodel.dosen

import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory

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