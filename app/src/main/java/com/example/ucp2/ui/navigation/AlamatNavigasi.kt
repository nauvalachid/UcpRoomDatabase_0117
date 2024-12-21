package com.example.ucp2.ui.navigation

interface AlamatNavigasi{
    val route : String
}

object DestinasiHalamanUtama : AlamatNavigasi{
    override val route = "home"
}

object DestinasiDosen : AlamatNavigasi {
    override val route = "dosen"
}

object DestinasiMataKuliah : AlamatNavigasi {
    override val route = "matakuliah"
}

object DestinasiMKDetail : AlamatNavigasi{
    override val route = "MKdetail"
    const val KODE = "kode"
    val routesWithArg = "$route/{$KODE}"
}

object DestinasiMKUpdate : AlamatNavigasi{
    override val route = "MKupdate"
    const val KODE = "kode"
    val routesWithArg = "$route/{$KODE}"
}