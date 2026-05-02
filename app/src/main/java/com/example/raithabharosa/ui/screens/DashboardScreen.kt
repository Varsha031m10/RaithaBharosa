package com.example.raithabharosa.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.foundation.layout.statusBarsPadding

@Composable
fun DashboardScreen(
    onViewActionPlan: () -> Unit,
    onViewHistory: () -> Unit
) {

    var moisture by remember { mutableStateOf("") }

    var selectedCrop by remember { mutableStateOf("Select Crop") }
    val crops = listOf("Ragi", "Paddy", "Sugarcane")
    var expanded by remember { mutableStateOf(false) }

    val moistureValue = moisture.toIntOrNull() ?: 0
    val index = if (moistureValue > 30) 40 else 80
    val recommendation = if (moistureValue > 30) "WAIT ❌" else "GO ✅"

    val aiSuggestion = if (moistureValue > 30) {
        "AI Suggestion: Soil too wet. Wait before sowing."
    } else {
        "AI Suggestion: Conditions are good. You can proceed with sowing."
    }

    val color = if (recommendation.contains("GO"))
        Color(0xFF4CAF50)
    else
        Color.Red

    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()   // ✅ fixes top overlap
            .padding(16.dp),
        verticalArrangement = Arrangement.Top
    ) {

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Sowing Index",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(20.dp))

        TextField(
            value = moisture,
            onValueChange = { moisture = it },
            label = { Text("Enter Moisture") }
        )

        Spacer(modifier = Modifier.height(20.dp))

        Box {
            Button(onClick = { expanded = true }) {
                Text(selectedCrop)
            }

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                crops.forEach { crop ->
                    DropdownMenuItem(
                        text = { Text(crop) },
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

        Button(onClick = { onViewActionPlan() }) {
            Text("View Action Plan")
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(onClick = { onViewHistory() }) {
            Text("View History")
        }
    }
}