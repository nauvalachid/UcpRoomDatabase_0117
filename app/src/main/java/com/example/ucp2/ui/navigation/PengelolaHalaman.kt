package com.example.ucp2.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.ucp2.ui.view.dosen.DestinasiInsert
import com.example.ucp2.ui.view.dosen.HomeDsnView
import com.example.ucp2.ui.view.dosen.InsertDsnView
import com.example.ucp2.ui.view.halamanawal.halamanutamaview
import com.example.ucp2.ui.view.matakuliah.DetailMkViewView
import com.example.ucp2.ui.view.matakuliah.HomeMkView
import com.example.ucp2.ui.view.matakuliah.InsertMkView
import com.example.ucp2.ui.view.matakuliah.UpdateMkView

@Composable
fun PengelolaHalaman(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
){
    NavHost(
        navController = navController,
        startDestination = DestinasiHalamanUtama.route
    ) {
        composable(route = DestinasiHalamanUtama.route) {
            halamanutamaview(
                onDosenClick = {
                    navController.navigate(DestinasiDosen.route)
                },
                onMataKuliahClick = {
                    navController.navigate(DestinasiMataKuliah.route)
                },
                modifier = modifier
            )
        }
        // Dosen List Screen
        composable(route = DestinasiDosen.route) {
            HomeDsnView(
                onBack = { navController.popBackStack() },
                onAddDsn = {
                    navController.navigate(DestinasiInsert.route)
                },
                modifier = modifier
            )
        }

        // Insert Dosen Screen
        composable(
            route = DestinasiInsert.route
        ) {
            InsertDsnView(
                onBack = { navController.popBackStack() },
                onNavigate = { navController.popBackStack() },
                modifier = modifier
            )
        }

        composable(
            route = DestinasiMataKuliah.route
        ) {
            HomeMkView(
                onDetailClick = {kode ->
                    navController.navigate("${DestinasiMKDetail.route}/$kode")
                    println("PengelolaHalaman: nim = $kode")
                },
                onBack = {
                    navController.popBackStack()
                },
                onAddMk = {
                    navController.navigate(com.example.ucp2.ui.view.matakuliah.DestinasiInsert.route)
                },
                modifier = modifier
            )
        }

        composable (
            route = DestinasiMataKuliah.route
        ) {
            InsertMkView(
                onBack = {
                    navController.popBackStack()
                },
                onNavigate = {
                    navController.popBackStack()
                },
                modifier = modifier
            )
        }

        composable (
            DestinasiMKDetail.routesWithArg,
            arguments = listOf(
                navArgument(DestinasiMKDetail.KODE) {
                    type = NavType.StringType
                }
            )
        ){
            val kode = it.arguments?.getString(DestinasiMKDetail.KODE)

            kode?.let { kode ->
                DetailMkViewView(
                    onBack = {
                        navController.popBackStack()
                    },
                    onEditClick = {
                        navController.navigate("${DestinasiMKUpdate.route}/$kode")
                    },
                    modifier = modifier,
                    onDeleteClick = {
                        navController.popBackStack()
                    }
                )
            }
        }

        composable(
            DestinasiMKUpdate.routesWithArg,
            arguments = listOf(
                navArgument (DestinasiMKUpdate.KODE) {
                    type = NavType.StringType
                }
            )
        ) {
            UpdateMkView(
                onBack = {
                    navController.popBackStack()
                },
                onNavigate = {
                    navController.popBackStack()
                },
                modifier = modifier,
            )
        }
    }
}