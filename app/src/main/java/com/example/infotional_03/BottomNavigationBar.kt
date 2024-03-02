package com.example.infotional_03

import android.os.Build
import android.os.Bundle
import android.text.style.BackgroundColorSpan
import androidx.annotation.RequiresApi
import androidx.compose.foundation.IndicationInstance
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.indication
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.modifier.ModifierLocalReadScope
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.ActivityNavigatorExtras
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.infotional_03.ThreeMainPages.CariMentor
import com.example.infotional_03.ThreeMainPages.Homepage
import com.example.infotional_03.ThreeMainPages.Profile
import com.example.infotional_03.ThreeMainPages.Routes

@Composable
fun BottomNavigationBar(navController: NavController) {
    val page = listOf(
        Routes.CariMentor,
        Routes.Homepage,
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
                    unselectedIconColor = Color.DarkGray
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

