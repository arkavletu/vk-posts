package ru.netology.attachment

import java.time.LocalDateTime

data class Photo(
    private val id: Int,
    private val ownerId: Int,
    private val width: Int,
    private val height: Int,
    private val date: LocalDateTime? = LocalDateTime.now(),
    private val text: String,
    private val albumId: Int,
) {

    override fun toString(): String {
        return "$date\nphoto id $id\nowner $ownerId album $albumId"
    }

}