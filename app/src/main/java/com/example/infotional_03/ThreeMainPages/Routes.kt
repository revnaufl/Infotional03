package com.example.infotional_03.ThreeMainPages


import com.example.infotional_03.R

sealed class Routes (val id: String, val icon: Int, val route: String) {
    object CariMentor: Routes("Cari Mentor", R.drawable.icon_cari_mentor, "cariMentor")
    object Homepage: Routes("Homepage", R.drawable.icon_homepage, "homepage")
    object Profile: Routes("Profile", R.drawable.icon_profile, "profile")
}