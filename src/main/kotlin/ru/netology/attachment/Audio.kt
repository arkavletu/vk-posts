package ru.netology.attachment

import java.time.LocalDateTime

data class Audio(
    private val id: Int,
    private val ownerId: Int,
    private val artist: String,
    private val title: String,
    private val duration: Int,
    private val genre: Int,
    private var text: String?,
    private var album: String?,
    private val url: String = "www.muzona.net",
    private val date: LocalDateTime? = LocalDateTime.now(),
    private val canSearch: Boolean = true,

    ) {

    fun getGenre(digit: Int): String {
        val types = arrayOf("pop", "rap", "classical", "rock", "неизвестный формат")
        return when (digit) {
            in 0..types.size -> types[digit - 1]
            else -> {
                "error"
            }
        }
    }

    override fun toString(): String {
        return "audio id $id, owner $ownerId\n$date\nartist $artist\ntitle $title\nduration " +
                "$duration\ngenre ${getGenre(genre)}\nalbum $album text $text\n$url"
    }

}