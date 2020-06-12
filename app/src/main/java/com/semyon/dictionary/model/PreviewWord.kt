package com.semyon.dictionary.model

data class PreviewWord(
    val id: Int,
    val text: String,
    val meanings: List<WordMeaning>
) {
    fun getPreview(): String {
        meanings.first().previewUrl?.let {
            return "https:$it";
        }
        return ""
    }
}

