package ru.netology


import java.time.LocalDateTime

class Post internal constructor(

    private val text: String,
    internal val original: Post?,
    internal val ownerId: Int = 1, //чья стена
    private val friendsOnly: Boolean = false,
    private val isPinned: Boolean = false,
    private val isFavorite: Boolean = false,
    private val likes: Int = 0,
    internal var reposts: Int = 0,
    private val comments: Int = 0,
    internal var id: Int = 0,
    internal val date: LocalDateTime? = LocalDateTime.now(),

    ) {

    var fromId: Int? = 0
        set(value) {
            if (value != null) {
                if (value < 0) return
            } else field = value
        }
        get() = original?.ownerId ?: this.ownerId

    var replyOwnerId: Int? = 0
        set(value) {
            if (value != null) {
                if (value < 0) return
            } else field = value
        }
        get() = original?.fromId ?: this.ownerId

    var replyPostId: Int? = 0
        set(value) {
            if (value != null) {
                if (value < 0) return
            } else field = value                        
        }
        get() = original?.id ?: 0



    override fun toString(): String {
        return "id $id \n owner $ownerId\n $date\n Author $fromId\n $text\n $likes " +
                "likes $reposts reposts\n original post $replyPostId\n author of post " +
                "$fromId \n owner of original $replyOwnerId"
    }


}
