package com.example.infotional_03

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.infotional_03.ui.theme.Infotional_03Theme
import androidx.compose.material3.*
import androidx.compose.material3.Icon
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.infotional_03.ThreeMainPages.CariMentor
import com.example.infotional_03.ThreeMainPages.Homepage
import com.example.infotional_03.ThreeMainPages.Profile
import com.example.infotional_03.ThreeMainPages.Routes


class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Infotional_03Theme {
                    val navigationController = rememberNavController()

                    Scaffold(
                        bottomBar = { BottomNavigationBar(navController = navigationController) }
                    ) {
                        NavigationGraph(navController = navigationController)
                    }
            }
        }
    }
}


