package com.example.infotional_03

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.infotional_03.threeMainPages.CariMentor
import com.example.infotional_03.threeMainPages.Homepage
import com.example.infotional_03.threeMainPages.Profile
import com.example.infotional_03.threeMainPages.Routes

@Composable
fun BottomNavigationBar(navController: NavController) {
    val page = listOf(
        Routes.Homepage,
        Routes.CariMentor,
        Routes.Profile
    )

    NavigationBar(
        containerColor = com.example.infotional_03.ui.theme.Blue,
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        page.forEach { destination ->
            NavigationBarItem(
                selected = currentRoute == destination.route,
                onClick = { navController.navigate(destination.route) },
                icon = {
                    Icon(
                        painterResource(destination.icon),
                        contentDescription = destination.id,
                        modifier = Modifier.size(28.dp)
                    )
                },
                label = { Text(text = destination.id, fontSize = 12.sp) },
                alwaysShowLabel = false,
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.Yellow,
                    selectedTextColor = Color.Yellow,
                    indicatorColor = com.example.infotional_03.ui.theme.Blue,
                    unselectedIconColor = Color.White
                )
            )
        }
    }
}

@Composable
fun NavigationGraph(navController: NavController) {
    NavHost(
        navController = navController as NavHostController,
        startDestination = Routes.Homepage.route
    ) {
        composable(Routes.Homepage.route) { Homepage() }
        composable(Routes.CariMentor.route) { CariMentor() }
        composable(Routes.Profile.route) { Profile() }
    }
}

//implementation
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun InfotionalBottomNavigationBarImplementation() {
    val navigationController = rememberNavController()

    Scaffold(
        bottomBar = { BottomNavigationBar(navController = navigationController) }
    ) {
        NavigationGraph(navController = navigationController)
    }
}