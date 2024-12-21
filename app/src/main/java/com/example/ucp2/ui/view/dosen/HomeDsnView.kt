package com.example.ucp2.ui.view.dosen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ucp2.ui.viewmodel.dosen.HomeDsnViewModel
import com.example.ucp2.ui.viewmodel.dosen.PenyediaDsnViewModel

@Composable
fun HomeDsnView (
    viewModel: HomeDsnViewModel = viewModel (factory = PenyediaDsnViewModel. Factory),
    onAddDsn: () -> Unit = { },
    onBack: () -> Unit,
    onDetailClick: (String) -> Unit = { },
    modifier: Modifier = Modifier
) {}