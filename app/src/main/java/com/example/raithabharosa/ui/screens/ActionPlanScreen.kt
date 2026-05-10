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
fun ActionPlanScreen(
    language: String,
    onBack: () -> Unit
) {

    val plan =

        if (language == "KN") {

            listOf(
                "ದಿನ 1: ಮುಂದುವರಿಸಿ - ಬಿತ್ತನೆಗೆ ಸೂಕ್ತ",
                "ದಿನ 2: ನಿಲ್ಲಿಸಿ - ಮಳೆ ನಿರೀಕ್ಷೆ",
                "ದಿನ 3: ಮುಂದುವರಿಸಿ - ಉತ್ತಮ ತೇವಾಂಶ",
                "ದಿನ 4: ನಿಲ್ಲಿಸಿ - ಮಣ್ಣು ತುಂಬಾ ತೇವವಾಗಿದೆ",
                "ದಿನ 5: ಮುಂದುವರಿಸಿ - ಉತ್ತಮ ಪರಿಸ್ಥಿತಿ",
                "ದಿನ 6: ನಿಲ್ಲಿಸಿ - ಭಾರಿ ಮಳೆ",
                "ದಿನ 7: ಮುಂದುವರಿಸಿ - ಕೃಷಿ ಪುನರಾರಂಭ"
            )

        } else {

            listOf(
                "Day 1: GO - Suitable for sowing",
                "Day 2: WAIT - Rain expected",
                "Day 3: GO - Good moisture",
                "Day 4: WAIT - Soil too wet",
                "Day 5: GO - Ideal conditions",
                "Day 6: WAIT - Heavy rain",
                "Day 7: GO - Resume farming"
            )
        }

    val title =

        if (language == "KN")
            "7 ದಿನಗಳ ಕಾರ್ಯ ಯೋಜನೆ"

        else
            "7-Day Action Plan"

    val backText =

        if (language == "KN")
            "ಹಿಂದೆ"

        else
            "Back"

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .statusBarsPadding()
    ) {

        Button(
            onClick = { onBack() }
        ) {

            Text(backText)
        }

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            title,
            fontSize = 24.sp
        )

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