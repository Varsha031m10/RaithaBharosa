package com.example.raithabharosa.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.foundation.layout.statusBarsPadding
import com.example.raithabharosa.viewmodel.SowingViewModel as SowingViewModel1
import com.google.firebase.database.FirebaseDatabase

@SuppressLint("ViewModelConstructorInComposable")
@Composable
fun DashboardScreen(
    language: String,
    onViewActionPlan: () -> Unit,
    onViewHistory: () -> Unit
) {

    val viewModel = SowingViewModel1()
    val database = FirebaseDatabase.getInstance()

    val ref = database.getReference("MoistureData")

    var moisture by remember {
        mutableStateOf("")
    }

    var selectedCrop by remember {

        mutableStateOf(

            if (language == "KN")
                "ಬೆಳೆ ಆಯ್ಕೆ"

            else
                "Select Crop"
        )
    }

    val crops =

        if (language == "KN") {

            listOf(
                "ರಾಗಿ",
                "ಭತ್ತ",
                "ಕಬ್ಬು"
            )

        } else {

            listOf(
                "Ragi",
                "Paddy",
                "Sugarcane"
            )
        }

    var expanded by remember {
        mutableStateOf(false)
    }

    // SAFE moisture value

    val moistureValue =
        moisture.toIntOrNull() ?: -1

    // INDEX

    val index =

        if (moistureValue == -1)
            0

        else
            viewModel.calculateIndex(moistureValue)

    // RECOMMENDATION

    val recommendation =

        if (moistureValue == -1) {

            ""

        } else if (language == "KN") {

            if (moistureValue > 30)
                "ನಿಲ್ಲಿಸಿ ❌"

            else
                "ಮುಂದುವರಿಸಿ ✅"

        } else {

            viewModel.getRecommendation(moistureValue)
        }

    // AI SUGGESTION

    val aiSuggestion =

        if (moistureValue == -1) {

            ""

        } else if (language == "KN") {

            if (moistureValue > 30)
                "AI ಸಲಹೆ: ಮಣ್ಣು ತುಂಬಾ ತೇವವಾಗಿದೆ."

            else
                "AI ಸಲಹೆ: ಬಿತ್ತನೆಗೆ ಉತ್ತಮ ಪರಿಸ್ಥಿತಿ ಇದೆ."

        } else {

            viewModel.getAiSuggestion(moistureValue)
        }

    // COLOR

    val color =

        if (moistureValue == -1)
            Color.Black

        else if (moistureValue <= 30)
            Color(0xFF4CAF50)

        else
            Color.Red

    // LANGUAGE TEXTS

    val title =

        if (language == "KN")
            "ಬಿತ್ತನೆ ಸೂಚ್ಯಂಕ"

        else
            "Sowing Index"

    val moistureText =

        if (language == "KN")
            "ತೇವಾಂಶ ನಮೂದಿಸಿ"

        else
            "Enter Moisture"

    val actionText =

        if (language == "KN")
            "ಕಾರ್ಯ ಯೋಜನೆ"

        else
            "View Action Plan"

    val historyText =

        if (language == "KN")
            "ಇತಿಹಾಸ"

        else
            "View History"

    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding(16.dp),

        verticalArrangement = Arrangement.Top
    ) {

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = title,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(20.dp))

        TextField(

            value = moisture,

            onValueChange = {
                moisture = it
            },

            label = {
                Text(moistureText)
            }
        )

        Spacer(modifier = Modifier.height(20.dp))

        Box {

            Button(
                onClick = {
                    expanded = true
                }
            ) {

                Text(selectedCrop)
            }

            DropdownMenu(

                expanded = expanded,

                onDismissRequest = {
                    expanded = false
                }

            ) {

                crops.forEach { crop ->

                    DropdownMenuItem(

                        text = {
                            Text(crop)
                        },

                        onClick = {

                            selectedCrop = crop
                            expanded = false
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "$index%",
            fontSize = 40.sp,
            color = color
        )

        Text(
            text = recommendation,
            fontSize = 24.sp,
            color = color
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = aiSuggestion,
            fontSize = 16.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {

                if (moisture.isNotEmpty()) {

                    val data = mapOf(
                        "moisture" to moisture,
                        "crop" to selectedCrop
                    )

                    ref.push().setValue(data)
                }

                onViewActionPlan()
            }
        ) {

            Text(actionText)
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = {
                onViewHistory()
            }
        ) {

            Text(historyText)
        }
    }
}