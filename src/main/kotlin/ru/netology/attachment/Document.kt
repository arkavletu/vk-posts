package ru.netology.attachment

import java.time.LocalDateTime

data class Document(
    private val id: Int,
    private val ownerId: Int,
    private val title: String,
    private val size: Int,
    private val ext: String = "txt",
    private val type: Int = 1,
    private val date: LocalDateTime? = LocalDateTime.now(),
    private val url: String = "www.doc.com",
) {
    fun typeOfDoc(digit: Int): String {
        val types = arrayOf("text", "archive", "gif", "picture", "audio", "video", "eBook", "неизвестный формат")
        return when (digit) {
            in 0..types.size -> types[digit - 1]
            else -> {
                "error"
            }
        }
    }

    override fun toString(): String {
        return "Doc id $id, owner $ownerId\n$title.$ext\n$date\n${typeOfDoc(type)} $size bites\nurl: $url"
    }
}