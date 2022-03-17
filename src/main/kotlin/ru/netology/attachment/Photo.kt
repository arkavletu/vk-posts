package ru.netology.attachment

import java.time.LocalDateTime

class Photo internal constructor(
    private val id: Int,
    private val ownerId: Int,
    private val width: Int,
    private val height: Int,
    private val date: LocalDateTime? = LocalDateTime.now(),
    text: String,
    albumId: Int
) {

    private var text: String? = null
    set(value) {
        if (value != null ) field = value
    }

    private var albumId: Int? = null
        set(value) {
            if (value != null) {
                if (value <= 0) return
            } else field = value
        }

    override fun toString(): String {
        return "$date\nphoto id $id\nowner $ownerId album $albumId"
    }

}