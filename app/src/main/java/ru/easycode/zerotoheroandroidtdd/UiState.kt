package ru.easycode.zerotoheroandroidtdd

interface UiState {

    var text: String
    data class Base(public override var text: String): UiState

    data class Max(public override var text: String): UiState

}