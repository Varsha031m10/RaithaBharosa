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
fun ActionPlanScreen(onBack: () -> Unit) {

    val plan = listOf(
        "Day 1: GO - Suitable for sowing",
        "Day 2: WAIT - Rain expected",
        "Day 3: GO - Good moisture",
        "Day 4: WAIT - Soil too wet",
        "Day 5: GO - Ideal conditions",
        "Day 6: WAIT - Heavy rain",
        "Day 7: GO - Resume farming"
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

        Text("7-Day Action Plan", fontSize = 24.sp)

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(plan) { item ->
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