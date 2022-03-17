package ru.netology

import java.time.LocalDateTime

class Audio internal constructor(
    private val id: Int,
    private val ownerId: Int,
    private val artist: String,
    private val title: String,
    private val duration: Int,
    private val genre: Int,
    text: String?,
    album: String?,
    private val url: String = "www.muzona.net",
    private val date: LocalDateTime? = LocalDateTime.now(),
    private val canSearch: Boolean = true,

        ) {

    private var text: String? = null
        set(value) {
            if (value != null ) field = value
        }

    private var album: String? = null
        set(value) {
            if (value != null ) field = value
        }

    fun getGenre(digit: Int): String {
        val types = arrayOf("pop","rap","classical","rock","неизвестный формат")
        return when (digit) {
            in 0..types.size -> types[digit - 1]
            else -> {"error"}
        }
    }

    override fun toString(): String{
        return "audio id $id, owner $ownerId\n$date\nartist $artist\ntitle $title\nduration " +
                "$duration\ngenre ${getGenre(genre)}\nalbum $album text $text\n$url"
    }

}