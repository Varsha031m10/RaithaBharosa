package com.example.raithabharosa

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.raithabharosa.ui.screens.ActionPlanScreen
import com.example.raithabharosa.ui.screens.DashboardScreen
import com.example.raithabharosa.ui.screens.HistoryScreen
import com.example.raithabharosa.ui.screens.LanguageScreen
import com.example.raithabharosa.ui.theme.RaithaBharosaTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            RaithaBharosaTheme {

                var currentScreen by remember { mutableStateOf("language") }

                Scaffold(modifier = Modifier.fillMaxSize()) {

                    when (currentScreen) {

                        "language" -> {
                            LanguageScreen {
                                currentScreen = "dashboard"
                            }
                        }

                        "dashboard" -> {
                            DashboardScreen(
                                onViewActionPlan = {
                                    currentScreen = "action"
                                },
                                onViewHistory = {
                                    currentScreen = "history"
                                }
                            )
                        }

                        "history" -> {
                            HistoryScreen(
                                onBack = {
                                    currentScreen = "dashboard"
                                }
                            )
                        }

                        "action" -> {
                            ActionPlanScreen(
                                onBack = {
                                    currentScreen = "dashboard"
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}