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
import com.example.raithabharosa.ui.screens.*
import com.example.raithabharosa.ui.theme.RaithaBharosaTheme

class MainActivity : ComponentActivity() {

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {

            RaithaBharosaTheme {

                var currentScreen by remember {
                    mutableStateOf("login")
                }

                var selectedLanguage by remember {
                    mutableStateOf("English")
                }

                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) {

                    when (currentScreen) {

                        "login" -> {

                            LoginScreen {

                                currentScreen = "language"
                            }
                        }

                        "language" -> {

                            LanguageScreen { language ->

                                selectedLanguage = language

                                currentScreen = "dashboard"
                            }
                        }

                        "dashboard" -> {

                            DashboardScreen(

                                language = selectedLanguage,

                                onViewActionPlan = {

                                    currentScreen = "action"
                                },

                                onViewHistory = {

                                    currentScreen = "history"
                                }
                            )
                        }

                        "action" -> {

                            ActionPlanScreen(

                                language = selectedLanguage,

                                onBack = {

                                    currentScreen = "dashboard"
                                }
                            )
                        }

                        "history" -> {

                            HistoryScreen(

                                language = selectedLanguage,

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