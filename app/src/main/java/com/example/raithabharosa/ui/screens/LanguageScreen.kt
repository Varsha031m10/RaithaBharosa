package com.example.raithabharosa.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LanguageScreen(onLanguageSelected: (String) -> Unit) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text("Select Language", fontSize = 24.sp)

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = { onLanguageSelected("EN") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("English")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { onLanguageSelected("KN") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("ಕನ್ನಡ")
        }
    }
}