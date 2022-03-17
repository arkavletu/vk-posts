package ru.netology

import java.time.LocalDateTime

class Note internal constructor(
    private val id: Int,
    private val ownerId: Int,
    private val text: String,
    private val comments: Int = 0,
    private val viewUrl: String = "www.note.ru",
    private val canComment: Boolean = false,
    private val title: String = "My note",
    private val date: LocalDateTime? = LocalDateTime.now()
) {
    override fun toString(): String {
        return "note id $id. Owner id $ownerId\n$date\n$viewUrl\n$title\n$text\n$comments comments"
    }

}
