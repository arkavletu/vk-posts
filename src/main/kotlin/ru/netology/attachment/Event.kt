package ru.netology.attachment

import java.text.SimpleDateFormat
import java.util.*

class Event internal constructor(
    private val id: Int,
    private val address: String,
    private val text: String,
    private val time: Long = 1679073434,
    private val buttonText: String = "I'm button text",
    private val friends: Int = 0,
    private val status: Boolean = true,
    private val isFavorite: Boolean = true
) {

    fun formatTime(): String {
        val date = SimpleDateFormat("dd-M-yyyy hh:mm:ss")
        return date.format(Date(time*1000))
    }
    override fun toString(): String {
        return "Event $id\n${formatTime()} \naddress $address\nabout " +
                "$text\nStatus $status\n$buttonText\nfriends coming $friends"
    }

}