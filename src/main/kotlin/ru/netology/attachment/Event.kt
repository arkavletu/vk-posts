package ru.netology.attachment

class Event(
    val id: Int,
    val time: Int,
    val status: Boolean,
    val isFavorite: Boolean,
    val address: String,
    val text: String,
    val buttonText: String,
    val friends: Int
) {
    override fun toString(): String {
        return "event"//"Event $id\n$time $address\nStatus $status"
    }

}