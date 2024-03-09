package com.example.infotional_03

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.*
import com.example.infotional_03.SplashScreen.SplashScreenNavigation
import com.example.infotional_03.ui.theme.Infotional_03Theme


class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Infotional_03Theme {
                Surface {
                    SplashScreenNavigation()
                }
            }
        }
    }
}


