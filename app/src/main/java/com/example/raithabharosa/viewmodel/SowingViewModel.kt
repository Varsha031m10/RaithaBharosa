package com.example.raithabharosa.viewmodel

import androidx.lifecycle.ViewModel

class SowingViewModel : ViewModel() {

    fun calculateIndex(moisture: Int): Int {
        return if (moisture > 30) 40 else 80
    }

    fun getRecommendation(moisture: Int): String {
        return if (moisture > 30) "WAIT ❌" else "GO ✅"
    }

    fun getAiSuggestion(moisture: Int): String {
        return if (moisture > 30) {
            "AI Suggestion: Soil too wet. Wait before sowing."
        } else {
            "AI Suggestion: Conditions are good. You can proceed with sowing."
        }
    }
}