package ru.netology


import java.time.LocalDateTime

data class Post internal constructor(

    private val text: String,
    private val ownerId: Int = 1,
    private val friendsOnly: Boolean = false,
    private val likes: Int = 0,
    private val reposts: Int = 0,
    internal val id: Int = 0,
    private val date: LocalDateTime? = LocalDateTime.now(),


    ){



    override fun toString(): String{
        return "$id\nFrom $date\n$text\n$likes likes $reposts reposts"
    }




}
