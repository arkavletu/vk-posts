package ru.netology


import ru.netology.attachment.*
import java.time.LocalDateTime

data class Post (

    private val text: String,
    internal val original: Post?,
    internal var ownerId: Int = 1, //чья стена
    private val friendsOnly: Boolean = false,
    private val isPinned: Boolean = false,
    private val isFavorite: Boolean = false,
    private val likes: Int = 0,
    internal var reposts: Int = 0,
    private val comments: Int = 0,
    internal var id: Int = 0,
    internal var date: LocalDateTime? = LocalDateTime.now(),


    ) {

    private var fromId: Int? = 0 // от кого запись
        set(value) {
            if (value != null) {
                if (value < 0) return
            } else field = value
        }
        get() = original?.ownerId ?: this.ownerId

    private var replyOwnerId: Int? = 0 //автор оригинала
        set(value) {
            if (value != null) {
                if (value < 0) return
            } else field = value
        }
        get() = original?.fromId ?: this.ownerId

    private var replyPostId: Int? = 0
        set(value) {
            if (value != null) {
                if (value < 0) return
            } else field = value
        }
        get() = original?.id ?: 0

    var attachment = emptyArray<Attachment>()

    fun printAttachment(): String {
        return "attached ${attachment.contentToString()}"
    }

    override fun toString(): String {
        return "id $id \n owner $ownerId\n $date\n Author $fromId\n $text\n $likes " +
                "likes $reposts reposts\n original post $replyPostId\n author of post " +
                "$fromId \n owner of original $replyOwnerId\n ${printAttachment()}"
    }


}
