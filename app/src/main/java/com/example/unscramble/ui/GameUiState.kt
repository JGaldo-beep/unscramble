package com.example.unscramble.ui

data class GameUiState(
    val wordUnscrambled: String = "",
    val hint: String = "",
    val currentWordCount: Int = 0,
    val score: Int = 0,
    val isGuessedWordWrong: Boolean = false,
    val isGameOver: Boolean = false
)
