package com.example.raithabharosa.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HistoryScreen(onBack: () -> Unit) {

    val historyList = listOf(
        "Ragi - Good yield (2024)",
        "Paddy - Moderate yield (2023)",
        "Sugarcane - High yield (2022)"
    )

    Column(

        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .statusBarsPadding()
    ) {
        Button(onClick = { onBack() }) {
            Text("Back")
        }

        Spacer(modifier = Modifier.height(10.dp))
        Text("Farming History", fontSize = 24.sp)


        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(historyList) { item ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    Text(
                        text = item,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }
    }
}