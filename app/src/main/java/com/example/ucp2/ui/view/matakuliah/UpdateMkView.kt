package com.example.ucp2.ui.view.matakuliah

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ucp2.ui.viewmodel.dosen.HomeDsnViewModel
import com.example.ucp2.ui.viewmodel.dosen.PenyediaDsnViewModel
import com.example.ucp2.ui.viewmodel.matakuliah.PenyediaMkViewModel
import com.example.ucp2.ui.viewmodel.matakuliah.UpdateMkViewModel

@Composable
fun UpdateMkView(
    onBack: () -> Unit,
    onNavigate: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: UpdateMkViewModel = viewModel(factory = PenyediaMkViewModel.Factory),
    viewModelDsn: HomeDsnViewModel = viewModel(factory = PenyediaDsnViewModel.Factory),

    ){
    val uiState = viewModel.updateUIState
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()
    val dsnList by viewModelDsn.homeUiState.collectAsState()
    }