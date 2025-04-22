package com.example.unscramble.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.unscramble.data.FruitTranslated
import com.example.unscramble.data.Resources.MAX_NO_OF_WORDS
import com.example.unscramble.data.Resources.SCORE_INCREASE
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class GameViewModel: ViewModel() {

    private val _uiState = MutableStateFlow(GameUiState())
    val uiState: StateFlow<GameUiState> = _uiState.asStateFlow()

    // Set of words used in the game
    private lateinit var currentFruit: FruitTranslated
    private var usedWords: MutableSet<FruitTranslated> = mutableSetOf()
    private var availableWords: List<FruitTranslated> = emptyList()

    var userGuess by mutableStateOf("")
        private set

    fun setWords(words: List<FruitTranslated>) {
        availableWords = words
        resetGame()
    }

    fun resetGame() {
        usedWords.clear()
        val nextFruit = pickRandomWordAndShuffle()
        _uiState.value = GameUiState(
            wordUnscrambled = nextFruit.name,
            hint = nextFruit.hint
        )
    }

    fun checkUserGuess() {
        if (userGuess.equals(currentFruit.name, ignoreCase = true)) {
            val updatedScore = _uiState.value.score.plus(SCORE_INCREASE)
            updateGameState(updatedScore)
        }
        else {
            _uiState.update { currentState ->
                currentState.copy(isGuessedWordWrong = true)
            }
        }
        updateUserGuess("")
    }

    fun updateUserGuess(guessedWord: String){
        userGuess = guessedWord
    }

    fun skipWord() {
        updateGameState(_uiState.value.score)
        // Reset user guess
        updateUserGuess("")
    }

    private fun updateGameState(updatedScore: Int) {
        if (usedWords.size == MAX_NO_OF_WORDS){
            //Last round in the game, update isGameOver to true, don't pick a new word
            _uiState.update { currentState ->
                currentState.copy(
                    isGuessedWordWrong = false,
                    score = updatedScore,
                    isGameOver = true
                )
            }
        } else{
            // Normal round in the game
            val nextFruit = pickRandomWordAndShuffle()
            _uiState.update { currentState ->
                currentState.copy(
                    isGuessedWordWrong = false,
                    wordUnscrambled = nextFruit.name,
                    hint = nextFruit.hint,
                    currentWordCount = currentState.currentWordCount.inc(),
                    score = updatedScore
                )
            }
        }
    }

    private fun shuffleCurrentWord(word: FruitTranslated): FruitTranslated {
        val tempName = word.name.toCharArray()
        tempName.shuffle()
        while (String(tempName) == word.name) {
            tempName.shuffle()
        }
        return word.copy(name = String(tempName))
    }

    private fun pickRandomWordAndShuffle(): FruitTranslated {
        currentFruit = availableWords.random()
        return if (usedWords.contains(currentFruit)) {
            pickRandomWordAndShuffle()
        } else {
            usedWords.add(currentFruit)
            shuffleCurrentWord(currentFruit)
        }
    }
}